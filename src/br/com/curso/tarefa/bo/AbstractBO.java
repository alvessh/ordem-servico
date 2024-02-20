package br.com.curso.tarefa.bo;

public abstract class AbstractBO {
	
	public AbstractBO() {
		
	}
	
	public abstract void iniciar();
	public abstract void carregar(Integer id) throws Exception;

}
