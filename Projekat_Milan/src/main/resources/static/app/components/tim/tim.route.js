(function() {
	"use strict";
	var config = function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');
		$stateProvider.state('timList',{
			url:'/tim',
			templateUrl:'app/components/tim/tim-list.html'
		}).state('tim',{
			url:'/tim/:id',
			templateUrl:'app/components/tim/tim.html'
		});
	}
	config.$inject = ["$stateProvider","$urlRouterProvider"];
	angular.module('com.example.demo.tim').config(config);
})();