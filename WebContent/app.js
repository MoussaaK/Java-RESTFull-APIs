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
        data.forEach(function(maire) {
          
          $scope.maires.push({
        	  ID : maire.id,
	          Nom : maire.nom,
	          Prenom : maire.prenom
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
	    var city = $scope.cityName;
	    var tmpUrl = "http://localhost:8080/tp-jee-glassfish/rest/commune/all";
	    $.ajax({
	      contentType: "",
	      async: false,
	      method: "GET",
	      url: tmpUrl,
	      dataType: "json",
	      success: function(data) {
	        console.log(data);
	        data.forEach(function(commune) {
	          
	          $scope.communes.push({
	            ID : commune.id,
	            Nom : commune.nom,
	            Maire : commune.maire
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
	        data.Search.forEach(function(dpt) {
	          
	          $scope.dpts.push({
	        	  ID : dpts.id,
	        	  Nom : dpts.nom,
	        	  Code_Postale : dpts.code
	          });
	        }, this);
	        
	        console.log($scope.dpts);
	      }
	    });
	  }
	}
app.controller("departementCtrl", getDepartements);