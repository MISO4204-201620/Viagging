marketPlaceApp.controller('AppCtrl', ['$scope', 'configService', 'productsService',
    function($scope, configService, productsService){

	$scope.categories = configService.getCategories();
	
	$scope.prices = configService.getPrices();
	
	$scope.products = productsService.getProducts();
	
}]);