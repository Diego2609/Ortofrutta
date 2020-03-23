<%@page import="it.dstech.oggetti.Prodotto"%>
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

<%ArrayList<Prodotto> listinoProdotti=(ArrayList<Prodotto>) request.getAttribute("listaVendite"); %>
<table>
  <tr>
    <th>IdProdotto</th>
    <th>Nome</th>
    <th>Qta</th>  
    <th>Prezzo</th> 
    <th>Descrizione</th>  
  </tr> 
  <% for(Prodotto prodotto : listinoProdotti) { %>
  <tr>
    <td>
				<%=prodotto.getIdProdotto()%>
	</td>  
	<td>
				<%=prodotto.getNome()%>
	</td>  
	<td>
				<%=prodotto.getQta()%>
	</td>  
	<td>
				<%=prodotto.getPrezzo()%>
	</td> 
	<td>
				<%=prodotto.getDescrizione()%>
	</td> 
	<% } %>
</table>
<form action="Compra">
<label for="idProdotto">Inserisci l'id del prodotto che vuoi comprare</label>
<input type="number" id="idProdotto" name="idProdotto"><br><br>
<label for="qtaVenduta">Inserisci la quantità che desideri comprare</label>
<input type="number" id="qtaVenduta" name="qtaVenduta"><br><br>
<input type="submit" value="Compra">
</form>
<form action="paginaIniziale.jsp">
<input type="submit" value="Indietro"><br><br>
</form>
</body>
</html>