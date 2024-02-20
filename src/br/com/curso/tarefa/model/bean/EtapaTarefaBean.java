package br.com.curso.tarefa.model.bean;

public class EtapaTarefaBean extends Bean {

	private Integer id;
	private TarefaBean tarefa;
	private EtapaBean etapa;

	public EtapaTarefaBean() {
		//
	}

	public EtapaTarefaBean(Integer id, TarefaBean tarefa, EtapaBean etapa) {
		super();
		this.id = id;
		this.tarefa = tarefa;
		this.etapa = etapa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TarefaBean getTarefa() {
		if(tarefa == null) tarefa = new TarefaBean();
		return tarefa;
	}

	public void setTarefa(TarefaBean tarefa) {
		this.tarefa = tarefa;
	}

	public EtapaBean getEtapa() {
		if(etapa == null) etapa = new EtapaBean();
		return etapa;
	}

	public void setEtapa(EtapaBean etapa) {
		this.etapa = etapa;
	}
}
