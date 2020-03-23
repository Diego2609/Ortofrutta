package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.gestionedb.GestioneDatabase;
import it.dstech.oggetti.Prodotto;
import it.dstech.oggetti.Vendita;

public class ControlloAzioni extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		try {
			if ("Aggiungi prodotto".equalsIgnoreCase(azione)) {
				req.getRequestDispatcher("aggiungiProdotto.jsp").forward(req, resp);
			} else if ("Rimuovi prodotto".equalsIgnoreCase(azione)) {
				ArrayList<Prodotto> listinoProdotti = GestioneDatabase.listinoProdotti();
				req.setAttribute("listinoProdotti", listinoProdotti);
				req.getRequestDispatcher("rimuoviProdotto.jsp").forward(req, resp);
			} else if ("Listino prodotti".equalsIgnoreCase(azione)) {
				ArrayList<Prodotto> listinoProdotti = GestioneDatabase.listinoProdotti();
				req.setAttribute("listinoProdotti", listinoProdotti);
				req.getRequestDispatcher("listinoProdotti.jsp").forward(req, resp);
			} else if ("Compra prodotto".equalsIgnoreCase(azione)) {
				ArrayList<Prodotto> listinoProdotti = GestioneDatabase.listinoProdotti();
				req.setAttribute("listinoProdotti", listinoProdotti);
				req.getRequestDispatcher("compra.jsp").forward(req, resp);
			} else if ("Prodotti venduti".equalsIgnoreCase(azione)) {
				ArrayList<Vendita> listaProdottiVenduti = GestioneDatabase.listaProdottiVenduti();
				req.setAttribute("listaVendite", listaProdottiVenduti);
				req.getRequestDispatcher("listaProdottiVenduti.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			req.setAttribute("risultato", "qualcosa non è andato a buon fine");
			req.getRequestDispatcher("risultatoOperazione.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
