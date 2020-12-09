<!doctype html>
<%@page import="com.entites.Todo"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.Helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <%@include file="bootsrap.jsp" %>
    <title>Hello, world!</title>
  </head>
  <body>
  <div class="container">
  <%@include file="navbar.jsp" %>
  <h1>Update your note</h1>
  <% 
  	Session s= FactoryProvider.getFactory().openSession();
  	int id= Integer.parseInt(request.getParameter("id").trim());
  	Todo note= s.get(Todo.class, id);
  	%>
  	<form action="UpdateServlet" method="post">
  	<input value="<%=note.getId()%>" type="hidden" name="id">
	  <div class="form-group">
	    <label for="title">Note title</label>
	    <input type="text" class="form-control" name="title" id="title" value="<%=note.getTitle() %>" aria-describedby="emailHelp" placeholder="Enter here" required="required">
	  </div>
	  <div class="form-group">
	    <label for="note-content">Note</label>
	    <textarea id="content" class="form-control" name="content"  for="note-content" placeholder="Enter your text here"
	    style="height: 200px" required="required"
	    ><%=note.getContent() %></textarea>
	  </div >
	  <div class="container text-center">
	  <button type="submit" class="btn btn-success text-center">Update now</button>
	  </div>
	  
	</form>

  </div>
  </body>
</html>