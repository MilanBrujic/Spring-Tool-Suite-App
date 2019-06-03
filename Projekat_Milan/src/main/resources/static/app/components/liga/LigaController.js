(function() {
	"use strict";
	var LigaController = function($stateParams, $location, LigaService, ngDialog, $http, baseUrl) {
		var ctrl = this;
		if($stateParams.id === "add"){
			ctrl.liga = new LigaService();
			ctrl.title = "Unos nove lige";
		}else{
			LigaService.get({id: $stateParams.id}).$promise.then(function(data) {
				ctrl.liga = data;
			});
			ctrl.title = "Modifikacija lige čiji je id = "+$stateParams.id;
		}
		ctrl.save = function() {
			if($stateParams.id === "add")
				ctrl.liga.$insert(success);
			else
				ctrl.liga.$update(success);
		};

		function success() {
			$location.path('/liga');
		};

		ctrl.edit= function() {
			if($stateParams.id === "add")
				return false;
			else
				return true;
		};

		ctrl.remove = function() {
			ctrl.liga.$delete(success).then(function(value) {
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
	LigaController.$inject = ["$stateParams","$location","LigaService","ngDialog","$http","baseUrl"];
	angular.module('com.example.demo.liga').controller('LigaController', LigaController);
})();