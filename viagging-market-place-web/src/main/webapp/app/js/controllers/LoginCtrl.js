marketPlaceApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService', 'configService',
    function($scope, $rootScope, $state, loginService, configService){

	'use strict';

	$scope.userLogin = {
		login: "",
		password: "",
	};

	var successCallback = function(userData){
		alert("Bienvenido de nuevo " + userData.primerNombre + " " + userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', userData);
		$state.go("home");
	};

	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son válidas!");
		$scope.user.password = "";
	};

	$scope.loginUser = function(){
		loginService.loginUser($scope.userLogin, successCallback, errorCallback);
	};

	$scope.loginTwitterUser = function(){
		loginService.loginTwitterUser();
	};

	$scope.loginFacebookUser = function(){
		loginService.loginFacebookUser();
	};

	$scope.initLoginCtrl = function(){
		$scope.components = configService.getComponents();
	}();
}]);