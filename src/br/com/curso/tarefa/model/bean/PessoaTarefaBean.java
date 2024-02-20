package br.com.curso.tarefa.model.bean;

public class PessoaTarefaBean extends Bean {

	private Integer id;
	private PessoaBean pessoa;
	private TarefaBean tarefa;
	
	public PessoaTarefaBean() {
		
	}
	
	public PessoaTarefaBean(Integer id, PessoaBean pessoa, TarefaBean tarefa) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.tarefa = tarefa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PessoaBean getPessoa() {
		if(pessoa == null) pessoa = new PessoaBean();
		return pessoa;
	}

	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}

	public TarefaBean getTarefa() {
		if(tarefa == null ) tarefa = new TarefaBean();
		return tarefa;
	}

	public void setTarefa(TarefaBean tarefa) {
		this.tarefa = tarefa;
	}
}
