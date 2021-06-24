package model;

public class Quarto {

	private int numQuarto;
	private String descricao;
	private double valorDiaria;
	private boolean statusDisp;
	private String urlImage;
	
	public Quarto() {
		super();
	}
	
	
	public Quarto(int numQuarto, String descricao, double valorDiaria, boolean statusDisp, String urlImage) {
		super();
		this.numQuarto = numQuarto;
		this.descricao = descricao;
		this.valorDiaria = valorDiaria;
		this.statusDisp = statusDisp;
		this.urlImage = urlImage;
	}



	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public boolean isStatusDisp() {
		return statusDisp;
	}
	public void setStatusDisp(boolean statusDisp) {
		this.statusDisp = statusDisp;
	}
	public String getUrlImage() { return urlImage; }
	public void setUrlImage(String urlImage) { this.urlImage = urlImage; }
	
}
