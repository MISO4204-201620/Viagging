marketPlaceApp.controller('CatalogueCtrl', ['$scope', '$state', 'configService', 'productsService', 'userService',
    function($scope, $state, configService, productsService, userService){
	
	$scope.categories = configService.getCategories();
	
	$scope.prices = configService.getPrices();
	
	$scope.products = productsService.getProducts();
	
	$scope.addProductToCart = function(serviceId){
		if(userService.getUserData() == null){
			$state.go("login");
		} else {
//			cartServicio
		}
	};
	
	var initCatalogueCtrl = function(){
	}();
}]);