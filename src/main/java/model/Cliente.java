package model;

public class Cliente extends Pessoa {

	private String codCli;
	
	public Cliente() {
		super();
	}
	public Cliente(String codCli,String nome, String fone, String email, String cpf, String dataNascimento, String cep, String numEnd,
			String complemento) {
		super(nome, fone, email, cpf, dataNascimento, cep, numEnd, complemento);
		this.codCli = codCli;
	}
	public String getCodCli() {
		return codCli;
	}
	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}
	
}
