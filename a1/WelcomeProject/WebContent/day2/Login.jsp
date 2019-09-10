<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link type="stylesheet" href="Login.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.content {
  max-width: 500px;
  margin: auto;
}
</style>
<script>
	function clearErrorMessage() {
		//alert(getElementById("clear"));
		window.location.href = "/WelcomeProject/day2/Login.jsp";
	}
</script>
</head>
<body>
	<!-- <input type="button" name="name" class="btn btn-success" value="Submit"/> -->
	<div class="content">
	<h2 class="active">Login Page</h2>
	<s:form action="login" method="post" theme="simple" namespace="/">
		<div>
			<s:label>Enter Username</s:label>
			<s:textfield name="objbean.username"
				placeholder="Enter Username" class="form-control" />
		</div>
		<div>
			<s:label>Enter Password</s:label>
			<s:password  name="objbean.password"
			placeholder="Enter Password" class="form-control" />
		</div>
		<br />
		<s:submit class="btn btn-success" />
		<s:reset value="Reset" onclick="clearErrorMessage();" />
	</s:form>

	<s:if test="hasActionErrors()">
		<div class="errors">
			<span style="color: red"><s:actionerror id="clear" /></span> <span
				style="color: red"><s:actionmessage /></span>
		</div>
	</s:if>
	</div>
</body>
</html>