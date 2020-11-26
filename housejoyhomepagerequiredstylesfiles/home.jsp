<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">

    function validatephone(phone) 
	{
    var maintainplus = '';
    var numval = phone.value	
    if ( numval.charAt(0)=='+' )
    {
        var maintainplus = '';
    }
    curphonevar = numval.replace(/[\\A-Za-z!"Â£$%^&\,*+_={};:'@#~,.Å \/<>?|`Â¬\]\[]/g,'');
    phone.value = maintainplus + curphonevar;
    var maintainplus = '';	
	}

	// Prevent dropdown menu from closing when click inside the form
	$(document).on("click", ".navbar-right .dropdown-menu", function(e){
		e.stopPropagation();
	});	
		

$(document).ready(function (e) {

  var maxsize = 500 * 1024; // 500 KB

  $('#max-size').html((maxsize/1024).toFixed(2));

 

  $('#file').change(function() {

    $('#message').empty();

    var file = this.files[0];
    var match = ["image/jpeg", "image/png", "image/jpg"];

    if ( !( (file.type == match[0]) || (file.type == match[1]) || (file.type == match[2]) ) )
    {
      $('#message').html('<div class="alert alert-warning" role="alert">Invalid image format. Allowed formats: JPG, JPEG, PNG.</div>');

	  $("#file").val(null);
      return false;
    }

    if ( file.size > maxsize )
    {
      $('#message').html('<div class=\"alert alert-danger\" role=\"alert\">The size of image you are attempting to upload is ' + (file.size/ 1024).toFixed(2) + ' KB maximum size allowed is ' + (maxsize/1024).toFixed(2) + ' KB</div>');
      return false;
    }
  });
});		
	
</script>
</head> 

<body>
<nav class="navbar navbar-default navbar-expand-lg navbar-light">
	<div class="navbar-header d-flex col">
		<a class="navbar-brand" href="#">House<b>Joy</b></a>  		
		<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
			<span class="navbar-toggler-icon"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
		<ul class="nav navbar-nav">
			<li class="nav-item"><a href="#" class="nav-link">Home</a></li>
			<li class="nav-item"><a href="#" class="nav-link">About</a></li>			
					
			<li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
		</ul>
		<form class="navbar-form form-inline">
			<div class="input-group search-box">								
				<input type="text" id="search" class="form-control" placeholder="Search here...">
				<span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
			</div>
		</form>
		<ul class="nav navbar-nav navbar-right ml-auto">			
			<li class="nav-item">
				<a data-toggle="dropdown" class="nav-link dropdown-toggle" href="#">Login</a>
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="HouseJoyController" method="post">
							<p class=class="btn btn-primary pull-left">Login</p>
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Email" name="loginEmail" id="email" required="required" onchange="email_validate(this.value);">
								<div class="status" id="status0"></div>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name="loginPassword" placeholder="Password" id="pwd" required="required">
							</div>
							<input type="submit" name="action" class="btn btn-primary btn-block" value="Login As User">
							<div class="or-seperator"><b>or</b></div>
							<input type="submit" name="action" class="btn btn-primary btn-block" value="Login As Force">
													
							<div class="form-footer">
								<a href="#">Forgot Your password?</a>
							</div>
						</form>
					</li>
				</ul>
			</li>
			<li class="nav-item">
				<a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle get-started-btn mt-1 mb-1">Sign up as User</a>				
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="HouseJoyController" method="post">
							<p class="hint-text">Create your account!</p>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Username" name="uname" id="uname" required="required">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Email" name="uemail" id="uemail"  required="required">
								<div class="status" id="status1"></div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Mobile Number" name="phone" pattern="[1-9]{1}[0-9]{9}" id="phone"  required="required" maxlength="10" onkeyup="validatephone(this);">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" placeholder="Password" name="upwd" id="upwd"  required="required">
							</div>							
							<div class="form-group">
								<label class="checkbox-inline"><input type="checkbox" name="uaccept" required="required"> I accept the <a href="#">Terms &amp; Conditions</a></label>
							</div>
							<input type="hidden" name="action" value="signUpUser" />
							<input type="submit" class="btn btn-primary btn-block" value="Sign up">
						</form>
					</li>
				</ul>
			</li>			
			<li class="nav-item">
				<a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle get-started-btn mt-1 mb-1">Sign up As Force</a>				
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="HouseJoyController" method="post"  enctype="multipart/form-data" >
							<p class="hint-text">Register as Skilled Person!</p>
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Username" name="fname" id="fname" required="required">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Email" id="femail" name="femail" required="required">
								<div class="status" id="status2"></div>
							</div>
							<div class="form-group">
								<input type="phone" class="form-control" placeholder="Mobile Number" name="fphone" id="fphone" required="required" pattern="[1-9]{1}[0-9]{9}" maxlength="10" onkeyup="validatephone(this);">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" placeholder="Password" name="fpwd" id="fpwd" required="required">
							</div>							
							<div class="form-group">								
								<h5> Upload your Aadhar scan copy : </h5>
								<input type="file" name="file" id="file" required>
							</div>
							<div class="form-group">
								<br>
								<label class="checkbox-inline"><input type="checkbox" id="faccept" name="faccept" required="required"> I accept the <a href="#">Terms &amp; Conditions</a></label>
							</div>
							<br>							
							<div id="message"></div>
							<input type="hidden" name="action" value="signUpForce" />
							<input type="submit" name="formType" class="btn btn-primary btn-block" value="Sign up">
						</form>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>


<c:if test="${message ne null }">
	<h3> ${message} </h3>
</c:if>
 
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h2>Reliable <b>Services</b></h2>
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="0">
			<!-- Carousel indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>   
			<!-- Wrapper for carousel items -->
			<div class="carousel-inner">
				<div class="item carousel-item active">				
					<div class="row">
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Appliances.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Home Appliances</h6>
									
								</div>						
							</div>
						</div>
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Beauty.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Beauty</h6>
									
								</div>						
							</div>
						</div>		
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Cleaning.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>House Keeping</h6>									
								</div>						
							</div>
						</div>								
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Electrical.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Electrical</h6>
									
								</div>						
							</div>
						</div>
					</div>
				</div>
				<div class="item carousel-item">
					<div class="row">
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Carpentry.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Carpentry</h6>									
								</div>						
							</div>
						</div>
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Plumbing.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Plumbing</h6>									
								</div>						
							</div>
						</div>
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Painting.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Painting</h6>
									
								</div>						
							</div>
						</div>
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/PestControl.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Pest Control</h6>
									
								</div>						
							</div>
						</div>						
					</div>
				</div>
				<div class="item carousel-item">
					<div class="row">
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Plantation.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Plantation</h6>									
								</div>						
							</div>
						</div>
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Events.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Event Organising</h6>									
								</div>						
							</div>
						</div>
						<div class="col-sm-3">
							<div class="thumb-wrapper">
								<div class="img-box">
									<img src="img/catagory-img/Laundry.jpg" class="img-responsive img-fluid" alt="">
								</div>
								<div class="thumb-content">
									<h6>Plumbing</h6>									
								</div>						
							</div>
						</div>	
						
					</div>
					
				</div>
			</div>
			
			
			
			<!-- Carousel controls -->
			<a class="carousel-control left carousel-control-prev" href="#myCarousel" data-slide="prev">
				<i class="fa fa-angle-left"></i>
			</a>
			<a class="carousel-control right carousel-control-next" href="#myCarousel" data-slide="next">
				<i class="fa fa-angle-right"></i>
			</a>
		</div>
		</div>
	</div>
</div>



<div class="bs-example">
    <div class="container">
    <c:set var="size" value="${categories.size()}" />
  	<c:set var="cntr" value="1" />  
    
                
        <c:forEach var="category" items="${categories}"> 
          <c:if test="${cntr % 4 eq 1}">
        	<div class="row">
          </c:if>
            <div class="col-xs-3">
                <a href="#" class="thumbnail">
                    <img src="img/catagory-img/${category.categoryImage}" class="img-circle" alt="125x125" />
                    <h6> ${category.getType()} </h6>
                </a>
            </div>    
            <c:if test="${cntr % 4 eq 0}">       
        	</div> 
        	  </c:if>
        	  
        	  <c:set var="cntr" value="${cntr + 1}" />
       </c:forEach>      
         
         
    </div>
</body>

</html>
