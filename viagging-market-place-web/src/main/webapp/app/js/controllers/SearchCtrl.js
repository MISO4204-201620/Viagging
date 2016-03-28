marketPlaceApp.controller('SearchCtrl', ['$scope', '$state', 'configService', 'products', '$stateParams',
    function($scope, $state, configService, products, $stateParams){

	$scope.categories = configService.getCategories();

	$scope.prices = configService.getPrices();

	$scope.products = products;

	$scope.busqueda = $stateParams.busqueda;

}]);