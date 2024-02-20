package br.com.curso.tarefa.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.curso.tarefa.helper.UtilsHelper;
import br.com.curso.tarefa.model.bean.EtapaTarefaBean;
import br.com.curso.tarefa.utils.CondicaoUtils;
import br.com.curso.tarefa.utils.FiltroUtils;


public class EtapaTarefaDAO extends AbstractDAO<EtapaTarefaBean>{

	public EtapaTarefaDAO() {
		super.iniciarConexao();
	}

	public void inserir(EtapaTarefaBean ettaBean) throws SQLException{

		String ettaQuery = "insert into etapatarefa(tar_id, eta_id)" +
				"values(?, ?)";

		query(ettaQuery);

		try {

			prSt.setInt(1, ettaBean.getTarefa().getId());
			prSt.setInt(2, ettaBean.getEtapa().getId());

			execute();
			close();

		} catch (SQLException e) {
			throw new SQLException("Erro ao fazer operação no banco de dados, favor verificar.");
		}
	}

	public void atualizar(EtapaTarefaBean ettaBean) throws SQLException{

		String ettaQuery = "update etapatarefa set tar_id = ?, eta_id = ? where etta_id = "+ettaBean.getId()+"";

		query(ettaQuery);

		prSt.setInt(1, ettaBean.getTarefa().getId());
		prSt.setInt(1, ettaBean.getEtapa().getId());

		execute();
		close();
	}

	public EtapaTarefaBean listarPorId(Integer id) throws Exception {
		EtapaTarefaBean ettaBean = new EtapaTarefaBean();

		FiltroUtils where = new FiltroUtils();
		where.adicionar("tar.tar_id", CondicaoUtils.EQUALS, id);
		List<EtapaTarefaBean> etaList = listar(where);
		ettaBean = etaList.get(0);

		return ettaBean;
	}

	public List<EtapaTarefaBean> listar(FiltroUtils filUtils) throws Exception{
		List<EtapaTarefaBean> ettaList = new ArrayList<EtapaTarefaBean>();

		String condicoes = "";

		if(filUtils != null){
			condicoes = filUtils.criarCondicao();
		}

		StringBuilder etaQuery = new StringBuilder();
		etaQuery.append("								  select eta.eta_id,															"+PL);
		etaQuery.append("			                             eta.eta_descricao,														"+PL);
		etaQuery.append("			                             tar.tar_id,															"+PL);
		etaQuery.append("										 tar.tar_numero,														"+PL);
		etaQuery.append("						                 tar.tar_descricao,														"+PL);
		etaQuery.append("						                 tar.tar_percentual,													"+PL);
		etaQuery.append("						                 tar.tar_dataInicio,													"+PL);
		etaQuery.append("						                 tar.tar_dataFim,														"+PL);
		etaQuery.append("						                 tar.tar_ativo,															"+PL);
		etaQuery.append("			                             cat.cat_id,															"+PL);
		etaQuery.append("			                             cat.cat_descricao														"+PL);
		etaQuery.append("									from etapa eta																"+PL);
		etaQuery.append("							  inner join etapatarefa etta on (etta.eta_id = eta.eta_id)							"+PL);
		etaQuery.append("			                  inner join tarefa tar on (tar.tar_id = etta.tar_id)								"+PL);
		etaQuery.append("			                  inner join categoria cat on (cat.cat_id = eta.cat_id)								"+PL);
		etaQuery.append("				     where 1 = 1"+condicoes+"																	"+PL);

		query(etaQuery.toString());
		ResultSet resSet = prSt.executeQuery();

		while(resSet.next()) {
			EtapaTarefaBean ettaBean = new EtapaTarefaBean();
			ettaBean.getEtapa().setId(resSet.getInt("eta_id"));
			ettaBean.getEtapa().setDescricao(resSet.getString("eta_descricao"));
			ettaBean.getTarefa().setId(resSet.getInt("tar_id"));
			ettaBean.getTarefa().setNumero(resSet.getInt("tar_numero"));
			ettaBean.getTarefa().setDescricao(resSet.getString("tar_descricao"));
			ettaBean.getTarefa().setPercentual(UtilsHelper.casasDecimais(2, resSet.getBigDecimal("tar_percentual")));
			ettaBean.getTarefa().setDataInicio(resSet.getDate("tar_dataInicio"));
			ettaBean.getTarefa().setDataFim(resSet.getDate("tar_dataFim"));
			ettaBean.getTarefa().setAtivo(resSet.getInt("tar_ativo"));
			ettaBean.getEtapa().getCategoria().setId(resSet.getInt("cat_id"));
			ettaBean.getEtapa().getCategoria().setDescricao(resSet.getString("cat_descricao"));

			ettaList.add(ettaBean);
		}

		return ettaList;
	}

	public void deletar(Integer id) throws SQLException {

		String etaQuery = "delete from etapatarefa where etta_id = "+id+"";

		query(etaQuery);

		execute();
		close();

	}
}
