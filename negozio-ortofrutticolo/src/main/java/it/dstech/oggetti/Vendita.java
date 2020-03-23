package it.dstech.oggetti;

public class Vendita {
	private int idVenduto;
	private int idProdotto;
	private int qtaVenduta;

	public Vendita(int idProdotto, int qtaVenduta) {
		this.idProdotto = idProdotto;
		this.qtaVenduta = qtaVenduta;
	}

	public Vendita(int idVenduto, int idProdotto, int qtaVenduta) {
		this.idVenduto = idVenduto;
		this.idProdotto = idProdotto;
		this.qtaVenduta = qtaVenduta;
	}

	public int getIdVenduto() {
		return idVenduto;
	}

	public void setIdVenduto(int idVenduto) {
		this.idVenduto = idVenduto;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public int getQtaVenduta() {
		return qtaVenduta;
	}

	public void setQtaVenduta(int qtaVenduta) {
		this.qtaVenduta = qtaVenduta;
	}

}
