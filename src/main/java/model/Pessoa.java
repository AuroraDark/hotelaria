package model;

public class Pessoa {
	private String nome;
	private String fone;
	private String email;
	private String cpf;
	private String dataNascimento;
	private String cep;
	private String numEnd;
	private String complemento;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, String fone, String email, String cpf, String dataNascimento, String cep, String numEnd,String complemento) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.numEnd = numEnd;
		this.complemento = complemento;
	}

	public Pessoa(String nome, String email, String cpf, String dataNascimento, String cep, String numEnd,
			String complemento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.numEnd = numEnd;
		this.complemento = complemento;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumEnd() {
		return numEnd;
	}

	public void setNumEnd(String numEnd) {
		this.numEnd = numEnd;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
