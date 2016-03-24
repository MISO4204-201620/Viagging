marketPlaceApp.controller('CheckoutCtrl', ['$scope', 'ngCart', 'userService',
    function($scope, ngCart, userService){
	
	$scope.ngCart = ngCart;
	
	$scope.userData = userService.getUserData();
	
}]);