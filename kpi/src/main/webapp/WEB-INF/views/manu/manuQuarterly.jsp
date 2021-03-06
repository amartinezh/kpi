<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

<title>Balanced Scorecard</title>
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
	href="<c:url value="/resources/css/smartadmin-production-plugins.min.css" />">
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/smartadmin-production.min.css" />">
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/smartadmin-skins.min.css" />">

<!-- SmartAdmin RTL Support is under construction
			 This RTL CSS will be released in version 1.5
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> -->

<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/smartadmin-rtl.min.css" />">

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

.transp-block {
	background: #000 url(watermark.jpg) no-repeat;
	width: 575px;
	height: 335px;
}

img.transparent {
	filter: alpha(opacity = 75);
	opacity: .75;
}

#tbl tr td {
	height: 1px;
	padding: 1px;
}
</style>

</head>
<!--  <body oncontextmenu="return false">  -->

<body>
	<!-- HEADER -->

	<header id="header">
		<div class="icon-addon addon-md">
			<select class="form-control " id="moneda" class="moneda"
				name="moneda" onclick="moneda()">
				<c:forEach items="${currencyList}" var="curr"
					varStatus="loopCounter">
					<option value="${curr.id}">${curr.descripcion}</option>
				</c:forEach>
			</select> <label for="email" class="glyphicon glyphicon-search" rel="tooltip"
				title="" data-original-title="email"></label>
		</div>
		<div class="icon-addon addon-md">
			<select class="form-control input-sm col-sm-2" id="tasa" class="tasa"
				name="tasa" onclick="tasa()">
				<option value="p">Average</option>
				<option value="m">Month rate</option>
			</select> <label for="email" class="glyphicon glyphicon-search" rel="tooltip"
				title="" data-original-title="email"></label>
		</div>
		<div class="icon-addon addon-md">
			<select class="form-control input-sm col-sm-2" id="anio" class="anio"
				name="anio" onclick="anio()">
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
			</select> <label for="email" class="glyphicon glyphicon-search" rel="tooltip"
				title="" data-original-title="email"></label>
		</div>
		<div class="pull-right">
			<a href="javascript:history.back(1)"
				class="btn btn-labeled btn-danger btn-sm"> <span
				class="btn-label"> <i class="fa fa-sign-out"> </i>
			</span> Back
			</a>
		</div>
		<!-- end pulled right: nav area -->
	</header>

	<div class="row">
		<h1>
			<strong>${tit}</strong>
		</h1>
		<div id="dialog-message" title="Drill Down">
			<div id="opc" width="1500" height="100"
				style="background-color: #ffffff;"></div>
		</div>

		<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
			<h1 class="page-title txt-color-blueDark">
				<i class="fa fa-list-alt fa-fw "></i> <span><c:out
						value="${navegacion}" /> </span>
			</h1>
		</div>

		<div
			style="margin: 0 auto; display: block; position: absolute; right: 3%;">
			<p
				style="font-family: 'Arial Black', 'Arial Bold', Gadget, sans-serif; font-size: 60px; font-style: normal; font-variant: normal; font-weight: bold; line-height: 44px; color: #ffffe6">
				Manufacture</p>
		</div>
		<!-- Widget ID (each widget will need unique ID)-->

		<!-- widget div-->

		<!-- end widget -->

	</div>
	<!-- END HEADER -->

	<!-- Left panel : Navigation area -->
	<!-- Note: This width of the aside area can be adjusted through LESS variables -->

	<!-- END NAVIGATION -->

	<!-- MAIN PANEL -->
	<div id="mainn" role="mainn">

		<!-- RIBBON -->

		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">


			<!-- widget grid -->

			<section id="widget-grid" class="">

				<!-- row -->
				<div class="row">

					<!-- NEW WIDGET START -->
					<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Pulp Plant -->
						<!-- Pulp Plant -->
						<!-- Pulp Plant -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-0" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Pulp</strong> <i>Plant</i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">

										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${valor}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>

									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Pulp Plant -->
						<!-- Pulp Plant -->
						<!-- Pulp Plant -->
						<!-- end widget -->


						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Deinking Plant -->
						<!-- Deinking Plant -->
						<!-- Deinking Plant -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Destinct</strong> <i>Plant</i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">


										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${deinking}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Deinking Plant -->
						<!-- Deinking Plant -->
						<!-- Deinking Plant -->
						<!-- end widget -->




						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Paper Mills -->
						<!-- Paper Mills -->
						<!-- Paper Mills -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Paper</strong> <i>Mills</i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">

										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${papermills}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Paper Mills -->
						<!-- Paper Mills -->
						<!-- Paper Mills -->
						<!-- end widget -->




						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Converting -->
						<!-- Converting -->
						<!-- Converting -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Converting</strong> <i></i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">


										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${converting}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Converting -->
						<!-- Converting -->
						<!-- Converting -->
						<!-- end widget -->




						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Adsorbents -->
						<!-- Adsorbents -->
						<!-- Adsorbents -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Adsorbents</strong> <i></i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">


										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${absorbents}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Adsorbents -->
						<!-- Adsorbents -->
						<!-- Adsorbents -->
						<!-- end widget -->




						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Suppy Chain -->
						<!-- Suppy Chain -->
						<!-- Suppy Chain -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Suppy</strong> <i>Chain</i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">


										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${supplychain}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Suppy Chain -->
						<!-- Suppy Chain -->
						<!-- Suppy Chain -->
						<!-- end widget -->



						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Quality Environment -->
						<!-- Quality Environment -->
						<!-- Quality Environment -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Quality</strong> <i>Environment</i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">


										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${qualityandenvironment}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Quality Environment -->
						<!-- Quality Environment -->
						<!-- Quality Environment -->
						<!-- end widget -->




						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- Maintenance -->
						<!-- Maintenance -->
						<!-- Maintenance -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>Maintenance</strong> <i></i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">


										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${maintenance}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- Maintenance -->
						<!-- Maintenance -->
						<!-- Maintenance -->
						<!-- end widget -->



						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->
						<!-- ----------------------------------------->


						<!-- Widget ID (each widget will need unique ID)-->
						<!-- General -->
						<!-- General -->
						<!-- General -->
						<div class="jarviswidget jarviswidget-color-blueDark"
							id="wid-id-1" data-widget-editbutton="false">
							<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i>
								</span>
								<h2>
									<strong>General</strong> <i></i>
								</h2>

							</header>

							<!-- widget div-->
							<div>

								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->

								</div>
								<!-- end widget edit box -->

								<!-- widget content -->
								<div class="widget-body">

									<div class="table-responsive">


										<table id="tbl" class="table table-bordered" width="100%">
											<thead>
												<div class="row">
													<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
														<h1 class="page-title txt-color-blueDark">
															<i class="fa fa-list-alt fa-fw "></i> <span><c:out
																	value="${navegacion}" /> </span>
														</h1>
													</div>
												</div>
												<tr>
												</tr>
												<tr>
													<th style="text-align: center; color: blue;">Indicator
													</th>
													<th style="text-align: center; color: blue;">UM</th>
													<th style="text-align: center; color: blue;">Type</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio-1}" />
													</th>
													<th style="text-align: center; color: blue;">Average <c:out
															value="${anio}" />
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q1
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q2
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q3
													</th>
													<th colspan="2" style="text-align: center; color: blue;">Q4
													</th>
													<th style="text-align: center; color: blue;">Graph</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${general}" var="kpi"
													varStatus="loopCounter">
													<tr class="${color}">

														<td rowspan="2">${ kpi.ind }</td>
														<td rowspan="2">${ kpi.unidad }</td>
														<td>${kpi.tipoUno}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:set var="real" value="" />
														<c:set var="presupuestado" value="" />
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<td style="text-align: right;" nowrap><c:choose>
																	<c:when
																		test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if>
																	</c:when>
																	<c:otherwise>
																		<fmt:formatNumber pattern="###,##0.0"
																			value="${val.mveval}" type="number" />
																	</c:otherwise>
																</c:choose></td>
															<td valign="middle" rowspan="2"><c:choose>
																	<c:when
																		test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
																		<c:choose>
																			<c:when test="${val.mveval lt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when test="${val.mveval gt val.mvevpe}">
																				<img
																					src="<c:url value="/resources/img/adm/verde.png"/>"
																					alt="Verde"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:when>
																			<c:otherwise>
																				<img
																					src="<c:url value="/resources/img/adm/rojo.png"/>"
																					alt="Rojo"
																					style="width: 15px; height: 15px; margin-top: 3px; margin-right: 10px;">
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
															<fmt:formatNumber var="real2" pattern="##0.0"
																value="${val.mveval}" type="number"
																maxFractionDigits="0" />
															<c:set var="real" value="${real};${real2}" />
														</c:forEach>

														<td></td>
														</td>

													</tr>
													<tr class="${color}">
														<td>${kpi.tipoDos}</td>
														<c:choose>
															<c:when
																test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" />
																	<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
															</c:when>
															<c:otherwise>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnt}"
																		type="number" /></td>
																<td style="text-align: right;"><fmt:formatNumber
																		pattern="###,##0.0"
																		value="${kpi.promMvevpePresupuestadoAnoActual}"
																		type="number" /></td>
															</c:otherwise>
														</c:choose>
														<c:forEach items="${kpi.lista}" var="val"
															varStatus="loopCounter">
															<c:choose>
																<c:when
																	test="${not fn:contains(kpi.ind_cod, '001') and not fn:contains(kpi.ind_cod, '002')}">
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:when>
																<c:otherwise>
																	<td style="text-align: right;"><fmt:formatNumber
																			pattern="###,##0.0" value="${val.mvevpe}"
																			type="number" />
																		<c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
																</c:otherwise>
															</c:choose>
															<fmt:formatNumber var="presupuestado2" pattern="###"
																value="${val.mvevpe}" type="number"
																maxFractionDigits="0" />
															<c:set var="presupuestado"
																value="${presupuestado};${presupuestado2}" />
														</c:forEach>

														<td><img
															onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')"
															src="<c:url value="/resources/img/adm/graph.png"/>"
															alt="Graficos"
															style="width: 20px; height: 20px; margin-top: 3px; margin-right: 10px;"></td>
													</tr>
													<c:choose>
														<c:when test="${color=='success'}">
															<c:set var="color" value="warning" />
														</c:when>
														<c:otherwise>
															<c:set var="color" value="success" />
														</c:otherwise>
													</c:choose>
												</c:forEach>
												<tr>
													<td colspan="20" align="center"></td>
												</tr>
												
											</tbody>
										</table>



									</div>
								</div>
								<!-- end widget content -->

							</div>
							<!-- end widget div -->

						</div>
						<!-- General -->
						<!-- General -->
						<!-- General -->
						<!-- end widget -->


					</article>
					<!-- WIDGET END -->

					<!-- NEW WIDGET START -->

					<!-- WIDGET END -->

				</div>

				<!-- end row -->

				<!-- row -->

				<!-- end row -->

			</section>

			<!-- end widget ->
				
				
				
				
				
			</div>
			<!-- END MAIN CONTENT -->



		</div>
		<!-- END MAIN PANEL -->

		<!-- PAGE FOOTER -->

		<!-- END PAGE FOOTER -->

		<!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
		Note: These tiles are completely responsive,
		you can add as many as you like
		-->

		<!-- END SHORTCUT AREA -->



		<!-- END MAIN CONTENT -->

		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }'
			src="<c:url value="/resources/js/plugin/pace/pace.min.js"/>"></script>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
		<script src="<c:url value="/resources/js/j/jquery.min.js"/>"></script>
		<script>
			if (!window.jQuery) {
				document
						.write('<script src="<c:url value="/resources/js/libs/jquery-2.0.2.min.js"/>""><\/script>');
			}
		</script>

		<!-- <script	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>  -->
		<script src="<c:url value="/resources/js/j/jquery-ui.min.js"/>"></script>
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
		<script
			src="<c:url value="/resources/js/bootstrap/bootstrap.min.js"/>"></script>

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
			src="<c:url value="/resources/js/plugin/jquery-validate/jquery.validate.min.js"/>"></script>

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
		<script
			src="<c:url value="/resources/js/speech/voicecommand.min.js"/>"></script>

		<!-- PAGE RELATED PLUGIN(S) -->

		<script
			src="<c:url value="/resources/js/plugin/chartjs/chart.min.js"/>"></script>

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

		<script type="text/javascript">
			// DO NOT REMOVE : GLOBAL FUNCTIONS!

			$(document).ready(
					function() {

						pageSetUp();

						// PAGE RELATED SCRIPTS

						// switch style change
						$('input[name="checkbox-style"]').change(function() {
							//alert($(this).val())
							$this = $(this);

							if ($this.attr('value') === "switch-1") {
								$("#switch-1").show();
								$("#switch-2").hide();
							} else if ($this.attr('value') === "switch-2") {
								$("#switch-1").hide();
								$("#switch-2").show();
							}

						});

						// tab - pills toggle
						$('#show-tabs').click(
								function() {
									$this = $(this);
									if ($this.prop('checked')) {
										$("#widget-tab-1").removeClass(
												"nav-pills").addClass(
												"nav-tabs");
									} else {
										$("#widget-tab-1").removeClass(
												"nav-tabs").addClass(
												"nav-pills");
									}

								});

					});
		</script>

		<script type="text/javascript">
			// DO NOT REMOVE : GLOBAL FUNCTIONS!

			// Para el titulo del Drill Down
			var tit = "Grand Bay";
			$(document).ready(function() {

				//document.getElementById("region").selectedIndex = "${r3g}";
				//document.getElementById("nia").selectedIndex = "${c1a}";
				//document.getElementById("moneda").selectedIndex = "${cur}";

				clearTable();

				$("#region").val("${r3g}");
				$("#nia").val("${c1a}");
				$("#moneda").val("${cur}");
				$("#anio").val("${anio}");
				var t = "${tas}";
				var c1a = "${c1a}";
				var curr = "${cur}";

				if (c1a == "Todas")
					$('#moneda').prop('disabled', true);
				else
					$('#moneda').prop('disabled', false);

				if (curr == "1")
					$('#tasa').prop('disabled', true);
				else
					$('#tasa').prop('disabled', false);

				if (t == "mveval") {
					$("#tasa").val("m");
				} else
					document.getElementById("tasa").selectedIndex = "p";

				pageSetUp();

				/* // DOM Position key index //
				
				l - Length changing (dropdown)
				f - Filtering input (search)
				t - The Table! (datatable)
				i - Information (records)
				p - Pagination (paging)
				r - pRocessing 
				< and > - div elements
				<"#id" and > - div with an id
				<"class" and > - div with a class
				<"#id.class" and > - div with an id and class
				
				Also see: http://legacy.datatables.net/usage/features
				 */

				/* BASIC ;*/
				var responsiveHelper_dt_basic = undefined;
				var responsiveHelper_datatable_fixed_column = undefined;
				var responsiveHelper_datatable_col_reorder = undefined;
				var responsiveHelper_datatable_tabletools = undefined;

				var breakpointDefinition = {
					tablet : 1024,
					phone : 480
				};

				/* END TABLETOOLS */

			})

			$(function() {
				$("table").stickyTableHeaders();
			});
			/*! Copyright (c) 2011 by Jonas Mosbech - https://github.com/jmosbech/StickyTableHeaders
			    MIT license info: https://github.com/jmosbech/StickyTableHeaders/blob/master/license.txt */

			;
			(function($, window, undefined) {
				'use strict';

				var name = 'stickyTableHeaders';
				var defaults = {
					fixedOffset : 0
				};

				function Plugin(el, options) {
					// To avoid scope issues, use 'base' instead of 'this'
					// to reference this class from internal events and functions.
					var base = this;

					// Access to jQuery and DOM versions of element
					base.$el = $(el);
					base.el = el;

					// Listen for destroyed, call teardown
					base.$el.bind('destroyed', $.proxy(base.teardown, base));

					// Cache DOM refs for performance reasons
					base.$window = $(window);
					base.$clonedHeader = null;
					base.$originalHeader = null;

					// Keep track of state
					base.isSticky = false;
					base.leftOffset = null;
					base.topOffset = null;

					base.init = function() {
						base.options = $.extend({}, defaults, options);

						base.$el
								.each(function() {
									var $this = $(this);

									// remove padding on <table> to fix issue #7
									$this.css('padding', 0);

									base.$originalHeader = $('thead:first',
											this);
									base.$clonedHeader = base.$originalHeader
											.clone();

									base.$clonedHeader
											.addClass('tableFloatingHeader');
									base.$clonedHeader.css('display', 'none');

									base.$originalHeader
											.addClass('tableFloatingHeaderOriginal');

									base.$originalHeader
											.after(base.$clonedHeader);

									base.$printStyle = $('<style type="text/css" media="print">'
											+ '.tableFloatingHeader{display:none !important;}'
											+ '.tableFloatingHeaderOriginal{position:static !important;}'
											+ '</style>');
									$('head').append(base.$printStyle);
								});

						base.updateWidth();
						base.toggleHeaders();

						base.bind();
					};

					base.destroy = function() {
						base.$el.unbind('destroyed', base.teardown);
						base.teardown();
					};

					base.teardown = function() {
						if (base.isSticky) {
							base.$originalHeader.css('position', 'static');
						}
						$.removeData(base.el, 'plugin_' + name);
						base.unbind();

						base.$clonedHeader.remove();
						base.$originalHeader
								.removeClass('tableFloatingHeaderOriginal');
						base.$originalHeader.css('visibility', 'visible');
						base.$printStyle.remove();

						base.el = null;
						base.$el = null;
					};

					base.bind = function() {
						base.$window.on('scroll.' + name, base.toggleHeaders);
						base.$window.on('resize.' + name, base.toggleHeaders);
						base.$window.on('resize.' + name, base.updateWidth);
					};

					base.unbind = function() {
						// unbind window events by specifying handle so we don't remove too much
						base.$window.off('.' + name, base.toggleHeaders);
						base.$window.off('.' + name, base.updateWidth);
						base.$el.off('.' + name);
						base.$el.find('*').off('.' + name);
					};

					base.toggleHeaders = function() {
						base.$el
								.each(function() {
									var $this = $(this);

									var newTopOffset = isNaN(base.options.fixedOffset) ? base.options.fixedOffset
											.height()
											: base.options.fixedOffset;

									var offset = $this.offset();
									var scrollTop = base.$window.scrollTop()
											+ newTopOffset;
									var scrollLeft = base.$window.scrollLeft();

									if ((scrollTop > offset.top)
											&& (scrollTop < offset.top
													+ $this.height()
													- base.$clonedHeader
															.height())) {
										var newLeft = offset.left - scrollLeft;
										if (base.isSticky
												&& (newLeft === base.leftOffset)
												&& (newTopOffset === base.topOffset)) {
											return;
										}

										base.$originalHeader.css({
											'position' : 'fixed',
											'top' : newTopOffset,
											'margin-top' : 0,
											'left' : newLeft,
											'z-index' : 1
										// #18: opacity bug
										});
										base.$clonedHeader.css('display', '');
										base.isSticky = true;
										base.leftOffset = newLeft;
										base.topOffset = newTopOffset;

										// make sure the width is correct: the user might have resized the browser while in static mode
										base.updateWidth();
									} else if (base.isSticky) {
										base.$originalHeader.css('position',
												'static');
										base.$clonedHeader.css('display',
												'none');
										base.isSticky = false;
									}
								});
					};

					base.updateWidth = function() {
						if (!base.isSticky) {
							return;
						}
						// Copy cell widths from clone
						var $origHeaders = $('th,td', base.$originalHeader);
						$('th,td', base.$clonedHeader).each(function(index) {

							var width, $this = $(this);

							if ($this.css('box-sizing') === 'border-box') {
								width = $this.outerWidth(); // #39: border-box bug
							} else {
								width = $this.width();
							}

							$origHeaders.eq(index).css({
								'min-width' : width,
								'max-width' : width
							});
						});

						// Copy row width from whole table
						base.$originalHeader.css('width', base.$clonedHeader
								.width());
					};

					base.updateOptions = function(options) {
						base.options = $.extend({}, defaults, options);
						base.updateWidth();
						base.toggleHeaders();
					};

					// Run initializer
					base.init();
				}

				// A plugin wrapper around the constructor,
				// preventing against multiple instantiations
				$.fn[name] = function(options) {
					return this.each(function() {
						var instance = $.data(this, 'plugin_' + name);
						if (instance) {
							if (typeof options === "string") {
								instance[options].apply(instance);
							} else {
								instance.updateOptions(options);
							}
						} else if (options !== 'destroy') {
							$.data(this, 'plugin_' + name, new Plugin(this,
									options));
						}
					});
				};

			})(jQuery, window);

			function clearTable() {
				var table = $("#mprDetailDataTable table tbody");
				//alert(table);
				table.find('tr').each(function(i) {
					var $tds = $(this).find('td'), colu = $tds.eq(0).text();

					// do something with productId, product, Quantity
					log('Row ' + (i + 1) + ':\nId: ' + colu);
				});
			}

			function cargaRegiones() {
				var r3g = $("#region").val();
				if (r3g.localeCompare("Todas") == 0) {
					var $select = $('#nia').empty();
					var o = $('<option/>', {
						value : "Todas"
					}).text("-All-");
					o.appendTo($select);
					cia();
				} else {
					//if (r3g.localeCompare("Todas") == 0){
					//	var $select = $('#nia').empty();
					//	var o = $('<option/>', { value: "Todas" }).text("-Todas-");
					//	o.appendTo($select);
					//}
					//else{
					$.ajax({
						type : "POST",
						url : "get_region",
						data : {
							r3g : r3g
						},
						success : function(data) {
							data = data.substring(0, data.length - 1);
							var arr = data.split(';');
							var $select = $('#nia').empty();
							var o = $('<option/>', {
								value : "Todas"
							}).text("-All-");
							o.appendTo($select);
							for (var i = 0; i < arr.length; i++) {
								var arr2 = arr[i].split('---');
								var o = $('<option/>', {
									value : arr2[0]
								}).text(arr2[1]).prop('selected', i == 0);
								o.appendTo($select);
							}
							//alert(data);
						},
						error : function(data) {
							alert("Inconveniente con la base de datos");

						}
					});
					//}
				}
			}

			function cia() {
				var region = document.getElementById("region").value;
				var nia = document.getElementById("nia").value;
				//alert(dato);
				$.ajax({
					type : "POST",
					url : "cia",
					data : {
						r3g : region,
						c1a : nia
					},
					success : function(data) {
						//alert("si");
						location.reload();
					},
					error : function(data) {
						alert("no");

					}
				});
			}

			function moneda() {
				var dato = document.getElementById("moneda").value;
				var t4s4 = document.getElementById("tasa").value;
				//alert(dato);
				$.ajax({
					type : "POST",
					url : "moneda",
					data : {
						m3r : dato,
						t4s4 : t4s4
					},
					success : function(data) {
						//alert("si");
						location.reload();
					},
					error : function(data) {
						alert("no");

					}
				});
			}

			function tasa() {
				var dato = document.getElementById("tasa").value;
				$.ajax({
					type : "POST",
					url : "tasa",
					data : {
						t4s4 : dato
					},
					success : function(data) {
						//alert(dato);
						location.reload();
					},
					error : function(data) {
						alert("no");

					}
				});
			}

			function anio() {
				var dato = document.getElementById("anio").value;
				$.ajax({
					type : "POST",
					url : "anio",
					data : {
						anio : dato
					},
					success : function(data) {
						//alert(dato);
						location.reload();
					},
					error : function(data) {
						alert("no");

					}
				});
			}

			$('#modal').click(function() {
				$('#dialog-message').dialog('open');
				return false;
			});

			$("#dialog-graph").dialog({
				autoOpen : false,
				modal : true,
				title : "Graph",
				position : 'top'

			});

			function drilldown_controller(indicador, nombre_filtro,
					campo_llave, campo_des, indicador_des, sim) {
				//indicador_des = indicador_des.replace("%", "");
				window.location = "drilldown?m3r=" + nombre_filtro + "&ind1c4="
						+ indicador + "&ind1c4d3s="
						+ encodeURIComponent(indicador_des) + "&ll4v3="
						+ campo_llave + "&d3s=" + campo_des + "&op10n=Y"
						+ "&s1m=" + sim;
			}

			function opciones_detalle(indicador, indicador_des, cosa_this) {
				var opc = new Array();
				var simbolo_porcentaje = $(cosa_this).closest("tr").find(
						'td:eq(1)').text();
				if (simbolo_porcentaje.indexOf("%") < 0)
					simbolo_porcentaje = "-";
				else
					simbolo_porcentaje = "p";

				// Indicación especial para el indicador 02, que no es % pero debe llevar decimal
				if (indicador == 'VEN002')
					simbolo_porcentaje = "d";
				opc[1] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Clientes\', \'mvecli\', \'mvecln\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/cliente.png"/>" style="width: 48px; height: 48px">Por Cliente<br>';
				opc[2] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Tipos de Cliente\', \'mvetic\', \'mvetin\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/tipocliente.png"/>" style="width: 48px; height: 48px">Tipo Cliente<br>';
				opc[3] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Bodega\', \'mveloc\', \'mvelon\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/bodega.png"/>" style="width: 48px; height: 48px">Bodega<br>';
				opc[4] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Areas de Cliente\', \'mvecr1\', \'mvecn1\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/areacliente.png"/>" style="width: 48px; height: 48px">Area Cliente<br>';
				opc[5] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Zonas Cliente\', \'mvecr2\', \'mvecn2\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/zonacliente.png"/>" style="width: 48px; height: 48px"> Zona Cliente<br>';
				opc[6] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Region Cliente\', \'mvecr3\', \'mvecn3\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/regioncliente.png"/>" style="width: 48px; height: 48px">Región Cliente<br>';
				opc[7] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Local Cliente\', \'mvecr4\', \'mvecn4\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/localcliente.png"/>" style="width: 48px; height: 48px">Local Cliente<br>';
				opc[8] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Distrito\', \'mvecr5\', \'mvecn5\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/distrito.png"/>" style="width: 48px; height: 48px">Distrito<br>';
				opc[9] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Vendedor\', \'mvesal\', \'mvesan\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/vendedor.png"/>" style="width: 48px; height: 48px">Vendedor<br>';
				opc[10] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Producto\', \'mvepro\', \'mveprn\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/producto.png"/>" style="width: 48px; height: 48px"> Producto<br>';
				opc[11] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Clase Articulo\', \'mvecal\', \'mvecan\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/clasearticulo.png"/>" style="width: 48px; height: 48px"> Clase Artículo<br>';
				opc[12] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Tipo Articulo\', \'mvesr1\', \'mvesn1\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/grupoarticulo.png"/>" style="width: 48px; height: 48px"> Grupo Artículo<br>';
				opc[13] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Grupo Articulo\', \'mvesr2\', \'mvesn2\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/grupoarticulo.png"/>" style="width: 48px; height: 48px"> Grupo Artículo<br>';
				opc[14] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Linea Articulo\', \'mvesr3\', \'mvesn3\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/lineaarticulo.png"/>" style="width: 48px; height: 48px"> Línea Artículo<br>';
				opc[15] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Categoria Articulo\', \'mvesr4\', \'mvesn4\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/categoriaarticulo.png"/>" style="width: 48px; height: 48px"> Categoría Artículo<br>';
				opc[16] = '<img onclick="drilldown_controller(\''
						+ indicador
						+ '\', \'Marca\', \'mvesr5\', \'mvesn5\', \''
						+ indicador_des
						+ '\', \''
						+ simbolo_porcentaje
						+ '\')" src="<c:url value="/resources/img/adm/marca.png"/>" style="width: 48px; height: 48px"> Marca <br>';
				var opciones = new Array();
				switch (indicador) {
				case "DIS001":
					opciones.push(opc[1]);
					opciones.push(opc[2]);
					opciones.push(opc[3]);
					opciones.push(opc[4]);
					opciones.push(opc[5]);
					opciones.push(opc[6]);
					opciones.push(opc[7]);
					opciones.push(opc[8]);
					opciones.push(opc[9]);
					opciones.push(opc[10]);
					opciones.push(opc[11]);
					opciones.push(opc[12]);
					opciones.push(opc[13]);
					opciones.push(opc[14]);
					opciones.push(opc[15]);
					opciones.push(opc[16]);
					break;
				case "DIS002":
					opciones.push(opc[1]);
					opciones.push(opc[2]);
					opciones.push(opc[3]);
					opciones.push(opc[4]);
					opciones.push(opc[5]);
					opciones.push(opc[6]);
					opciones.push(opc[7]);
					opciones.push(opc[8]);
					opciones.push(opc[9]);
					opciones.push(opc[10]);
					opciones.push(opc[11]);
					opciones.push(opc[12]);
					opciones.push(opc[13]);
					opciones.push(opc[14]);
					opciones.push(opc[15]);
					opciones.push(opc[16]);
					break;
				case "DIS003":
					opciones.push(opc[1]);
					opciones.push(opc[2]);
					opciones.push(opc[3]);
					opciones.push(opc[4]);
					opciones.push(opc[5]);
					opciones.push(opc[6]);
					opciones.push(opc[7]);
					opciones.push(opc[8]);
					opciones.push(opc[9]);
					opciones.push(opc[10]);
					opciones.push(opc[11]);
					opciones.push(opc[12]);
					opciones.push(opc[13]);
					opciones.push(opc[14]);
					opciones.push(opc[15]);
					opciones.push(opc[16]);
					break;
				case "DIS004":
					break;
				case "DIS005":
					opciones.push(opc[1]);
					opciones.push(opc[2]);
					opciones.push(opc[3]);
					opciones.push(opc[4]);
					opciones.push(opc[5]);
					opciones.push(opc[6]);
					opciones.push(opc[7]);
					opciones.push(opc[8]);
					opciones.push(opc[9]);
					opciones.push(opc[10]);
					opciones.push(opc[11]);
					opciones.push(opc[12]);
					opciones.push(opc[13]);
					opciones.push(opc[14]);
					opciones.push(opc[15]);
					opciones.push(opc[16]);

					break;
				case "DIS006":
					break;
				case "DIS007":
					opciones.push(opc[3]);
					opciones.push(opc[11]);
					break;
				case "DIS008":
					break;
				case "DIS009":
					break;
				case "DIS010":
					break;
				case "DIS011":
					break;
				case "DIS02":
					break;
				default:
					console.log("Sorry, we are out of " + indicador + ".");
				}
				return opciones;
			}

			$("#dialog-message").dialog({
				autoOpen : false,
				modal : true,
				title : tit,
				position : 'top'

			});

			function ventana_drill() {
				//$("#dialog-message").dialog('close');
				//$("#dialog-message").dialog('destroy');
				$("#dialog-message").dialog('open');
			}

			function drilldown(indicador, cosa) {
				$("#opc").html('');
				$("#opc").append(
						opciones_detalle(indicador, cosa.innerHTML, cosa));
				//tit=cosa.innerHTML;
				$("span.ui-dialog-title").text(cosa.innerHTML);
				ventana_drill();
			}

			function graph(real, presupuestado, indicador) {
				window.location = "chartjs?i=" + real + "&indicador="
						+ encodeURIComponent(indicador) + "&p=" + presupuestado
						+ "&op=y";
				//$('#dialog-graph').dialog('open');
			}

			function plan(cod) {
				//alert(cod);
				$.ajax({
					type : "POST",
					url : "plan",
					data : {
						ind1c4 : cod
					},
					success : function(data) {
						//alert(data);
						//document.write(data);
						//location.reload();
						window.location = "plan?ind1c4=1";
					},
					error : function(data) {
						alert("no");

					}
				});
			}
		</script>
</body>

</html>