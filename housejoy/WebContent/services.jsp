<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    


<!DOCTYPE html>
<html lang="en">
<head>
<title>Services</title>
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


#sub_list{
    display: none;
}
</style>
</head>

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
				<li class="nav-item"><a href="ManPowerController?action=user_home" class="nav-link">Home</a></li>
				<li class="nav-item"><a href="#" class="nav-link">About</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
				<li class="nav-item"><a href="ManPowerController?action=logout"
					class="nav-link">LogOut</a></li>
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
	
	
	<c:if test="${user eq null}">	
	   <%
	    response.sendRedirect("home.jsp");			
	   %>
	</c:if>
	
	
	<c:if test="${message ne null }">
		<h3> ${message} </h3>
	</c:if>


<div class="container" style="margin-top: 15px;">
          <div class="form-group">
          	<select class="form-control" name="ser_type" id="ser_type"  required="required">
            	<option value="">-- Service Type --</option>
            	<c:forEach  items="${services}"  var="service">
                	<option value="${service.id}-${service.approxPrice}-${service.description}">${service.description}</option>
                </c:forEach>                
            </select>
            <h5 id="est_price" style="display: none;margin: 20px 0px;">Estimated Price: <span id="price"></span></h5> 
          </div>
          <div class="form-group">          
          <c:forEach items="${addresslist}"  var="address">
          	
  			<label class="radio-inline"><input type="radio" name="addr"  value="${address.id}" checked="checked">${address.doorno},${address.street}<br>${address.city}<br>${address.state} - ${address.postalCode} </label>
			
			</c:forEach>			
          </div>
          <div class="form-group">
          	<textarea rows="6" class="form-control" name="comments" id="org_com" placeholder="Comments..."></textarea>
          </div>
          <button class="btn btn-primary" onclick="subForm();">Submit</button>
</div>

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content" style="border-radius: 0px;">
        <div class="modal-header" style="border:0px;padding: 5px 15px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          
        </div>
        <div class="modal-body">
          <div class="row">
          <div class="col-sm-6 col-sm-12">
          	<h3>HouseJoy Advantages</h3>
            <hr/>
            
            <ul>
            	<li><h5>Service Guarantee</h5></li>
                <li><h5>Professional Servicing & Repair</h5></li>
                <li><h5>Background checked and trained technicians</h5></li>
                <li><h5>Genuine parts & fixed pricing</h5></li>
                
            </ul>
          </div>
          <div class="col-sm-6 col-sm-12">
          	<h4 id="orgservice">Service Charge</h4>
            <hr/>
            	<form  action="Man"  method="post">
            	<input type="hidden" name="description" id="desc"/>
            	<input type="hidden" name="addressid" id="addrid"/>            	
            	<input type="hidden" name="id" id="id"/>
            	<input type="hidden" name="action" value="confirmation"/>
            	<table style="width: 100%" class="table">
          		<tr><td>Approx Charge</td><td class="text-right" id="orgamount">200.00 INR</td></tr>                   
          		</table>
                <button type="submit" class="btn btn-primary">Confirm</button>
                </form>
          </div>
          </div>
        </div>        
      </div>
      
    </div>
  </div>

<script>
var val=null;
$("#ser_type").change(function(){
	val = $(this).val().split('-');
	if(val[1]){
		$('#est_price').show();
		$('#orgservice').html(val[2]);
		$('#price').html(val[1]);
		$('#orgamount').html(val[1]);
	}else{
		$('#est_price').hide();
		$('#price').html('');
	}
  	
});


function subForm(){
	$('#desc').val($('#org_com').val());
	$('#addrid').val($("input[name='addr']:checked").val());
	$('#id').val(val[0]);
	$('#myModal').modal('show');
}

</script>
</body>
</html>