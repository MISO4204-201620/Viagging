'use strict';

var providersApp = angular.module('viaggingApp', ['ui.router', 'ui.bootstrap','ngDialog', 'angularFileUpload']);

providersApp.config(['$stateProvider', function($stateProvider){
	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: 'template/html/login.html',
			controller: 'LoginCtrl'
		})
		.state("consultar", {
			url: "/consultar",
			templateUrl: 'template/html/consultarservicios.html',
			controller: 'samplecontroller',
		})
		.state("alojamiento", {
			url: "/alojamiento",
			templateUrl: 'template/html/crearalojamiento.html',
			controller: 'AlojamientoCtrl',
		})
		.state("alimentacion", {
			url: "/alimentacion",
			templateUrl: 'template/html/crearalimentacion.html',
			controller: 'AlimentacionCtrl',
		})
		.state("turismo", {
			url: "/turismo",
			templateUrl: 'template/html/crearturismo.html',
			controller: 'TurismoCtrl',
		})
		.state("transporte", {
			url: "/transporte",
			templateUrl: 'template/html/creartransporte.html',
			controller: 'TransporteCtrl',
		})
		.state("consultarpaquete", {
			url: "/consultarpaquete",
			templateUrl: 'template/html/consultaPaquete.html',
			controller: 'samplecontroller',
		})
		.state("paquete", {
			url: "/paquete",
			templateUrl: 'template/html/crearPaquete.html',
			controller: 'samplecontroller',
		})
		.state("pregunta", {
			url: "/pregunta",
			templateUrl: 'template/html/consultarpreguntas.html',
			controller: 'samplecontroller',
		});
}]);

providersApp.run(['$state', function run($state) {
	$state.go("home");
}]);
