<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.ck.beans.InterpolationBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CUSUM Anomaly Detection Algorithm</title>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

</head>
<body>
	<div>
	
		<label>Enter Point Data : </label> <input type="text" id="point_data" style="border: 0; font-weight: bold;" value="1.0" />
			
		 <br /> <br /> <input id="button_LagAlgoAdd" class="TopMenuButtons"
			style="" type="button" value="Add" />
			<input id="button_LagAlgoClear" class="TopMenuButtons"
			style="" type="button" value="Clear" />
		
		<br />
	</div>	 
	<p id="ajax_lag_algo_result">
	Algorithm Results will appear here!</p> <p id="point_info"> Points Data will Appear here </p>
	<%
		InterpolationBean tsBean = (InterpolationBean) request.getSession()
				.getAttribute("tsBean");
		//out.println("Output String <br/>"+tsBean.getResult());
	%>
	<script type="text/javascript">
		$("#button_LagAlgoAdd").button().click(function () {
	        $("#ajax_lag_algo_result").load("MainController", 
	        		{"taskType" : "ADD_POINT",
	        		 "algorithmType" : "LAGRANGE",
	        		 "point_data" : $("#point_data").val(),
	        		}
	        );
	        var body = <% if(tsBean==null)out.println("No Data"); else out.println(tsBean.getMapData());%>
	        	
	        $("#point_info").html(body);
	        
	    });
		$("#button_LagAlgoClear").button().click(function () {
	        $("#ajax_lag_algo_result").load("MainController", 
	        		{"taskType" : "CLEAR_POINT",
	        		 "algorithmType" : "LAGRANGE",
	        		 "point_data" : $("#point_data").val(),
	        		}
	        );
	        
	    });

	</script>
</body>
</html>