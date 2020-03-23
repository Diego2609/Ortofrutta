package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.gestionedb.GestioneDatabase;
import it.dstech.oggetti.Vendita;

public class Compra extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "devi usare la pagina iniziale per accedere all'azione");
		req.getRequestDispatcher("paginaIniziale.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
		int qtaVenduta = Integer.parseInt(req.getParameter("qtaVenduta"));
		Vendita vendita = new Vendita(idProdotto, qtaVenduta);
		try {
			if (GestioneDatabase.controlloQTA(vendita)) {
				if (GestioneDatabase.controlloVendita(vendita)) {
					GestioneDatabase.compra(vendita);
					GestioneDatabase.aggiungiQtaVenduta(vendita);
					req.setAttribute("risultato", "operazione andata a buon fine");
					req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
				} else {
					GestioneDatabase.compra(vendita);
					GestioneDatabase.aggiungiVendita(vendita);
					req.setAttribute("risultato", "operazione andata a buon fine");
					req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("risultato", "Non c'è disponibilità sufficiente per questo prodotto");
				req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			req.setAttribute("risultato", "ERRORE:qualcosa non è andato a buon fine");
			req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
