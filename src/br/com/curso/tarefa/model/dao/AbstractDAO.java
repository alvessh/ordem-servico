package br.com.curso.tarefa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.curso.tarefa.model.bean.Bean;

public abstract class AbstractDAO<T extends Bean> {
	
	protected final static String PL = "\n";
	protected static Connection conexao;
	protected static PreparedStatement prSt;
	
	public AbstractDAO() {
		
	}
	
	public abstract void inserir(T t) throws SQLException;
	public abstract void atualizar(T t) throws SQLException;
	public abstract void deletar(Integer id) throws SQLException;
	
	protected void iniciarConexao() {
		conexao = ConnectionFactory.getConexaoMySQL();
	}
	
	protected void query(String query) throws SQLException {
		prSt = conexao.prepareStatement(query);
	}
	
	protected void execute() throws SQLException {
		prSt.execute();
	}
	
	protected void close() throws SQLException {
		prSt.close();
		conexao.close();
	}

}
