angular.module('viaggingApp', [])
.controller('AppCtrl', ['$scope', '$http', function($scope, $http) {
	
	$scope.test = function() {
    	console.log("aaa");
    }
	
	var load = function(page, url) {
		$http({
	    	method: 'GET', 
	    	url: url+"&p_p_resource_id=adList"
		})	.then(function(response) {
			var data = response.data;
			$scope.records = [];	
        	angular.forEach(data, function(value, key){
                if(value.status != "PENDIENTE_MODIFICACION")
                	$scope.records.push(value);
        	});
        	
        	$scope.pagination.numPages = Math.ceil($scope.records.length / $scope.pagination.perPage);
            $scope.pagination.totalRecords = $scope.records.length;
            $scope.pagination.page = page;
            $scope.orderSearch('id', false);
        }, function(error) {
        });
	}


}])