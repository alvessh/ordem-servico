package br.com.curso.tarefa.model.dao;

import java.sql.SQLException;

import br.com.curso.tarefa.model.bean.CategoriaBean;

public class CategoriaDAO extends AbstractDAO<CategoriaBean>{

	public CategoriaDAO() {
		super.iniciarConexao();
	}

	public void inserir(CategoriaBean catBean) throws SQLException{

		String catQuery = "insert into categoria(cat_id, cat_descricao) " +
				"values(?, ?)";

		query(catQuery);

		prSt.setInt(1, catBean.getId());
		prSt.setString(2, catBean.getDescricao());

		execute();
		close();
		
	}

	@Override
	public void atualizar(CategoriaBean t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
