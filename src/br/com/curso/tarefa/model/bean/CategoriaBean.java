package br.com.curso.tarefa.model.bean;

public class CategoriaBean extends Bean {

	private Integer id;
	private String descricao;

	public CategoriaBean() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaBean(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
