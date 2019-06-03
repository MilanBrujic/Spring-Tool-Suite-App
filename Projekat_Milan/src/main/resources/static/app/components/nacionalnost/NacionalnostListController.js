(function() {
	"use strict";
	var NacionalnostListController = function($location, NacionalnostService) {
		var ctrl = this;
		NacionalnostService.query().$promise.then(function(data) {
			ctrl.nacionalnosti = data;
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
			$location.path("/nacionalnost/"+id);
		};
	};
	NacionalnostListController.$inject = ["$location","NacionalnostService"];
	angular.module('com.example.demo.nacionalnost').controller('NacionalnostListController', NacionalnostListController);
})();