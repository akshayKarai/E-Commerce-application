<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
	
</script>
<link rel="stylesheet" type="text/css" href="../css/product.css">
<link rel="stylesheet" type="text/css" href="../css/login.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">

<head>
<meta charset="UTF-8">
<title>E-Commerce</title>
</head>
<body ng-app="myapp">

	<div id="header">
		<div class="container">
			<div class="leftbox">LOGO image</div>
			<div class="rightbox" ng-controller="loginController">
				<form class="form-signin">
					<h2 style="color: black;">Start selling right away!</h2>
					<br>
					<button class="btn btn-lg btn-primary btn-block" type="button"
						ng-click="goLogin()">Sign in</button>
					<button class="btn btn-lg btn-primary btn-block" type="button"
						ng-click="goReg()">Register</button>
				</form>

			</div>
		</div>
	</div>

	<div ng-controller="productController">

		<c:forEach items="${productList}" var="prod" varStatus="x">
			<div class="wrapper">
				<div class="container">
					<div class="jumbotron">
						<div class="top">
							<img alt="" style="width: 200px" height="200px"
								src='<c:out value="${prod.imageurl}" />'>
						</div>
						<div class="left">
							<div class="details">
								<h1>
									<c:out value="${prod.name}" />
								</h1>
								<p>
									$<c:out value="${prod.basePrice}" />
								</p>
							</div>
							<div id="buy${x.index}" style="display: none">
								<label style="color: Green">Successful Bid!</label> <input
									style="width: 100px" height="80px" type="button" value="Buy"
									ng-click="buy(${prod.id})" />
							</div>
						</div>

						<div class="right">
							<div class="done">
								<i class="material-icons"></i>
							</div>
							<div class="details">
								<label>Quote Price:<input type="number"
									id="divIDNo${x.index}" ></label>
								<button type="button"
									ng-click="quote(${x.index},${prod.minPrice},${prod.id})"
									style="width: 100px">Quote</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

		<script>
			var myApp = angular.module("myapp", []);
			var quotedPrice;
			myApp.controller('loginController', [ '$scope', function($scope) {
				$scope.goReg = function() {
					window.location = "/user/register";
				}

				$scope.goLogin = function() {
					window.location = "/user/login";
				}
			} ]);

			myApp.controller(
							'productController',
							[
									'$scope',
									function($scope) {

										$scope.quote = function(id, minPrice,
												prodId) {
											//     	window.alert("id " +id);
											//     	window.alert("minPrice " +minPrice);
											quotedPrice = document
													.getElementById("divIDNo"
															+ id).value;
											//     	window.alert("quoted Price " + quotedPrice);
											if (quotedPrice >= minPrice) {
												window
														.alert("Successful quote, redirecting...");
												document.getElementById("buy"
														+ id).style.display = 'block';
												return true;
											} else {
												window
														.alert("Please increase your bid!");
												return false;
											}
										}

									$scope.buy = function(prodId) {
											window.alert(quotedPrice);
											window.location = "/api/buyProduct?prodId="
													+ prodId
													+ "&quote="
													+ quotedPrice;
										}
										
									/*$scope.buy = function(prodId) {
											window.alert(quotedPrice);
											window.location = "/api/buyProduct?prodId="+prodId;
										}*/

									} ]);
		</script>
	</div>
</body>
</html>