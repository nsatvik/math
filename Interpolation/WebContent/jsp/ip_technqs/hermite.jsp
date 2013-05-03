<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Hermite</title>
<script src="./js/jquery-ui.js"></script>
  
</head>
<body>
	<div>
	
		<label>Select Data Set</label> <select id="dropdown_cusum_algo"
			class="TopMenuButtons">
			
		</select> <br /> <br /> <input id="button_cusumAlgoCalc" class="TopMenuButtons"
			style="" type="button" value="Calculate" />
		
		<br />
		<label for="threshold">Threshold Value : </label>
		<input type="text" id="threshold" style="border: 0; font-weight: bold;" value="1.0" />
	</div>	 
	<p id="ajax_cusum_algo_result">
	Algorithm Results will appear here!</p>
	
	<script type="text/javascript">
		$("#button_cusumAlgoCalc").button().click(function () {
			
	        
	    });
	</script>
</body>
</html>