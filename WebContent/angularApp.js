var app = angular.module("CityApp", []);

app.controller('maireCtrl', function($scope, $http) {
	$scope.search = function() {
		$http.get('http://localhost:8080/tp-jee-glassfish/rest/maire/all').
		then(function(response) {

			$scope.maires = [];
			console.log(response.data);
			response.data.forEach(function(maire) {
				$scope.maires.push({
					"ID" : maire[0],
					"Nom" : maire[1],
					"Prenom" : maire[2]
				});
			});

		});
	}
});

app.controller('communeCtrl', function($scope, $http) {
	$scope.search = function() {
		$http.get('http://localhost:8080/tp-jee-glassfish/rest/commune/all').
		then(function(response) {
			$scope.communes = [];
			console.log(response.data);
			response.data.forEach(function(commune) {
				$scope.communes.push({
					"ID" : commune[0],
					"Nom" : commune[1],
					"Maire" : commune[2]
				});
			});
		});
	}
});

app.controller('departementCtrl', function($scope, $http) {
	$scope.search = function() {
		$http.get('http://localhost:8080/tp-jee-glassfish/rest/departement/all').
		then(function(response) {
			$scope.dpts = [];
			console.log(response.data);
			response.data.forEach(function(dpt) {

				$scope.dpts.push({
					"ID" : dpt[0],
					"Nom" : dpt[1],
					"Code_Postale" : dpt[2]
				});
			});
		});
	}
});