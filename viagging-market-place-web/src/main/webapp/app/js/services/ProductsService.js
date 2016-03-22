marketPlaceApp.service('productsService', ['$http', '$q', function($http, $q){
	
	var products = [];
	
	var productsService = {
			
		getAllProducts : function(){
			return $http({
	            url: "/viagging-providers-web/getServices",
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
		
		getProductById : function(){
			return $http({
				url: "",
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
		
		getProducts : function(){
			return products;
		}
	};
	
	return productsService;
}]);