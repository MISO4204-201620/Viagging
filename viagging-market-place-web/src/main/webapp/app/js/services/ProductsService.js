marketPlaceApp.service('productsService', ['$http', '$q', function($http, $q){
	
	var products = [];
	
	var currentProduct = {};
	
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
		
		getProductById : function(categoryId, serviceId){
			var url = "";
			if(categoryId == "01"){
				url= "/viagging-providers-web/getServiceTransport";
			} else if(categoryId == "02"){
				url= "/viagging-providers-web/getServiceAlojamiento";
			} else if(categoryId == "03"){
				url= "/viagging-providers-web/getServicePaseoEcologico";
			} else if(categoryId == "04"){
				url= "/viagging-providers-web/getServiceAlimentacion";
			}
			
			return $http({
				url: url,
				method: "GET",
				params: {idService : serviceId},
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
		
		getProducts : function(){
			return products;
		},
		
		getCurrentProduct: function(){
			return currentProduct;
		}
	};
	
	return productsService;
}]);