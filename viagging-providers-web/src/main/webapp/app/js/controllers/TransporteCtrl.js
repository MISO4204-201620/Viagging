angular.module('viaggingApp', ['angularFileUpload'])
.controller('TransporteCtrl', ['$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {

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
			numPasajeros: 2,
	}

	$scope.caracteristicas = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getFeatures?categoria=TRANSPORTE').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
		}).
		error(function(data, status, headers, config) {
		});
	});

	$scope.guardarTransporte = function(ftransporte) {
		var idService;
		$scope.transporte.servicio.caracteristicas=JSON.stringify($scope.selection);
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
					activo: true
				},
				tipoTransporte: "",
				lugarOrigen: "",
				lugarDestino: "",
				valor: "",
				tiempoEstimado: "",
				horarioInicio: "",
				horarioFin: "",
				frecuenciaSalida: "",
				numPasajeros: 2,
				caracteristicas: "",
				restricciones: "",
				imagenes: [],
				imagenPrincipal: ""
		}
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