var app = angular.module("CityApp", []);

function getMaires($scope) {
	
	$scope.search = function () {
		$scope.maires = [];
		var resource_url = "http://localhost:8080/tp-jee-glassfish/rest/maire/all";
		$.ajax({
			contentType: "",
			async: false,
			method: "GET",
			url: resource_url,
			dataType: "json",
			success: function(data) {
				console.log(data);
				data.forEach(function(maire) {
					$scope.maires.push({
						"ID" : maire[0],
						"Nom" : maire[1],
						"Prenom" : maire[2]
					});
				}, this);

				console.log($scope.maires);
			}
		});
	}
}
app.controller("maireCtrl", getMaires);

function getCommunes($scope) {
	$scope.search = function () {
		$scope.communes = [];
		var resource_url = "http://localhost:8080/tp-jee-glassfish/rest/commune/all";
		$.ajax({
			contentType: "",
			async: false,
			method: "GET",
			url: resource_url,
			dataType: "json",
			success: function(data) {
				console.log(data);
				data.forEach(function(commune) {
					$scope.communes.push({
						"ID" : commune[0],
						"Nom" : commune[1],
						"Maire" : commune[2]
					});
				}, this);

				console.log($scope.communes);
			}
		});
	}
}
app.controller("communeCtrl", getCommunes);

function getDepartements($scope) {
	
	$scope.search = function () {
		$scope.dpts = [];
		var city = $scope.cityName;
		var resource_url = "http://localhost:8080/tp-jee-glassfish/rest/departement/all";
		$.ajax({
			contentType: "",
			async: false,
			method: "GET",
			url: resource_url,
			dataType: "json",
			success: function(data) {
				console.log(data[0]);
				data.forEach(function(dpt) {

					$scope.dpts.push({
						"ID" : dpt[0],
						"Nom" : dpt[1],
						"Code_Postale" : dpt[2]
					});
				}, this);
				console.log($scope.dpts);
			}
		});
	}
}
app.controller("departementCtrl", getDepartements);