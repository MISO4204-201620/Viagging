marketPlaceApp.controller('SearchCtrl', ['$scope', '$state', 'configService', 'products',
    function($scope, $state, configService, products){
	
	$scope.categories = configService.getCategories();
	
	$scope.prices = configService.getPrices();
	
	$scope.products = products;
}]);