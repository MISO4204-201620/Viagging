'use strict';

var marketPlaceApp = angular.module('viaggingApp', ['ui.router', 'ui.bootstrap', 'ngCart', 'ngHello']);

marketPlaceApp.config(['$stateProvider', 'helloProvider', function($stateProvider, helloProvider){

	helloProvider.init({
        twitter: 'myTwitterToken',
        facebook: '1528185660824408'
    },{
    	scope : 'email'
    });
	
	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: 'views/catalogue.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}],
				products : ['productsService', function(productsService){
					return productsService.getAllProducts();
				}]
			},
			controller: 'CatalogueCtrl',
			reloadOnSearch: true
		})
		.state("search", {
			url: "/search",
			templateUrl: 'views/search.html',
			params: { busqueda : null },
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}],
				products : ['productsService', '$stateParams', function(productsService, $stateParams){
					return productsService.getAllProducts();
				}]
			},
			controller: 'SearchCtrl'
		})
		.state("detail", {
			url: "/detail/:productId",
			templateUrl: 'views/detail.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}],
				product : ['productsService', '$stateParams', function(productsService, $stateParams){
					return productsService.getProductById($stateParams.productId);
				}]
			},
			controller: 'DetailCtrl'
		})
		.state("login", {
			url: "/login",
			templateUrl: '../app/views/login.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}]
			},
			controller: 'LoginCtrl'
		})
		.state("register", {
			url: "/register",
			templateUrl: '../app/views/register.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}]
			},
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
			resolve: {
				wishlist : ['wishListService', function(wishListService){
					return wishListService.getAllWishList();
				}]
			},
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
			resolve: {
				faq : ['faqService', function(faqService){
					return faqService.getAllFaqs();
				}]
			},
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