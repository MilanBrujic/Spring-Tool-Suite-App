(function() {
	"use strict";
	var IgracListController = function($location, IgracService) {
		var ctrl = this;
		IgracService.query().$promise.then(function(data) {
			ctrl.igraci = data;
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
			$location.path("/igrac/"+id);
		};
	};
	IgracListController.$inject = ["$location","IgracService"];
	angular.module('com.example.demo.igrac').controller('IgracListController', IgracListController);
})();