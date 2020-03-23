<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%String risultato= (String)request.getAttribute("risultato"); %>

<h2> <%= risultato %> </h2>

<form action="paginaIniziale.jsp">
  <input type="submit" value ="Indietro"><br><br>
  </form>
  
</body>
</html>