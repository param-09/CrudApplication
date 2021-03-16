<%@page import="data.PersonData"%>
<%@page import="bean.Person"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of all persons</title>
</head>
<%
List<Person> personList = new ArrayList<>();
if(request.getParameter("requestType") != null &&  request.getParameter("requestType").equalsIgnoreCase("search"))
{
	String srchParameter= request.getParameter("srchString");
	personList = PersonData.searchPersons(srchParameter);
}
else{
	personList = PersonData.getAllPersons();	
}
%>
<body>
<a href="/CrudApp">Home</a>
<h1> List of persons </h1>
<% if(personList.size() > 0){ %>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Address</th>
<th>Contact</th>
<th>mail</th>
<th>Update</th>
<th>Delete</th>
</tr>
<%for(Person person : personList)
	{%>
		<tr>
		<td><%= person.getId() %></td>
		<td><%= person.getName() %></td>
		<td><%= person.getAddress() %></td>
		<td><%= person.getContact() %></td>
		<td><%= person.getEmail() %></td>
		<td><a href="updatePerson.jsp?personId=<%=person.getId()%>">Update</a></td>
		<td><a href="mainServlet/?action=delete&personId=<%=person.getId()%>">Delete</a></td>
		</tr>
	<%}
%>
</table>
<%}
else {%>
<h2> No data found !</h2>
<%} %>
</body>
</html>