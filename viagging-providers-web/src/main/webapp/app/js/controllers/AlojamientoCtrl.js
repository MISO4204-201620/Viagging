angular.module('viaggingApp', ['flow', 'angularFileUpload'])
.controller('AlojamientoCtrl', ['$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {
	
	$scope.alojamiento = {
		nombre: "",
		descripcion: "",
		ciudad: "",
		valorNoche: "",
		caracteristicas: [],
		restricciones: "",
		activo: true,
		id: 0,
		images: []
	}
	
	$scope.ciudades = [];
	 
    $scope.$watch("ajaxURL", function (newValue, oldValue) {
    	 $http.get('/viagging-providers-web/obtenerCiudades').
         success(function(data, status, headers, config) {
           $scope.ciudades = data;
           console.log(data);
         }).
         error(function(data, status, headers, config) {
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
//      var fd = new FormData();
//      var imgBlob = dataURItoBlob($scope.uploadme);
//      fd.append('file', imgBlob);
    	console.log("uploadera", uploader.queue[0]);
    	var array = [];
    	for (var i = 0; i < uploader.queue.length; i++) {
            array.push(uploader.queue[i]._file);
        }
    	console.log("array", array);
    	$http.post('/viagging-providers-web/guardarImagen2', array, {
    	  headers: {"Content-Type": "application/json"},
    	  transformRequest: angular.identity}
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
    
    var uploader = $scope.uploader = new FileUploader({
        url: '/viagging-providers-web/guardarImagen'
    });

    // FILTERS

    uploader.filters.push({
        name: 'customFilter',
        fn: function(item /*{File|FileLikeObject}*/, options) {
            return this.queue.length < 10;
        }
    });

//    // CALLBACKS
//
//    uploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
//        console.info('onWhenAddingFileFailed', item, filter, options);
//    };
//    uploader.onAfterAddingFile = function(fileItem) {
//        console.info('onAfterAddingFile', fileItem);
//    };
//    uploader.onAfterAddingAll = function(addedFileItems) {
//        console.info('onAfterAddingAll', addedFileItems);
//    };
//    uploader.onBeforeUploadItem = function(item) {
//        console.info('onBeforeUploadItem', item);
//    };
//    uploader.onProgressItem = function(fileItem, progress) {
//        console.info('onProgressItem', fileItem, progress);
//    };
//    uploader.onProgressAll = function(progress) {
//        console.info('onProgressAll', progress);
//    };
//    uploader.onSuccessItem = function(fileItem, response, status, headers) {
//        console.info('onSuccessItem', fileItem, response, status, headers);
//    };
//    uploader.onErrorItem = function(fileItem, response, status, headers) {
//        console.info('onErrorItem', fileItem, response, status, headers);
//    };
//    uploader.onCancelItem = function(fileItem, response, status, headers) {
//        console.info('onCancelItem', fileItem, response, status, headers);
//    };
//    uploader.onCompleteItem = function(fileItem, response, status, headers) {
//        console.info('onCompleteItem', fileItem, response, status, headers);
//    };
//    uploader.onCompleteAll = function() {
//        console.info('onCompleteAll');
//    };

    console.info('uploader', uploader);


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