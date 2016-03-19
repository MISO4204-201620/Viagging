
var app = angular.module('sampleapp', ['ngDialog']).controller('samplecontroller', ['$scope', '$http','ngDialog','$rootScope', function($scope, $http,ngDialog, $rootScope) {
$scope.idEspecifico = '1';
$scope.name;
$scope.lastName;
$scope.chooseservices=[];
var servicesSelect = {
		id: "f",
		nombre : "f",
		precio : "f",
		descripcionCorta: "f",
	    datosServicio : false
};

//$scope.getCategory();
   $scope.getCategory = function() { 
		console.log('esta entrando category'); 
		 /*  $scope.category = 
			        [
				      {key: '01', value: 'TRANSPORTE'},
				      {key: '02', value: 'ALOJAMIENTO'},
				      {key: '03', value: 'PASEO_ECOLOGICO'},
				      {key: '04', value: 'ALIMENTACION'}
				    ];
				   */
		console.log($scope.category);
		 $http.get('/viagging-providers-web/getCategory').
		    success(function(data, status, headers, config) {
		    	console.log(status);
		      $scope.category = data;
		      console.log(data);
		    }).
		    error(function(data, status, headers, config) {
		      // log error
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
	      // log error
	    }); 


	    
	    
	    console.log('despues de llamar');
	}



	$scope.test1 = function() { 
		console.log("alojamiento");
		console.log($rootScope.idEspecifico);
	    var post = {
	    		userId: $scope.name,
				id : $scope.lastName,
				title : 'test1',
				body: 'test12'
		};
	    
	    $scope.post1 = post;
	    $http.post('/viagging-providers-web/savePost', post).
	    success(function(data, status, headers, config) {
	    	console.log(status);
	      $scope.post1 = data;
	      console.log(data);
	    }).
	    error(function(data, status, headers, config) {
	    }); 
	    console.log('despues de llamar');
	}


	$scope.especifico = function(id,idCategoria) { 	
		$rootScope.idEspecifico = id;
	    console.log('especifico'+id + "---"+idCategoria); 
	    ngDialog.open({ template: '../html/transporte.html', className: 'ngdialog-theme-default' });
	    if(idCategoria == "01"){
	         ngDialog.open({ template: '../html/transporte.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "02"){
	    	ngDialog.open({ template: '../html/alojamiento.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "03"){
	    	ngDialog.open({ template: '../html/paseoEcologico.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "04"){
	    	ngDialog.open({ template: '../html/alimentacion.html', className: 'ngdialog-theme-default' });
	    }
	    console.log('despues de llamarbb especifico');
	}



	$scope.saveServicesTemp = function() { 	
	      for (var i=0;i<$scope.listservices.length;i++){
	    	  console.log("saveServicesTemp---"+i); 
	    	  var flagExist = false;
	    	  if($scope.listservices[i].datosServicio){
		    	  for (var j=0;j<$scope.chooseservices.length;j++){
		    	       if($scope.listservices[i].id == $scope.chooseservices[j].id){
		    	    	   flagExist = true;		    	    	   
		              }
		    	  }
		    	  if(!flagExist){
		    		  console.log("saveServicesTempdddd---"+i); 
		    		  $scope.chooseservices.push($scope.listservices[i]);
		    	  }
	    	  }
	    	  
	      }		
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
	    console.log('despues de llamar');
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
		console.log("Alimentacion");
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
	    console.log('despues de llamar');
	}
}]);