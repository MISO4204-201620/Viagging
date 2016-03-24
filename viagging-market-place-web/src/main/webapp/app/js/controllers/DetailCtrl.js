marketPlaceApp.controller('DetailCtrl', ['$scope', 'productsService','ngCart', function($scope, productsService, ngCart){
	
	'use strict';
	
	$scope.ngCart = ngCart;
	
	$scope.product = productsService.getCurrentProduct();
	
	$scope.inCart = function(){
        return ngCart.getItemById(String($scope.product.servicio.id));
    };
}]);