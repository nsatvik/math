<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cusum Algorithm Results</title>
	 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  
</head>
<body>
		
		<div id="line_chart_div" style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;"> 	</div>
	
		
	<%
		
		//out.println("Output String <br/>"+tsBean.getResult());
	%>
		
	 <script type="text/javascript">    	
	    google.load("visualization", "1", {callback : function(){drawLineChart();}, packages:["corechart"]});
	    function drawLineChart() { 		    	
	      	//var data = google.visualization.arrayToDataTable(getDataArrayForLineChart());
	      var data = new google.visualization.DataTable();
			data.addColumn('number', 'Time');
			data.addColumn('number', 'Data Points');
			data.addColumn('number', 'Anomalous Data Points');
			//data.addRows();
		    var options = {
		        title: 'Anomaly Detector'
		      };
		  
	     	var chart = new google.visualization.LineChart(document.getElementById('line_chart_div'));
	     	chart.draw(data, options);
	    }
    </script>
    
    <script type="text/javascript">    	
	    google.load("visualization", "1", {callback : function(){drawAnnotatedTimeline();}, packages:["annotatedtimeline"]});
	    function drawAnnotatedTimeline() { 		    	
	    	
	    	var data = new google.visualization.DataTable();
			data.addColumn('number', 'Time');
			data.addColumn('number', 'Data Point');
			data.addColumn('number', 'Anomalous Data Point');
			//data.addRows();
	        //data.addRows([[ 0,-1.3382422126395963, 0],[ 1,0,-1.376596681557371],[ 2,0,-0.9163430545440788]]);
	        var chart = new google.visualization.AnnotatedTimeLine(document.getElementById('annotated_timeline_div'));
	        chart.draw(data, {displayAnnotations: true});

	    }
    </script>
    <script type="text/javascript">		
		$("#dropdown").change(function(){
			
		});
	</script>
    
</body>
</html>