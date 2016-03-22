marketPlaceApp.service('configService', ['$http', '$q', function($http, $q){
	
	'use strict';
	
	var applicationConfig = {};
	
	var initApplicationConfig = function(config){
		applicationConfig.categories = config.categories;
		applicationConfig.prices = config.prices;
	};
	
	var configService = {
	
		initMarketPlaceConfig : function(){
			return $http({
	            url: "/viagging-market-place-web/config",
	            method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isObject(response.data)){
	        		var config = response.data;
	        		//Set application config data
	        		initApplicationConfig(config);
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},
			
		getCategories : function(){
			return applicationConfig.categories;
		},
		
		getPrices : function(){
			return applicationConfig.prices;
		}
	};
	
	return configService;
}]);