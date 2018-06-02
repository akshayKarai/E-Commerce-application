<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div ng-app="app" class="container">
  <form ng-controller="PaymentFormCtrl" class="payment-form" name="paymentForm">
    <div class="notification">
      <img src=""  class="notification__icon"/>
      <span class="notification__text">
     Credit Card Details
      </span>
    </div>
    <div class="card-type clearfix">
      <div class="card-type__label">
        Credit/Debit Card
      </div>
      <div class="card-type__icons">
        <img src="" class="" ng-class="" />
        <img src="" class="" ng-class=""/>
      </div>
    </div>
    <input type="text" class="card-input card-input--full" placeholder="Card Number*" ng-model="card.number" required card-number/>
    <input type="text" class="card-input card-input--full" placeholder="Name On Card" ng-model="card.holder" card-holder required/>
    <div class="card-info clearfix">
      <div class="card-info__date">
        <div class="card-info__text">
         Card Expiry 
        </div>
       
  </form>
</div>
</body>
</html>