providersApp.controller('samplecontroller', ['$scope', '$http','ngDialog','$rootScope', function($scope, $http,ngDialog, $rootScope) {
$scope.idEspecifico = '1';
$scope.name;
$scope.lastName;
$scope.filtrarnombre = "";
$scope.chooseservices=[];
$scope.ocultarSeccionAdicionarPaquete = true;
$scope.ocultarSeccionActualizarPaquete = true;
$scope.paquete = {
		precio: 0,
		nombre: "",
		descripcion: "",
		activo: false,
		id : 0,
		usuario: {
			id: ""
		}
}



   $scope.getCategory = function() { 
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



	$scope.getServices = function(idCategoria) { 	
	    console.log('getServices'+idCategoria); 
	    $http.get('/viagging-providers-web/getServicesByProveedor',{
	        params: { 
	        	idCategory: idCategoria,
	        	idProveedor :  $scope.userData.id
	        	}
	    }).success(function(data, status, headers, config) {
	    	console.log(status);
	    	console.log(data);
	        $scope.listservices = data;
	        for (var i=0;i<$scope.chooseservices.length;i++){
	    	     for (var j=0;j<$scope.listservices.length;j++){
		 	         if($scope.chooseservices[i].id == $scope.listservices[j].id){
		 	        	 $scope.listservices[j].datosServicio = true;
		 	         }
	 		  }	    	  
		    }
	    }).
	    error(function(data, status, headers, config) {
	    }); 

	}

	$scope.especifico = function(id,idCategoria) { 	
		$rootScope.idEspecifico = id;
	    console.log('especifico'+id + "---"+idCategoria); 

	    if(idCategoria == "01"){
	         ngDialog.open({ template: 'template/html/transporte.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "02"){
	    	ngDialog.open({ template: 'template/html/alojamiento.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "03"){
	    	ngDialog.open({ template: 'template/html/paseoEcologico.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "04"){
	    	ngDialog.open({ template: 'template/html/alimentacion.html', className: 'ngdialog-theme-default' });
	    }
	}



	$scope.saveServicesTemp = function() { 	
	      for (var i=0;i<$scope.listservices.length;i++){
	    	  var flagExist = false;
	    	  if($scope.listservices[i].datosServicio){
		    	  for (var j=0;j<$scope.chooseservices.length;j++){
		    	       if($scope.listservices[i].id == $scope.chooseservices[j].id){
		    	    	   flagExist = true;		    	    	   
		              }
		    	  }
		    	  if(!flagExist){
		    		  $scope.chooseservices.push($scope.listservices[i]);
		    	  }
	    	  }
	    	  
	      }	
	      $scope.ocultarSeccionAdicionarPaquete = false;
	}
	
	
	$scope.getDatosTransporte = function() { 
		console.log("transporte");
		console.log($rootScope.idEspecifico);
	    $http.get('/viagging-providers-web/getServiceTransport',{
	    	params: { idService: $rootScope.idEspecifico }
	    }).success(function(data, status, headers, config) {
	    	console.log(status);
	        $scope.transporte = data;
	        console.log(data);
	    }).
	    error(function(data, status, headers, config) {
	    }); 
	    console.log('despues de llamar');
	}
	
	
	$scope.getDatosAlojamiento = function() { 
		console.log("Alojamiento");
		console.log($rootScope.idEspecifico);
	    $http.get('/viagging-providers-web/getServiceAlojamiento',{
	    	params: { idService: $rootScope.idEspecifico }
	    }).success(function(data, status, headers, config) {
	    	console.log(status);
	        $scope.alojamiento = data;
	        console.log(data);
	    }).
	    error(function(data, status, headers, config) {
	    }); 
	}
	
	
	$scope.getDatosAlimentacion = function() { 
		console.log("Alimentacion");
		console.log($rootScope.idEspecifico);
	    $http.get('/viagging-providers-web/getServiceAlimentacion',{
	    	params: { idService: $rootScope.idEspecifico }
	    }).success(function(data, status, headers, config) {
	    	console.log(status);
	        $scope.alimentacion = data;
	        console.log(data);
	    }).
	    error(function(data, status, headers, config) {
	    }); 
	    console.log('despues de llamar');
	}
	
	
	$scope.getDatosPaseoEcologico = function() { 
		console.log($rootScope.idEspecifico);
	    $http.get('/viagging-providers-web/getServicePaseoEcologico',{
	    	params: { idService: $rootScope.idEspecifico }
	    }).success(function(data, status, headers, config) {
	    	console.log(status);
	        $scope.paseoEcologico = data;
	        console.log(data);
	    }).
	    error(function(data, status, headers, config) {
	    }); 
	}
	
	
	$scope.createPackage = function() { 
		console.log($scope.paquete);
		console.log("idUsuario"+$scope.userData.id);
		$scope.paquete.usuario.id = $scope.userData.id;
		if($scope.paquete.precio > 2147483647){
			alert("Precio debe ser menor a 2147483648");
		}else{
		
			$scope.paquete.servicios = $scope.chooseservices;
			 $http.post('/viagging-providers-web/addPackage',$scope.paquete).
				 success(function(data, status, headers, config) {
		    	console.log(status);
		    	alert("Paquete creado");
		    	$scope.paquete.precio = "";
		    	$scope.paquete.nombre = "";
		    	$scope.paquete.descripcion = "";
		    	console.log($rootScope.respuestaCreacion);
	
	        }).
	          error(function(data, status, headers, config) {
	        	  alert("Error al crear paquete");
	        }); 
		}
    	 
	}
	
	$scope.desasociarServicio = function(id) { 
		console.log("desasociarServicio"+id);
  	  for (var j=0;j<$scope.chooseservices.length;j++){
	       if($scope.chooseservices[j].id == id){
	    	   $scope.chooseservices.splice(j, 1);	
	    	   break;
         }
	  }
  	    if($scope.chooseservices.length == 0){
  	       $scope.ocultarSeccionAdicionarPaquete = true;
  	    }
  	 }
     
	   $scope.getPackages = function(filtro) { 
		   console.log("filtro"+filtro);
		   console.log("idUsuario"+$scope.userData.id);
			 $http.get('/viagging-providers-web/getPackages',{
			    	params: { filtro: filtro, idUsuario : $scope.userData.id }
			    }).success(function(data, status, headers, config) {
			    	console.log(status);
			      $scope.listPackages = data;
			      console.log(data);
			    }).
			    error(function(data, status, headers, config) {
			    	console.log(data);
			    	console.log(status);
			    	$scope.listPackages = [];
			    }); 
			    console.log('despues de llamar Packages');
	     }
	   

	   $scope.getPackage = function(idPaquete) {
		   
		   for (var i=0;i<$scope.listPackages.length;i++){
 	    	  if($scope.listPackages[i].id == idPaquete){
 	    		 $scope.paquete.nombre = $scope.listPackages[i].nombre;
 	    		 $scope.paquete.descripcion = $scope.listPackages[i].descripcion;
 	    		 $scope.paquete.precio = $scope.listPackages[i].precio;
 	    		 $scope.paquete.id = $scope.listPackages[i].id;
 	    		  break;
 	    	  }	    	    	  
 	      }
			 $http.get('/viagging-providers-web/getPackage',{
			    	params: { idPackage: idPaquete }
			    }).
			    success(function(data, status, headers, config) {
			    	console.log(status);
			      $scope.listaServicios = data;
			      console.log(data);
			      $scope.ocultarSeccionActualizarPaquete = false;
			      console.log($scope.ocultarSeccionActualizarPaquete);
			    }).
			    error(function(data, status, headers, config) {

			    }); 
			    console.log('despues de llamar Packages');
	     }
	   
	   $scope.login = function() { 
		   console.log('login');
			 $http.get('/viagging-providers-web/getPackage',{
			    	params: { idPackage: idPaquete }
			    }).
			    success(function(data, status, headers, config) {
			    	console.log(status);
			      $scope.listaServicios = data;
			      console.log(data);
			    }).
			    error(function(data, status, headers, config) {
			      // log error
			    }); 
			    console.log('despues de llamar Packages');
	     }
	   
	   $scope.activatePackage = function(id,estado) { 
		   $scope.paquete.id = id;
		   $scope.paquete.activo = estado;
		   console.log("id"+id);
		   console.log("estado"+estado);
			 $http.post('/viagging-providers-web/activatePackage',$scope.paquete).
			 success(function(data, status, headers, config) {
	    	      console.log(status);
	    	      alert("Transacción exitosa");
	    	      for (var i=0;i<$scope.listPackages.length;i++){
	    	    	  if($scope.listPackages[i].id == id){
	    	    		  $scope.listPackages[i].activo = estado;
	    	    		  break;
	    	    	  }	    	    	  
	    	      }
            }).
          error(function(data, status, headers, config) {
        	  alert("Error al activar/desactivar");
            });
	     }
	   
	   $scope.eliminatePackage = function(idPaquete) { 
		   console.log("idPaquete"+idPaquete)
		   $http({ url: '/viagging-providers-web/deletePackage', 
               method: 'DELETE', 
               data: idPaquete, 
               headers: {"Content-Type": "application/json;charset=utf-8"}
	       }).then(function(res) {
	    	   console.log(res); 
	    	   for (var i=0;i<$scope.listPackages.length;i++){
	    	    	  if($scope.listPackages[i].id == idPaquete){
	    	    		  $scope.listPackages.splice(i, 1);	
	    	    		  break;
	    	    	  }	    	    	  
	    	      }
	    	      alert("Transacción exitosa");
	       }, function(error) {
	    	   alert("Error al eliminar");
	       });
		   
	     }
	   
		$scope.updatePackage = function() { 
			console.log($scope.paquete);
			console.log("idUsuario"+$scope.userData.id);
			$scope.paquete.usuario.id = $scope.userData.id;
			if($scope.paquete.precio > 2147483647){
				alert("Precio debe ser menor a 2147483648");
			}else{
			
				$scope.paquete.servicios = $scope.chooseservices;
				 $http.put('/viagging-providers-web/editPackage',$scope.paquete).
					success(function(data, status, headers, config) {
				    	console.log(status);
				    	console.log(data);
				    	alert("Paquete actualizado");

				    	 for (var i=0;i<$scope.listPackages.length;i++){
				 	    	  if($scope.listPackages[i].id == $scope.paquete.id){
							    	$scope.listPackages[i].nombre = $scope.paquete.nombre;
							    	$scope.listPackages[i].descripcion = $scope.paquete.descripcion;
							    	$scope.listPackages[i].precio = $scope.paquete.precio;
							    	console.log($rootScope.respuestaCreacion);
							    	$scope.paquete.precio = "";
							    	$scope.paquete.nombre = "";
							    	$scope.paquete.descripcion = "";
							    	break;
				 	         }
				 	   }
				    	 $scope.ocultarSeccionActualizarPaquete = true;
		        }).
		          error(function(data, status, headers, config) {
		        	  alert("Error al actualizar paquete");
		        }); 
			}
	    	 
		}
   
}]);