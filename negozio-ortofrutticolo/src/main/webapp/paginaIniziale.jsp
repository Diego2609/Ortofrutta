<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina Iniziale</title>
</head>
<body>
<%String messaggio = (String) request.getAttribute("messaggio");
if(messaggio!= null){

%>

<h1>Errore</h1>

<%=messaggio%>

<%}else{%>
<h1>Scegli un'azione</h1>

<form action="ControlloAzioni">
<input type="submit" name="azione" value = "Aggiungi prodotto">
<input type="submit" name="azione" value = "Rimuovi prodotto">
<input type="submit" name="azione" value = "Listino prodotti">
<input type="submit" name="azione" value = "Compra prodotto">
<input type="submit" name="azione" value = "Prodotti venduti">
</form>
<%}%>
</body>
</html>