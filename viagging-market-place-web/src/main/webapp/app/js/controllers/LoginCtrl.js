marketPlaceApp.controller('LoginCtrl', ['$scope', '$state', 'loginService', 
    function($scope, $state, loginService){
	
	'use strict';
	
	$scope.user = {
		login: "",
		password: "",
	};
	
	var successCallback = function(result){
		alert("Bienvenido!");
		$state.go("home");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son válidas!");
		$scope.user.password = "";
	};
	
	$scope.loginUser = function(){
		if($scope.user.login != "" && $scope.user.password != ""){
			loginService.loginUser($scope.user, successCallback, errorCallback);
		}
	};
}]);