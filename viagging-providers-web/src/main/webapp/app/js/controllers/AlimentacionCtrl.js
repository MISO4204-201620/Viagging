angular.module('viaggingApp', ['flow', 'angularFileUpload'])
.controller('AlimentacionCtrl', ['$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {

	$scope.alimentacion = {
			servicio:{ 
				id: 0,
				nombre: "",
				descripcionCorta: "",
				activo: true
			},	
			ciudad: "",
			horarioApertura: "",
			horarioCierre: "",
			precioMenor: "",
			precioMayor: "",
			caracteristicas: "",
			restricciones: "",
			imagenes: [],
			imagenPrincipal: ""
	}

	$scope.ciudades = [];
	$scope.caracteristicas = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/obtenerCaracteristicas?categoria=ALIMENTACION').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
			console.log("caracteristicas" + data);
		}).
		error(function(data, status, headers, config) {
		});
	});

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


	$scope.guardarAlojamiento = function(falojamiento) {
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
		$http.post('/viagging-providers-web/guardarAlimentacion', angular.toJson($scope.alojamiento), {
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
//		var fd = new FormData();
//		var imgBlob = dataURItoBlob($scope.uploadme);
//		fd.append('file', imgBlob);
		console.log("uploadera", uploader.queue[0]);
		var files = [];
		for (var i = 0; i < uploader.queue.length; i++) {
			files.push(uploader.queue[i]._file);
			console.log("arrayaqui1", uploader.queue[i]._file);
		}
		console.log("arrayaqui", files);
		$http.post('/viagging-providers-web/guardarImagen2', angular.toJson(files), {
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


	function reset() {
		$scope.alojamiento = {
				servicio:{ 
					id: 0,
					nombre: "",
					descripcionCorta: "",
					activo: true
				},	
				ciudad: "",
				valorPorNoche: "",
				caracteristicas: "",
				restricciones: "",
				imagenes: []
		}
	}

	$scope.cancel = function () {
		reset();
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

//	// CALLBACKS

//	uploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
//	console.info('onWhenAddingFileFailed', item, filter, options);
//	};
//	uploader.onAfterAddingFile = function(fileItem) {
//	console.info('onAfterAddingFile', fileItem);
//	};
//	uploader.onAfterAddingAll = function(addedFileItems) {
//	console.info('onAfterAddingAll', addedFileItems);
//	};
//	uploader.onBeforeUploadItem = function(item) {
//	console.info('onBeforeUploadItem', item);
//	};
//	uploader.onProgressItem = function(fileItem, progress) {
//	console.info('onProgressItem', fileItem, progress);
//	};
//	uploader.onProgressAll = function(progress) {
//	console.info('onProgressAll', progress);
//	};
//	uploader.onSuccessItem = function(fileItem, response, status, headers) {
//	console.info('onSuccessItem', fileItem, response, status, headers);
//	};
//	uploader.onErrorItem = function(fileItem, response, status, headers) {
//	console.info('onErrorItem', fileItem, response, status, headers);
//	};
//	uploader.onCancelItem = function(fileItem, response, status, headers) {
//	console.info('onCancelItem', fileItem, response, status, headers);
//	};
//	uploader.onCompleteItem = function(fileItem, response, status, headers) {
//	console.info('onCompleteItem', fileItem, response, status, headers);
//	};
//	uploader.onCompleteAll = function() {
//	console.info('onCompleteAll');
//	};

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