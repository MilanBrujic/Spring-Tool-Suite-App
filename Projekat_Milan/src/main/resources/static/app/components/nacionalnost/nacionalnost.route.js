(function() {
	"use strict";
	var config = function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');
		$stateProvider.state('nacionalnostList',{
			url:'/nacionalnost',
			templateUrl:'app/components/nacionalnost/nacionalnost-list.html'
		}).state('nacionalnost',{
			url:'/nacionalnost/:id',
			templateUrl:'app/components/nacionalnost/nacionalnost.html'
		});
	}
	config.$inject = ["$stateProvider","$urlRouterProvider"];
	angular.module('com.example.demo.nacionalnost').config(config);
})();