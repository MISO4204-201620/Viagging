providersApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', '$http',
    function($scope, $rootScope, $state, $http){
	
	'use strict';
	
	$scope.user = {
		login: "",
		password: "",
	};
	
	var successCallback = function(userData){
//		alert("Hola " + userData.primerNombre + "!");
		$rootScope.$broadcast('USER_LOGGED_IN', userData);	
		$state.go("home");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son v�lidas!");
		$scope.user.password = "";
	};
	
	$scope.loginUser = function(){
		console.log("esta intentando ingresar");
		if($scope.user.login != "" && $scope.user.password != "") {
			$http.post('/viagging-api/login', angular.toJson($scope.user), {
    			headers: {"Content-Type": "application/json"},
    			transformRequest: angular.identity}
    		)
    		.success(function(response) {
    			console.log('success', response);
    		})
    		.error(function(response) {
    			console.log('error', response);
    		});
			console.log("no estan vacios");
		}
	};
}]);