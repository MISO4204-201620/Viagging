'use strict';


angular


    .module('app', ['angularFileUpload'])


    .controller('AppController', ['$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {
        var uploader = $scope.uploader = new FileUploader({
            url: '/viagging-providers-web/guardarImagen2'
        });

        // FILTERS

        uploader.filters.push({
            name: 'customFilter',
            fn: function(item /*{File|FileLikeObject}*/, options) {
                return this.queue.length < 10;
            }
        });
        
        $scope.uploadImage = function() {
    		var files = [];
    		for (var i = 0; i < uploader.queue.length; i++) {
    			files.push(uploader.queue[i]._file);
//    			$http.put('/viagging-providers-web/guardarImagen3?idservicio=TRANSPORTE', uploader.queue[i]._file, {
//        			headers: {"Content-Type": "application/json"},
//        			transformRequest: angular.identity}
//        		)
//        		.success(function(response) {
//        			console.log('success', response);
//        		})
//        		.error(function(response) {
//        			console.log('error', response);
//        		});
//    			console.log("arrayaqui1", uploader.queue[i]._file);
    		}
    		console.log("arrayaqui", files);
    		$http.post('/viagging-providers-web/saveImage', angular.toJson(files), {
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

        // CALLBACKS

        uploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
            console.info('onWhenAddingFileFailed', item, filter, options);
        };
        uploader.onAfterAddingFile = function(fileItem) {
            console.info('onAfterAddingFile', fileItem);
        };
        uploader.onAfterAddingAll = function(addedFileItems) {
            console.info('onAfterAddingAll', addedFileItems);
        };
        uploader.onBeforeUploadItem = function(item) {
            console.info('onBeforeUploadItem', item);
        };
        uploader.onProgressItem = function(fileItem, progress) {
            console.info('onProgressItem', fileItem, progress);
        };
        uploader.onProgressAll = function(progress) {
            console.info('onProgressAll', progress);
        };
        uploader.onSuccessItem = function(fileItem, response, status, headers) {
            console.info('onSuccessItem', fileItem, response, status, headers);
        };
        uploader.onErrorItem = function(fileItem, response, status, headers) {
            console.info('onErrorItem', fileItem, response, status, headers);
        };
        uploader.onCancelItem = function(fileItem, response, status, headers) {
            console.info('onCancelItem', fileItem, response, status, headers);
        };
        uploader.onCompleteItem = function(fileItem, response, status, headers) {
            console.info('onCompleteItem', fileItem, response, status, headers);
        };
        uploader.onCompleteAll = function() {
            console.info('onCompleteAll');
        };

        console.info('uploader', uploader);
    }]);