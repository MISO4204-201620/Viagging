providersApp.controller('MensajesCtrl', ['$scope', 'FileUploader', '$http', 'userService', function($scope, FileUploader, $http, userService) {
console.log("ingreso a controller mensajes");
	$scope.conversation = {
			usuario:{ 
				id: 0,
				nombre: "JOSE RIVERA"
			},	
			fecha: "",
			id : 0
	}

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
	
	$scope.mensaje = {
			key: "",
			value : ""
	}
	$scope.listConversation = [];
	$scope.ocultarSeccionMensajes = true;
	$scope.ocultarEscribirMensaje = true;
	$scope.getConversation1 = function(id) {
       console.log("getConersation - -"+id);	
       $scope.ocultarSeccionConversation = true;
       $scope.ocultarSeccionMensajes = false;
       /*$scope.listConversation[0] = $scope.conversation;
       $scope.listConversation[0].usuario.id = 1;
       $scope.listConversation[0].usuario.nombre = "Pedro";
       $scope.listConversation[0].fecha = "2015-12-05 03:00";
       $scope.listConversation[0].id = 1;
       $scope.listConversation[1] = $scope.conversation;
       $scope.listConversation[1].usuario.id = 2;
       $scope.listConversation[1].usuario.nombre = "Pedro1";
       $scope.listConversation[1].fecha = "03:00 PM";
       $scope.listConversation[1].id = 2;*/
       
       //$scope.listConversation[0] = $scope.conversation;
       $scope.conversation.usuario.id = 1;
       $scope.conversation.usuario.nombre = "Pedro";
       $scope.conversation.fecha = "2015-12-05 03:00";
       $scope.conversation.id = 1;
       var p = $scope.conversation;
       $scope.listConversation.push(p);
       $scope.conversation.usuario.id = 2;
       $scope.conversation.usuario.nombre = "Pedro1";
       $scope.conversation.fecha = "03:00 PM";
       $scope.conversation.id = 2;
       var p1 = $scope.conversation;
       $scope.listConversation.push(p1);
       console.log($scope.listConversation);
	}
	
	   $scope.getConversation = function() { 
		   $scope.ocultarMensaje = true;
			 $http.get('/viagging-providers-web/getCategory').
			    success(function(data, status, headers, config) {
			    	console.log(status);
			      $scope.category = data;
			      console.log(data);
			    }).
			    error(function(data, status, headers, config) {
			    }); 
			    console.log('despues de llamar');
	     }
	


	$scope.sendMessage = function() { 
		console.log("ingresooo escribit mensaje"+$scope.message.contenido);
		//$scope.mensaje.key = $scope.message.contenido;
			//	$scope.mensaje.value = $scope.message.contenido;
				$scope.mensaje = {
						key: $scope.message.contenido,
						value : $scope.message.contenido
				}
		$scope.category.push($scope.mensaje);
	
	}
     
	
	$scope.writeMessage = function() { 
		console.log("ingresooo escribirrrrr mensaje");
		$scope.ocultarEscribirMensaje = false;
	}





}]);