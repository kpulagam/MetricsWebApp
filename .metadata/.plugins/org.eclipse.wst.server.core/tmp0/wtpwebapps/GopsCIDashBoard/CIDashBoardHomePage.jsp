<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CI Dash Board Home Page JSP</title>
</head>
<body>
Served from Home Page JSP!
<p/>
<%@ include file="contactus.jsp" %>
<p/>


<%@ page import="java.util.Date" %>
<%=new Date() %>

<jsp:include page="frequentchangeexmp.txt" />

<% String id = request.getParameter("id"); %>
<%if(id==null) {%>
<jsp:include page="nongopsusersexmp.html"/>
<%}else{ %>
<jsp:include page="gopsusersexmp.html"/>
<%} %>



<%

response.sendRedirect("index.jsp");

%>

<jsp:forward page="index.jsp"></jsp:forward>

<%
request.getRequestDispatcher("index.jsp").forward(request,response);

%>

</body>
</html>