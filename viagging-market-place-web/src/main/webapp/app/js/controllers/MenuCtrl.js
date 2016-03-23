marketPlaceApp.controller('MenuCtrl', ['$scope', '$rootScope', 'loginService', 'userService',
    function($scope, $rootScope, loginService, userService){
	
	$scope.logoutUser = function(){
		loginService.logoutUser();
		$scope.isUserLoggedIn = false;
	};
	
}]);