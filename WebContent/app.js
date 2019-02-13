var app = angular.module("CityApp", []);

function getMaires($scope) {

  $scope.maires = [];
  $scope.search = function () {
    var city = $scope.cityName;
    var tmpUrl = "http://localhost:8080/tp-jee-glassfish/rest/maire/all";
    $.ajax({
      contentType: "",
      async: false,
      method: "GET",
      url: tmpUrl,
      dataType: "json",
      success: function(data) {
        console.log(data);
        data[0].forEach(function(maire) {
          
          $scope.maires.push({
        	  ID : maire[0],
	          Nom : maire[1],
	          Prenom : maire[2]
          });
        }, this);
        
        console.log($scope.maires);
      }
    });
  }
}
app.controller("maireCtrl", getMaires);

function getCommunes($scope) {

	  $scope.communes = [];
	  $scope.search = function () {
	    var tmpUrl = "http://localhost:8080/tp-jee-glassfish/rest/commune/all";
	    $.ajax({
	      contentType: "",
	      async: false,
	      method: "GET",
	      url: tmpUrl,
	      dataType: "json",
	      success: function(data) {
	        console.log(data);
	        data[0].forEach(function(commune) {
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

	  $scope.dpts = [];
	  $scope.search = function () {
	    var city = $scope.cityName;
	    var tmpUrl = "http://localhost:8080/tp-jee-glassfish/rest/departement/all";
	    $.ajax({
	      contentType: "",
	      async: false,
	      method: "GET",
	      url: tmpUrl,
	      dataType: "json",
	      success: function(data) {
	        console.log(data);
	        data[0].forEach(function(dpt) {
	          
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