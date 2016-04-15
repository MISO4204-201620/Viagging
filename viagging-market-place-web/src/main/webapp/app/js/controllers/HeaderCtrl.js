marketPlaceApp.controller('HeaderCtrl', ['$scope', '$rootScope', '$state',
    function($scope, $rootScope, $state){		

	$scope.busqueda = "";		
	
	$scope.buscarProductos = function(){
		if($state.current.name === "search"){
			$scope.$broadcast("event_SEARCH", $scope.busqueda);
		} else {
			$state.go("search", { busqueda: $scope.busqueda });
		}
	};
	
}]);