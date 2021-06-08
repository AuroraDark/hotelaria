package model;

public class Cartao {
	private String codCli;
	private String tipo;
	private String cNome;
	private String cNum;
	private String cVal;
	
	public Cartao() {
		super();
	}
	
	public Cartao(String codCli,String tipo, String cNome, String cNum, String cVal) {
		super();
		this.codCli = codCli;
		this.tipo = tipo;
		this.cNome = cNome;
		this.cNum = cNum;
		this.cVal = cVal;
	}
	public String getCodCli() {
		return codCli;
	}
	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getcNome() {
		return cNome;
	}
	public void setcNome(String cNome) {
		this.cNome = cNome;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public String getcVal() {
		return cVal;
	}
	public void setcVal(String cVal) {
		this.cVal = cVal;
	}
}
