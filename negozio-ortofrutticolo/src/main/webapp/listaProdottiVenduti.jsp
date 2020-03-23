<%@page import="it.dstech.oggetti.Vendita"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<body>

<%ArrayList<Vendita> listaProdottiVenduti=(ArrayList<Vendita>) request.getAttribute("listaVendite"); %>
<table>
  <tr>
    <th>IdVendita</th>
    <th>IdProdotto</th>
    <th>QtaVenduta</th>   
  </tr> 
  <% for(Vendita vendita : listaProdottiVenduti) { %>
  <tr>
    <td>
				<%=vendita.getIdVenduto()%>
	</td>  
	<td>
				<%=vendita.getIdProdotto()%>
	</td>  
	<td>
				<%=vendita.getQtaVenduta()%>
	</td>  
	
	<% } %>
</table>

<form action="paginaIniziale.jsp">
  <input type="submit" value ="Indietro"><br><br>
  </form>
</body>
</html>