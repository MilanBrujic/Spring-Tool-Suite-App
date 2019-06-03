(function() {
	"use strict";
	var NacionalnostService = function($resource, baseUrl) {
		return $resource(baseUrl + "nacionalnost/:id",
				{id:"@id"},
				{
					insert: {method: "POST"},
					update: {method: "PUT"}
				}
		);
	};
	
	NacionalnostService.$inject = ["$resource","baseUrl"];
	angular.module('com.example.demo.nacionalnost').factory('NacionalnostService',NacionalnostService);
})();