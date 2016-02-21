   //this is the definition for a new angularjs single page application

var app = angular.module('sampleapp', []).controller('samplecontroller', ['$scope', '$http', function($scope, $http) {

$scope.name;
$scope.lastName;

$scope.test = function() {    	
    console.log('esta entrando primera parte');
  
    
    var post = {
    		userId: $scope.name,
			id : $scope.lastName,
			title : 'test',
			body: 'test'
	};
    $http.post('/market-place-viagging-web/savePost', post).
    success(function(data, status, headers, config) {
      $scope.post = data;
      console.log(data);
    }).
    error(function(data, status, headers, config) {
      // log error
    }); 
    console.log('despues de llamar');
}

}]);