package br.com.curso.tarefa.model.bean;

public class EtapaBean extends Bean {

	private Integer id;
	private String descricao;
	private CategoriaBean categoria;

	public EtapaBean() {
		// TODO Auto-generated constructor stub
	}

	public EtapaBean(Integer id, String descricao, CategoriaBean categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
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

	public CategoriaBean getCategoria() {
		if(categoria == null) categoria = new CategoriaBean();
		return categoria;
	}

	public void setCategoria(CategoriaBean categoria) {
		this.categoria = categoria;
	}
}
