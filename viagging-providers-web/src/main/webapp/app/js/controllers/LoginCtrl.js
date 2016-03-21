providersApp.controller('loginCtrl', ['$scope', '$http','ngDialog','$rootScope','$location', function($scope, $http,ngDialog, $rootScope,$location) {
	
	   $scope.login = function() { 
		   console.log('login');
		   //$stateProvider.run("homwe");
		  $location.path('/contenido.html');
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
}]);