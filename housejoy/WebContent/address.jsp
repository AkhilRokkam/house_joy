<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html lang="en">

<head>
<title>Address Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	


<style>
body {
	font-family: 'Varela Round', sans-serif;
}

.form-control {
	box-shadow: none;
	font-weight: normal;
	font-size: 13px;
}

.form-control:focus {
	border-color: #33cabb;
	box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
}

.navbar-header.col {
	padding: 0 !important;
}

.navbar {
	background: #bd4646;
	padding-left: 16px;
	padding-right: 16px;
	border-bottom: 1px solid #dfe3e8;
	border-radius: 0;
}

.nav-link img {
	color: #fff199;
	border-radius: 50%;
	width: 36px;
	height: 36px;
	margin: -8px 0;
	float: left;
	margin-right: 10px;
}

.navbar .navbar-brand, .navbar .navbar-brand:hover, .navbar .navbar-brand:focus
	{
	padding-left: 0;
	font-size: 40px;
	padding-right: 50px;
	color: #deef21;
}

.navbar .navbar-brand b {
	font-weight: bold;
	color: #fff199;
}

.navbar .form-inline {
	display: inline-block;
}

.navbar .nav li {
	position: relative;
}

.navbar .nav li a {
	color: #fff199;
}

.search-box {
	position: relative;
}

.search-box input {
	padding-right: 35px;
	border-color: #dfe3e8;
	border-radius: 4px !important;
	box-shadow: none
}

.search-box .input-group-addon {
	min-width: 35px;
	border: none;
	background: transparent;
	position: absolute;
	right: 0;
	z-index: 9;
	padding: 7px;
	height: 100%;
}

.search-box i {
	color: #a0a5b1;
	font-size: 19px;
}

.navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
	color: #fff199;
	background: #bd4646;
	padding-top: 8px;
	padding-bottom: 6px;
	vertical-align: middle;
	border: none;
}

.navbar .nav .btn-primary:hover, .navbar .nav .btn-primary:focus {
	color: #fff199;
	outline: none;
	background: #f44242;
}

.navbar .navbar-right li:first-child a {
	padding-right: 30px;
}

.navbar .nav-item i {
	font-size: 18px;
}

.navbar .dropdown-item i {
	font-size: 16px;
	min-width: 22px;
}

.navbar ul.nav li.active a, .navbar ul.nav li.open>a {
	background: transparent !important;
}

.navbar .nav .get-started-btn {
	min-width: 120px;
	margin-top: 8px;
	margin-bottom: 8px;
}

.navbar ul.nav li.open>a.get-started-btn {
	color: #fff199;
	background: #f44242 !important;
}

.navbar .dropdown-menu {
	border-radius: 1px;
	border-color: #e5e5e5;
	box-shadow: 0 2px 8px rgba(0, 0, 0, .05);
}

.navbar .nav .dropdown-menu li {
	color: #999;
	font-weight: normal;
}

.navbar .nav .dropdown-menu li a, .navbar .nav .dropdown-menu li a:hover,
	.navbar .nav .dropdown-menu li a:focus {
	padding: 8px 20px;
	line-height: normal;
	color: #9B1905;
}

.navbar .navbar-form {
	border: none;
}

.navbar .dropdown-menu.form-wrapper {
	width: 280px;
	padding: 20px;
	left: auto;
	right: 0;
	font-size: 14px;
}

.navbar .dropdown-menu.form-wrapper a {
	color: #33cabb;
	padding: 0 !important;
}

.navbar .dropdown-menu.form-wrapper a:hover {
	text-decoration: underline;
}

.navbar .form-wrapper .hint-text {
	text-align: center;
	margin-bottom: 15px;
	font-size: 13px;
}

.navbar .form-wrapper .social-btn .btn, .navbar .form-wrapper .social-btn .btn:hover
	{
	color: #fff;
	margin: 0;
	padding: 0 !important;
	font-size: 13px;
	border: none;
	transition: all 0.4s;
	text-align: center;
	line-height: 34px;
	width: 47%;
	text-decoration: none;
}

.navbar .social-btn .btn-primary {
	background: #507cc0;
}

.navbar .social-btn .btn-primary:hover {
	background: #4676bd;
}

.navbar .social-btn .btn-info {
	background: #64ccf1;
}

.navbar .social-btn .btn-info:hover {
	background: #4ec7ef;
}

.navbar .social-btn .btn i {
	margin-right: 5px;
	font-size: 16px;
	position: relative;
	top: 2px;
}

.navbar .form-wrapper .form-footer {
	text-align: center;
	padding-top: 10px;
	font-size: 13px;
}

.navbar .form-wrapper .form-footer a:hover {
	text-decoration: underline;
}

.navbar .form-wrapper .checkbox-inline input {
	margin-top: 3px;
}

.or-seperator {
	margin-top: 32px;
	text-align: center;
	border-top: 1px solid #e0e0e0;
}

.or-seperator b {
	color: #666;
	padding: 0 8px;
	width: 30px;
	height: 30px;
	font-size: 13px;
	text-align: center;
	line-height: 26px;
	background: #fff;
	display: inline-block;
	border: 1px solid #e0e0e0;
	border-radius: 50%;
	position: relative;
	top: -15px;
	z-index: 1;
}

.navbar .checkbox-inline {
	font-size: 13px;
}

.navbar .navbar-right .dropdown-toggle::after {
	display: none;
}

@media ( min-width : 1200px) {
	.form-inline .input-group {
		width: 300px;
		margin-left: 30px;
	}
}

@media ( max-width : 768px) {
	.navbar .dropdown-menu.form-wrapper {
		width: 100%;
		padding: 10px 15px;
		background: transparent;
		border: none;
	}
	.navbar .form-inline {
		display: block;
	}
	.navbar .input-group {
		width: 100%;
	}
	.navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
		display: block;
	}
}

h2 {
	color: #000;
	font-size: 26px;
	font-weight: 300;
	text-align: center;
	text-transform: uppercase;
	position: relative;
	margin: 30px 0 80px;
}

h2 b {
	color: #ffc000;
}

h2::after {
	content: "";
	width: 100px;
	position: absolute;
	margin: 0 auto;
	height: 4px;
	background: rgba(0, 0, 0, 0.2);
	left: 0;
	right: 0;
	bottom: -20px;
}

.dropdown-menu li, .cust-hand {
	cursor: pointer;
}

.modal-content {
	border-radius: 0px;
}

.cust-smll-btn {
	padding: 0px 10px;
}
</style>





	


<!------ Include the above in your HEAD tag ---------->
<body>
<nav class="navbar navbar-default navbar-expand-lg navbar-light">
		<div class="navbar-header d-flex col">
			<a class="navbar-brand" href="#">House<b>Joy</b></a>
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
				<span class="navbar-toggler-icon"></span> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>
		<!-- Collection of nav links, forms, and other content for toggling -->
		<div id="navbarCollapse"
			class="collapse navbar-collapse justify-content-start">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a href="#" onclick="history.go(-1)" class="nav-link">Home</a></li>
				<li class="nav-item"><a href="#" class="nav-link">About</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Contact</a></li>				
			</ul>
			<form class="navbar-form form-inline">
				<div class="input-group search-box">
					<input type="text" id="search" class="form-control"
						placeholder="Search here..."> <span
						class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
				</div>
			</form>

		</div>
	</nav>
	
	<c:if test="${message ne null }">
		<h3> ${message} </h3>
	</c:if>
	
	<div class="container">
		<div class="col-md-9 col-sm-12 col-xs-12">










<form action="HouseJoyController"  class="form-horizontal"  method="post">
<fieldset>

<!-- Form Name -->
<center> <h3>Fill Address Form</h3> </center>
<br>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address1">Address Line1</label>  
  <div class="col-md-8">
  <input id="address1" name="address1" type="text" placeholder="" class="form-control input-md"  required="">
  <span class="help-block">Door No or Flat No</span>  
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Address2">Address Line2</label>  
  <div class="col-md-8">
  <input id="address2" name="address2" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Street or Apartment name etc.</span>  
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="city">City/Town</label>  
  <div class="col-md-6">
  <input id="city" name="city" type="text" placeholder="city or town" class="form-control input-md" required="">
    
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="State">State</label>  
  <div class="col-md-6">
  <input id="state" name="state" type="text" placeholder="Enter state" class="form-control input-md" required="">
  <span class="help-block">Enter Source state</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group" >
  <label class="col-md-4 control-label" for="zip">Zip/Postal code</label>  
  <div class="col-md-4">
  <input id="zip" name="zip" type="text" placeholder="zip or postal code" class="form-control input-md" required="">  <br> <br>  
  <input type="hidden" value="add_address" name="action" /> 
  <button type="submit" class="btn btn-primary">Add Address</button>
  </div> 
</div>

<div class="form-group" >  
   <div class="col-md-4">
  
  </div> 
</div>
  
</fieldset>
</form>
</div>
</div>
</body>
</html>