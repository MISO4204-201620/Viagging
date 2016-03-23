'use strict';

var marketPlaceApp = angular.module('viaggingApp', ['ui.router', 'ui.bootstrap', 'ngCart']);

marketPlaceApp.config(['$stateProvider', function($stateProvider){

	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: '../app/views/catalogue.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}],
				products : ['productsService', function(productsService){
					return productsService.getAllProducts();
				}]
			},
			controller: 'CatalogueCtrl'
		})
		.state("detail", {
			url: "/detail/:serviceId",
			templateUrl: '../app/views/detail.html',
			resolve: {
				product : ['productsService', '$stateParams', function(productsService, $stateParams){
					var productId = $stateParams.serviceId;
					return productsService.getDetailedProductById(productId);
				}]
			},
			controller: 'DetailCtrl'
		})
		.state("login", {
			url: "/login",
			templateUrl: '../app/views/login.html',
			controller: 'LoginCtrl'
		})
		.state("register", {
			url: "/register",
			templateUrl: '../app/views/register.html',
			controller: 'RegisterCtrl'
		})
		.state("cart", {
			url: "/cart",
			templateUrl: '../app/views/cart.html'
		})
		.state("checkout", {
			url: "/checkout",
			templateUrl: '../app/views/checkout.html',
			controller: 'CheckoutCtrl'
		})
		.state("wishlist", {
			url: "/user/wishlist",
			templateUrl: '../app/views/wishlist.html',
			controller: 'WishlistCtrl'
		})
		.state("profile", {
			url: "/user/profile",
			templateUrl: '../app/views/profile.html',
			controller: 'ProfileCtrl'
		})
		.state("messages", {
			url: "/user/messages",
			templateUrl: '../app/views/messages.html',
			controller: 'MessagesCtrl'
		})
		.state("purchases", {
			url: "/user/purchases",
			templateUrl: '../app/views/purchases.html',
			controller: 'PurchasesCtrl'
		})
		.state("faq", {
			url: "/faq",
			templateUrl: '../app/views/faq.html',
			controller: 'FaqCtrl'
		})
		.state("compare", {
			url: "/compare",
			templateUrl: '../app/views/compare.html'
		})
		.state("contact", {
			url: "/contact",
			templateUrl: '../app/views/contact.html',
			controller: 'ContactCtrl'
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