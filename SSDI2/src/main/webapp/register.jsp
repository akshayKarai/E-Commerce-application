<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
<head>
<link rel="stylesheet" type="text/css" href="../css/reg.css">
<title>Seller Register</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body ng-app="myapp">
 <div id ="signOutDiv" ng-controller="logoutController">
 	<div class="logoutLblPos"> 
 	<p>Already have an account?
 		<input name="signIn" type="submit" value="Sign In" ng-click="signIn()">
 	</p> 
 	<p>Not a seller?
 		<input name="home" type="submit" value="Buy Products" ng-click="goToHome()">
 	</p> 
 	</div> 
 </div>


<div id="container">
  <div class="signup">
     <form:form name="frm3" method="POST" action="/user/compRegister" modelAttribute="user">
       <form:input path = "firstname" type='text' placeholder='First Name' name="fname"
       data-ng-model="user.fname" required="required"  />
       <form:input path = "lastname" type='text' placeholder='Last Name' name="lname"
       data-ng-model="user.lname" required="required" />
       <form:input path = "emailid" placeholder='Email ID' type='email' name="email" 
       data-ng-model="user.email" required="required"  />
       <form:input path="password" type='password' placeholder='Password' name="password" 
       data-ng-model="user.password" required="required"  />
       <input type='submit' value='Start Selling !' />
     </form:form>
  </div>
  <div class="whysign">
    <h1>Sell your unused products today!</h1>
    <p>It is time to sell those products which you have stopped using for a while</p>
    
  </div>
</div>

<script>
var myApp = angular.module("myapp", []);
myApp.controller('logoutController', ['$scope',function($scope) {

    $scope.signIn = function(){   
    	 window.location = "/user/login";
    }
    $scope.goToHome = function(){   
   	 window.location = "/api/displayProducts";
   }

}]);


</script>

</body>
</html>