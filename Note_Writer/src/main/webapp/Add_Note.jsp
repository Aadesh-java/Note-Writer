<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="All_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="Navbar.jsp"%>
		<h2 align="center" style="color: gray; padding: 4px;">Please fill
			your note detail</h2>
	</div>

	<div class="container">
		<form action="AddNote" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> <input type="text"
					class="form-control" id="title" name="title" required="required"
					placeholder="Enter here"> <small id="emailHelp"
					class="form-text text-muted">You can enter your note title
					first.</small>
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea class="form-control" id="content" name="content"
					required="required" placeholder="Enter your content here"
					style="height: 250px;">
    </textarea>
			</div> 
			<div class="container" text align="center">
				<button type="submit" class="btn btn-success">Add</button>
			</div>
		</form>

	</div>
</body>
</html>