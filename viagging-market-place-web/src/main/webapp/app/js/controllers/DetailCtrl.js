marketPlaceApp.controller('DetailCtrl', ['$scope', 'productsService', function($scope, productsService){
	$scope.product = productsService.getCurrentProduct();
}]);