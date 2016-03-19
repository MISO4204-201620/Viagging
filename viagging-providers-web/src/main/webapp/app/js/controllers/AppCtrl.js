angular.module('viaggingApp', ['flow'])
.controller('AppCtrl', ['$scope', '$http', function($scope, $http) {
	
	$scope.servicio = {
		nombre: "",
		descripcion: "",
		categoria: "",
		ciudad: "",
		activo: true,
		id: 0,
		images: []
	}
	
	$scope.opCategories = [];
	 
	$scope.category = '';
	
	$scope.myimage;
	 
    $scope.$watch("ajaxURL", function (newValue, oldValue) {
    	 $http.get('/viagging-providers-web/obtenerCategorias').
         success(function(data, status, headers, config) {
           $scope.post = data;
           console.log(data);
         }).
         error(function(data, status, headers, config) {
           // log error
        });
     });
    
    $scope.uploadFile = function(files) {
    	console.log("va a carhar archivo");
        var fd = new FormData();
        //Take the first selected file
        fd.append("file", files[0]);
        $scope.servicio.images[0]=fd;

//        $http.post('/viagging-providers-web/guardarServicio', fd, {
//            withCredentials: true,
//            headers: {'Content-Type': undefined },
//            transformRequest: angular.identity
//        }).success().error();

    };
     
     $scope.opStatuses = [{
         id: "ACTIVO",
         name: "Activo"
     }, {
         id: "INACTIVO",
         name: "Inactivo"
     }]
     
	$scope.test = function() {
    	console.log("aaa");
    }
     
    $scope.saveService = function(fService) {
    	console.log("va a guardar" + $scope.servicio.images[0]);
    	$scope.servicio.images[0]=$scope.uploadme;
    	$http.post('/viagging-providers-web/guardarServicio', angular.toJson($scope.servicio), {
    		withCredentials: true,
            transformRequest: angular.identity
    	}).
        success(function(data, status, headers, config) {
        	console.log(status);
//	        $scope.post = data;
	        console.log(data);
        }).
        error(function(data, status, headers, config) {
          // log error
        }); 
    } 
    
    function reset() {
        $scope.guardando = false;
        $scope.servicio.nombre = "";
        $scope.servicio.descripcion = "";
        $scope.servicio.ciudad = "";
        $scope.servicio.categoria = "";
        $scope.servicio.images = [];
    }
    
    $scope.cancel = function () {
        reset();
    }
	
    $scope.uploadme;

    $scope.uploadImage = function() {
      var fd = new FormData();
      var imgBlob = dataURItoBlob($scope.uploadme);
      fd.append('file', imgBlob);
      $http.post('/viagging-providers-web/guardarImagen', $scope.uploadme, {
            transformRequest: angular.identity,
          }
        )
        .success(function(response) {
          console.log('success', response);
        })
        .error(function(response) {
          console.log('error', response);
        });
    }


    //you need this function to convert the dataURI
    function dataURItoBlob(dataURI) {
      var binary = atob(dataURI.split(',')[1]);
      var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
      var array = [];
      for (var i = 0; i < binary.length; i++) {
        array.push(binary.charCodeAt(i));
      }
      return new Blob([new Uint8Array(array)], {
        type: mimeString
      });
    }


}]).directive("fileread", [
                           function() {
                        	    return {
                        	      scope: {
                        	        fileread: "="
                        	      },
                        	      link: function(scope, element, attributes) {
                        	        element.bind("change", function(changeEvent) {
                        	          var reader = new FileReader();
                        	          reader.onload = function(loadEvent) {
                        	            scope.$apply(function() {
                        	              scope.fileread = loadEvent.target.result;
                        	            });
                        	          }
                        	          reader.readAsDataURL(changeEvent.target.files[0]);
                        	        });
                        	      }
                        	    }
                        	  }
                        	]).config(['flowFactoryProvider', function (flowFactoryProvider) {
    flowFactoryProvider.defaults = {
            target: '/upload',
            permanentErrors:[404, 500, 501]
        };
        // You can also set default events:
        flowFactoryProvider.on('catchAll', function (event) {
        });
        // Can be used with different implementations of Flow.js
        // flowFactoryProvider.factory = fustyFlowFactory;
    }]);