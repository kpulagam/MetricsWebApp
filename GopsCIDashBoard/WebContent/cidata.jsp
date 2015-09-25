<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jQuery.js" /></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The CI Data is Displayed below</title>
</head>
<body>
	<p />
	<a
		href="<%=response.encodeURL(request.getContextPath() + "/exceptions.jsp")%>">Take
		me to the Exceptions</a>



	<%@ page
		import="com.paypal.test.gops.admin.cidashboard.model.*,org.bson.Document,java.util.List"%>



	<%
		int runNumber = Integer.parseInt(getServletContext().getAttribute("runNum").toString());
		String suiteName = getServletContext().getAttribute("sName").toString();

		GetCIDataDAO dat = (GetCIDataDAO) session.getAttribute("ciData");
		List<Document> failureList = dat.getMultipleRunsFailures(runNumber, suiteName);
		failureList.size();
		int i = 0;
	%>
	Displaying Failure for
	<%=suiteName%>
	Suite

	<table border="1px solid black">

		<tr>
			<th>ClassName</th>
			<th>Status</th>
			<th>Test Tag</th>
			<th>Build Number</th>


		</tr>

		<%
			for (Document d : failureList) {
				++i;
		%>
		<tr>
			<td><input type="text" id="row<%=i%>"
				maxlength=<%=failureList.size()%> size="100" style="border: none;"
				value="<%=d.getString("ClassName")%>" /></td>
			<td><input type="text" id="row<%=i%>"
				maxlength=<%=failureList.size()%> size="5" style="border: none;"
				value="<%=d.get("Status")%>" /></td>
			<td><input type="text" id="row<%=i%>"
				maxlength=<%=failureList.size()%> size="50" style="border: none;"
				value="<%=d.get("TestTagName")%>" /></td>
			<td><input type="text" id="row<%=i%>"
				maxlength=<%=failureList.size()%> size="5" style="border: none;"
				value="<%=d.get("BuildNumber")%>" /></td>
		</tr>
		<%
			}
		%>

	</table>



</body>
</html>