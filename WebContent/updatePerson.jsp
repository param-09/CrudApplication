<%@page import="data.PersonData"%>
<%@page import="bean.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Person</title>
</head>
<%
	int personId = Integer.parseInt(request.getParameter("personId").toString() != null && !request.getParameter("personId").toString().isEmpty() ? request.getParameter("personId").toString() : "-1");
	Person person = PersonData.getPersonById(personId);
%>
<body>

<form action="mainServlet" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name" maxlength="32" placeholder="Enter Your Name" value="<%= person.getName()%>"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email" placeholder="Enter Your Email" value="<%= person.getEmail()%>"/></td></tr>
<tr><td>Contact:</td><td><input type="text" name="contact" maxlength="10" value="<%= person.getContact()%>"/></td></tr>
<tr><td>Address:</td><td><input type="text" name="address" maxlength ="128" placeholder="Enter Address" value="<%= person.getAddress()%>"/></td></tr>
<tr>
<td colspan="2">
	<input type="hidden" id="requestType" name="requestType" value="update" />
	<input type="hidden" id="personId" name="personId" value="<%=personId %>" />
	 <input type="submit" value="Update Person"/></td>
</tr>
</table>
</form>

</body>
</html>