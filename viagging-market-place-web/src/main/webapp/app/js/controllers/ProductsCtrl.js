marketPlaceApp.controller('ProductsCtrl', ['$scope', function($scope){

	//Pagination controls
	$scope.currentPage = 1;
	$scope.totalItems = $scope.products.length;
	$scope.entryLimit = 9;
	$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

}]);