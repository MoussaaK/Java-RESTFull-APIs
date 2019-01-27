var app = angular.module("CityApp", []);

function getMaires($scope) {

  $scope.items = [];
  $scope.search = function () {
    var city = $scope.cityName;
    var tmpUrl = "http://www.omdbapi.com/?s=" + city + "&apikey=12543596&page=1";
    $.ajax({
      contentType: "",
      async: false,
      method: "GET",
      url: tmpUrl,
      dataType: "json",
      success: function(data) {
        console.log(data);
        data.Search.forEach(function(item) {
          
          $scope.items.push({
            Name : item.Title,
            Year : item.Year,
            Reference : item.imdbID
          });
        }, this);
        
        $scope.orderByMe = function(x) {
            $scope.myOrderBy = x;
          }
        console.log($scope.items);
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
	        
	        $scope.orderByMe = function(x) {
	            $scope.myOrderBy = x;
	          }
	        console.log($scope.items);
	      }
	    });
	  }
	}
app.controller("communeCtrl", getCommunes);

function getDepartements($scope) {

	  $scope.items = [];
	  $scope.search = function () {
	    var city = $scope.cityName;
	    var tmpUrl = "";
	    $.ajax({
	      contentType: "",
	      async: false,
	      method: "GET",
	      url: tmpUrl,
	      dataType: "json",
	      success: function(data) {
	        console.log(data);
	        data.Search.forEach(function(item) {
	          
	          $scope.items.push({
	            Name : item.Title,
	            Year : item.Year,
	            Reference : item.imdbID
	          });
	        }, this);
	        
	        $scope.orderByMe = function(x) {
	            $scope.myOrderBy = x;
	          }
	        console.log($scope.items);
	      }
	    });
	  }
	}
app.controller("departementCtrl", getDepartements);