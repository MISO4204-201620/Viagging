marketPlaceApp.controller('ProfileCtrl', ['$scope', 'userService',  function($scope, userService){

	$scope.userData = userService.getUserData();
	
	$scope.updateUser = function(){
		alert("Test!");
	};

}]);