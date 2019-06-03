(function(){
	angular.module('com.example.demoApp',['com.example.demo.core','com.example.demo.igrac','com.example.demo.liga','com.example.demo.nacionalnost','com.example.demo.tim'])
	.constant("baseUrl","http://localhost:8088/");
})
();