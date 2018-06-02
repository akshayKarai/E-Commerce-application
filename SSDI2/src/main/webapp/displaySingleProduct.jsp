<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/ui-bootstrap-tpls-2.5.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/product.css">
<link rel="stylesheet" type="text/css" href="../css/login.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">

<head>
    <meta charset="UTF-8">
    <title>E-Commerce</title>
</head>
<body>

<div id="header">
 <div class="container">
        <div class="leftbox">
            LOGO image
            </div>
</div></div>

<div>

   <c:forEach items="${productList}" var="prod" varStatus="x">
   <div class="wrapper" style="height: 800px">
  <div class="container">
  <div class="jumbotron">
    <div class="top"><img alt="" style="width:200px" height="200px" src='<c:out value="${prod.imageurl}" />'></div>
      <div class="left">
       <form:form name="frm4" method="POST" action="/pay/sendEmail"  modelAttribute="quoteandid">
	        <div class="details">
	          <h1><c:out value="${prod.name}"/></h1>
	          <p>Base Price: $<c:out value="${prod.basePrice}" /></p>
	          <p>Bid price: $<c:out value="${quoteandid.quotedPrice}" /></p>
	          <!-- <p>You save $ <% %></p> -->
	        </div>
	        <form:hidden path="quotedPrice" />
	        <form:hidden path="productId" />
	        <p> <form:input path="buyerEmail" placeholder='Email ID' type='email'
					name="email" data-ng-model="quoteandid.buyerEmail" required="required" />
	       <input type='submit' value='Confirm Purchase' /> </p>
	        </form:form>
      </div>
      
      <div class="right">
        <div class="done"><i class="material-icons"></i></div>
		        <div class="details">
				       <label>Product Details:</label>
				       <p><c:out value="${prod.description}" /></p>
        		</div>
      </div>
  </div>
  </div></div>
</c:forEach>


</div>
</body>
</html>