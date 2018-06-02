<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
 <c:forEach items="${products}" var="product" varStatus="i">
 	<c:forEach items="${quotes}" var="quote" varStatus="j">
 	
   		<c:if test="${product.id == quote.productId}">
   			 <form:form name="frm4" method="POST" action="/pay/sendLink?id=${quote.productId}&email=${quote.buyerEmail }">
    		<p>Product Name : <c:out value="${product.name}"/></p>
    		<p>Product Base Price : $<c:out value="${product.basePrice }"/></p>
    		<p>Product Selling Price : $<c:out value="${product.minPrice }"/></p>
    		<p>Customer's Bid Price : $<c:out value="${quote.quotedPrice}"/></p>
    		<input type="submit" value="Ok"/>
    		</form:form>
		</c:if>
	</c:forEach>  
</c:forEach>

</body>
</html>
