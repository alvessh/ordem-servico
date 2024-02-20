package br.com.curso.tarefa.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.curso.tarefa.helper.UtilsHelper;
import br.com.curso.tarefa.model.bean.TarefaBean;
import br.com.curso.tarefa.utils.CondicaoUtils;
import br.com.curso.tarefa.utils.FiltroUtils;

public class TarefaDAO extends AbstractDAO<TarefaBean>{

	public TarefaDAO() {
		super.iniciarConexao();
	}

	public void inserir(TarefaBean tarBean) throws SQLException{

		String tarQuery = "insert into tarefa(tar_numero, tar_descricao, tar_percentual, tar_dataInicio, tar_dataFim, tar_ativo, cat_id) " +
				"values(?, ?, ?, ?, ?, ?, ?)";

		query(tarQuery);

		try {

			prSt.setInt(1, tarBean.getNumero());
			prSt.setString(2, tarBean.getDescricao());
			prSt.setBigDecimal(3, tarBean.getPercentual());
			prSt.setDate(4, new java.sql.Date(tarBean.getDataInicio().getTime()));
			prSt.setDate(5, new java.sql.Date(tarBean.getDataFim().getTime()));
			prSt.setInt(6, tarBean.getAtivo());
			prSt.setInt(7, tarBean.getCategoriaId().getId());

			execute();
			close();

		} catch (SQLException e) {
			throw new SQLException("Erro ao fazer operação no banco de dados, favor verificar.");
		}
	}

	public void atualizar(TarefaBean tarBean) throws SQLException{

		String tarQuery = "update tarefa set tar_numero = ?, tar_descricao = ?, tar_percentual = ?, cat_id = ?, tar_dataInicio = ?, tar_dataFim = ?, tar_ativo = ? where tar_id = "+tarBean.getId()+"";

		query(tarQuery);

		prSt.setInt(1, tarBean.getNumero());
		prSt.setString(2, tarBean.getDescricao());
		prSt.setBigDecimal(3, tarBean.getPercentual());
		prSt.setDate(4, new java.sql.Date(tarBean.getDataInicio().getTime()));
		prSt.setDate(5, new java.sql.Date(tarBean.getDataFim().getTime()));
		prSt.setInt(6, tarBean.getAtivo());
		prSt.setInt(7, tarBean.getCategoriaId().getId());

		execute();
		close();
	}
	
	public TarefaBean listarPorId(Integer id) throws Exception {
		TarefaBean tarBean = new TarefaBean();

		FiltroUtils where = new FiltroUtils();
		where.adicionar("tar_id", CondicaoUtils.EQUALS, id);
		List<TarefaBean> tarList = listarTarefa(where);
		tarBean = tarList.get(0);
		
		return tarBean;

	}
	
	public List<TarefaBean> listarTarefa(FiltroUtils filUtils) throws Exception{
		List<TarefaBean> tarList = new ArrayList<TarefaBean>();
		
		String condicoes = "";
        
        if(filUtils != null){
            condicoes = filUtils.criarCondicao();
        }

		StringBuilder tarQuery = new StringBuilder();
		tarQuery.append("					select cat.cat_descricao,							"+PL);
		tarQuery.append("						   tar.tar_id,									"+PL);
		tarQuery.append("						   tar.tar_numero,								"+PL);
		tarQuery.append("			               tar.tar_descricao,							"+PL);
		tarQuery.append("			               tar.tar_percentual,							"+PL);
		tarQuery.append("			               tar.tar_dataInicio,							"+PL);
		tarQuery.append("			               tar.tar_dataFim,								"+PL);
		tarQuery.append("			               tar.tar_ativo,								"+PL);
		tarQuery.append("			               cat.cat_id									"+PL);
		tarQuery.append("					  from tarefa tar									"+PL);
		tarQuery.append("				inner join categoria cat on (cat.cat_id = tar.cat_id)	"+PL);
		tarQuery.append("				     where 1 = 1"+condicoes+"							"+PL);
		tarQuery.append("				  group by cat.cat_descricao,							"+PL);
		tarQuery.append("						   tar.tar_id,									"+PL);
		tarQuery.append("						   tar.tar_numero,								"+PL);
		tarQuery.append("			               tar.tar_descricao,							"+PL);
		tarQuery.append("			               tar.tar_percentual,							"+PL);
		tarQuery.append("			               cat.cat_id									"+PL);

		query(tarQuery.toString());
		ResultSet resSet = prSt.executeQuery();

		while(resSet.next()) {
			TarefaBean tarBean = new TarefaBean();
			tarBean.setId(resSet.getInt("tar_id"));
			tarBean.setNumero(resSet.getInt("tar_numero"));
			tarBean.setDescricao(resSet.getString("tar_descricao"));
			tarBean.setPercentual(UtilsHelper.casasDecimais(2, resSet.getBigDecimal("tar_percentual")));
			tarBean.getCategoriaId().setId(resSet.getInt("cat_id"));
			tarBean.getCategoriaId().setDescricao(resSet.getString("cat_descricao"));
			tarBean.setDataInicio(resSet.getDate("tar_dataInicio"));
			tarBean.setDataFim(resSet.getDate("tar_dataFim"));
			tarBean.setAtivo(resSet.getInt("tar_ativo"));
			
			tarList.add(tarBean);
		}

		return tarList;
	}

	public void deletar(Integer id) throws SQLException {

		String tarQuery = "delete from tarefa where tar_id = "+id+"";

		query(tarQuery);
		execute();
		close();

	}
}
