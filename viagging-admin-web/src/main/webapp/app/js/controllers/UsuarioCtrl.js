angular.module('viaggingApp', ['flow', 'angularFileUpload'])
.controller('UsuarioCtrl', ['$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {

	$scope.listUsers = {
			perfil:{ 
				id: 0,
				nombre: "ADMIN"
			},	
			primerNombre: "",
			primerApellido: ""
	}
	
   $scope.getProfile = function() {    
		 $http.get('/viagging-providers-web/getProfiles').
		    success(function(data, status, headers, config) {
		    	console.log(status);
		      $scope.profile = data;
		      console.log(data);
		    }).
		    error(function(data, status, headers, config) {
		      // log error
		    }); 
	    
		    $http.get('/viagging-providers-web/getTypeDocuments').
		    success(function(data, status, headers, config) {
		    	console.log(status);
		      $scope.tipoDocumento = data;
		      console.log(data);
		    }).
		    error(function(data, status, headers, config) {
		      // log error
		    }); 
     }
	
   $scope.getUsers = function() { 
		 $http.get('/viagging-providers-web/getUsers').
		    success(function(data, status, headers, config) {
		    	console.log(status);
		      $scope.listUsers = data;
		      console.log(data);
		    }).
		    error(function(data, status, headers, config) {
		    }); 
		    console.log('despues de llamar');
   }
	




	$scope.createUser = function() { 
              console.log($scope.usuario);
			 $http.post('/viagging-providers-web/addProveedorAdministrador',$scope.usuario).
				success(function(data, status, headers, config) {
		    	console.log(status);
		    	reset();
	        }).
	          error(function(data, status, headers, config) {
	        	  console.log(data);
	        }); 
		}
    	 
	

	function reset() {
		$scope.usuario = {
					id: 0,
					login: "",
					password: "",
					correo: "",
					numeroCelular: "",
					numeroDocumento: "",
					primerApellido: "",
					primerNombre: "",
					segundoApellido: "",
					segundoNombre: "",
					tipoDocumento: "",
					direccion1: "",
					direccion2: "",
					ciudad: "",
					pais: ""
		};
	}
	
	$scope.cancel = function () {
		reset();
	}
	


}]);