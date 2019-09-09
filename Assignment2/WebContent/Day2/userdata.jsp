<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="java.util.*"%>
<%@page import="day2.UserDataBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="main">
	<div class="login-form1">
		<table>
			<%
				int i = 0;
				String userName = request.getAttribute("userName").toString();
				List<UserDataBean> userData = (ArrayList<UserDataBean>) request.getAttribute("userData");
				if (userData.size()>0) {
			%>
			<tr>
				<td class="login-title" colspan=2>User Details</td>
			</tr>
			<tr>
				<td colspan=2><hr></td>
			</tr>
			<tr>
				<td class="field1">UserId</td>
				<td class="content1"><label id="userId" name="userId"
					class="data"><%=userData.get(i).getUserId()%></label></td>
			</tr>
			<tr>
				<td class="field1">Salutation</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getSalutation()%></span></td>
			</tr>
			<tr>
				<td class="field1">FirstName</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getFirstName()%></span></td>
			</tr>
			<tr>
				<td class="field1">MiddleInitial</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getMiddleInitial()%></span></td>
			</tr>
			<tr>
				<td class="field1">LastName</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getLastName()%></span></td>
			</tr>
			<tr>
				<td class="field1">Sex</td>
				<td class="content1"><span id="sex" class="sex"><%=userData.get(i).getSex()%></span></td>
			</tr>
			<tr>
				<td class="field1">EmailId</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getEmailID()%></span></td>
			</tr>
			<tr>
				<td class="field1">BirthDate</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getBirthDate()%></span></td>
			</tr>
			<tr>
				<td class="field1">Address</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getAddress()%></span></td>
			</tr>
			<tr>
				<td class="field1">AreaOfInterest</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getAreaOfInterest()%></span></td>
			</tr>
			<tr>
				<td class="field1">OtherInterest</td>
				<td class="content1"><span id="uidmsg" class="data"><%=userData.get(i).getOtherInterest()%></span></td>
			</tr>
			<tr>
				<td colspan=2><hr></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>