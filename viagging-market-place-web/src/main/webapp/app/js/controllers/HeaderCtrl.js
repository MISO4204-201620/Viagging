marketPlaceApp.controller('HeaderCtrl', ['$scope', '$rootScope', '$state',
    function($scope, $rootScope, $state){		

	$scope.busqueda = {
		texto : ""
	};
	
	$scope.buscarProductos = function(){
		$state.go("search", { busqueda: $scope.busqueda }, {reload: true});
	};
	
}]);