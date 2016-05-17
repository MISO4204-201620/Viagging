marketPlaceApp.controller('OrderDetailCtrl', ['$scope', 'order', function($scope, order){

	initOrdersCtrl = function(){
		$scope.order = order;
	}();
	
}]);