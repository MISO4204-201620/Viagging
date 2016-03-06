angular.module('viaggingApp', [])
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
	 
//    $scope.$watch("ajaxURL", function (newValue, oldValue) {
//         $http({
//             method: 'GET',
//             url: newValue + "&p_p_resource_id=segments"
//         }).then(function (response) {
//             $scope.opCategories = response.data;
//         }, function (error) {
//             console.log("Ocurrió un error cargando la lista de categorias: " + error);
//         });
//     });
     
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
    	console.log("va a guardar");
    	$http.post('/viagging-providers-web/guardarServicio', angular.toJson($scope.servicio)).
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
	
//	var load = function(page, url) {
//		$http({
//	    	method: 'GET', 
//	    	url: url+"&p_p_resource_id=adList"
//		})	.then(function(response) {
//			var data = response.data;
//			$scope.records = [];	
//        	angular.forEach(data, function(value, key){
//                if(value.status != "PENDIENTE_MODIFICACION")
//                	$scope.records.push(value);
//        	});
//        	
//        	$scope.pagination.numPages = Math.ceil($scope.records.length / $scope.pagination.perPage);
//            $scope.pagination.totalRecords = $scope.records.length;
//            $scope.pagination.page = page;
//            $scope.orderSearch('id', false);
//        }, function(error) {
//        });
//	}


}])