marketPlaceApp.controller('AppCtrl', ['$scope', 'configService', function($scope, configService){

	$scope.categories = configService.getCategories();
	
	$scope.prices = configService.getPrices();	
	
}]);