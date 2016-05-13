marketPlaceApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService', 'configService', 'hello',
    function($scope, $rootScope, $state, loginService, configService, hello){

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
		hello('twitter').login();
	};

	$scope.loginFacebookUser = function(){
		hello('facebook').login();
	};

	hello.on("auth.login", function(r){
		console.log(r.authresponse);
	});

	$scope.initLoginCtrl = function(){
		$scope.components = configService.getComponents();
	}();
}]);