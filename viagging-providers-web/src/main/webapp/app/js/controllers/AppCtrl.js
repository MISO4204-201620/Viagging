
var app = angular.module('sampleapp', ['ngDialog']).controller('samplecontroller', ['$scope', '$http','ngDialog','$rootScope', function($scope, $http,ngDialog, $rootScope) {
$scope.idEspecifico = '1';
$scope.name;
$scope.lastName;

$scope.test = function() { 	
    console.log('esta entrando primera parteddd'); 
   // ngDialog.open({ template: '../html/descripcionServicio.html', className: 'ngdialog-theme-default' });
    var post = {
    		userId: $scope.name,
			id : $scope.lastName,
			title : 'test',
			body: 'test'
	};
    $http.post('/viagging-providers-web/getServices', post).
    success(function(data, status, headers, config) {
    	console.log(status);
      $scope.post = data;
      console.log(data);
    }).
    error(function(data, status, headers, config) {
      // log error
    }); 
    console.log('despues de llamar');
}


$scope.test1 = function() { 
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


$scope.especifico = function(id) { 	
	$rootScope.idEspecifico = id;
    console.log('esta entrando primera parteddd'+id); 
    ngDialog.open({ template: '../html/descripcionServicio.html', className: 'ngdialog-theme-default' });
    console.log('despues de llamarbb');
}


}]);