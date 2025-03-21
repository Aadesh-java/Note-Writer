<%@page import="com.entity.*"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.FactoryProvider.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes !!</title>
<%@include file="All_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="Navbar.jsp"%><br>
		<h2 class="text-uppercase" style="color: #ff4000">All Notes :</h2>

		<div class="row">
			<div class="col-12">
				<%
				Session session1 = FactoryProvider.getFactory().openSession();
				Query q = session1.createQuery("from Note");
				List<Note> list = q.list();

				for (Note note : list) {
				%>
				<div class="card mt-3">
					<img class="card-img-top mx-auto mt-2" style="max-width: 50px;"
						src="image/note1.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text"><%=note.getContent()%></p>
						<div class="container text-center mt-2">
							<a href="DeleteNote?NoteID=<%=note.getId() %>" class="btn btn-danger">Delete</a>
							<a href="Edit_Note.jsp?NoteID=<%=note.getId()%>"class="btn btn-primary">update</a>
						</div>
					</div>
				</div>


				<%
				}
				session1.close();
				%>

			</div>
		</div>

	</div>
</body>
</html>