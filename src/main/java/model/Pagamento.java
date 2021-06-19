package model;

public class Pagamento {
	private String codPagamento;
	private String formaPagamento;
	private double valorTotal;
	
	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pagamento(String codPagamento, String formaPagamento, double valorTotal) {
		super();
		this.codPagamento = codPagamento;
		this.formaPagamento = formaPagamento;
		this.valorTotal = valorTotal;
	}
	public String getCodPagamento() {
		return codPagamento;
	}
	public void setCodPagamento(String codPagamento) {
		this.codPagamento = codPagamento;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
