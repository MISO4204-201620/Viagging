marketPlaceApp.controller('CatalogueCtrl', ['$scope', '$state', 'configService', 'productsService', 'userService',
    function($scope, $state, configService, productsService, userService){
	
	$scope.categories = configService.getCategories();
	
	$scope.prices = configService.getPrices();
	
	$scope.products = productsService.getProducts();
}]);