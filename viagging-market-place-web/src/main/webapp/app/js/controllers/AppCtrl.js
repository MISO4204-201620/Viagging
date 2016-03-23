marketPlaceApp.controller('AppCtrl', ['$scope', '$rootScope', 'ngCart', 'userService',
    function($scope, $rootScope, ngCart, userService){

	$scope.userData = userService.getUserData();
	$scope.isUserLoggedIn = $scope.userData != null;
	
	$rootScope.$on('USER_LOGGED_IN', function(event, userData){
		$scope.isUserLoggedIn = true;
		$scope.userData = userData;
	});
	
}]);