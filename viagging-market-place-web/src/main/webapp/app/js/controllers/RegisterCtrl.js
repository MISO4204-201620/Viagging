marketPlaceApp.controller('RegisterCtrl', ['$scope', '$rootScope', '$state', 'loginService', 'emailValidationHelper',
   function($scope, $rootScope, $state, loginService, emailValidationHelper){

	$scope.user = {
			primerNombre: "",
			primerApellido: "",
			correo: "",
			login: "",
			password: "",
			passwordCopy: "",
		};
	
	var successCallback = function(userData){
		alert("Bienvenido a Viagging " + userData.primerNombre + " " + userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', userData);	
		$state.go("home");
	};
	
	var errorCallback = function(){
		alert("Ha ocurrido un error durante el registro.");
		$scope.user.password = "";
		$scope.user.passwordCopy = "";
	};
	
	var validateForm = function(){
		var validForm = true;
		if($scope.user.password !== $scope.user.passwordCopy){
			validForm = false;
			alert("La contraseña no coincide");
		} else if(!emailValidationHelper.validateEmail($scope.user.correo)){
			validForm = false;
			alert("El correo no es válido");
		}
		return validForm;
	};
	
	$scope.registerUser = function(){
		if(validateForm()){
			loginService.registerUser($scope.user, successCallback, errorCallback);
		}
	};
	
}]);