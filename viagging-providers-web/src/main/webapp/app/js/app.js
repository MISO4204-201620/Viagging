'use strict';

var marketPlaceApp = angular.module('sampleapp', ['ui.router', 'ui.bootstrap']);

marketPlaceApp.config(['$stateProvider', function($stateProvider){

	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: '../app/views/main.html'
		})
		.state("catalogue", {
			url: "/catalogue",
			templateUrl: '../app/views/catalogue.html'
		})
		.state("detail", {
			url: "/detail",
			templateUrl: '../app/views/detail.html'
		})
		.state("login", {
			url: "/login",
			templateUrl: '../app/views/login.html'
		})
		.state("register", {
			url: "/register",
			templateUrl: '../app/views/register.html'
		})
		.state("cart", {
			url: "/cart",
			templateUrl: '../app/views/cart.html'
		})
		.state("checkout", {
			url: "/checkout",
			templateUrl: '../app/views/checkout.html'
		})
		.state("compare", {
			url: "/compare",
			templateUrl: '../app/views/compare.html'
		})
		.state("contact", {
			url: "/contact",
			templateUrl: '../app/views/contact.html'
		})
		.state("typography", {
			url: "/typography",
			templateUrl: '../app/views/typography.html'
		})
		.state("about", {
			url: "/about",
			templateUrl: '../app/views/about.html'
		});
}]);

marketPlaceApp.run(['$state', function run($state) {
	$state.go("home");
}]);
