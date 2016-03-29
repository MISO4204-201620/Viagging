marketPlaceApp.controller('ProductsCtrl', ['$scope', 'filterFilter', function($scope, filterFilter){

//	if($scope.busqueda && $scope.busqueda.texto != ""){
//		$scope.products = filterFilter($scope.products, $scope.busqueda.texto);
//	}
//
//	$scope.$on("CATEGORY_SELECTED", function(event, category){
//		$scope.products = filterFilter($scope.products, category);
//		$scope.totalItems = $scope.products.length;
//		$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
//	});
	
	//Pagination controls
	$scope.currentPage = 1;
	$scope.totalItems = $scope.products.length;
	$scope.entryLimit = 9;
	$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

}]);