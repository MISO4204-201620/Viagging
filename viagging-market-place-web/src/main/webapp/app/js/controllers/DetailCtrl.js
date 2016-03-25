marketPlaceApp.controller('DetailCtrl', ['$scope', 'product','ngCart', 'wishListService', function($scope, product, ngCart, wishListService){
	
	'use strict';
	
	$scope.inCart = function(){
        return ngCart.getItemById($scope.product.id);
    };
    
    $scope.addWishToList = function(){
    	if(product.servicio != null)
    	
    	var listaDeseo = {
    		idUsuario : userService.getUserData().id,
    		idPaquete : "",
    		idServicio : ""
    	};
    	
    	wishListService.addWishToList(listaDeseo);
    };
    
    var initDetailCtrl = function(){
    	$scope.ngCart = ngCart;
    	$scope.product = product;
    }();
}]);