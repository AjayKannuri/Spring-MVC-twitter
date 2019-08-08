<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Registration</title>
    <style>
    .error{
        color:red;
        font-size: 15px;
        padding:10px;
    }
    </style>
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

<form:form action="/registerUser" method="POST" modelAttribute="User">
    <div class="form-group">
        <label>Name:</label><form:input path="name" size="30" cssClass="form-control" placeholder="Enter name" />
        <small><form:errors path="name" cssClass="error" /></small>
    </div>
    <div class="form-group">
        <label>city:</label><form:input path="city" cssClass="form-control" placeholder="Enter city" />
        <small><form:errors path="city" cssClass="error" /></small>
    </div>
    <div class="form-group">
        <label>State:</label><form:input path="state" cssClass="form-control" placeholder="Enter the state" />
        <small><form:errors path="state" cssClass="error" /></small>
    </div>
    <div class="form-group">
        <label>password:</label><form:input path="password" cssClass="form-control" placeholder="Enter password" />
        <small><form:errors path="password" cssClass="error" /></small>
    </div>
    <div class="form-group">
        <button type="submit" >Submit</button>
    </div>
</form:form>

</body>
</html>