providersApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService',
    function($scope, $rootScope, $state, loginService){
	$scope.ocultarMensaje = false;

	$scope.userData = {
			id: "",
			login: "",
			password: "",
			correo: "",
			numeroCelular : "",
			numeroDocumento: "",
			primerApellido: "",
			primerNombre: "",
			segundoApellido: "",
			segundoNombre : "",
			tipoDocumento: "",
			direccion1: "",
			direccion2: "",
			ciudad: "",
			pais : "",
			estado: "",
			zipcode: ""
	}
	
	'use strict';
	
	$scope.userLogin = {
		login: "",
		password: "",
		profile:"Proveedor"
	};
	
	var successCallback = function(map){
		$scope.userData = map["usuario"];
		alert("Bienvenido de nuevo " + $scope.userData.primerNombre + " " + $scope.userData.primerApellido);
		console.log(map["derivador"]);
		console.log("finaliza");
		$scope.ocultarMensaje = false;
		$rootScope.$broadcast('USER_LOGGED_IN', $scope.userData);	
		$state.go("alimentacion");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son válidas!");
		$scope.userLogin.password = "";
	};
	
	$scope.loginUser = function(){
		loginService.loginUser($scope.userLogin, successCallback, errorCallback);
	};
}]);