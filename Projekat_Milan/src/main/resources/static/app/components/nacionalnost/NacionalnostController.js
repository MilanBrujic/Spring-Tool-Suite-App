(function() {
	"use strict";
	var NacionalnostController = function($stateParams, $location, NacionalnostService, ngDialog, $http, baseUrl) {
		var ctrl = this;
		if($stateParams.id === "add"){
			ctrl.nacionalnost = new NacionalnostService();
			ctrl.title = "Unos nove nacionalnosti";
		}else{
			NacionalnostService.get({id: $stateParams.id}).$promise.then(function(data) {
				ctrl.nacionalnost = data;
			});
			ctrl.title = "Modifikacija nacionalnosti ciji je id = "+$stateParams.id;
		}
		ctrl.save = function() {
			if($stateParams.id === "add")
				ctrl.nacionalnost.$insert(success);
			else
				ctrl.nacionalnost.$update(success);
		};

		function success() {
			$location.path('/nacionalnost');
		};

		ctrl.edit= function() {
			if($stateParams.id === "add")
				return false;
			else
				return true;
		};

		ctrl.remove = function() {
			ctrl.nacionalnost.$delete(success).then(function(value) {
				// sve je ok
			}, function(reason) {
				ngDialog.openConfirm({
					template: 'modalDialogDelete',
					className: 'ngdialog-theme-default'
				})
			});
		};

		ctrl.openConfirm = function(operacija) {
			ngDialog.openConfirm({
				template: 'modalDialogId',
				className: 'ngdialog-theme-default'
			}).then(function(value) {
				ctrl.remove();
			}, function(reason) {
				//nista
			});
		}
	};
	NacionalnostController.$inject = ["$stateParams","$location","NacionalnostService","ngDialog","$http","baseUrl"];
	angular.module('com.example.demo.nacionalnost').controller('NacionalnostController', NacionalnostController);
})();