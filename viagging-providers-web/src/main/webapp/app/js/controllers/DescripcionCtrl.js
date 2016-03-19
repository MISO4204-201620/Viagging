angular.module('descripcionapp',[]).controller('descripcioncontroller', ['$scope', '$http', function($scope, $http) {
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
    
    $scope.post = post;
    /*$http.post('/viagging-providers-web/getServices', post).
    success(function(data, status, headers, config) {
    	console.log(status);
      $scope.post = data;
      console.log(data);
    }).
    error(function(data, status, headers, config) {
    }); */
    console.log('despues de llamar');
}

}])