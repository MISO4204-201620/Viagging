marketPlaceApp.controller('CatalogueCtrl', ['$scope', '$state', 'configService', 'products', 'userService',
    function($scope, $state, configService, products, userService){
	
	$scope.categories = configService.getCategories();
	
	$scope.prices = configService.getPrices();
	
	$scope.products = products;
}]);