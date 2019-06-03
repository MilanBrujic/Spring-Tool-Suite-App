(function() {
	"use strict";
	var SideBarController = function($location) {
		var sbc = this;
		sbc.isActive = function(path) {
			return $location.path().indexOf != -1;
		}
	}
	SideBarController.$inject = ["$location"];
	angular.module('com.example.demo.core').controller('SideBarController', SideBarController);
})();