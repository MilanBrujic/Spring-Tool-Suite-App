(function() {
	"use strict";
	var config = function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');
		$stateProvider.state('igracList',{
			url:'/igrac',
			templateUrl:'app/components/igrac/igrac-list.html'
		}).state('igrac',{
			url:'/igrac/:id',
			templateUrl:'app/components/igrac/igrac.html'
		});
	}
	config.$inject = ["$stateProvider","$urlRouterProvider"];
	angular.module('com.example.demo.igrac').config(config);
})();