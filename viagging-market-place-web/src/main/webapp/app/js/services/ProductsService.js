marketPlaceApp.service('productsService', ['$http', '$q', function($http, $q){
	
	var productsService = {
			
		getAllProducts : function(){
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
		}		
	};
	
	return productsService;
}]);