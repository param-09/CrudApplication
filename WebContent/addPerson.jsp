<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
</head>
<body>

<form action="mainServlet" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="name" maxlength="32" placeholder="Enter Your Name"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email" placeholder="Enter Your Email"/></td></tr>
<tr><td>Contact:</td><td><input type="text" name="contact" maxlength="10"/></td></tr>
<tr><td>Address:</td><td><input type="text" name="address" maxlength ="128" placeholder="Enter Address"/></td></tr>
<tr>
<td colspan="2"><input type="hidden" id="requestType" name="requestType" value="insert" /><input type="submit" value="Add Person"/></td>
</tr>
</table>
</form>

</body>
</html>