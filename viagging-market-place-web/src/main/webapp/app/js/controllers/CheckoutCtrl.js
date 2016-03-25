marketPlaceApp.controller('CheckoutCtrl', ['$scope', 'ngCart', 'userService', '$state',
    function($scope, ngCart, userService, $state){
	
	$scope.payment = {		
		productos: [],
		medioPago: null,
		nombrePagador: null,
		numeroTarjeta: null,
		codigoSeguridad: null,
		mesVencimiento: null,
		annoVencimiento: null,
		cuotas: null
	};
	
	$scope.showGeneralData = function(){
		$scope.isGeneralDataVisible = true;
		$scope.isPaymentMethodsVisible = false;
	};
	
	$scope.showPaymentMethods = function(){
		$scope.isGeneralDataVisible = false;
		$scope.isPaymentMethodsVisible = true;
	};
	
	$scope.submitPayment = function(){
		
	};
	
	var initCheckoutCtrl = function(){
		$scope.isGeneralDataVisible = true;
		$scope.isPaymentMethodsVisible = false;
		
		$scope.ngCart = ngCart;
		
		$scope.userData = userService.getUserData();
		
		if($scope.userData == null){
			$state.go("login");
		}
	}();
	
}]);