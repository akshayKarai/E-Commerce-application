<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="../css/reg.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Seller Register</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body ng-app="myapp">
	<div ng-controller="logoutController" >
		
	</div>
	<div id="container">
		<div class="signup">
			<form:form name="frm3" method="POST" action="/user/compRegisterBuyer"
				modelAttribute="user">
				<form:input path="firstname" type='text' placeholder='First Name'
					name="fname" data-ng-model="user.fname" required="required" />
				<form:input path="lastname" type='text' placeholder='Last Name'
					name="lname" data-ng-model="user.lname" required="required" />
				<form:input path="emailid" placeholder='Email ID' type='email'
					name="email" data-ng-model="user.email" required="required" readonly="true"/>
				<form:input path="password" type='password' placeholder='Password'
					name="password" data-ng-model="user.password" required="required" />
				<input type='submit' value='Get your Deal !' />
			</form:form>
		</div>
		<div class="whysign">
			<h1>Get your deal today!</h1>
			<p>It is time for savings, go light on your pocket</p>

		</div>
	</div>

	<script>
		var myApp = angular.module("myapp", []);
		$scope.user.email = <% %>;
		myApp.controller('logoutController', [ '$scope', function($scope) {

			$scope.signIn = function() {
				window.location = "/user/login";
			}
			$scope.goToHome = function() {
				window.location = "/api/DisplayProducts";
			}

		} ]);
	</script>

</body>
</html>