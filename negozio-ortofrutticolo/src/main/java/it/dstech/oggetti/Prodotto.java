package it.dstech.oggetti;

public class Prodotto {
	private int idProdotto;
	private String nome;
	private int qta;
	private double prezzo;
	private String descrizione;

	public Prodotto(String nome, int qta, double prezzo, String descrizione) {
		this.nome = nome;
		this.qta = qta;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
	}

	public Prodotto(int idProdotto, String nome, int qta, double prezzo, String descrizione) {
		this.idProdotto = idProdotto;
		this.nome = nome;
		this.qta = qta;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
