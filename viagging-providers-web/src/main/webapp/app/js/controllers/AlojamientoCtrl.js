providersApp.controller('AlojamientoCtrl', ['$scope', 'userService', 'FileUploader', '$http', function($scope, userService, FileUploader, $http) {

	$scope.alojamiento = {
			servicio:{ 
				id: 0,
				nombre: "",
				descripcionCorta: "",
				activo: true,
				restricciones: "",
				caracteristicas: "",
				precio: "",
				usuario: {
					id: ""
				}
			},	
			ciudad: ""
	}

	$scope.caracteristicas = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getFeatures?categoria=ALOJAMIENTO').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
			console.log("caracteristicas" + data);
		}).
		error(function(data, status, headers, config) {
		});
	});

	$scope.guardarAlojamiento = function(falojamiento) {
		var idService;
		
		var caracteristicas = [];
		for(valorCaracteristica in $scope.selection){
			var caracteristica = {
				valor: valorCaracteristica
			};
			caracteristicas.push(caracteristica);
		}
		$scope.alojamiento.servicio.caracteristicas = caracteristicas;
		$scope.alojamiento.servicio.usuario.id=$scope.userData.id;
		$http.post('/viagging-providers-web/saveLodging', angular.toJson($scope.alojamiento), {
			headers: {"Content-Type": "application/json"},
			transformRequest: angular.identity
		}).success(function(data, status, headers, config) {
			idService = data;
			for (var i = 0; i < uploader.queue.length; i++) {
				$http.put('/viagging-providers-web/saveImage', uploader.queue[i]._file, {
					params: { idServicio : idService },
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
			reset();
			alert("El servicio fue creado!");
		}).error(function(data, status, headers, config) {
			alert("Error en la creación");
		}); 
	} 
	
	function reset() {
		$scope.alojamiento = {
				servicio:{ 
					id: 0,
					nombre: "",
					descripcionCorta: "",
					activo: true,
					restricciones: "",
					caracteristicas: "",
					precio: ""
				},	
				ciudad: ""
		};
		$scope.selection = {};
		uploader.queue = [];
	}
	
	$scope.cancel = function () {
		reset();
	}
	
	var uploader = $scope.uploader = new FileUploader({
		url: '/viagging-providers-web/guardarImagen'
	});
}]);