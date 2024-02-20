package br.com.curso.tarefa.seed;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.curso.tarefa.model.bean.CategoriaBean;
import br.com.curso.tarefa.model.dao.CategoriaDAO;

public class CategoriaSeed {

	List<CategoriaBean> catList = new ArrayList<CategoriaBean>();


	public void cadastrarCategoria(CategoriaBean catBean) {
		catList.add(catBean);
	}

	public static final Integer ATIVO = 0;
	public static final Integer INATIVO = 1;
	public static final Integer PENDENTE = 2;
	public static final Integer CONCLUIDO = 3;

	public void adicionarCategoria() {
		cadastrarCategoria(new CategoriaBean(ATIVO, "Ativo"));
		cadastrarCategoria(new CategoriaBean(INATIVO, "Inativo"));
		cadastrarCategoria(new CategoriaBean(PENDENTE, "Pendente"));
		cadastrarCategoria(new CategoriaBean(CONCLUIDO, "Concluído"));
	}
	
	public void executar() throws SQLException {
		for(CategoriaBean catBean : catList) {
			CategoriaDAO catDAO = new CategoriaDAO();
			catDAO.inserir(catBean);
		}
	}

}
