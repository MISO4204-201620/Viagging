providersApp.controller('LoginCtrl', ['$scope', '$http','ngDialog','$rootScope','$location','$state', function($scope, $http,ngDialog, $rootScope,$location,$state) {
	
	   $scope.login = function() { 
		   console.log('loginb ingreso');
		   $location.path( '/contenido.html' );
		   

				     
				   
		   //$stateProvider.run("homwe");
		//  $location.path('/contenido');
			/* $http.get('/viagging-providers-web/register').
			    success(function(data, status, headers, config) {
			    	console.log(status);
			      $scope.listaServicios = data;
			      console.log(data);
			    }).
			    error(function(data, status, headers, config) {
			      // log error
			    });*/
			    console.log('despues de llamar Packages');
	     }
	   $scope.ActiveChange =   function (activeTab) {
		   $state.go('content');
	    }
}]);