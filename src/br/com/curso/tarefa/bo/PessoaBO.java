package br.com.curso.tarefa.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.curso.tarefa.model.bean.PessoaBean;
import br.com.curso.tarefa.model.dao.PessoaDAO;
import br.com.curso.tarefa.seed.CategoriaSeed;

public class PessoaBO extends AbstractBO {

	private PessoaDAO pesDAO = new PessoaDAO();
	private PessoaBean pesBean;
	private List<PessoaBean> pesList;

	public PessoaBO() {

	}


	@Override
	public void iniciar() {
		pesBean = new PessoaBean();
		pesList = new ArrayList<PessoaBean>();
	}

	@Override
	public void carregar(Integer id) throws Exception {
		if(id != null) {
			pesBean = pesDAO.listarPorId(id);
		}

		pesList = pesDAO.listarTarefa();

	}

	public void definirDadosTarefa(String nome, Integer idade, String endereco, String email, String telefone, String descricao) {
		
		this.pesBean.setNome(nome);
		this.pesBean.setIdade(idade);
		this.pesBean.setEndereco(endereco);
		this.pesBean.setEmail(email);
		this.pesBean.setTelefone(telefone);
		this.pesBean.setAtivo(CategoriaSeed.ATIVO);
		this.pesBean.setDescricao(descricao);
	}


	public void validar() {

	}

	public void gravar() throws Exception {

		if(pesBean.getId() == null) {
			pesDAO.inserir(pesBean);
		}else {
			pesDAO.atualizar(pesBean);
		}
	}

	public List<PessoaBean> getPessoa(){

		List<PessoaBean> list = new ArrayList<PessoaBean>();
		for(PessoaBean pesBean : pesList) {
			list.add(pesBean);
		}
		return list;
	}

}
