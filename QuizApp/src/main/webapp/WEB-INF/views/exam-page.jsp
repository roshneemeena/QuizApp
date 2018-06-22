<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Online Examination</title>
		<script language="javascript">
			function navigate(){				
				var id = document.getElementById('id').value;
				window.location ='skip-question?id='+id;			
			}
		</script>
		<td><a href="load-home-page">Logout</a>
	</head>
	<body style="background-color: 	#F2ECD4;">
	<center>
		<form:form name="examForm" action="process-answer" method="GET" ModelAttribute="questionForm">
			<br><br>			
			<table>
				<tr>
					<td colspan="2" width="600"><font color="megenta" size="6"><marquee>Online Test</marquee></font></td>
				</tr>
				<tr align="center">
					<td><c:if test="${error != null}">
						<font color="red" size="5">${error}</font>
					</c:if>	
					</td>
				</tr>
				<c:forEach var="opt" items="${questionForm}">							
				<tr>
					<td style="padding-left:200px;">						
							<input type="hidden" name="id" id="id" value="${opt.id}"/>
							<h2>Q. <c:out value="${opt.question}"/></h2>
							<input type="radio" name="option" value="${opt.option1}">
							<b><c:out value="${opt.option1}"/></b><br>
							<input type="radio" name="option" value="${opt.option2}">
							<b><c:out value="${opt.option2}"/></b><br>
							<input type="radio" name="option" value="${opt.option3}">
							<b><c:out value="${opt.option3}"/></b><br>
							<input type="radio" name="option" value="${opt.option4}">
							<b><c:out value="${opt.option4}"/></b><br><br>							
					</td>
					<tr align="center">
						<td>
							<c:if test="${opt.id > 0}">
								<input type="submit" value="Answer"/>
							</c:if>
						</td>
					</tr>
				</tr>			
				</c:forEach>
				
			</table>
			</form:form>
				<button onClick="return navigate()">Skip Question</button>
				<button onClick="javascript:window.location ='show-result'">Result</button>
				
				
				
	</center>
	<body>
</html>