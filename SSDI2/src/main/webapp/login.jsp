<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/reg.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<title>Log In</title>
</head>
<body ng-app="myapp">

<div id ="registerDiv" ng-controller="registerController">
 	<div class="logoutLblPos"> 
 	<p>Don't have an account?
 		<input name="signIn" type="submit" value="Register" ng-click="register()">
 	</p> 
 	<p>Not a seller?
 		<input name="home" type="submit" value="Buy Products" ng-click="goToHome()">
 	</p> 
 	</div> 
 </div>


<div id="container">
  <div class="signup">
     <form:form method="POST" action="/user/compLogin" modelAttribute="user">
       <form:input path = "emailid" type='email' placeholder='Email ID'  name="email" 
       data-ng-model="user.email" required="required" />
       <form:input path="password" type='password' placeholder='Password' name="password" 
       data-ng-model="user.password" required="required"   />
       <span>${error}</span>
       <input type='submit' value='Log In' />
     </form:form>
  </div>
  <div class="whysign">
    <h1>Welcome Back!</h1>
    <p>Continue selling your unused products</p>
    
  </div>
</div>

<script>
var myApp = angular.module("myapp", []);
myApp.controller('registerController', ['$scope',function($scope) {

    $scope.register = function(){   
    	 window.location = "/user/register";
    }
    $scope.goToHome = function(){   
   	 window.location = "/api/displayProducts";
   }

}]);


</script>

</body>
</html>