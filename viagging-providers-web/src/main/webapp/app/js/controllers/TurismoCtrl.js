providersApp.controller('TurismoCtrl', ['$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {

	$scope.turismo = {
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
			ciudad: "",
			tiempoDeRecorrido: "",
			horario: "",
	}
	
	$scope.caracteristicas = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getFeatures?categoria=PASEOECOLOGICO').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
		}).
		error(function(data, status, headers, config) {
		});
	});

	$scope.guardarTurismo = function(fturismo) {
		var idService;
		$scope.turismo.servicio.caracteristicas=JSON.stringify($scope.selection);
		$http.post('/viagging-providers-web/saveTravel', angular.toJson($scope.turismo), {
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
		}).error(function(data, status, headers, config) {}); 
	} 

	function reset() {
		$scope.turismo = {
				servicio:{ 
					id: 0,
					nombre: "",
					descripcionCorta: "",
					activo: true,
					restricciones: "",
					caracteristicas: ""
				},
				ciudad: "",
				valor: "",
				tiempoDeRecorrido: "",
				horario: "",
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

	// FILTERS

	uploader.filters.push({
		name: 'customFilter',
		fn: function(item /*{File|FileLikeObject}*/, options) {
			return this.queue.length < 10;
		}
	});

	console.info('uploader', uploader);
}]);