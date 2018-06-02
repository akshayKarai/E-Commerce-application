<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/reg.css">
<title>New Product</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

</head>
<body>
 <div id ="logoutDiv">
 <form:form name="frm" method="POST" action="/user/logout"
 				modelAttribute="product">
 	<div class="logoutLblPos"> 
 		<input name="submit2" type="submit" id="submit2" value="log out"> 
 	</div> 
 </form:form> </div>

	<div id="container">
		<div class="signup">

			<form:form name="frm" method="POST" action="/api/addproductsuccess"
				modelAttribute="product">
				<form:input path="name" type='text'
					placeholder='Name of the Product' name="name"
					data-ng-model="product.name" required="required" />
				<form:input path="description" type='text' placeholder='Description'
					name="desc" data-ng-model="product.desc" required="required" />
				<form:input path="basePrice" placeholder='Base Price' type='number'
					min="0" name="bprice" data-ng-model="product.bprice"
					required="required" />
				<form:input path="minPrice" type='number' min="0"
					placeholder='Minimum Price' name="mprice"
					data-ng-model="product.bprice" required="required" />
				<form:input path="quantity" type='number' min="0"
					placeholder='Quantity' name="quan" data-ng-model="product.quan"
					required="required" />
				<form:input path="imageurl" type='text' placeholder='Image URL'
					name="url" data-ng-model="product.bprice" required="required" />
				<input type='submit' value='Post the Product !' />
			</form:form>

		</div>
		<div class="whysign">
			<h1>Hello ${uname}</h1>
			<p>Add the details for your product</p>

		</div>

	</div>

</body>
</html>