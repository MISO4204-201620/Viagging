marketPlaceApp.controller('OrderResponseCtrl', ['$scope', 'order', function($scope, order){

	initOrderResponseCtrl = function(){
		$scope.order = order;
	}();
	
}]);