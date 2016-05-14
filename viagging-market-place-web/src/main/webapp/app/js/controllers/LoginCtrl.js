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
		$scope.userLogin.password = "";
	};
	
	var socialRegisterSuccessCallback = function(userData){
		alert("Bienvenido a Viagging " + userData.primerNombre + " " + userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', userData);
		$state.go("home");
	};

	var socialRegisterErrorCallback = function(){
		alert("Ha ocurrido un error durante el registro.");
		$scope.user.password = "";
		$scope.user.passwordCopy = "";
	};
	
	var loginByEmailErrorCallback = function(){
		alert("Ha ocurrido un error durante la autenticación");
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
	
	$rootScope.$on("USER_LOGGED_IN_BY_SOCIAL_NETWORK", function(event, userData){
		successCallback(userData);
	});
	
	$rootScope.$on("USER_REGISTERED_IN_BY_SOCIAL_NETWORK", function(event, userData){
		socialRegisterSuccessCallback(userData);
	});
	
	$rootScope.$on("ERROR_REGISTERING_SOCIAL_NETWORK_USER", function(){
		socialRegisterErrorCallback();
	});

	$scope.initLoginCtrl = function(){
		$scope.components = configService.getComponents();
	}();
}]);