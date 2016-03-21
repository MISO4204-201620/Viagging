'use strict';

var providersApp = angular.module('providersapp', ['ui.router', 'ui.bootstrap']);

providersApp.config(['$routeProvider',function($routeProvider) {
     $routeProvider.
      when('/login', {
        templateUrl: 'template/html/login.html',
        controller: 'AddOrderController'
      }).
      when('/showOrders', {
        templateUrl: 'templates/show-orders.html',
        controller: 'ShowOrdersController'
      }).
      otherwise({
        redirectTo: '/addOrder'
      });
}]);

providersApp.run(['$state', function run($state) {
	$state.go("home");
}]);
