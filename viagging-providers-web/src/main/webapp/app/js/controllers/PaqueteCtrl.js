providersApp.controller('samplecontroller', ['$scope', '$http','ngDialog','$rootScope', function($scope, $http,ngDialog, $rootScope) {
$scope.idEspecifico = '1';
$scope.name;
$scope.lastName;
$scope.filtrarnombre = "";
$scope.chooseservices=[];
$scope.ocultarSeccionAdicionarPaquete = true;
$scope.paquete = {
		precio: 0,
		nombre: "",
		descripcion: "",
		activo: false,
		id : 0
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
	    $http.get('/viagging-providers-web/getServices',{
	        params: { idCategory: idCategoria }
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
	    	ngDialog.open({ template: 'template/html/paseoecologico.html', className: 'ngdialog-theme-default' });
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
		if($scope.paquete.precio > 2147483647){
			alert("Precio debe ser menor a 2147483648");
	    	//ngDialog.open({ template: 'popup.html', className: 'ngdialog-theme-popup' });
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
	        	  ngDialog.open({ template: 'popup.html', className: 'ngdialog-theme-popup' });
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
			 $http.get('/viagging-providers-web/getPackages',{
			    	params: { filtro: filtro }
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
			 $http.get('/viagging-providers-web/getPackage',{
			    	params: { idPackage: idPaquete }
			    }).
			    success(function(data, status, headers, config) {
			    	console.log(status);
			      $scope.listaServicios = data;
			      console.log(data);
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
}]);