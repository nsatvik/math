<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.ck.beans.InterpolationBean"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lagrange Interpolation Results</title>
	 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  
</head>
<body>
		<div id="points_table_div" style="margin-left: auto; margin-right: auto; color: blue; text-shadow: white;"> 	</div>
		<div id="line_chart_div" style="margin-left: auto; margin-right: auto;"> 	</div>
		
	
		
	 <script type="text/javascript">    	
	    google.load("visualization", "1", {callback : function(){drawLineChart();}, packages:["corechart"]});
	    function drawLineChart() { 		    	
	      	//var data = google.visualization.arrayToDataTable(getDataArrayForLineChart());
	      var data = new google.visualization.DataTable();
			data.addColumn('number', 'x');
			data.addColumn('number', 'f(x)');
			data.addColumn('number', 'f\'(x)');
			data.addRows([[0,2,0],[1,1,1],[2,4,4]]);
			
		    var options = {
		        title: 'Graph'
		      };
		  
	     	var chart = new google.visualization.LineChart(document.getElementById('line_chart_div'));
	     	chart.draw(data, options);
	    }
    </script>
    
    <script type="text/javascript">    	
	    google.load("visualization", "1", {callback : function(){drawPointsTable();}, packages:["table"]});
	    function drawPointsTable() { 		    	
	    	
	    	var data = new google.visualization.DataTable();
			data.addColumn('number', 'x');
			data.addColumn('number', 'f(x)');
			data.addColumn('number', 'f\'(x)');
			data.addRows([[0,0,0],[1,3,1],[2,4,6]]);
			var options = {
			        title: 'Points Table',
			        alternatingRowStyle: 'true'
			      };
	        //data.addRows([[ 0,-1.3382422126395963, 0],[ 1,0,-1.376596681557371],[ 2,0,-0.9163430545440788]]);
	        var table = new google.visualization.Table(document.getElementById('points_table_div'));
	        table.draw(data, options);

	    }
    </script>
    <script type="text/javascript">		
		$("#dropdown").change(function(){
	
		});
	</script>
    
</body>
</html>