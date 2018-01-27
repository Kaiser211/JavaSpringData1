<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Java</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		
		<form:form  action="/languages/update/${language.id}" method="post"  modelAttribute="language">
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