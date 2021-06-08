package model;

public class Funcionario extends Pessoa{

	private String codFunc;
	private String usuario;
	private String senha;


	public Funcionario(String codFunc,String nome, String email,String usuario, String senha, String cpf, String dataNascimento, String cep, String numEnd,
			String complemento) {
		super(nome, email, cpf, dataNascimento, cep, numEnd, complemento);
		// TODO Auto-generated constructor stub
		this.codFunc = codFunc;
		this.senha = senha;
		this.usuario = usuario;
	}
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCodFunc() {
		return codFunc;
	}
	public void setCodFunc(String codFunc) {
		this.codFunc = codFunc;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
