(function() {
	"use strict";
	var TimController = function($stateParams, $location, TimService, ngDialog, $http, baseUrl) {
		var ctrl = this;
		if($stateParams.id === "add"){
			ctrl.tim = new TimService();
			ctrl.title = "Unos novog tima";
		}else{
			TimService.get({id: $stateParams.id}).$promise.then(function(data) {
				ctrl.tim = data;
			});
			ctrl.title = "Modifikacija tima ciji je id = "+$stateParams.id;
		}
		ctrl.save = function() {
			if($stateParams.id === "add")
				ctrl.tim.$insert(success);
			else
				ctrl.tim.$update(success);
		};

		function success() {
			$location.path('/tim');
		};

		ctrl.edit= function() {
			if($stateParams.id === "add")
				return false;
			else
				return true;
		};

		ctrl.remove = function() {
			ctrl.tim.$delete(success).then(function(value) {
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
	TimController.$inject = ["$stateParams","$location","TimService","ngDialog","$http","baseUrl"];
	angular.module('com.example.demo.tim').controller('TimController', TimController);
})();