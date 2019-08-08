<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<table style="width:100%">
			  <tr>
			    <th><a href="/loginPage"> Go to the Login Page</a></th>
			    <th><a href="/register"> Go to the Register Page</a></th> 
			    <th><a href="/delUser"> Delete a User By ID</a></th> 
			    <th><a href="/updatePage"> Update an User by ID</a></th> 
			    <th><a href="/listAll"> List All the Users</a></th>
			    <th><a href="/addTweet"> Add Tweet to ID</a> </th>
			  </tr>
			</table>
			<table border="1">
			    <tr>
			        
			        <th> ID</th>
			        <th> Name </th>
			        
			        <th> city </th>
			        
			
			    </tr>
			    <c:forEach items="${list}" var="user">
			        <tr>
			            <td>${user.id}</td>
			        	<td> ${user.name}</td>
			        	
			        	<td> ${user.city } </td>
			
			        </tr>
			    </c:forEach>
			</table>
			
</body>
</html>