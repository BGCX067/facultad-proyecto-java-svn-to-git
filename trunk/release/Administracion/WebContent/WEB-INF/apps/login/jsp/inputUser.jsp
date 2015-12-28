<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	CAJAS DE TEXTO PARA REALIZAR EL LOGIN
	
	<s:form action="flow" method="post">  		
    		SUBMIT DE LOS DATOS!!!!!
    		
    	<s:textfield name="customerNumber" label="Número de usuario"></s:textfield>
    	<s:label name="customerNumberError"></s:label>
    	    	
    	<s:textfield name="password" label="Contraseña"></s:textfield>
    	<s:label name="passwordError"></s:label>
    	
    	<s:submit value="ValidateUser.action"/>
    	<s:hidden name="eventId" value="success"/>
  	</s:form>

	<style>
	  	.errorMessage{
	  		font-style: italic;
	  		color: red;
	  	}
	</style>  	  	
</body>
</html>