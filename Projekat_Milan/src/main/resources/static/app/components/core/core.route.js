(function() {
	"use strict";
	var config = function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');
		$stateProvider.state('home',{
			url:'/home',
			templateUrl:'app/components/core/home.html'
		}).state('about',{
			url:'/about',
			templateUrl:'app/components/core/about.html'
		});
	}
	config.$inject = ["$stateProvider","$urlRouterProvider"];
	angular.module('com.example.demo.core').config(config);
})();
