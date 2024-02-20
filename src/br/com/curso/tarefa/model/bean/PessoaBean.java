package br.com.curso.tarefa.model.bean;

public class PessoaBean extends Bean {

	private Integer id;
	private String nome;
	private Integer idade;
	private String endereco;
	private String email;
	private String telefone;
	private Integer ativo;
	private String descricao;
	
	public PessoaBean() {
		
	}
	
	public PessoaBean(Integer id, String nome, Integer idade, String endereco, String email, String telefone,
			Integer ativo, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.ativo = ativo;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
