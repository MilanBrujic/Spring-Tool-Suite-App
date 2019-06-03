(function() {
	"use strict";
	var LigaService = function($resource, baseUrl) {
		return $resource(baseUrl + "liga/:id",
				{id:"@id"},
				{
					insert: {method: "POST"},
					update: {method: "PUT"}
				}
		);
	};
	
	LigaService.$inject = ["$resource","baseUrl"];
	angular.module('com.example.demo.liga').factory('LigaService',LigaService);
})();