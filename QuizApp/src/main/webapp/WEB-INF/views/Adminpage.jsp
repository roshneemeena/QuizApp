<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<title>Welcome</title>
</head>
<body style="background-color: blue;">
<h1></h1>
<div>
   <div align="right">
      <td><a href="load-home-page">Logout</a>
      
   </div>
   
   <div align="center">
      Welcome Back Admin <b style="color:red;">${Students.name}</b>
      <h2>Create Test</h2><br>
      <p><a href="load-exam-page">Create</p></p>
   
   </div>

</div>



</body>