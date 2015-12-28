<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido 
	<s:property value="nombre"/> <s:property value="apellido"/> 
	(<s:property value="alias"/>) 
</title>
</head>
<body>
	<br>Datos Personales:<br>
	<s:property value="nombre"/>	
	<s:property value="apellido"/>
</body>
</html>