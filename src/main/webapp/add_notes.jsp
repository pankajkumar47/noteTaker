<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <%@include file="bootsrap.jsp" %>
    <title>Note taker: add notes</title>
  </head>
  <body>
  <div class="container">
  <%@include file="navbar.jsp" %>
  <h1>add notes</h1>
  <form action="SaveNoteServlet" method="post">
  <div class="form-group">
    <label for="title">Note title</label>
    <input type="text" class="form-control" name="title" id="title" aria-describedby="emailHelp" placeholder="Enter here" required="required">
  </div>
  <div class="form-group">
    <label for="note-content">Note</label>
    <textarea id="content" class="form-control" name="content" for="note-content" placeholder="Enter your text here"
    style="height: 200px" required="required"
    ></textarea>
  </div >
  <div class="container text-center">
  <button type="submit" class="btn btn-primary text-center">Add</button>
  </div>
  
</form>
  </div>
  </body>
</html>