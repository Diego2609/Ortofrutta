<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Prodotto</title>
</head>
<body>

<form action="AggiungiProdotto" method="post">
  <label for="nome">Inserisci il nome del prodotto:</label>
  <input type="text" id="nome" name="nome"><br><br>
  <label for="qta">Inserisci la quantita del prodotto</label>
  <input type="number" id="qta" name="qta"><br><br>
  <label for="prezzo">Inserisci il prezzo del prodotto</label>
  <input type="number" step="0.01" id="prezzo" name="prezzo"><br><br>
  <label for="descrizione">Inserisci la descrizione del prodotto:</label>
  <input type="text" id="descrizione" name="descrizione"><br><br>
  <input type="submit" value="Aggiungi">
</form>

<form action="paginaIniziale.jsp">
  <input type="submit" value ="Indietro"><br><br>
  </form>
</body>
</html>