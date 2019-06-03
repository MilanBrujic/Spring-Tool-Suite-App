(function() {
	"use strict";
	var LigaListController = function($location, LigaService) {
		var ctrl = this;
		LigaService.query().$promise.then(function(data) {
			ctrl.liga = data;
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
			$location.path("/liga/"+id);
		};
	};
	LigaListController.$inject = ["$location","LigaService"];
	angular.module('com.example.demo.liga').controller('LigaListController', LigaListController);
})();