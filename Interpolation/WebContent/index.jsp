<%@page contentType="text/html" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interpolation Technique</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/themes/dot-luv/jquery-ui.css" />
<link rel="stylesheet" href="./styles/MainPage.css" />
<script src="./js/jquery-1.9.1.js"></script>
<script src="./js/jquery-ui.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="./js/MainPage.js"></script>
<script>
$(function() {
	$( "#tabs_all_nav" ).tabs({
		beforeLoad: function( event, ui ) {
			ui.jqXHR.error(function() {
				ui.panel.html(
				"Couldn't load this tab. We'll try to fix this as soon as possible. " +
				"If this wouldn't be a demo." );
			});
		}
	});
});
</script>
</head>

<body>
	<img id="background-image" src="./images/bgimage.jpg" />
	<h1>Maths Assignment - Interpolation Techniques in JEE</h1>
	<p>
	Satvik N(1RV09CS095) and Vinay BS(1RV09CS119)
	</p>
	
	<div style="margin-top: 1%; margin-left: auto; margin-right: auto;" id="tabs_all_nav">
	<ul>
		<li><a href="./jsp/ip_technqs/spline.jsp">Lagrange's Interpolation</a></li>		
		<li><a href="./jsp/ip_technqs/hermite.jsp">Hermite's Interpolation</a></li>
	</ul>
	
	</div>

</body>
</html>