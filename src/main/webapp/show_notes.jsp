<!doctype html>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.Helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entites.Todo"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <%@include file="bootsrap.jsp" %>
    <title>note taker: show notes</title>
  </head>
  <body>
  <div class="container">
  <%@include file="navbar.jsp" %>
  <h1 class="text-capitalise">Notes:-</h1>
    <br>
    <div class="row">
    <%
    	Session s= FactoryProvider.getFactory().openSession();
    	Query q= s.createQuery("from Todo");
    	List<Todo> notes= q.list();
    	
    	for(Todo note: notes){%>
    		 <div class="card  m-1" style="width: 100%;">
			  <img class="card-img-top m-4 mx-auto" style="max-width:100px"; src="image/notes.png" alt="Card image cap">
			  <div class="card-body px-5">
			    <h5 class="card-title text-center"><%= note.getTitle() %></h5>
			    <p class="card-text"><%= note.getContent() %></p>
			    <div class="container text-center">
			    <a href="DeleteServlet?id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
			    <a href="update.jsp?id=<%=note.getId() %>" class="btn btn-primary">Update</a>
			    </div>
			  </div>
			</div>
    		<%}
    %>
    </div>
    
  </div>
  
    
<script type="text/javascript">
</script>
  </body>
</html>