marketPlaceApp.controller('DetailCtrl', ['$scope', 'product','ngCart', function($scope, product, ngCart){
	
	'use strict';
	
	$scope.inCart = function(){
        return ngCart.getItemById($scope.product.id);
    };
    
    var initDetailCtrl = function(){
    	$scope.ngCart = ngCart;
    	$scope.product = product;
    }();
}]);