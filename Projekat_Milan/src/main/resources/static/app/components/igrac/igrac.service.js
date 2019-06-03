(function() {
	"use strict";
	var IgracService = function($resource, baseUrl) {
		return $resource(baseUrl + "igrac/:id",
				{id:"@id"},
				{
					insert: {method: "POST"},
					update: {method: "PUT"}
				}
		);
	};
	
	IgracService.$inject = ["$resource","baseUrl"];
	angular.module('com.example.demo.igrac').factory('IgracService',IgracService);
})();