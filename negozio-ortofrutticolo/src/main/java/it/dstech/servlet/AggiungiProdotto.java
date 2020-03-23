package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.gestionedb.GestioneDatabase;
import it.dstech.oggetti.Prodotto;

public class AggiungiProdotto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "devi usare la pagina iniziale per accedere all'azione");
		req.getRequestDispatcher("paginaIniziale.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		int qta = Integer.parseInt(req.getParameter("qta"));
		double prezzo = Double.parseDouble(req.getParameter("prezzo"));
		String descrizione = req.getParameter("descrizione");
		Prodotto prodotto = new Prodotto(nome, qta, prezzo, descrizione);
		try {
			if (GestioneDatabase.controlloProdotto(prodotto)) {
				GestioneDatabase.rifornimento(prodotto);
			} else {
				GestioneDatabase.aggiungiProdotto(prodotto);
			}
			req.setAttribute("risultato", "operazione andata a buon fine");
			req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			req.setAttribute("risultato", "ERRORE:qualcosa non è andato a buon fine");
			req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
