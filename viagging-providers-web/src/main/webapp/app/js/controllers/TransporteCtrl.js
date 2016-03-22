angular.module('viaggingApp', ['angularFileUpload'])
.controller('TransporteCtrl', ['$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {

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

	$scope.ciudades = [];
	$scope.caracteristicas = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/obtenerCaracteristicas?categoria=TRANSPORTE').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
		}).
		error(function(data, status, headers, config) {
		});
	});

	var uploader = $scope.uploader = new FileUploader({
		url: '/viagging-providers-web/guardarImagen'
	});

	uploader.filters.push({
		name: 'customFilter',
		fn: function(item /*{File|FileLikeObject}*/, options) {
			return this.queue.length < 10;
		}
	});

	$scope.guardarTransporte = function(fTransporte) {
		var files = [];
		for (var i = 0; i < uploader.queue.length; i++) {
			files.push(uploader.queue[i].file);
		}
		console.log("array", files);
		$scope.alojamiento.caracteristicas=JSON.stringify($scope.selection);
		console.log("seleccionadas"+$scope.alojamiento.caracteristicas);
		for (var i = 0; i < $scope.selection.length; i++) {
			console.log("seleccionadas"+$scope.selection[i].caracteristica);
		}
		$scope.alojamiento.imagenes=files;
		console.log("imagenes", $scope.alojamiento.imagenes);
		$http.post('/viagging-providers-web/guardarTransporte', angular.toJson($scope.transporte), {
			headers: {"Content-Type": "application/json"},
			transformRequest: angular.identity
		}).
		success(function(data, status, headers, config) {
			console.log(status);
			console.log(data);
			reset();
		}).
		error(function(data, status, headers, config) {
		}); 
	} 

	$scope.uploadImage = function() {
		var files = [];
		for (var i = 0; i < uploader.queue.length; i++) {
			files.push(uploader.queue[i]._file._proto_);
			console.log("arrayaqui1", uploader.queue[i]._file);
		}
		console.log("arrayaqui", files);
		$http.post('/viagging-providers-web/guardarImagen2', angular.toJson(files), {
			transformRequest: angular.identity}
		)
		.success(function(response) {
			console.log('success', response);
			reset();
		})
		.error(function(response) {
			console.log('error', response);
		});
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

	console.info('uploader', uploader);
}]);