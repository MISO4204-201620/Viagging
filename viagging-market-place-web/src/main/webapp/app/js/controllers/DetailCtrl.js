marketPlaceApp.controller('DetailCtrl', ['$scope', 'product','ngCart', 'wishListService', 'userService', 'productsService',
     function($scope, product, ngCart, wishListService, userService, productsService){
	
	'use strict';
	
	$scope.comentarioCalificacion = {
		comentario: "",
		calificacion: 5,
		usuario: userService.getUserData()
	};
	
	$scope.addComment = function(){
		productsService.addCommentToProduct($scope.comentarioCalificacion, $scope.product.id,
			function(){
				alert("Gracias por agregar tu comentario y calificación!");
				
				$scope.product.comentarios.push($scope.comentarioCalificacion);
			},
			function(){
				alert("No ha sido posible agregar tu comentario y calificación. Inténtalo de nuevo!");
			});
	};
	
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