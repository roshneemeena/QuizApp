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
	</head>
	
	<body>
	<center>
		 <form:form id="detailform"  action="detail-answer" method="GET" modelAttribute="dquestionform">

			<br><br>			
			<table>
				<tr>
					<td colspan="2" width="600"><font color="megenta" size="6"><marquee>Detailed questions</marquee></font></td>
				</tr>
				<tr align="center">
					<td><c:if test="${error != null}">
						<font color="red" size="5">${error}</font>
					</c:if>	
					</td>
				</tr>
				<c:forEach var="opt" items="${dquestionform}">							
				<tr>
					<td style="padding-left:200px;">						
							<input type="hidden" name="id" id="id" value="${opt.id}"/>
							<h2>Q. <c:out value="${opt.question}"/></h2>
							
							
							
														
					</td>
					<tr align="center">
						<td>
							<c:if test="${opt.id > 0}">
								<input type="submit" value="submit"/>
							</c:if>
						</td>
					</tr>
				</tr>			
				</c:forEach>
			</table>
			</form:form>
				
				
	</center>
	<body>