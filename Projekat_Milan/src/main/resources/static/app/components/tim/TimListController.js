(function() {
	"use strict";
	var TimListController = function($location, TimService) {
		var ctrl = this;
		TimService.query().$promise.then(function(data) {
			ctrl.timovi = data;
		});
		
		ctrl.tableChanged = function(sortParam) {
			if(ctrl.sort === sortParam){
				ctrl.sortDirection = ctrl.sortDirection == '+' ? '-' : '+';
			}else{
				ctrl.sort = sortParam;
				ctrl.sortDirection = '+';
			}
		};
		
		ctrl.edit = function(id) {
			$location.path("/tim/"+id);
		};
	};
	TimListController.$inject = ["$location","TimService"];
	angular.module('com.example.demo.tim').controller('TimListController', TimListController);
})();