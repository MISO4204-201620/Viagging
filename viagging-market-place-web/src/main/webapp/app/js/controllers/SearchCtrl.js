marketPlaceApp.controller('SearchCtrl', ['$scope', '$state', 'configService', 'products', '$stateParams',
    function($scope, $state, configService, products, $stateParams){

	$scope.categories = configService.getCategories();

	$scope.prices = configService.getPrices();

	$scope.products = products;

	$scope.busqueda = angular.copy($stateParams.busqueda);

	$scope.$watch('busqueda.categoria', function(newVal, oldVal){
		console.log("old=" + oldVal + ";new="+newVal);
	});

}]);