package br.com.curso.tarefa.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.curso.tarefa.model.bean.EtapaBean;
import br.com.curso.tarefa.model.bean.EtapaTarefaBean;
import br.com.curso.tarefa.model.dao.EtapaDAO;
import br.com.curso.tarefa.model.dao.EtapaTarefaDAO;
import br.com.curso.tarefa.seed.CategoriaSeed;
import br.com.curso.tarefa.utils.CondicaoUtils;
import br.com.curso.tarefa.utils.FiltroUtils;

public class EtapaBO extends AbstractBO {

	private EtapaDAO etaDAO = new EtapaDAO();
	private EtapaTarefaDAO ettaDAO = new EtapaTarefaDAO();
	private EtapaBean etaBean;
	private List<EtapaBean> etaList;

	public EtapaBO() {

	}


	@Override
	public void iniciar() {
		etaBean = new EtapaBean();
		etaList = new ArrayList<EtapaBean>();
	}

	@Override
	public void carregar(Integer id) throws Exception {
		if(id !=  null) {
			etaBean = etaDAO.listarPorId(id);
		}
		etaList = etaDAO.listar(null);

	}

	public void definirDadosEtapa(String descricao) {

		this.etaBean.setDescricao(descricao);
		this.etaBean.getCategoria().setId(CategoriaSeed.PENDENTE);
	}

	public void definirEtapaConcluida() throws Exception {

		this.etaBean.getCategoria().setId(CategoriaSeed.CONCLUIDO);
	}
	
	public void validar(Integer id) throws Exception {
		TarefaBO tarBO = new TarefaBO();
		FiltroUtils filUtils = new FiltroUtils();
		filUtils.adicionar("tar.tar_id", CondicaoUtils.EQUALS, id);
		filUtils.adicionar("cat.cat_id", CondicaoUtils.EQUALS, CategoriaSeed.PENDENTE);
		List<EtapaTarefaBean> ettaList = ettaDAO.listar(filUtils);
		
		if(ettaList.size() == 0) {
			tarBO.carregar(null);
			tarBO.definirTarefaConcluida();
		}
		
	}
	

	public void gravar() throws Exception {

		if(etaBean.getId() == null) {
			etaDAO.inserir(etaBean);
		}else {
			etaDAO.atualizar(etaBean);
		}
	}

	public List<EtapaBean> getEtapa(){

		List<EtapaBean> list = new ArrayList<EtapaBean>();
		for(EtapaBean etaBean : etaList) {
			list.add(etaBean);
		}
		return list;
	}

}
