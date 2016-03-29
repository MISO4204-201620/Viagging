providersApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService',
    function($scope, $rootScope, $state, loginService){
	
	'use strict';
	
	$scope.userLogin = {
		login: "",
		password: "",
		profile:"Administrador"
	};
	
	var successCallback = function(userData){
		alert("Bienvenido de nuevo " + userData.primerNombre + " " + userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', userData);	
		$state.go("crear");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son validas!");
		$scope.userLogin.password = "";
	};
	
	$scope.loginUser = function(){
		loginService.loginUser($scope.userLogin, successCallback, errorCallback);
	};
}]);