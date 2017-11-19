<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatiable" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
<div align = "center">
	<h1>Hello Lucene!</h1>
	<br>
	<hr>
</div>
<br><br><br>
<div align = "center">
	<form name="form" class="form" action="SearchServlet" method="post">
		<input type="text" name="search" placeholder=" Just input you want" style="width:600px;height:30px"><button type="submit" value="search"  style="width:70px;height:36px">search</button>
	</form>
</div>
<div>
     <%
         String results = (String)session.getAttribute("results"); 
     %>
     
     <%if(results != ""){
      %>
      <p><%=results%></p>
     <%}%>
   
</div>
</body>
</html>
