package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.gestionedb.GestioneDatabase;

public class RimuoviProdotto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "devi usare la pagina iniziale per accedere all'azione");
		req.getRequestDispatcher("paginaIniziale.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
		try {
			if (GestioneDatabase.controlloProdotto(idProdotto)) {
				GestioneDatabase.rimuoviVendita(idProdotto);
				GestioneDatabase.rimuoviProdotto(idProdotto);
				req.setAttribute("risultato", "operazione andata a buon fine");
				req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
			} else {
				req.setAttribute("risultato", "ERRORE:qualcosa non è andato a buon fine");
				req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			req.setAttribute("risultato", "ERRORE:qualcosa non è andato a buon fine");
			req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
