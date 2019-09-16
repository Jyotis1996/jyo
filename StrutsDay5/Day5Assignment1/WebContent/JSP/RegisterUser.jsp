<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="s"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet" href="styleUserInfo.css">
<style type="text/css">
.errorMessage, .actionMessage {
	color: #b30000;
}
</style>
<script language="JavaScript" type="text/javascript">
	//Disable back button
	window.history.forward(1);
	function reloadPage() {
		window.location.reload(true);
	}
	function logout() {
		var backlen = history.length;
		history.go(-backlen);
		window.location.replace("http://localhost:8080/Day5Assignment1/");
	}
</script>
</head>
<body>
	<%
		String categoryType = request.getAttribute("categoryType").toString();
	%>
	<s:form action="registerUser">
		<div
			style="padding-bottom: 50px; padding-top: 50px; padding-left: 580px; float:right">
			<a href="http://localhost:8080/Day5Assignment1/userList.do"><bean:message
					key="link.display.back" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
				href="javascript:logout()"><bean:message
					key="link.display.logout" /></a>
		</div>
		<h1 style='font-family: MV Boli; margin-left: 500px;'>
			<bean:message key="label.update.registeruser" />
		</h1>
		<table class="table1">
			<tr>
				<td colspan="3"><label><bean:message
							key="label.display.userdetails" /> </label></td>
			</tr>
			<tr>
				<th><bean:message key="label.display.salutation" /></th>
				<td><s:select styleId="salutation" property="salutation"
						style="height: 100%; width: 172px;">
						<s:option value="">select</s:option>
						<s:option value="Mr">Mr</s:option>
						<s:option value="Mrs">Ms</s:option>
						<s:option value="Dr">Dr</s:option>
					</s:select></td>

			</tr>
			<tr>
				<th><bean:message key="label.display.firstname" /> <b>*</b></th>
				<td><s:text styleId="fname" property="firstName" maxlength="49"
						styleClass="size">
					</s:text></td>
				<td><div class="errorMessage">
						<s:errors property="firstName_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.display.middleinitial" /></th>
				<td><s:text styleId="mname" property="middleInitial"
						maxlength="1" styleClass="size" /></td>
			</tr>
			<tr>
				<th><bean:message key="label.display.lastname" /> <b>*</b></th>
				<td><s:text styleId="lname" property="lastName" maxlength="50"
						styleClass="size" /></td>
				<td><div class="errorMessage">
						<s:errors property="lastName_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.display.sex" /> <b>*</b></th>
				<td><s:radio property="gender" value="Male" styleId="sexMale">
						<bean:message key='label.update.male' />
					</s:radio> <s:radio property="gender" value="Female" styleId="sexFemale">
						<bean:message key='label.update.female' />
					</s:radio></td>
				<td><div class="errorMessage">
						<s:errors property="sex_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.search.category" /><b>*</b></th>
				<td><s:select styleId="category" property="category"
						style="height: 70%; width: 172px;">
						<s:option value="">select</s:option>
						<s:option value="admin">
							<bean:message key="label.search.admin" />
						</s:option>
						<s:option value="user">
							<bean:message key="label.search.user" />
						</s:option>
					</s:select></td>
				<td><div class="errorMessage">
						<s:errors property="category_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.display.email" /></th>
				<td><s:text styleId="email" property="email" maxlength="50"
						styleClass="size" title="Please enter Proper Email" /></td>
				<td><div class="errorMessage">
						<s:errors property="email_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.display.birthdate" /> <b>*</b></th>

				<td><s:select property="birthDate" styleClass="size1"
						styleId="bdate">
						<s:option value="">Date</s:option>
						<%
							for (int i = 1; i <= 31; i++) {
						%>
						<s:option value="<%=Integer.toString(i)%>"><%=i%></s:option>
						<%
							}
						%>
					</s:select> <s:select property="birthMonth" styleClass="size1"
						styleId="bmonth">
						<s:option value="">Month</s:option>
						<s:option value="1">January</s:option>
						<s:option value="2">February</s:option>
						<s:option value="3">March</s:option>
						<s:option value="4">April</s:option>
						<s:option value="5">May</s:option>
						<s:option value="6">June</s:option>
						<s:option value="7">July</s:option>
						<s:option value="8">August</s:option>
						<s:option value="9">September</s:option>
						<s:option value="10">October</s:option>
						<s:option value="11">November</s:option>
						<s:option value="12">December</s:option>
					</s:select> <s:select property="birthYear" styleClass="size1" styleId="byear">
						<s:option value="">Year</s:option>
						<%
							for (int i = 1970; i <= 2017; i++) {
						%>
						<s:option value="<%=Integer.toString(i)%>"><%=i%></s:option>
						<%
							}
						%>
					</s:select></td>
				<td><div class="errorMessage">
						<s:errors property="birthdate_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.login.userID" /> :<b>*</b></th>
				<td><s:text property="userName" styleId="userName"
						onblur="return checkUsername()" /></td>
				<td><div class="errorMessage">
						<s:errors property="userid_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.login.password" /> :<b>*</b></th>
				<td><s:password property="password" styleId="password" /></td>
				<td><div class="errorMessage">
						<s:errors property="password_error" />
					</div></td>
			</tr>
			<tr>
				<th><bean:message key="label.display.address" /></th>
				<td><s:textarea rows="3" cols="21"
						style="height: 100%; width: 88%;" property="address"></s:textarea></td>
			</tr>
			<tr>
				<td colspan="2"><label><bean:message
							key="label.display.areaofinterest" /><b>*</b></label></td>
				<td><div class="errorMessage">
						<s:errors property="areaofinterest_error" />
					</div></td>

			</tr>
			<tr>
				<td colspan="2"><s:multibox property="areaOfInterest"
						value="Web Programming" />
					<bean:message key="label.update.webprograming" /></td>

			</tr>
			<tr>
				<td colspan="2"><s:multibox property="areaOfInterest"
						value="Database Programming" />
					<bean:message key="label.update.databaseprograming" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:multibox property="areaOfInterest"
						value="Swing Programming" />
					<bean:message key="label.update.swingprograming" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:multibox property="areaOfInterest"
						value="Mobile Programming" />
					<bean:message key="label.update.mobileprograming" /></td>
			</tr>


			<tr>
				<th><bean:message key="label.display.otherinterest" /></th>
				<td><s:textarea rows="3" cols="15"
						style="height: 100%; width: 88%;" property="otherInterest"></s:textarea></td>
			</tr>
			<tr>
				<td><s:submit styleClass="button1">
						<bean:message key="button.register.register" />
					</s:submit></td>
				<td><s:reset styleClass="button1 button2"
						onclick="return reloadPage()">
						<bean:message key="button.search.clear" />
					</s:reset></td>
			</tr>
		</table>
		<input type="hidden" name="catType" value="<%=categoryType%>">
	</s:form>
</body>
</html>
