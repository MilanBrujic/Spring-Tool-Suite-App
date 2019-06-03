(function() {
	"use strict";
	var TimService = function($resource, baseUrl) {
		return $resource(baseUrl + "tim/:id",
				{id:"@id"},
				{
					insert: {method: "POST"},
					update: {method: "PUT"}
				}
		);
	};
	
	TimService.$inject = ["$resource","baseUrl"];
	angular.module('com.example.demo.tim').factory('TimService',TimService);
})();