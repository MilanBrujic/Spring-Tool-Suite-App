(function() {
	"use strict";
	var IgracController = function($stateParams, $location, IgracService, ngDialog, $http, baseUrl) {
		var ctrl = this;
		if($stateParams.id === "add"){
			ctrl.igrac = new IgracService();
			ctrl.title = "Unos novog igraca";
		}else{
			IgracService.get({id: $stateParams.id}).$promise.then(function(data) {
				ctrl.igrac = data;
			});
			ctrl.title = "Modifikacija igraca čiji je id = "+$stateParams.id;
		}
		ctrl.save = function() {
			if($stateParams.id === "add")
				ctrl.igrac.$insert(success);
			else
				ctrl.igrac.$update(success);
		};

		function success() {
			$location.path('/igrac');
		};

		ctrl.edit= function() {
			if($stateParams.id === "add")
				return false;
			else
				return true;
		};

		ctrl.remove = function() {
			ctrl.igrac.$delete(success).then(function(value) {
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
	IgracController.$inject = ["$stateParams","$location","IgracService","ngDialog","$http","baseUrl"];
	angular.module('com.example.demo.igrac').controller('IgracController', IgracController);
})();