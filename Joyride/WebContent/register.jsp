<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="img/fav.png">
<meta name="author" content="codepixer">
<meta name="description" content="">
<meta name="keywords" content="">
<meta charset="UTF-8">
<title>Joyride Car Rentals</title>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">

<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>

	<header id="header" id="home">
		<div class="container">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="index.jsp"><h3 class="text-white text-uppercase">JOYRIDE</h3></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="menu-active"><a href="index.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li><a href="contact.jsp">Contact</a></li>

					</ul>
				</nav>
			</div>
		</div>
	</header>


	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div
				class="row fullscreen d-flex align-items-center justify-content-center">
				<div class="banner-content col-lg-7 col-md-6 ">
					<h6 class="text-white ">the Royal Essence of Journey</h6>
					<h1 class="text-white text-uppercase">Relaxed Journey Ever</h1>
					<p class="pt-20 pb-20 text-white">Book a Car instantly with
						Joyride. Explore the city with Joyride rentals.</p>
				</div>
				<div class="col-lg-5  col-md-6 header-right">
					<h4 class="text-white pb-30">Register to Book... ${carselected.model }</h4>
					<form class="form" role="form" autocomplete="off"
						action="register" method="POST">

						   <div class="form-group">
						   
							    	<input class="form-control txt-field" type="text" name="name" placeholder="Name">
							    	<div class="input-group dates-wrap">
									<input id="datepicker" class="dates form-control"
										id="exampleAmount" name="dob" placeholder="Date of Birth"
										type="text">
									<div class="input-group-prepend">
										<span class="input-group-text"><span
											class="lnr lnr-calendar-full"></span></span>
									</div>
								    </div><br>
								    <input class="form-control txt-field" type="number" name="dlnumber" placeholder="Driving Liscense Number">
								    <div class="input-group dates-wrap">
									<input id="datepicker2" class="dates form-control"
										id="exampleAmount" name="dlvalidity" placeholder="Driving License Validity"
										type="text">
									<div class="input-group-prepend">
										<span class="input-group-text"><span
											class="lnr lnr-calendar-full"></span></span>
									</div>
								</div><br>
									<input class="form-control txt-field" type="number" name="mobile" placeholder="Mobile Number">
							    	<input class="form-control txt-field" type="email" name="email" placeholder="Email Address">
							    	<input class="form-control txt-field" type="password" name="password" placeholder="Password">
							    	<input class="form-control txt-field" type="password" name="confirmpassword" placeholder="Confirm Password">
							    	
							    </div>
							    <div class="form-group row">
							        <div class="col-md-12">
							            <button type="submit" class="btn btn-default btn-lg btn-block text-center text-uppercase">Register</button>
							        </div>
							    </div>
					</form>
					<p>Already have an account?<a href="login.jsp">Sign In</a></p>
				</div>
			</div>
		</div>
	</section>
	
	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="js/easing.min.js"></script>
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/parallax.min.js"></script>
	<script src="js/mail-script.js"></script>
	<script src="js/main.js"></script>
</body>
</html>



