package br.com.curso.tarefa.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.curso.tarefa.model.bean.EtapaBean;
import br.com.curso.tarefa.utils.CondicaoUtils;
import br.com.curso.tarefa.utils.FiltroUtils;


public class EtapaDAO extends AbstractDAO<EtapaBean>{

	public EtapaDAO() {
		super.iniciarConexao();
	}

	public void inserir(EtapaBean etaBean) throws SQLException{

		String pesQuery = "insert into etapa(eta_descricao, cat_id) " +
				"values(?, ?)";

		query(pesQuery);

		try {

			prSt.setString(1, etaBean.getDescricao());
			prSt.setInt(2, etaBean.getCategoria().getId());

			execute();
			close();

		} catch (SQLException e) {
			throw new SQLException("Erro ao fazer operação no banco de dados, favor verificar.");
		}
	}

	public void atualizar(EtapaBean etaBean) throws SQLException{

		String tarQuery = "update etapa set eta_descricao = ?, cat_id = ? where eta_id = "+etaBean.getId()+"";

		query(tarQuery);
		try {
			prSt.setString(1, etaBean.getDescricao());
			prSt.setInt(2, etaBean.getCategoria().getId());

			execute();
			close();
		} catch (SQLException e) {
			throw new SQLException("Erro ao fazer operação no banco de dados, favor verificar.");
		}
	}

	public EtapaBean listarPorId(Integer id) throws Exception {
		EtapaBean etaBean = new EtapaBean();

		FiltroUtils where = new FiltroUtils();
		where.adicionar("eta.eta_id", CondicaoUtils.EQUALS, id);
		List<EtapaBean> etaList = listar(where);
		etaBean = etaList.get(0);

		return etaBean;

	}

	public List<EtapaBean> listar(FiltroUtils filUtils) throws Exception{
		List<EtapaBean> etaList = new ArrayList<EtapaBean>();

		String condicoes = "";

		if(filUtils != null){
			condicoes = filUtils.criarCondicao();
		}

		StringBuilder etaQuery = new StringBuilder();
		etaQuery.append("								  select eta.eta_id,															"+PL);
		etaQuery.append("			                             eta.eta_descricao,														"+PL);
		etaQuery.append("			                             etta.tar_id,															"+PL);
		etaQuery.append("			                             cat.cat_id,															"+PL);
		etaQuery.append("			                             cat.cat_descricao														"+PL);
		etaQuery.append("									from etapa eta																"+PL);
		etaQuery.append("			                  inner join categoria cat on (cat.cat_id = eta.cat_id)								"+PL);
		etaQuery.append("			                  inner join etapatarefa etta on (etta.eta_id = eta.eta_id)							"+PL);
		etaQuery.append("				     where 1 = 1"+condicoes+"																	"+PL);

		query(etaQuery.toString());
		ResultSet resSet = prSt.executeQuery();

		while(resSet.next()) {
			EtapaBean etaBean = new EtapaBean();
			etaBean.setId(resSet.getInt("eta_id"));
			etaBean.setDescricao(resSet.getString("eta_descricao"));
			etaBean.getCategoria().setId(resSet.getInt("cat_id"));
			etaBean.getCategoria().setDescricao(resSet.getString("cat_descricao"));

			etaList.add(etaBean);
		}

		return etaList;
	}

	public void deletar(Integer id) throws SQLException {

		String etaQuery = "delete from etapa where eta_id = "+id+"";

		query(etaQuery);

		execute();
		close();
	}
}
