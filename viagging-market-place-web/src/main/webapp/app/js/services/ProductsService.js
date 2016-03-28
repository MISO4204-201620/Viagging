marketPlaceApp.service('productsService', ['$http', '$q', function($http, $q){

	var products = [];

	var productsService = {

		getAllProducts : function(){
			if(products != null && products.length > 0){
				return $q.resolve(products);
			}

			return $http({
	            url: "/viagging-api/products",
	            method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isArray(response.data)){
	        		products = response.data;
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},

		getProductById : function(productId){
			return $http({
				url: "/viagging-api/products/" + productId,
				method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isObject(response.data)){
	        		currentProduct = response.data;
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},

		findProducts : function(busqueda){

			if(busqueda == null){
				busqueda = { texto : "" };
			}

			return $http({
	            url: "/viagging-api/products/find",
	            method: "POST",
	            cache: false,
	            data: busqueda,
	        }).then(function successCallback(response) {
	        	if(angular.isArray(response.data)){
	        		products = response.data;
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},

		addCommentToProduct : function(comment, productId, successCallback, errorCallback){
			$http({
				url: "/viagging-api/products/" + productId + "/comment",
				method: "POST",
	            cache: false,
	            data: comment
	        }).success(successCallback).error(errorCallback);
		},

		addQuestionToProduct : function(question, productId, successCallback, errorCallback){
			$http({
				url: "/viagging-api/products/" + productId + "/question",
				method: "POST",
	            cache: false,
	            data: question
	        }).success(successCallback).error(errorCallback);
		}
	};

	return productsService;
}]);