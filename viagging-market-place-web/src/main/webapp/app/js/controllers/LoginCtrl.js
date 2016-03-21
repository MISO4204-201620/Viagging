marketPlaceApp.controller('LoginCtrl', ['$scope', '$state', 'loginService', 
    function($scope, $state, loginService){
	
	'use strict';
	
	$scope.user = {
		login: "",
		password: "",
	};
	
	var successHandler = function(result){
		alert("Bienvenido!");
		$state.go("home");
	};
	
	var errorHandler = function(){
		alert("Las credenciales que ha ingresado no son validas!");
		$scope.user.password = "";
	};
	
	$scope.loginUser = function(){
		if($scope.user.login != "" && $scope.user.password != ""){
			loginService.loginUser($scope.user)
				.success(successHandler)
				.error(errorHandler);
		}
	};
}]);