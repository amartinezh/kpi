<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en-us" id="extr-page">
	<head>
		<meta charset="utf-8">
		<title>Balanced Scorecard</title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles --> <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/font-awesome.min.css" />">

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-production.min.css" />">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-skins.min.css" />" >

		<!-- SmartAdmin RTL Support is under construction
			 This RTL CSS will be released in version 1.5
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> -->

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/demo.min.css" />" >

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="<c:url value="/resources/img/favicon/favicon.ico"/>" type="image/x-icon">
		<link rel="icon" href="<c:url value="/resources/img/favicon/favicon.ico" />" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="<c:url value="/resources/img/splash/sptouch-icon-iphone.png"/>">
		<link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/img/splash/touch-icon-ipad.png" />" >
		<link rel="apple-touch-icon" sizes="120x120" href="<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />">
		<link rel="apple-touch-icon" sizes="152x152" href="<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />">
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/ipad-landscape.png" />" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/ipad-portrait.png" />" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/iphone.png" />" media="screen and (max-device-width: 320px)">
		<style type="text/css">
			.error {
				color: red;
			}
		</style>
	</head>
	<!--  <body class="animated fadeInDown" oncontextmenu="return false"> -->
	<body>
	<!--  <body> -->
		<div id="main" role="main">
			<!-- MAIN CONTENT -->
			<div id="content" class="container">
				<div class="jumbotron text-center">
					<!-- <a href="javascript:void(0);" class="username text-left"> <c:out value="${r3g	}" /> </a> -->
					<h1> <c:out value="${tit}" /></h1>
					<c:choose>
					    <c:when test="${n == 1}">
					       	<a class="btn btn-success btn-lg" href="<c:url value="${viewManufacture}"/>?t=${tit}&op10=${op10}">Manufacturing</a>
					    </c:when>
					    <c:when test="${n == 2}">
					       <a class="btn btn-warning btn-lg" href="${view}?t=${tit}&op10=${op10}">Sales</a>
					    </c:when>
					    <c:when test="${n == 3}">
					       <a class="btn btn-info btn-lg" href="<c:url value="${viewDistri}"/>?t=${tit}&op10=${op10}">Distribution</a>
					    </c:when>
					    <c:when test="${n == 4}">
					       <a class="btn btn-success btn-lg" href="<c:url value="${viewHuman}"/>?t=${tit}&op10=${op10}">Human Resources</a>
					    </c:when>
					    <c:when test="${n == 5}">
					       <a class="btn btn-warning btn-lg" href="<c:url value="${viewFinance}"/>?t=${tit}&op10=${op10}">Finance</a>
					    </c:when>
					    <c:when test="${n == 6}">
					        <a class="btn btn-success btn-lg" href="<c:url value="${viewManufacture}"/>?t=${tit}&op10=${op10}">Manufacturing</a>
							<a class="btn btn-warning btn-lg" href="${view}?t=${tit}&op10=${op10}">Sales</a>
							<a class="btn btn-info btn-lg" href="<c:url value="${viewDistri}"/>?t=${tit}&op10=${op10}">Distribution</a>
							<a class="btn btn-success btn-lg" href="<c:url value="${viewHuman}"/>?t=${tit}&op10=${op10}">Human Resources</a>
							<a class="btn btn-warning btn-lg" href="<c:url value="${viewFinance}"/>?t=${tit}&op10=${op10}">Finance</a>
					    </c:when>
					    <c:otherwise>
					        Comuniquese con el administrador
					    </c:otherwise>
					</c:choose>
					<br><br><a href="inicio" class="btn btn-labeled btn-danger btn-lg"> <span
								class="btn-label"><i class="fa fa-sign-out"></i></span>Back
							</a>
					
				</div>
				<div class="well  well-light text-center">
					<div id="logos" style="width: 100%">
						<c:choose>
						    <c:when test="${r3g == 'COL' }">
						       <img src="<c:url value="/resources/img/adm/Panasa_Colombia.png"/>" style="z-index: -1;  max-width: 20%; height: auto;" alt="SmartAdmin">
						    </c:when>
						    <c:when test="${r3g == 'VEN' }">
						        <img src="<c:url value="/resources/img/adm/Paveca_Venezuela.jpg"/>" style="z-index: -1;  max-width: 20%; height: auto;" alt="Sistemas">
						    </c:when>
						    <c:when test="${r3g == 'GUA' }">
						    	<img src="<c:url value="/resources/img/adm/Painsa_Guatemala.JPG"/>" style="z-index: -1;  max-width: 20%; height: auto;" alt="Sistemas">
						    </c:when>
						    <c:when test="${r3g == 'TRI' }">
						    	<img src="<c:url value="/resources/img/adm/GBP_Trinidad.jpg"/>" style="z-index: -1;  max-width: 20%; height: auto;" alt="Sistemas">
						    </c:when>
						    <c:when test="${r3g == 'PAN' }">
						    	<img src="<c:url value="/resources/img/adm/Papisa_Panama.gif"/>" style="z-index: -1;  max-width: 20%; height: auto;" alt="Sistemas">
						    </c:when>
						    
						    <c:otherwise>
						       ${r3g} No es una región
						    </c:otherwise>
						</c:choose>
					</div>
				</div>
		
			</div>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script src="<c:url value="/resources/js/plugin/pace/pace.min.js" />" ></script>

	    
		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	    <!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
	    <script src="<c:url value="/resources/js/j/jquery.min.js"/>"></script>
		<script> if (!window.jQuery) { document.write('<script src="<c:url value="/resources/js/libs/jquery-2.0.2.min.js"/>"><\/script>');} </script>

	    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script> if (!window.jQuery.ui) { document.write('<script src="<c:url value="/resources/js/libs/jquery-ui-1.10.3.min.js"/>"><\/script>');} </script>
		
		<!-- CUSTOM NOTIFICATION -->
		<script src="<c:url value="/resources/js/notification/SmartNotification.min.js" />"></script>
		

		<!-- BOOTSTRAP JS -->		
		<script src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>

		<!-- JQUERY VALIDATE -->
		<script src="<c:url value="/resources/js/plugin/jquery-validate/jquery.validate.min.js" />" ></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="<c:url value="/resources/js/plugin/masked-input/jquery.maskedinput.min.js" />"></script>
		
		<!--[if IE 8]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="<c:url value="/resources/js/app.min.js" />" ></script>
	</body>
</html>