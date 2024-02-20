package br.com.curso.tarefa.utils;

public enum CondicaoUtils {

	EQUALS("="),
	GREAT(">"),
	LESS("<"),
	LIKE("LIKE"),
	LIKEIN("LIKE"),
	LIKEOUT("LIKE"),
	GREATOREQUALS(">="),
	LESSOREQUALS("<=");

	String condicao;
	CondicaoUtils(String condicao){
		this.condicao = condicao;
	}

	public String get(){
		return this.condicao;
	}
}
