<%@page import="com.entity.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.FactoryProvider.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Note !!</title>
<%@include file="All_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="Navbar.jsp"%>
		<h2 style="color: #ff4000">Edit your Notes</h2>
		<%
		int id = Integer.parseInt(request.getParameter("NoteID"));
		Session session1 = FactoryProvider.getFactory().openSession();

		Note note = (Note) session1.get(Note.class, id);
		%>

		<form action="UpdateNote" method="post">
		<input value="<%=note.getId() %>" name="NoteID" type="hidden"/>
			<div class="form-group">
				<label for="title">Note Title</label> <input type="text"
					class="form-control" id="title" name="title" required="required"
					placeholder="Enter here" value="<%= note.getTitle()%>"/>  
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea class="form-control" id="content" name="content"
					required="required" placeholder="Enter your content here"
					 style="height: 250px; "> <%=note.getContent() %>
    </textarea>
			</div>
			<div class="container" text align="center">
				<button type="submit" class="btn btn-success">Save</button>
			</div>
		</form>

	</div>
</body>
</html>