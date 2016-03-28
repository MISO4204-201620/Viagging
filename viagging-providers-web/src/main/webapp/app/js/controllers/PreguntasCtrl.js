providersApp.controller('PreguntasCtrl', ['$scope', '$http', function($scope, $http) {

	$scope.question;
	$scope.id;
	
	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getQuestions').
		success(function(data, status, headers, config) {
			console.log("caracteristicas" + data);
			$scope.questions = data;
		}).
		error(function(data, status, headers, config) {
		});
	});
	
	$scope.getPregunta = function(idPregunta) { 
		for (var i = 0; i < $scope.questions.length; i++) {
			if ($scope.questions[i].id == idPregunta) {
				$scope.question = $scope.questions[i];
				$scope.id = $scope.question.id;
			}
		}
    }
	
	$scope.test = function() { 
		console.log("ingresando a test" + $scope.id);
    }

}]);