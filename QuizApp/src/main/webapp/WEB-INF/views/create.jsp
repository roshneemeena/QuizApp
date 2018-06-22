<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>Welcome</title>
</head>
<body style="background-color:	#F2ECD4">
	<h1></h1>
	<div>
		<div align="right">
			<td><a href="load-home-page">Logout</a>
			 <tr>
                      
                        <td><a href="load-home-page">Home</a>
                        </td>
                    </tr>	
		</div>

		<div align="center">
			<h2>Add Questions</h2>
			<br>
			<body style="background-color: blue;">
				<form:form id="adminform" modelAttribute="question" action="adminProcess" method="post">
					<table align="center">
						<tr>
							<td><form:label path="question">question</form:label></td>
							<td><input type="text" id="question" name="question"
								required minLength="4" maxLength="100"
								placeholder="upto 100 characters long" /></td>
						</tr>
						<tr>
							<td><form:label path="option1">option1</form:label></td>
							<td><input type="text" id="option1" name="option1" required
								minLength="4" maxLength="50"
								placeholder="upto 50 characters long" /></td>
						</tr>

						<tr>
							<td><form:label path="option2">option2</form:label></td>
							<td><input type="text" id="option2" name="option2" required
								minLength="4" maxLength="50"
								placeholder="upto 50 characters long" /></td>
						</tr>

						<tr>
							<td><form:label path="option3">option3</form:label></td>
							<td><input type="text" id="option3" name="option3" required
								minLength="4" maxLength="50"
								placeholder="upto 50 characters long" /></td>
						</tr>

						
						<td><form:label path="option4">option4</form:label></td>
						<td><input type="text" id="option4" name="option4" required
							minLength="4" maxLength="50"
							placeholder="upto 50 characters long" /></td>
						</tr>	
						<tr>
                        <td></td>
                        <td align="center">
                        <input type="button" value="submit" name="button" onClick='adminform'/> 
                    <tr></tr>
                   
					</table>
				</form:form>
				
							


			</body>


		</div>

	</div>



</body>