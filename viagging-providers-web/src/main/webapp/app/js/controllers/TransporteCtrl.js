providersApp.controller('TransporteCtrl', ['$scope', 'userService', 'FileUploader', '$http', function($scope, userService, FileUploader, $http) {

	$scope.transporte = {
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
			tipoTransporte: "",
			lugarOrigen: "",
			lugarDestino: "",
			tiempoEstimado: "",
			horarioInicio: "",
			horarioFin: "",
			frecuenciaSalida: "",
			numeroPasajeros: 2,
	}

	$scope.caracteristicas = [];
	$scope.transportTypes = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getFeatures?categoria=TRANSPORTE').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
		}).
		error(function(data, status, headers, config) {
		});
		$http.get('/viagging-providers-web/getTransportTypes').
		success(function(data, status, headers, config) {
			$scope.transportTypes = data;
		}).
		error(function(data, status, headers, config) {
		});
	});

	$scope.guardarTransporte = function(ftransporte) {
		var idService;
		var caracteristicas = [];
		for(valorCaracteristica in $scope.selection){
			var caracteristica = {
				valor: valorCaracteristica
			};
			caracteristicas.push(caracteristica);
		}
		$scope.transporte.servicio.caracteristicas = caracteristicas;
		$scope.transporte.servicio.usuario.id=$scope.userData.id;
		console.log($scope.transporte.servicio.caracteristicas);
		$http.post('/viagging-providers-web/saveTransport', angular.toJson($scope.transporte), {
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
		$scope.transporte = {
				servicio:{ 
					id: 0,
					nombre: "",
					descripcionCorta: "",
					activo: true,
					restricciones: "",
					caracteristicas: ""
				},
				tipoTransporte: "",
				lugarOrigen: "",
				lugarDestino: "",
				valor: "",
				tiempoEstimado: "",
				horarioInicio: "",
				horarioFin: "",
				frecuenciaSalida: "",
				numeroPasajeros: 2,
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