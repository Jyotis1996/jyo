<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn Page</title>
<link rel="stylesheet" type="text/css" href="css/Login.css">
<style type="text/css">
.errors {
	color: #E74C3C;
}
</style>
<script type="text/javascript">
	// 	function clearThis(target) {

	// 		document.getElementById("LoginForm").reset();
	// 	}
</script>
</head>
<body class="main">
	<div class="login">
		<div class="login-title">LogIn Details</div>
		<div class="login-form">
			<html:form action="UserData" method="post">
				<table>
					<tr>
						<td colspan="2"><html:errors property="err_invalid" /></td>
					</tr>
					<tr>
						<td>User Name :</td>
						<td><html:text name="LoginForm" property="userName" /></td>
					</tr>
					<tr>
						<td colspan="2"><html:errors property="err_username" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><html:password name="LoginForm" property="password" /></td>
					</tr>
					<tr>
						<td colspan="2"><html:errors property="err_passsword" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><html:submit value="Login" />
							<html:reset value="reset" /></td>
					</tr>
				</table>
			</html:form>
		</div>
	</div>
</body>
</html>