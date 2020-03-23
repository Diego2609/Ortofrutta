package it.dstech.gestionedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.dstech.oggetti.Prodotto;
import it.dstech.oggetti.Vendita;

public class GestioneDatabase {

	public static Connection connessioneDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://remotemysql.com:3306/xgouH99Q5G?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, "xgouH99Q5G", "sKoY2hSBYL");
		return connessione;
	}

	public static void aggiungiProdotto(Prodotto prodotto) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "INSERT INTO prodotti (nome,qta,prezzo,descrizione) VALUES (?,?,?,?);";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, prodotto.getNome());
		statement.setInt(2, prodotto.getQta());
		statement.setDouble(3, prodotto.getPrezzo());
		statement.setString(4, prodotto.getDescrizione());
		statement.execute();
		connessione.close();
	}

	public static void rifornimento(Prodotto prodotto) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "update prodotti set qta=qta+? where nome=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, prodotto.getQta());
		statement.setString(2, prodotto.getNome());
		statement.execute();
		connessione.close();
	}

	public static boolean controlloProdotto(Prodotto prodotto) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "select * from prodotti where nome=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, prodotto.getNome());
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			connessione.close();
			return true;
		}
		connessione.close();
		return false;
	}

	public static boolean controlloProdotto(int idProdotto) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "select * from prodotti where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idProdotto);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			connessione.close();
			return true;
		}
		connessione.close();
		return false;
	}

	public static void rimuoviProdotto(int idProdotto) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "delete from prodotti where idProdotto= ?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idProdotto);
		statement.execute();
		connessione.close();
	}

	public static void modificaProdotto(Prodotto prodotto) throws SQLException, ClassNotFoundException {
		Connection connessione = connessioneDatabase();
		String query = "update prodotti set nome=?,qta=?, prezzo=?, descrizione=? where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, prodotto.getNome());
		statement.setInt(2, prodotto.getQta());
		statement.setDouble(3, prodotto.getPrezzo());
		statement.setString(4, prodotto.getDescrizione());
		statement.setInt(5, prodotto.getIdProdotto());
		statement.execute();
		connessione.close();
	}

	public static ArrayList<Prodotto> listinoProdotti() throws ClassNotFoundException, SQLException {
		ArrayList<Prodotto> listaProdotti = new ArrayList<>();
		Connection connessione = connessioneDatabase();
		String query = "select * from prodotti;";
		PreparedStatement statement = connessione.prepareStatement(query);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			listaProdotti.add(new Prodotto(risultato.getInt(1), risultato.getString(2), risultato.getInt(3),
					risultato.getDouble(4), risultato.getString(5)));
		}
		connessione.close();
		return listaProdotti;
	}

	public static void aggiungiVendita(Vendita vendita) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "INSERT INTO vendite (idProdotto,qtaVenduta) VALUES (?,?);";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, vendita.getIdProdotto());
		statement.setInt(2, vendita.getQtaVenduta());
		statement.execute();
		connessione.close();
	}

	public static void aggiungiQtaVenduta(Vendita vendita) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "update vendite set qtaVenduta= qtaVenduta+? where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, vendita.getQtaVenduta());
		statement.setInt(2, vendita.getIdProdotto());
		statement.execute();
		connessione.close();
	}

	public static boolean controlloVendita(Vendita vendita) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "select * from vendite where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, vendita.getIdProdotto());
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			connessione.close();
			return true;
		}
		connessione.close();
		return false;
	}

	public static void compra(Vendita vendita) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "update prodotti set qta =qta-? where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, vendita.getQtaVenduta());
		statement.setInt(2, vendita.getIdProdotto());
		statement.execute();
		connessione.close();
	}

	public static boolean controlloQTA(Vendita vendita) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "select * from prodotti where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, vendita.getIdProdotto());
		ResultSet risultato = statement.executeQuery();
		Prodotto prodotto = null;
		while (risultato.next()) {
			prodotto = new Prodotto(risultato.getInt(1), risultato.getString(2), risultato.getInt(3),
					risultato.getDouble(4), risultato.getString(5));
		}
		if (prodotto.getQta() > vendita.getQtaVenduta()) {
			return true;
		} else {
			return false;
		}
	}

	public static void rimuoviVendita(int idProdotto) throws ClassNotFoundException, SQLException {
		Connection connessione = connessioneDatabase();
		String query = "delete from vendite where idProdotto= ?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idProdotto);
		statement.execute();
		connessione.close();
	}

	public static ArrayList<Vendita> listaProdottiVenduti() throws ClassNotFoundException, SQLException {
		ArrayList<Vendita> listaProdottiVenduti = new ArrayList<>();
		Connection connessione = connessioneDatabase();
		String query = "select * from vendite ;";
		PreparedStatement statement = connessione.prepareStatement(query);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			listaProdottiVenduti.add(new Vendita(risultato.getInt(1), risultato.getInt(2), risultato.getInt(3)));
		}
		connessione.close();
		return listaProdottiVenduti;
	}

}
