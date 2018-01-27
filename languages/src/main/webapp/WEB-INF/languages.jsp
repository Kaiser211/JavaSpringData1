<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Languages</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		<c:forEach items="${errs}" var="err">
			<h2><c:out value="${err.getDefaultMessage()}"/></h2>
		</c:forEach>
	
		<table>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${languages}" var="language" varStatus="loop">
				<tr>
					<td><a href="languages/show/${language.id}"><c:out value="${language.name}"></c:out></a></td>
					<td><c:out value="${language.creator}"></c:out></td>
					<td><c:out value="${language.version}"></c:out></td>
					<td><a href="languages/delete/${language.id}">Delete</a> <a href="languages/edit/${language.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	
		<form:form action="languages/new" method="post" modelAttribute="language">
			<form:label path="name">
				<form:errors path="name"></form:errors>
				<form:input path="name"></form:input>
			</form:label>
			
			<form:label path="creator">
				<form:errors path="creator"></form:errors>
				<form:input path="creator"></form:input>
			</form:label>
			
			<form:label path="version">
				<form:errors path="version"></form:errors>
				<form:input path="version"></form:input>
			</form:label>
			
			<input type="submit"></input>
		</form:form>
			
	</body>
</html>














