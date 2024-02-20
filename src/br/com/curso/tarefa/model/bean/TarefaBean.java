package br.com.curso.tarefa.model.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TarefaBean extends Bean {
	
	private Integer id;
	private Integer numero;
	private String descricao;
	private BigDecimal percentual;
	private CategoriaBean categoria;
	private Date dataInicio ;
	private Date dataFim ;
	private Integer ativo;
	
	public TarefaBean() {
		//
	}
	
	public TarefaBean(Integer id, Integer numero, String descricao, BigDecimal percentual, CategoriaBean categoriaId,
			Date dataInicio, Date dataFim, Integer ativo) {
		super();
		this.id = id;
		this.numero = numero;
		this.descricao = descricao;
		this.percentual = percentual;
		this.categoria = categoriaId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	public CategoriaBean getCategoriaId() {
		if(categoria == null ) categoria = new CategoriaBean();
		return categoria;
	}

	public void setCategoriaId(CategoriaBean categoriaId) {
		this.categoria = categoriaId;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
}
