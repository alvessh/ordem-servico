package br.com.curso.tarefa.model.dao;

import java.sql.SQLException;

import br.com.curso.tarefa.model.bean.PessoaTarefaBean;


public class PessoaTarefaDAO extends AbstractDAO<PessoaTarefaBean>{

	public PessoaTarefaDAO() {
		super.iniciarConexao();
	}

	public void inserir(PessoaTarefaBean petaBean) throws SQLException{

		String petaQuery = "insert into pessoatarefa(pes_id, tar_id)" +
				"values(?, ?)";

		query(petaQuery);

		try {

			prSt.setInt(1, petaBean.getPessoa().getId());
			prSt.setInt(2, petaBean.getTarefa().getId());

			execute();
			close();

		} catch (SQLException e) {
			throw new SQLException("Erro ao fazer operação no banco de dados, favor verificar.");
		}
	}

	public void atualizar(PessoaTarefaBean petaBean) throws SQLException{

		String petaQuery = "update pessoatarefa set tar_id = ?, eta_id = ? where etta_id = "+petaBean.getId()+"";

		query(petaQuery);

		prSt.setInt(1, petaBean.getPessoa().getId());
		prSt.setInt(1, petaBean.getTarefa().getId());

		execute();
		close();
	}

	public void deletar(Integer id) throws SQLException {

		String etaQuery = "delete from pessoatarefa where peta_id = "+id+"";

		query(etaQuery);
		execute();
		close();
	}
}
