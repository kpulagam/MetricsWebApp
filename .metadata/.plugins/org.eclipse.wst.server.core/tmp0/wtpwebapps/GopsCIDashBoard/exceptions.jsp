<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exceptions Page</title>
</head>
<body>

	<%@ page import="com.paypal.test.gops.admin.cidashboard.model.*,org.bson.Document"%>
	<%

	GetCIDataDAO dat = (GetCIDataDAO)session.getAttribute("ciData");

for(Document d:dat.getFailuresForBuildId("AdminCITestSuite", 10)){
	out.println(d.get("ClassName"));
	out.println(d.get("Status"));
	out.println("\n");
	out.println(d.get("Methods"));
	
	
	
}





%>



</body>
</html>