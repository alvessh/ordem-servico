package br.com.curso.tarefa.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.curso.tarefa.model.bean.PessoaBean;

public class PessoaDAO extends AbstractDAO<PessoaBean>{

	public PessoaDAO() {
		super.iniciarConexao();
	}

	public void inserir(PessoaBean pesBean) throws SQLException{

		String pesQuery = "insert into pessoa (pes_nome, pes_idade, pes_endereco, pes_email, pes_telefone, pes_ativo, pes_descricao)" +
				"values(?, ?, ?, ?, ?, ?, ?)";

		query(pesQuery);

		try {

			prSt.setString(1, pesBean.getNome());
			prSt.setInt(2, pesBean.getIdade());
			prSt.setString(3, pesBean.getEndereco());
			prSt.setString(4, pesBean.getEmail());
			prSt.setString(5, pesBean.getTelefone());
			prSt.setInt(6, pesBean.getAtivo());
			prSt.setString(7, pesBean.getDescricao());

			execute();
			close();

		} catch (SQLException e) {
			throw new SQLException("Erro ao fazer operação no banco de dados, favor verificar.");
		}
	}

	public void atualizar(PessoaBean pesBean) throws SQLException{

		String tarQuery = "update pessoa set pes_nome = ?, pes_idade = ?, pes_endereco = ?, pes_email = ?, pes_telefone = ?, pes_ativo = ?, pes_descricao = ? where pes_id = "+pesBean.getId()+"";

		query(tarQuery);

		prSt.setString(1, pesBean.getNome());
		prSt.setInt(2, pesBean.getIdade());
		prSt.setString(3, pesBean.getEndereco());
		prSt.setString(4, pesBean.getEmail());
		prSt.setString(5, pesBean.getTelefone());
		prSt.setInt(6, pesBean.getAtivo());
		prSt.setString(7, pesBean.getDescricao());

		execute();
		close();
	}

	public List<PessoaBean> listarTarefa() throws Exception{
		List<PessoaBean> pesList = new ArrayList<PessoaBean>();

		StringBuilder pesQuery = new StringBuilder();
		pesQuery.append("					select pes.pes_id,										"+PL);
		pesQuery.append("						   pes.pes_nome,									"+PL);
		pesQuery.append("						   pes.pes_idade,									"+PL);
		pesQuery.append("			               pes.pes_endereco,								"+PL);
		pesQuery.append("			               pes.pes_email,									"+PL);
		pesQuery.append("			               pes.pes_telefone,								"+PL);
		pesQuery.append("			               pes.pes_ativo,									"+PL);
		pesQuery.append("			               pes.pes_descricao								"+PL);
		pesQuery.append("					  from pessoa pes										"+PL);

		query(pesQuery.toString());
		ResultSet resSet = prSt.executeQuery();

		while(resSet.next()) {
			PessoaBean pesBean = new PessoaBean();
			pesBean.setId(resSet.getInt("pes_id"));
			pesBean.setNome(resSet.getString("pes_nome"));;
			pesBean.setIdade(resSet.getInt("pes_idade"));
			pesBean.setEndereco(resSet.getString("pes_endereco"));
			pesBean.setEmail(resSet.getString("pes_email"));
			pesBean.setTelefone(resSet.getString("pes_telefone"));
			pesBean.setAtivo(resSet.getInt("pes_ativo"));
			pesBean.setDescricao(resSet.getString("pes_descricao"));

			pesList.add(pesBean);
		}

		resSet.close();
		close();

		return pesList;
	}

	public PessoaBean listarPorId(Integer id) throws Exception {

		StringBuilder pesQuery = new StringBuilder();
		pesQuery.append("					select pes.pes_id,										"+PL);
		pesQuery.append("						   pes.pes_nome,									"+PL);
		pesQuery.append("						   pes.pes_idade,									"+PL);
		pesQuery.append("			               pes.pes_endereco,								"+PL);
		pesQuery.append("			               pes.pes_email,									"+PL);
		pesQuery.append("			               pes.pes_telefone,								"+PL);
		pesQuery.append("			               pes.pes_ativo,									"+PL);
		pesQuery.append("			               pes.pes_descricao								"+PL);
		pesQuery.append("					  from pessoa pes										"+PL);
		pesQuery.append("			 where pes.pes_id = "+id+" 										"+PL);

		query(pesQuery.toString());
		ResultSet resSet = prSt.executeQuery();

		resSet.next();

		PessoaBean pesBean = new PessoaBean();
		pesBean.setId(resSet.getInt("pes_id"));
		pesBean.setNome(resSet.getString("pes_nome"));;
		pesBean.setIdade(resSet.getInt("pes_idade"));
		pesBean.setEndereco(resSet.getString("pes_endereco"));
		pesBean.setEmail(resSet.getString("pes_email"));
		pesBean.setTelefone(resSet.getString("pes_telefone"));
		pesBean.setAtivo(resSet.getInt("pes_ativo"));
		pesBean.setDescricao(resSet.getString("pes_descricao"));

		resSet.close();
		close();

		return pesBean;

	}

	public void deletar(Integer id) throws SQLException {

		String pesQuery = "delete from pessoa where pes_id = "+id+"";

		query(pesQuery);

		execute();
		close();

	}
}
