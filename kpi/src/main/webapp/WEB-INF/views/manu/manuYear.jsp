<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="../resources/css/font-awesome.min.css"/>">

<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-production-plugins.min.css" />">
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-production.min.css" />">
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-skins.min.css" />">

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
	
	.transp-block {
	    background: #000 url(watermark.jpg) no-repeat;
	    width: 575px;
	    height: 335px;
	}
	img.transparent {
	    filter:alpha(opacity=75);
	    opacity:.75;
	}
	#tbl tr td {
		    height: 1px;
		    padding: 1px;
	}
</style>

</head>
<!--  <body oncontextmenu="return false">  -->

<body>
	<!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->

	<!-- HEADER -->
	
	<!-- ---------------------------------------------------- -->
	<!-- ---------------------------------------------------- -->
	<header id="header">
		<div class="icon-addon addon-md">
            <select class="form-control " id="moneda" class="moneda" name="moneda" onchange="moneda()">
				<c:forEach items="${currencyList}" var="curr"
					varStatus="loopCounter">
					<option value="${curr.id}">${curr.descripcion}</option>
				</c:forEach>
			</select>
            <label for="email" class="glyphicon glyphicon-search" rel="tooltip" title="" data-original-title="email"></label>
        </div>
        <div class="icon-addon addon-md">
        	<select class="form-control input-sm col-sm-2" id="tasa" class="tasa"	name="tasa" onchange="tasa()">
				<option value="p">Average</option>
				<option value="m">Month rate</option>
			</select>
			
			<label for="email" class="glyphicon glyphicon-search" rel="tooltip" title="" data-original-title="email"></label>
		</div>
		<div class="icon-addon addon-md">
        	<select class="form-control input-sm col-sm-2" id="anio" class="anio"
				name="anio" onchange="anio()">
				<option value="2015">2015</option>
				<option value="2016">2016</option>
			</select>
			<label for="email" class="glyphicon glyphicon-search" rel="tooltip" title="" data-original-title="email"></label>
		</div>
		<div class="pull-right">
		<a href="javascript:history.back(1)" class="btn btn-labeled btn-danger btn-sm" > 
			<span class="btn-label">
				<i class="fa fa-sign-out">
				</i>
			</span>
			Back
		</a>
		</div>
		<!-- end pulled right: nav area -->
	</header>
	
	<!-- ---------------------------------------------------- -->
	<!-- ---------------------------------------------------- -->

	<!-- END HEADER -->

	<!-- MAIN CONTENT -->
	<div id="content">

		<!-- widget grid -->
		<section id="widget-grid">

			<!-- row -->
			<div class="row">










				<div class="ui-widget-overlay jqgrid-overlay" id="lui_jqgrid"></div>
				<div style="display: none;"
					class="loading ui-state-default ui-state-active" id="load_jqgrid">Loading...</div>
				<div style="width: 1105px;" id="gview_jqgrid" class="ui-jqgrid-view">
					<div class="ui-jqgrid-titlebar ui-corner-top ui-helper-clearfix">
						<a style="right: 0px;" role="link"
							class="ui-jqgrid-titlebar-close HeaderButton"><span
							class="ui-icon ui-icon-circle-triangle-n"></span></a><span
							class="ui-jqgrid-title">SmartAdmin jQgrid Skin</span>
					</div>
					<div class="ui-jqgrid-hdiv" style="width: 1105px;">
						<div class="ui-jqgrid-hbox">
							<table class="ui-jqgrid-htable table table-bordered table-hover"
								style="width: 1105px;" role="grid" aria-labelledby="gbox_jqgrid"
								border="0" cellpadding="0" cellspacing="0">
								<thead>
									<tr class="ui-jqgrid-labels" role="rowheader">
										<th style="width: 20px;" id="jqgrid_cb" role="columnheader"
											class=""><div id="jqgh_jqgrid_cb">
												<input role="checkbox" id="cb_jqgrid" class="cbox"
													type="checkbox"><span class="s-ico"
													style="display: none"><span sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_act" role="columnheader"
											class=""><span style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_act">
												Actions<span class="s-ico" style="display: none"><span
													sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_id" role="columnheader"
											class=""><span style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_id">
												Inv No<span class="s-ico" style=""><span sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_date" role="columnheader"
											class=""><span style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_date">
												Date<span class="s-ico" style="display: none"><span
													sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_name" role="columnheader"
											class=""><span style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_name">
												Client<span class="s-ico" style="display: none"><span
													sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_amount"
											role="columnheader" class=""><span
											style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_amount">
												Amount<span class="s-ico" style="display: none"><span
													sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_tax" role="columnheader"
											class=""><span style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_tax">
												Tax<span class="s-ico" style="display: none"><span
													sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_total"
											role="columnheader" class=""><span
											style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_total">
												Total<span class="s-ico" style="display: none"><span
													sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
										<th style="width: 130px;" id="jqgrid_note" role="columnheader"
											class=""><span style="cursor: col-resize;"
											class="ui-jqgrid-resize ui-jqgrid-resize-ltr">&nbsp;</span>
										<div class="ui-jqgrid-sortable" id="jqgh_jqgrid_note">
												Notes<span class="s-ico" style="display: none"><span
													sort="asc"
													class="ui-grid-ico-sort ui-icon-asc ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-ltr"></span><span
													sort="desc"
													class="ui-grid-ico-sort ui-icon-desc ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-ltr"></span></span>
											</div></th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
					<div style="height: auto; width: 1105px;" class="ui-jqgrid-bdiv">
						<div style="position: relative;">
							<div></div>
							<table style="width: 1105px;"
								class="ui-jqgrid-btable table table-bordered table-striped"
								aria-labelledby="gbox_jqgrid" aria-multiselectable="true"
								role="grid" tabindex="0" id="jqgrid" border="0" cellpadding="0"
								cellspacing="0">
								<tbody>
									<tr class="jqgfirstrow" role="row" style="height: auto">
										<td role="gridcell" style="height: 0px; width: 20px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
										<td role="gridcell" style="height: 0px; width: 130px;"></td>
									</tr>
									<tr role="row" id="1" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center; width: 20px;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_1" class="cbox" name="jqg_jqgrid_1"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('1');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('1');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('1');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="1"
											aria-describedby="jqgrid_id">1</td>
										<td role="gridcell" style="" title="2007-10-01"
											aria-describedby="jqgrid_date">2007-10-01</td>
										<td role="gridcell" style="" title="test"
											aria-describedby="jqgrid_name">test</td>
										<td role="gridcell" style="text-align: right;" title="200.00"
											aria-describedby="jqgrid_amount">200.00</td>
										<td role="gridcell" style="text-align: right;" title="10.00"
											aria-describedby="jqgrid_tax">10.00</td>
										<td role="gridcell" style="text-align: right;" title="210.00"
											aria-describedby="jqgrid_total">210.00</td>
										<td role="gridcell" style="" title="note"
											aria-describedby="jqgrid_note">note</td>
									</tr>
									<tr role="row" id="10" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_10" class="cbox" name="jqg_jqgrid_10"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('10');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('10');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('10');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="10"
											aria-describedby="jqgrid_id">10</td>
										<td role="gridcell" style="" title="2007-10-01"
											aria-describedby="jqgrid_date">2007-10-01</td>
										<td role="gridcell" style="" title="test"
											aria-describedby="jqgrid_name">test</td>
										<td role="gridcell" style="text-align: right;" title="200.00"
											aria-describedby="jqgrid_amount">200.00</td>
										<td role="gridcell" style="text-align: right;" title="10.00"
											aria-describedby="jqgrid_tax">10.00</td>
										<td role="gridcell" style="text-align: right;" title="210.00"
											aria-describedby="jqgrid_total">210.00</td>
										<td role="gridcell" style="" title="note"
											aria-describedby="jqgrid_note">note</td>
									</tr>
									<tr role="row" id="11" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_11" class="cbox" name="jqg_jqgrid_11"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('11');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('11');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('11');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="11"
											aria-describedby="jqgrid_id">11</td>
										<td role="gridcell" style="" title="2007-10-02"
											aria-describedby="jqgrid_date">2007-10-02</td>
										<td role="gridcell" style="" title="test2"
											aria-describedby="jqgrid_name">test2</td>
										<td role="gridcell" style="text-align: right;" title="300.00"
											aria-describedby="jqgrid_amount">300.00</td>
										<td role="gridcell" style="text-align: right;" title="20.00"
											aria-describedby="jqgrid_tax">20.00</td>
										<td role="gridcell" style="text-align: right;" title="320.00"
											aria-describedby="jqgrid_total">320.00</td>
										<td role="gridcell" style="" title="note2"
											aria-describedby="jqgrid_note">note2</td>
									</tr>
									<tr role="row" id="12" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_12" class="cbox" name="jqg_jqgrid_12"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('12');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('12');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('12');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="12"
											aria-describedby="jqgrid_id">12</td>
										<td role="gridcell" style="" title="2007-09-01"
											aria-describedby="jqgrid_date">2007-09-01</td>
										<td role="gridcell" style="" title="test3"
											aria-describedby="jqgrid_name">test3</td>
										<td role="gridcell" style="text-align: right;" title="400.00"
											aria-describedby="jqgrid_amount">400.00</td>
										<td role="gridcell" style="text-align: right;" title="30.00"
											aria-describedby="jqgrid_tax">30.00</td>
										<td role="gridcell" style="text-align: right;" title="430.00"
											aria-describedby="jqgrid_total">430.00</td>
										<td role="gridcell" style="" title="note3"
											aria-describedby="jqgrid_note">note3</td>
									</tr>
									<tr role="row" id="13" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_13" class="cbox" name="jqg_jqgrid_13"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('13');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('13');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('13');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="13"
											aria-describedby="jqgrid_id">13</td>
										<td role="gridcell" style="" title="2007-10-04"
											aria-describedby="jqgrid_date">2007-10-04</td>
										<td role="gridcell" style="" title="test"
											aria-describedby="jqgrid_name">test</td>
										<td role="gridcell" style="text-align: right;" title="200.00"
											aria-describedby="jqgrid_amount">200.00</td>
										<td role="gridcell" style="text-align: right;" title="10.00"
											aria-describedby="jqgrid_tax">10.00</td>
										<td role="gridcell" style="text-align: right;" title="210.00"
											aria-describedby="jqgrid_total">210.00</td>
										<td role="gridcell" style="" title="note"
											aria-describedby="jqgrid_note">note</td>
									</tr>
									<tr role="row" id="14" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_14" class="cbox" name="jqg_jqgrid_14"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('14');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('14');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('14');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="14"
											aria-describedby="jqgrid_id">14</td>
										<td role="gridcell" style="" title="2007-10-05"
											aria-describedby="jqgrid_date">2007-10-05</td>
										<td role="gridcell" style="" title="test2"
											aria-describedby="jqgrid_name">test2</td>
										<td role="gridcell" style="text-align: right;" title="300.00"
											aria-describedby="jqgrid_amount">300.00</td>
										<td role="gridcell" style="text-align: right;" title="20.00"
											aria-describedby="jqgrid_tax">20.00</td>
										<td role="gridcell" style="text-align: right;" title="320.00"
											aria-describedby="jqgrid_total">320.00</td>
										<td role="gridcell" style="" title="note2"
											aria-describedby="jqgrid_note">note2</td>
									</tr>
									<tr role="row" id="15" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_15" class="cbox" name="jqg_jqgrid_15"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('15');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('15');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('15');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="15"
											aria-describedby="jqgrid_id">15</td>
										<td role="gridcell" style="" title="2007-09-06"
											aria-describedby="jqgrid_date">2007-09-06</td>
										<td role="gridcell" style="" title="test3"
											aria-describedby="jqgrid_name">test3</td>
										<td role="gridcell" style="text-align: right;" title="400.00"
											aria-describedby="jqgrid_amount">400.00</td>
										<td role="gridcell" style="text-align: right;" title="30.00"
											aria-describedby="jqgrid_tax">30.00</td>
										<td role="gridcell" style="text-align: right;" title="430.00"
											aria-describedby="jqgrid_total">430.00</td>
										<td role="gridcell" style="" title="note3"
											aria-describedby="jqgrid_note">note3</td>
									</tr>
									<tr role="row" id="16" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_16" class="cbox" name="jqg_jqgrid_16"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('16');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('16');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('16');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="16"
											aria-describedby="jqgrid_id">16</td>
										<td role="gridcell" style="" title="2007-10-04"
											aria-describedby="jqgrid_date">2007-10-04</td>
										<td role="gridcell" style="" title="test"
											aria-describedby="jqgrid_name">test</td>
										<td role="gridcell" style="text-align: right;" title="200.00"
											aria-describedby="jqgrid_amount">200.00</td>
										<td role="gridcell" style="text-align: right;" title="10.00"
											aria-describedby="jqgrid_tax">10.00</td>
										<td role="gridcell" style="text-align: right;" title="210.00"
											aria-describedby="jqgrid_total">210.00</td>
										<td role="gridcell" style="" title="note"
											aria-describedby="jqgrid_note">note</td>
									</tr>
									<tr role="row" id="17" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_17" class="cbox" name="jqg_jqgrid_17"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('17');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('17');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('17');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="17"
											aria-describedby="jqgrid_id">17</td>
										<td role="gridcell" style="" title="2007-10-03"
											aria-describedby="jqgrid_date">2007-10-03</td>
										<td role="gridcell" style="" title="test2"
											aria-describedby="jqgrid_name">test2</td>
										<td role="gridcell" style="text-align: right;" title="300.00"
											aria-describedby="jqgrid_amount">300.00</td>
										<td role="gridcell" style="text-align: right;" title="20.00"
											aria-describedby="jqgrid_tax">20.00</td>
										<td role="gridcell" style="text-align: right;" title="320.00"
											aria-describedby="jqgrid_total">320.00</td>
										<td role="gridcell" style="" title="note2"
											aria-describedby="jqgrid_note">note2</td>
									</tr>
									<tr role="row" id="18" tabindex="-1"
										class="ui-widget-content jqgrow ui-row-ltr">
										<td role="gridcell" style="text-align: center;"
											aria-describedby="jqgrid_cb"><input role="checkbox"
											id="jqg_jqgrid_18" class="cbox" name="jqg_jqgrid_18"
											type="checkbox"></td>
										<td role="gridcell" style="" title=""
											aria-describedby="jqgrid_act"><button
												class="btn btn-xs btn-default"
												data-original-title="Edit Row"
												onclick="jQuery('#jqgrid').editRow('18');">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Save Row"
												onclick="jQuery('#jqgrid').saveRow('18');">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-xs btn-default"
												data-original-title="Cancel"
												onclick="jQuery('#jqgrid').restoreRow('18');">
												<i class="fa fa-times"></i>
											</button></td>
										<td role="gridcell" style="" title="18"
											aria-describedby="jqgrid_id">18</td>
										<td role="gridcell" style="" title="2007-09-01"
											aria-describedby="jqgrid_date">2007-09-01</td>
										<td role="gridcell" style="" title="test3"
											aria-describedby="jqgrid_name">test3</td>
										<td role="gridcell" style="text-align: right;" title="400.00"
											aria-describedby="jqgrid_amount">400.00</td>
										<td role="gridcell" style="text-align: right;" title="30.00"
											aria-describedby="jqgrid_tax">30.00</td>
										<td role="gridcell" style="text-align: right;" title="430.00"
											aria-describedby="jqgrid_total">430.00</td>
										<td role="gridcell" style="" title="note3"
											aria-describedby="jqgrid_note">note3</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="ui-jqgrid-resize-mark" id="rs_mjqgrid">&nbsp;</div>
				<div dir="ltr" class="ui-jqgrid-pager ui-corner-bottom"
					style="width: 1105px;" id="pjqgrid">
					<div id="pg_pjqgrid" class="ui-pager-control" role="group">
						<table class="ui-pg-table"
							style="width: 100%; table-layout: fixed; height: 100%;"
							role="row" border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td id="pjqgrid_left" align="left"><table
											class="ui-pg-table navtable"
											style="float: left; table-layout: auto;" border="0"
											cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td data-original-title="Delete selected row"
														id="del_jqgrid" title=""
														class="ui-pg-button ui-corner-all"><div
															class="btn btn-sm btn-primary">
															<span class="fa fa-trash-o"></span>
														</div></td>
													<td title="" data-original-title=""
														class="ui-pg-button ui-state-disabled" style="width: 4px;"><span
														class="ui-separator"></span></td>
													<td data-original-title="Find records" id="search_jqgrid"
														title="" class="ui-pg-button ui-corner-all"><div
															class="btn btn-sm btn-primary">
															<span class="fa fa-search"></span>
														</div></td>
													<td data-original-title="Reload Grid" id="refresh_jqgrid"
														title="" class="ui-pg-button ui-corner-all"><div
															class="btn btn-sm btn-primary">
															<span class="fa fa-refresh"></span>
														</div></td>
													<td data-original-title="Add new row" title=""
														id="jqgrid_iladd" class="ui-pg-button ui-corner-all"><div
															class="btn btn-sm btn-primary">
															<span class="fa fa-plus"></span>
														</div></td>
													<td data-original-title="Edit selected row" title=""
														id="jqgrid_iledit" class="ui-pg-button ui-corner-all"><div
															class="btn btn-sm btn-primary">
															<span class="fa fa-pencil"></span>
														</div></td>
													<td data-original-title="Save row" title=""
														id="jqgrid_ilsave"
														class="ui-pg-button ui-corner-all ui-state-disabled"><div
															class="btn btn-sm btn-success">
															<span class="fa fa-save"></span>
														</div></td>
													<td data-original-title="Cancel row editing" title=""
														id="jqgrid_ilcancel"
														class="ui-pg-button ui-corner-all ui-state-disabled"><div
															class="btn btn-sm btn-danger">
															<span class="fa fa-times"></span>
														</div></td>
												</tr>
											</tbody>
										</table></td>
									<td id="pjqgrid_center" style="white-space: pre; width: 270px;"
										align="center"><table style="table-layout: auto;"
											class="ui-pg-table" border="0" cellpadding="0"
											cellspacing="0">
											<tbody>
												<tr>
													<td id="first_pjqgrid"
														class="ui-pg-button ui-corner-all ui-state-disabled"><div
															class="btn btn-sm btn-default">
															<span class="fa fa-fast-backward"></span>
														</div></td>
													<td id="prev_pjqgrid"
														class="ui-pg-button ui-corner-all ui-state-disabled"><div
															class="btn btn-sm btn-default">
															<span class="fa fa-backward"></span>
														</div></td>
													<td class="ui-pg-button ui-state-disabled"
														style="width: 4px;"><span class="ui-separator"></span></td>
													<td dir="ltr">Page <input class="ui-pg-input" size="2"
														maxlength="7" value="0" role="textbox" type="text">
														of <span id="sp_1_pjqgrid">2</span></td>
													<td class="ui-pg-button ui-state-disabled"
														style="width: 4px;"><span class="ui-separator"></span></td>
													<td id="next_pjqgrid" class="ui-pg-button ui-corner-all"><div
															class="btn btn-sm btn-default">
															<span class="fa fa-forward"></span>
														</div></td>
													<td id="last_pjqgrid" class="ui-pg-button ui-corner-all"><div
															class="btn btn-sm btn-default">
															<span class="fa fa-fast-forward"></span>
														</div></td>
													<td dir="ltr"><select class="ui-pg-selbox"
														role="listbox"><option role="option" value="10"
																selected="selected">10</option>
															<option role="option" value="20">20</option>
															<option role="option" value="30">30</option></select></td>
												</tr>
											</tbody>
										</table></td>
									<td id="pjqgrid_right" align="right"><div dir="ltr"
											style="text-align: right" class="ui-paging-info">View 1
											- 10 of 18</div></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
















				<!-- NEW WIDGET START -->
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div style="margin: 0 auto; display: block; position: absolute; right: 3%;">
						<p style="font-family: 'Arial Black', 'Arial Bold', Gadget, sans-serif;	font-size: 60px; font-style: normal; font-variant: normal; font-weight: bold; line-height: 44px; color:#ffffe6">
						Manufacturing</p>
					</div>
					<!-- Widget ID (each widget will need unique ID)-->
					<div class="jarviswidget jarviswidget-color-darken far"
						id="wid-id-0" data-widget-editbutton="false">

						<!-- widget div-->
						<div>

							<!-- widget content -->
							<div class="widget-body no-padding">
								<div class="row"><h1><strong>${tit}</strong></h1>
								<div id="dialog-message" title="Drill Down">
									<div id="opc" width="1500" height="100" style="background-color:#ffffff;">
										
									</div>
								</div>

								
							</div>
							
							<!-- end widget content -->

						</div>
						<!-- end widget div -->

					</div>
					<!-- end widget -->

				</article>
				<!-- WIDGET END -->

			</div>
			<!-- end row -->
			<!-- end row -->
			<c:set var="color" value="success"/>
			<table id="tbl" class="table table-bordered" width="100%" id="gral">
				<thead>
					<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
						<h1 class="page-title txt-color-blueDark"> 
							<i class="fa fa-list-alt fa-fw "></i> 
							<span><c:out value="${navegacion}" /> 
							</span>
						</h1>
					</div>
				</div>
					<tr>
					</tr>
					<tr >
						<th style="text-align: center; color: blue;">Indicator
						</th>
						<th style="text-align: center; color: blue;">UM
						</th>
						<th style="text-align: center; color: blue;">Type
						</th>
						<th style="text-align: center; color: blue;">Average <c:out value="${anio-1}"/>
						</th>
						<th style="text-align: center; color: blue;">Average <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">JAN <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">FEB <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">MAR <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">APR <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">MAY <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">JUN <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">JUL <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">AUG <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">SEP <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">OCT <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">NOV <c:out value="${anio}"/>
						</th>
						<th colspan="2" style="text-align: center; color: blue;">DEC <c:out value="${anio}"/>
						</th>
						<th style="text-align: center; color: blue;">Graph</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${valor}" var="kpi"
						varStatus="loopCounter">
						<tr class="${color}">
							
							<td rowspan="2"><a id="modal" href="#" onclick="drilldown('${ kpi.ind_cod }', this)">${ kpi.ind }</a>
							
							<td rowspan="2">${ kpi.unidad }</td>
							<td>${kpi.tipoUno}</td>
							<c:choose>	
								
								<c:when test="${not fn:contains(kpi.ind_cod, '001')}">
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevalRealAnoAnt}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevalRealAnoActual}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
						    	</c:when>    
						    	<c:otherwise>
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevalRealAnoAnt}" type="number" /></td>
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevalRealAnoActual}" type="number" /></td>
						    	</c:otherwise>
							</c:choose>
							<c:set var="real" value=""/>
							<c:set var="presupuestado" value=""/>
							<c:forEach items="${kpi.lista}" var="val"
								varStatus="loopCounter">
									<c:choose>
									
										<c:when test="${not fn:contains(kpi.ind_cod, '001')}">
											<td style="text-align: right;" nowrap><fmt:formatNumber pattern="###,##0.0" value="${val.mveval}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
								    	</c:when>    
								    	<c:otherwise>
											<td style="text-align: right;" nowrap><fmt:formatNumber pattern="###,##0.0" value="${val.mveval}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
								    	</c:otherwise>
									</c:choose>
									
									<td style="text-align: right;" valign="middle" rowspan="2">
										<c:choose>
											<c:when test="${fn:contains(kpi.ind_cod, 'DIS003') || fn:contains(kpi.ind_cod, 'DIS004') || fn:contains(kpi.ind_cod, 'DIS005') || fn:contains(kpi.ind_cod, 'DIS008') || fn:contains(kpi.ind_cod, 'DIS009') || fn:contains(kpi.ind_cod, 'DIS011') || fn:contains(kpi.ind_cod, 'DIS012')}">
												<c:choose>
												    <c:when test="${val.mveval lt val.mvevpe}">
												    	<img src="<c:url value="/resources/img/adm/verde.png"/>" alt="Rojo" style="width: 15px; height:15px; margin-top: 3px; margin-right: 10px;">
												    </c:when>    
												    <c:otherwise>
												        <img src="<c:url value="/resources/img/adm/rojo.png"/>" alt="Verde" style="width: 15px; height:15px; margin-top: 3px; margin-right: 10px;">
												    </c:otherwise> 
												</c:choose>
									    	</c:when>    
									    	<c:otherwise>
									    		<c:choose>
												    <c:when test="${val.mveval gt val.mvevpe}">
												    	<img src="<c:url value="/resources/img/adm/verde.png"/>" alt="Verde" style="width: 15px; height:15px; margin-top: 3px; margin-right: 10px;">
												    </c:when>    
												    <c:otherwise>
												        <img src="<c:url value="/resources/img/adm/rojo.png"/>" alt="Rojo" style="width: 15px; height:15px; margin-top: 3px; margin-right: 10px;">
												    </c:otherwise>
												</c:choose>
									    	</c:otherwise>
										</c:choose>
									</td>
									<fmt:formatNumber var="real2" pattern="##0.0" value="${val.mveval}" type="number" maxFractionDigits="0"/>
									<c:set var="real" value="${real};${real2}"/>
							</c:forEach>
							
							<td><img onclick="drilldown('${ kpi.ind_cod }')" src="<c:url value="/resources/img/adm/plan.png"/>" alt="Graficos" style="width: 20px; height:20px; margin-top: 3px; margin-right: 10px;"></td>
							</td>
							
						</tr>
						<tr class="${color}">
							<td>${kpi.tipoDos}</td>
							
							<c:choose>
								<c:when test="${not fn:contains(kpi.ind_cod, '001')}">
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevpePresupuestadoAnt}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevpePresupuestadoAnoActual}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
						    	</c:when>    
						    	<c:otherwise>
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevpePresupuestadoAnt}" type="number" /></td>
									<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${kpi.promMvevpePresupuestadoAnoActual}" type="number" /></td>
						    	</c:otherwise>
							</c:choose>
							
							<c:forEach items="${kpi.lista}" var="val"
								varStatus="loopCounter">
								<c:choose>
									<c:when test="${not fn:contains(kpi.ind_cod, '001')}">
										<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${val.mvevpe}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
							    	</c:when>    
							    	<c:otherwise>
							    		<td style="text-align: right;"><fmt:formatNumber pattern="###,##0.0" value="${val.mvevpe}" type="number" /><c:if test="${fn:contains(kpi.unidad, '%')}">%</c:if></td>
							    	</c:otherwise>
								</c:choose>
									<fmt:formatNumber var="presupuestado2" pattern="###" value="${val.mvevpe}" type="number" maxFractionDigits="0"/>
									<c:set var="presupuestado" value="${presupuestado};${presupuestado2}"/>
							</c:forEach>
							
							<td><img onclick="graph('${real}', '${presupuestado}', '${ kpi.ind }')" src="<c:url value="/resources/img/adm/graph.png"/>" alt="Graficos" style="width: 20px; height:20px; margin-top: 3px; margin-right: 10px;"></td>
						</tr>
						<c:choose>
							<c:when test="${color=='success'}">
								<c:set var="color" value="warning"/>
						    </c:when>    
						    <c:otherwise>
								<c:set var="color" value="success"/>
						    </c:otherwise>
						</c:choose>
					</c:forEach>
					<tr>
						<td colspan="20" align="center"></td>
					</tr>
					<!-- <tr>
						<td colspan="11" align="center"></td>
					</tr>
					 <tr>
						<td colspan="11" align="center">Usuario: <c:out
								value="${usuarioactuall}" /></td>
					</tr>
					 -->
				</tbody>
			</table>
			<div style="float: right;">
				<strong>Usuario: </strong>${usuarioactuall}
			</div>
		</section>
		<!-- end widget grid -->

	</div>
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
	<script src="<c:url value="/resources/js/speech/voicecommand.min.js"/>"></script>

	<!-- PAGE RELATED PLUGIN(S) -->
	
	<script
		src="<c:url value="/resources/js/smart-chat-ui/chart.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/smart-chat-ui/smart.chat.manager.min.js"/>"></script>

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
	
	<!-- Ya esta <script
		src="<c:url value="/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js"/>"></script>
		 -->
		 
	<script
		src="<c:url value="/resources/js/plugin/jqgrid/jquery.jqGrid.min.js"/>"></script>
		
	<script
		src="<c:url value="/resources/js/plugin/jqgrid/grid.locale-en.min.js"/>"></script>
		
	<script type="text/javascript">
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		// Para el titulo del Drill Down
		var tit="Grand Bay";
		$(document)
				.ready(
						function() {
							
							
							//document.getElementById("region").selectedIndex = "${r3g}";
							//document.getElementById("nia").selectedIndex = "${c1a}";
							//document.getElementById("moneda").selectedIndex = "${cur}";
							clearTable();
							
							$("#region").val("${r3g}");
							$("#nia").val("${c1a}");
							$("#moneda").val("${cur}");
							$("#anio").val("${anio}");
							var t="${tas}";
							var c1a="${c1a}";
							var curr="${cur}";
							
							if (c1a=="Todas")
								$('#moneda').prop('disabled', true);
							else
								$('#moneda').prop('disabled', false);
							
							if (curr=="1")
								$('#tasa').prop('disabled', true);
							else
								$('#tasa').prop('disabled', false);
							
							if (t=="mveval"){
								$("#tasa").val("m");
							}
							else
								document.getElementById("tasa").selectedIndex = "p";
							
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

							    var lineData = { labels: ["January", "February", "March", "April", "May", "June", "July"],
							        datasets: [
								        {
								            label: "My First dataset",
								            fillColor: "rgba(220,220,220,0.2)",
								            strokeColor: "rgba(220,220,220,1)",
								            pointColor: "rgba(220,220,220,1)",
								            pointStrokeColor: "#fff",
								            pointHighlightFill: "#fff",
								            pointHighlightStroke: "rgba(220,220,220,1)",
								            data: [65, 59, 80, 81, 56, 55, 40]
								        },
								        {
								            label: "My Second dataset",
								            fillColor: "rgba(151,187,205,0.2)",
								            strokeColor: "rgba(151,187,205,1)",
								            pointColor: "rgba(151,187,205,1)",
								            pointStrokeColor: "#fff",
								            pointHighlightFill: "#fff",
								            pointHighlightStroke: "rgba(151,187,205,1)",
								            data: [28, 48, 40, 19, 86, 27, 90]
								        }
								    ]
							    };

							    // render chart
							    //var ctx = document.getElementById("lineChart").getContext("2d");
							    //var myNewChart = new Chart(ctx).Line(lineData, lineOptions);
							

							//document.getElementById('region').value="${navega.dash_region}";
							//document.getElementById('nia').value="${navega.dash_nia}";
							//document.getElementById('moneda').value="${navega.dash_moneda}";
							//document.getElementById('tasa').value="${navega.dash_tasa}";
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

							$('#dt_basic')
									.dataTable(
											{
												fixedColumns: true,
												   fixedHeader: true,
												"sDom" : "<'dt-toolbar'<'col-xs-12 fixed col-sm-6'f><'col-sm-6 col-xs-12 hidden-xs'l>r>"
														+ "t"
														+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
												"autoWidth" : true,
												"preDrawCallback" : function() {
													// Initialize the responsive datatables helper once.
													if (!responsiveHelper_dt_basic) {
														responsiveHelper_dt_basic = new ResponsiveDatatablesHelper(
																$('#dt_basic'),
																breakpointDefinition);
													}
												},
												"rowCallback" : function(nRow) {
													responsiveHelper_dt_basic
															.createExpandIcon(nRow);
												},
												"drawCallback" : function(
														oSettings) {
													responsiveHelper_dt_basic
															.respond();
												}
											});

							/* END BASIC */

							/* COLUMN FILTER  */
							var otable = $('#datatable_fixed_column')
									.DataTable(
											{
											
												//"bFilter": false,
												//"bInfo": false,
												//"bLengthChange": false
												//"bAutoWidth": false,
												//"bPaginate": false,
												//"bStateSave": true // saves sort state using localStorage
												"sDom" : "<'dt-toolbar'<'col-xs-12 col-sm-6 hidden-xs'f><'col-sm-6 col-xs-12 hidden-xs'<'toolbar'>>r>"
														+ "t"
														+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
												"autoWidth" : true,
												"preDrawCallback" : function() {
													// Initialize the responsive datatables helper once.
													if (!responsiveHelper_datatable_fixed_column) {
														responsiveHelper_datatable_fixed_column = new ResponsiveDatatablesHelper(
																$('#datatable_fixed_column'),
																breakpointDefinition);
													}
												},
												"rowCallback" : function(nRow) {
													responsiveHelper_datatable_fixed_column
															.createExpandIcon(nRow);
												},
												"drawCallback" : function(
														oSettings) {
													responsiveHelper_datatable_fixed_column
															.respond();
												}

											});

							// custom toolbar
							$("div.toolbar")
									.html(
											'<div class="text-right"><img src="<c:url value="/resources/img/logo.png"/>" alt="SmartAdmin" style="width: 111px; margin-top: 3px; margin-right: 10px;"></div>');

							// Apply the filter
							$(
									"#datatable_fixed_column thead th input[type=text]")
									.on(
											'keyup change',
											function() {

												otable.column(
														$(this).parent()
																.index()
																+ ':visible')
														.search(this.value)
														.draw();

											});
							/* END COLUMN FILTER */

							/* COLUMN SHOW - HIDE */
							$('#datatable_col_reorder')
									.dataTable(
											{
												"sDom" : "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'C>r>"
														+ "t"
														+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-sm-6 col-xs-12'p>>",
												"autoWidth" : true,
												"preDrawCallback" : function() {
													// Initialize the responsive datatables helper once.
													if (!responsiveHelper_datatable_col_reorder) {
														responsiveHelper_datatable_col_reorder = new ResponsiveDatatablesHelper(
																$('#datatable_col_reorder'),
																breakpointDefinition);
													}
												},
												"rowCallback" : function(nRow) {
													responsiveHelper_datatable_col_reorder
															.createExpandIcon(nRow);
												},
												"drawCallback" : function(
														oSettings) {
													responsiveHelper_datatable_col_reorder
															.respond();
												}
											});

							/* END COLUMN SHOW - HIDE */

							/* TABLETOOLS */
							$('#datatable_tabletools')
									.dataTable(
											{

												// Tabletools options: 
												//   https://datatables.net/extensions/tabletools/button_options
												"sDom" : "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'T>r>"
														+ "t"
														+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-sm-6 col-xs-12'p>>",
												"oTableTools" : {
													"aButtons" : [
															"copy",
															"csv",
															"xls",
															{
																"sExtends" : "pdf",
																"sTitle" : "SmartAdmin_PDF",
																"sPdfMessage" : "SmartAdmin PDF Export",
																"sPdfSize" : "letter"
															},
															{
																"sExtends" : "print",
																"sMessage" : "Generated by SmartAdmin <i>(press Esc to close)</i>"
															} ],
													"sSwfPath" : "js/plugin/datatables/swf/copy_csv_xls_pdf.swf"
												},
												"autoWidth" : true,
												"preDrawCallback" : function() {
													// Initialize the responsive datatables helper once.
													if (!responsiveHelper_datatable_tabletools) {
														responsiveHelper_datatable_tabletools = new ResponsiveDatatablesHelper(
																$('#datatable_tabletools'),
																breakpointDefinition);
													}
												},
												"rowCallback" : function(nRow) {
													responsiveHelper_datatable_tabletools
															.createExpandIcon(nRow);
												},
												"drawCallback" : function(
														oSettings) {
													responsiveHelper_datatable_tabletools
															.respond();
												}
											});

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

								base.$originalHeader = $('thead:first', this);
								base.$clonedHeader = base.$originalHeader
										.clone();

								base.$clonedHeader
										.addClass('tableFloatingHeader');
								base.$clonedHeader.css('display', 'none');

								base.$originalHeader
										.addClass('tableFloatingHeaderOriginal');

								base.$originalHeader.after(base.$clonedHeader);

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
												- base.$clonedHeader.height())) {
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
									base.$clonedHeader.css('display', 'none');
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
						$.data(this, 'plugin_' + name,
								new Plugin(this, options));
					}
				});
			};

		})(jQuery, window);
		
		function clearTable(){
			var table = $("#mprDetailDataTable table tbody");
			//alert(table);
			table.find('tr').each(function (i) {
		        var $tds = $(this).find('td'),
		            colu = $tds.eq(0).text();
		           
		        // do something with productId, product, Quantity
		        log('Row ' + (i + 1) + ':\nId: ' + colu
		             );
		    });
		}
		
		function cargaRegiones(){
			var r3g=$( "#region" ).val();
			if (r3g.localeCompare("Todas") == 0){
				var $select = $('#nia').empty();
				var o = $('<option/>', { value: "Todas" }).text("-All-");
				o.appendTo($select);
				cia();
			}
			else{
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
						var o = $('<option/>', { value: "Todas" }).text("-All-");
				    	o.appendTo($select);
						for (var i = 0; i < arr.length; i++) {
							var arr2 = arr[i].split('---');
						    var o = $('<option/>', { value: arr2[0] })
						        .text(arr2[1])
						        .prop('selected', i == 0);
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
			var region=document.getElementById("region").value;
			var nia=document.getElementById("nia").value;
			//alert(dato);
			$.ajax({
				type : "POST",
				url : "cia",
				data : {
					r3g:region,
					c1a:nia
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
			var dato=document.getElementById("moneda").value;
			var t4s4=document.getElementById("tasa").value;
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
			var dato=document.getElementById("tasa").value;
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
			var dato=document.getElementById("anio").value;
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
			position: 'top'
			
		});
		
		function drilldown_controller(indicador, nombre_filtro, campo_llave, campo_des, indicador_des, sim) {
			//indicador_des = indicador_des.replace("%", "");
			window.location="drilldown?m3r="+nombre_filtro+"&ind1c4="+indicador+"&ind1c4d3s="+encodeURIComponent(indicador_des)+"&ll4v3="+campo_llave+"&d3s="+campo_des+"&op10n=Y"+"&s1m="+sim;
		}
		
		function opciones_detalle(indicador, indicador_des, cosa_this){
			var opc = new Array();
			var simbolo_porcentaje = $(cosa_this).closest("tr").find('td:eq(1)').text();
			if (simbolo_porcentaje.indexOf("%") < 0) simbolo_porcentaje="-"; else simbolo_porcentaje="p";
			
			// Indicación especial para el indicador 02, que no es % pero debe llevar decimal
			if (indicador == 'VEN002') simbolo_porcentaje="d";
			opc[1]='<img onclick="drilldown_controller(\''+indicador+'\', \'Clientes\', \'mvecli\', \'mvecln\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/cliente.png"/>" style="width: 48px; height: 48px">Por Cliente<br>';
			opc[2]='<img onclick="drilldown_controller(\''+indicador+'\', \'Tipos de Cliente\', \'mvetic\', \'mvetin\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/tipocliente.png"/>" style="width: 48px; height: 48px">Tipo Cliente<br>';
			opc[3]='<img onclick="drilldown_controller(\''+indicador+'\', \'Bodega\', \'mveloc\', \'mvelon\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/bodega.png"/>" style="width: 48px; height: 48px">Bodega<br>';
			opc[4]='<img onclick="drilldown_controller(\''+indicador+'\', \'Areas de Cliente\', \'mvecr1\', \'mvecn1\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/areacliente.png"/>" style="width: 48px; height: 48px">Area Cliente<br>';
			opc[5]='<img onclick="drilldown_controller(\''+indicador+'\', \'Zonas Cliente\', \'mvecr2\', \'mvecn2\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/zonacliente.png"/>" style="width: 48px; height: 48px"> Zona Cliente<br>';
			opc[6]='<img onclick="drilldown_controller(\''+indicador+'\', \'Region Cliente\', \'mvecr3\', \'mvecn3\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/regioncliente.png"/>" style="width: 48px; height: 48px">Región Cliente<br>';
			opc[7]='<img onclick="drilldown_controller(\''+indicador+'\', \'Local Cliente\', \'mvecr4\', \'mvecn4\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/localcliente.png"/>" style="width: 48px; height: 48px">Local Cliente<br>';
			opc[8]='<img onclick="drilldown_controller(\''+indicador+'\', \'Distrito\', \'mvecr5\', \'mvecn5\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/distrito.png"/>" style="width: 48px; height: 48px">Distrito<br>';
			opc[9]='<img onclick="drilldown_controller(\''+indicador+'\', \'Vendedor\', \'mvesal\', \'mvesan\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/vendedor.png"/>" style="width: 48px; height: 48px">Vendedor<br>';
			opc[10]='<img onclick="drilldown_controller(\''+indicador+'\', \'Producto\', \'mvepro\', \'mveprn\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/producto.png"/>" style="width: 48px; height: 48px"> Producto<br>';
			opc[11]='<img onclick="drilldown_controller(\''+indicador+'\', \'Clase Articulo\', \'mvecal\', \'mvecan\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/clasearticulo.png"/>" style="width: 48px; height: 48px"> Clase Artículo<br>';
			opc[12]='<img onclick="drilldown_controller(\''+indicador+'\', \'Tipo Articulo\', \'mvesr1\', \'mvesn1\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/grupoarticulo.png"/>" style="width: 48px; height: 48px"> Grupo Artículo<br>';
			opc[13]='<img onclick="drilldown_controller(\''+indicador+'\', \'Grupo Articulo\', \'mvesr2\', \'mvesn2\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/grupoarticulo.png"/>" style="width: 48px; height: 48px"> Grupo Artículo<br>';
			opc[14]='<img onclick="drilldown_controller(\''+indicador+'\', \'Linea Articulo\', \'mvesr3\', \'mvesn3\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/lineaarticulo.png"/>" style="width: 48px; height: 48px"> Línea Artículo<br>';
			opc[15]='<img onclick="drilldown_controller(\''+indicador+'\', \'Categoria Articulo\', \'mvesr4\', \'mvesn4\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/categoriaarticulo.png"/>" style="width: 48px; height: 48px"> Categoría Artículo<br>';
			opc[16]='<img onclick="drilldown_controller(\''+indicador+'\', \'Marca\', \'mvesr5\', \'mvesn5\', \''+indicador_des+'\', \''+simbolo_porcentaje+'\')" src="<c:url value="/resources/img/adm/marca.png"/>" style="width: 48px; height: 48px"> Marca <br>';
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
			position: 'top'
			
		});
		
		function ventana_drill(){
			//$("#dialog-message").dialog('close');
			//$("#dialog-message").dialog('destroy');
			$("#dialog-message").dialog('open');
		}
		
		function drilldown(indicador, cosa) {
			$( "#opc" ).html('');
			$( "#opc" ).append(opciones_detalle(indicador, cosa.innerHTML, cosa));
			//tit=cosa.innerHTML;
			$("span.ui-dialog-title").text(cosa.innerHTML);
			ventana_drill();
		}
		
		function graph(real, presupuestado, indicador) {
			window.location="chartjs?i="+real+"&indicador="+encodeURIComponent(indicador)+"&p="+presupuestado+"&op=y";
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
					window.location="plan?ind1c4=1";
				},
				error : function(data) {
					alert("no");
					
				}
			});
		}
	</script>


</body>

</html>