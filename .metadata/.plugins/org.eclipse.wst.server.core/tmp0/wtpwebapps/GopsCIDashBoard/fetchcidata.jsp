<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
<body {
	font-family: Verdana;
	font-size: 9;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CI Data Request</title>
</head>
<body>

<form action="/GopsCIDashBoard/CIDashBoardHome" method="post" name="submitform">
<select name="sName" >
	<option >AdminDevelopBranchCITestSuite</option>
	<option>AdminReleaseBranchCITestSuite</option>
	<option>MasterBranchCITestSuite</option>
</select>
<br/>
<select name="runNum" >
	<option>0</option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
	<option>4</option>
	<option>5</option>
	<option>6</option>
	<option>7</option>
	<option>8</option>
	<option>9</option>
	<option>10</option>
</select>
<br/>

<input type="radio" name="gLRun" value="getLatestRun">Get Latest Run<br>
 Build ID <input type="text" name="runNum1"><br>

<input type="submit" value="GetCIData" />


</form>

</body>
</html>