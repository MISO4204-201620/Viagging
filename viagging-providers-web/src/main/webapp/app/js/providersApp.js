'use strict';

var providersApp = angular.module('providersapp', ['ui.router', 'ui.bootstrap','ngDialog']);

providersApp.config(['$stateProvider', function($stateProvider){
    		$stateProvider
    			.state("login", {
    				url: "/login",
    				templateUrl: 'app/template/html/login.html',
    				controller: 'LoginCtrl',
    			})
    			.state("content", {
    				url: "/content",
    				templateUrl: '/contenido.html',
    			})
    			.state("query", {
    				url: "/query",
    				templateUrl: 'app/templates/html/consulta.html'
    			});
    			
}]);

providersApp.run(['$state', function run($state) {
	$state.go("login");
}]);
