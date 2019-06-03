(function() {
	"use strict";
	var config = function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');
		$stateProvider.state('ligaList',{
			url:'/liga',
			templateUrl:'app/components/liga/liga-list.html'
		}).state('liga',{
			url:'/liga/:id',
			templateUrl:'app/components/liga/liga.html'
		});
	}
	config.$inject = ["$stateProvider","$urlRouterProvider"];
	angular.module('com.example.demo.liga').config(config);
})();