<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
		<div>
		<h2><a href="/dashboard">Dashboard</a></h2>

		<form method="post" action="/search">
			<h2>Songs by artist: <c:out value="${songs.get(0).getArtist()}"/> </h2>
			<input type="text" name="artist" placeholder="${songs.get(0).getArtist()}"></input>
			<input type="submit" value="New Search"></input>
		</form>

		<table border = 1>
			<tr>
				<th>Name</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${songs}" var="song" varStatus="loop" >
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
					<td><c:out value="${song.artist}" /></td>
					<td><c:out value="${song.rating}" /></td>
					<td> <a href="/songs/delete/${song.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
 </body>
</html>