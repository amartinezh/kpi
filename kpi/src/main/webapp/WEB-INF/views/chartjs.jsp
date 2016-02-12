<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

<title>Grand Bay</title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="../resources/css/font-awesome.min.css"/>">

<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/smartadmin-production.min.css" />">
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/smartadmin-skins.min.css" />">

<!-- SmartAdmin RTL Support is under construction
			 This RTL CSS will be released in version 1.5
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> -->

<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/demo.min.css" />">

<!-- FAVICONS -->
<link rel="shortcut icon"
	href="<c:url value="/resources/img/favicon/favicon.ico" />"
	type="image/x-icon">
<link rel="icon"
	href="<c:url value="/resources/img/favicon/favicon.ico" />"
	type="image/x-icon">

<!-- GOOGLE FONT -->
<!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700"> -->
<link rel="stylesheet" href="<c:url value="/resources/js/j/css.css"/>">

<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
<link rel="apple-touch-icon"
	href="<c:url value="/resources/img/splash/sptouch-icon-iphone.png" />">
<link rel="apple-touch-icon" sizes="76x76"
	href="<c:url value="/resources/img/splash/touch-icon-ipad.png" />">
<link rel="apple-touch-icon" sizes="120x120"
	href="<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />">
<link rel="apple-touch-icon" sizes="152x152"
	href="<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />">

<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!-- Startup image for web apps -->
<link rel="apple-touch-startup-image"
	href="<c:url value="/resources/img/splash/ipad-landscape.png" />"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
<link rel="apple-touch-startup-image"
	href="<c:url value="/resources/img/splash/ipad-portrait.png" />"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image"
	href="<c:url value="/resources/img/splash/iphone.png" />"
	media="screen and (max-device-width: 320px)">

<style type="text/css">
tr:last-child {
	color: #ff0000;
	font-weight: bold;
}
</style>

</head>
<!--  <body oncontextmenu="return false">  -->
<body>
	<!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->

		<input type="hidden" id="v4l0" value="${param['v4l0']}"/>
		<input type="hidden" id="p" value="${param['p']}"/>
		<!-- #HEADER -->
			<header id="header">
		<div id="logo-group">
			<!-- PLACE YOUR LOGO HERE -->
			<span id="logo"> <img
				src="<c:url value="/resources/img/logo.png"/>" alt="SmartAdmin">
			</span>
			<!-- END LOGO PLACEHOLDER -->
		</div>

		<!-- pulled right: nav area -->
		<div class="pull-right">

			<!-- collapse menu button 
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
				</div>
				 end collapse menu -->

			<!-- #MOBILE -->
			<!-- Top menu profile link : this shows only when top menu is active -->
			<ul id="mobile-profile-img"
				class="header-dropdown-list hidden-xs padding-5">
				<li class="">
					<ul class="dropdown-menu pull-right">
						<li><a href="login.html"
							class="padding-10 padding-top-5 padding-bottom-5"
							data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i>
								<strong><u>S</u>alir</strong></a></li>
					</ul>
				</li>
			</ul>
			
			<!-- ---------------------------------------------------- -->
			<!-- ---------------------------------------------------- -->
			<!-- ---------------------------------------------------- -->
			<!-- ---------------------------------------------------- -->

			<a href="#" onclick="window.history.back()" class="btn btn-labeled btn-success">
				<span class="btn-label"><i
					class="glyphicon glyphicon-chevron-left"></i></span>Atras
			</a> 
			
			<a href="historico" class="btn btn-labeled btn-primary bg-color-yellow">
				<span class="btn-label"><i class="glyphicon glyphicon-camera"></i></span>Manufactura
			</a> 
			<a href="anual" class="btn btn-success btn-labeled"> <span
				class="btn-label"><i class="glyphicon glyphicon-info-sign"></i></span>Ventas
			</a> 
			<a href="actualizar" class="btn btn-labeled btn-info"> <span
				class="btn-label"><i class="glyphicon glyphicon-refresh"></i></span>Distribución
			</a>
			<a href="historico" class="btn btn-labeled btn-primary bg-color-yellow">
				<span class="btn-label"><i class="glyphicon glyphicon-camera"></i></span>RRHH
			</a> 
			<a href="anual" class="btn btn-success btn-labeled"> <span
				class="btn-label"><i class="glyphicon glyphicon-info-sign"></i></span>Finanzas
			</a> 
			<a href="salir" class="btn btn-labeled btn-danger"> <span
				class="btn-label"><i class="fa fa-sign-out"></i></span>Salir
			</a>
			<!-- end logout button -->

		</div>


		<!-- end pulled right: nav area -->

	</header>
		<!-- END HEADER -->

		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		
		<!-- END NAVIGATION -->

		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->

			<!-- END RIBBON -->
			
			

			<!-- MAIN CONTENT -->
			<div id="content">

					
				<!--
					The ID "widget-grid" will start to initialize all widgets below 
					You do not need to use widgets if you dont want to. Simply remove 
					the <section></section> and you can use wells or panels instead 
					-->
				
				<!-- widget grid -->
				<section id="widget-grid" class="">

					<!-- row -->
					<div class="row">
						
						<!-- NEW WIDGET START -->
						<article class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							
								<header>
									<h2>${param["i"]}</h2>				
								</header>
								
								

								<!-- widget div-->
								<div>
									
									<!-- widget content -->
									<div class="widget-body">
										
										<!-- this is what the user will see -->
										<canvas id="lineChart" height="120"></canvas>

									</div>
									<!-- end widget content -->
									
								</div>
								<!-- end widget div -->
								
							<!-- end widget -->

							

						</article>

						
					</div>

					<!-- end row -->

					<!-- row -->

					<div class="row">

						<!-- a blank row to get started -->
						<div class="col-sm-12">
							<!-- your contents here -->
						</div>
							
					</div>

					<!-- end row -->

				</section>
				<!-- end widget grid -->


			</div>
			<!-- END MAIN CONTENT -->

		</div>
		<!-- END MAIN PANEL -->


		<!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
		Note: These tiles are completely responsive,
		you can add as many as you like
		-->
		<div id="shortcut">
			<ul>
				<li>
					<a href="inbox.html" class="jarvismetro-tile big-cubes bg-color-blue"> <span class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail <span class="label pull-right bg-color-darken">14</span></span> </span> </a>
				</li>
				<li>
					<a href="calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span> </span> </a>
				</li>
				<li>
					<a href="gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple"> <span class="iconbox"> <i class="fa fa-map-marker fa-4x"></i> <span>Maps</span> </span> </a>
				</li>
				<li>
					<a href="invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark"> <span class="iconbox"> <i class="fa fa-book fa-4x"></i> <span>Invoice <span class="label pull-right bg-color-darken">99</span></span> </span> </a>
				</li>
				<li>
					<a href="gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight"> <span class="iconbox"> <i class="fa fa-picture-o fa-4x"></i> <span>Gallery </span> </span> </a>
				</li>
				<li>
					<a href="profile.html" class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My Profile </span> </span> </a>
				</li>
			</ul>
		</div>
		<!-- END SHORTCUT AREA -->

		<!--================================================== -->

		<!-- END MAIN CONTENT -->

	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script data-pace-options='{ "restartOnRequestAfter": true }'
		src="<c:url value="/resources/js/plugin/pace/pace.min.js"/>"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script>
		if (!window.jQuery) {
			document
					.write('<script src="<c:url value="/resources/js/libs/jquery-2.0.2.min.js"/>""><\/script>');
		}
	</script>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	<script>
		if (!window.jQuery.ui) {
			document
					.write('<script src="<c:url value="/resources/js/libs/jquery-ui-1.10.3.min.js"/>"><\/script>');
		}
	</script>

	<!-- IMPORTANT: APP CONFIG -->
	<script src="<c:url value="/resources/js/app.config.js"/>"></script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
	<script
		src="<c:url value="/resources/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"/>"></script>

	<!-- BOOTSTRAP JS -->
	<script src="<c:url value="/resources/js/bootstrap/bootstrap.min.js"/>"></script>

	<!-- CUSTOM NOTIFICATION -->
	<script
		src="<c:url value="/resources/js/notification/SmartNotification.min.js"/>"></script>

	<!-- JARVIS WIDGETS -->
	<script
		src="<c:url value="/resources/js/smartwidgets/jarvis.widget.min.js"/>"></script>

	<!-- EASY PIE CHARTS -->
	<script
		src="<c:url value="/resources/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"/>"></script>

	<!-- SPARKLINES -->
	<script
		src="<c:url value="/resources/js/plugin/sparkline/jquery.sparkline.min.js"/>"></script>

	<!-- JQUERY VALIDATE -->
	<script
		src="<c:url value="/resources/vjs/plugin/jquery-validate/jquery.validate.min.js"/>"></script>

	<!-- JQUERY MASKED INPUT -->
	<script
		src="<c:url value="/resources/js/plugin/masked-input/jquery.maskedinput.min.js"/>"></script>

	<!-- JQUERY SELECT2 INPUT -->
	<script
		src="<c:url value="/resources/js/plugin/select2/select2.min.js"/>"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script
		src="<c:url value="/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js"/>"></script>

	<!-- browser msie issue fix -->
	<script
		src="<c:url value="/resources/js/plugin/msie-fix/jquery.mb.browser.min.js"/>"></script>

	<!-- FastClick: For mobile devices -->
	<script
		src="<c:url value="/resources/js/plugin/fastclick/fastclick.min.js"/>"></script>

	<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

	<!-- Demo purpose only -->
	<script src="<c:url value="/resources/js/demo.min.js"/>"></script>

	<!-- MAIN APP JS FILE -->
	<script src="<c:url value="/resources/js/app.min.js"/>"></script>

	<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
	<!-- Voice command : plugin -->
	<script src="<c:url value="/resources/js/speech/voicecommand.min.js"/>"></script>

	<!-- PAGE RELATED PLUGIN(S) -->
	<script
		src="<c:url value="/resources/js/plugin/datatables/jquery.dataTables.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatables/dataTables.colVis.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatables/dataTables.tableTools.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatables/dataTables.bootstrap.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatable-responsive/datatables.responsive.min.js"/>"></script>

	<script src="<c:url value="/resources/js/smart-chat-ui/smart.chat.ui.min.js"/>"></script>
	<script src="<c:url value="/resources/js/smart-chat-ui/smart.chat.manager.min.js"/>"></script>
		
	<script src="<c:url value="/resources/js/plugin/chartjs/chart.min.js"/>"></script>

	<script type="text/javascript">
     $(document).ready(function() {
			 	
				/* DO NOT REMOVE : GLOBAL FUNCTIONS!
				 *
				 * pageSetUp(); WILL CALL THE FOLLOWING FUNCTIONS
				 *
				 * // activate tooltips
				 * $("[rel=tooltip]").tooltip();
				 *
				 * // activate popovers
				 * $("[rel=popover]").popover();
				 *
				 * // activate popovers with hover states
				 * $("[rel=popover-hover]").popover({ trigger: "hover" });
				 *
				 * // activate inline charts
				 * runAllCharts();
				 *
				 * // setup widgets
				 * setup_widgets_desktop();
				 *
				 * // run form elements
				 * runAllForms();
				 *
				 ********************************
				 *
				 * pageSetUp() is needed whenever you load a page.
				 * It initializes and checks for all basic elements of the page
				 * and makes rendering easier.
				 *
				 */
				
				 pageSetUp();
				 
				/*
				 * ALL PAGE RELATED SCRIPTS CAN GO BELOW HERE
				 * eg alert("my home function");
				 * 
				 * var pagefunction = function() {
				 *   ...
				 * }
				 * loadScript("js/plugin/_PLUGIN_NAME_.js", pagefunction);
				 * 
				 * TO LOAD A SCRIPT:
				 * var pagefunction = function (){ 
				 *  loadScript(".../plugin.js", run_after_loaded);	
				 * }
				 * 
				 * OR
				 * 
				 * loadScript(".../plugin.js", run_after_loaded);
				 */

				 // reference: http://www.chartjs.org/docs/

				// LINE CHART
				// ref: http://www.chartjs.org/docs/#line-chart-introduction
				
			    var lineOptions = {
				    ///Boolean - Whether grid lines are shown across the chart
				    scaleShowGridLines : true,
				    //String - Colour of the grid lines
				    scaleGridLineColor : "rgba(0,0,0,.05)",
				    //Number - Width of the grid lines
				    scaleGridLineWidth : 1,
				    //Boolean - Whether the line is curved between points
				    bezierCurve : true,
				    //Number - Tension of the bezier curve between points
				    bezierCurveTension : 0.4,
				    //Boolean - Whether to show a dot for each point
				    pointDot : true,
				    //Number - Radius of each point dot in pixels
				    pointDotRadius : 4,
				    //Number - Pixel width of point dot stroke
				    pointDotStrokeWidth : 1,
				    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
				    pointHitDetectionRadius : 20,
				    //Boolean - Whether to show a stroke for datasets
				    datasetStroke : true,
				    //Number - Pixel width of dataset stroke
				    datasetStrokeWidth : 2,
				    //Boolean - Whether to fill the dataset with a colour
				    datasetFill : true,
				    //Boolean - Re-draw chart on page resize
			        responsive: true,
				    //String - A legend template
				     legendTemplate : ""
			    };
			    
				var v4lo=document.getElementById('v4l0').value;
				var pr3=document.getElementById('p').value;
				var real = v4lo.split(";");
				var presupuestado = pr3.split(";");
				//alert(presupuestado[1]);
			    var lineData = { labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
			        datasets: [
				        {
				            label: "My First dataset",
				            fillColor: "rgba(220,220,220,0.2)",
				            strokeColor: "rgba(220,220,220,1)",
				            pointColor: "rgba(220,220,220,1)",
				            pointStrokeColor: "#fff",
				            pointHighlightFill: "#fff",
				            pointHighlightStroke: "rgba(220,220,220,1)",
				            data: [real[1], real[2], real[3], real[4], real[5], real[6], real[7], real[8], real[9], real[10], real[11], real[12]]
				        },
				        {
				            label: "My Second dataset",
				            fillColor: "rgba(151,187,205,0.2)",
				            strokeColor: "rgba(151,187,205,1)",
				            pointColor: "rgba(151,187,205,1)",
				            pointStrokeColor: "#fff",
				            pointHighlightFill: "#fff",
				            pointHighlightStroke: "rgba(151,187,205,1)",
				            data: [presupuestado[1], presupuestado[2], presupuestado[3], presupuestado[4], presupuestado[5], presupuestado[6], presupuestado[7], presupuestado[8], presupuestado[9], presupuestado[10], presupuestado[11], presupuestado[12]]
				        }
				    ]
			    };

			    // render chart
			    var ctx = document.getElementById("lineChart").getContext("2d");
			    var myNewChart = new Chart(ctx).Line(lineData, lineOptions);

			    // END LINE CHART
	
				
			})
		
		</script>

		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script type="text/javascript">
			var _gaq = _gaq || [];
				_gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
				_gaq.push(['_trackPageview']);
			
			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();

		</script>

	</body>

</html>