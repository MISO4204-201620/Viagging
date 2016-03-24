marketPlaceApp.controller('MenuCtrl', ['$scope', '$location', '$state', 'loginService',
    function($scope, $location, $state, loginService){
	
	$scope.logoutUser = function(){
		loginService.logoutUser();
		$scope.isUserLoggedIn = false;
		$state.go("home");
	};
	
//	$timeout(function(){
//		angular.element('.navbar-nav li').on('click', function(e){
//			angular.element('.navbar-nav li .active').removeClass('active');
//			var href = angular.element(this).find('a').attr('href');
//			if(href != null && href != "#"){
//				angular.element(this).find('a').addClass('active');
//			}			
//		});
//	});
	
//	$scope.isStateActive = function (path) {
//	  return ($location.path().substr(0, path.length) === path) ? 'active' : '';
//	};
	
}]);