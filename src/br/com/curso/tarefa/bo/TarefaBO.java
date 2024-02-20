package br.com.curso.tarefa.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.curso.tarefa.helper.UtilsHelper;
import br.com.curso.tarefa.model.bean.EtapaTarefaBean;
import br.com.curso.tarefa.model.bean.PessoaTarefaBean;
import br.com.curso.tarefa.model.bean.TarefaBean;
import br.com.curso.tarefa.model.dao.EtapaTarefaDAO;
import br.com.curso.tarefa.model.dao.PessoaTarefaDAO;
import br.com.curso.tarefa.model.dao.TarefaDAO;
import br.com.curso.tarefa.seed.CategoriaSeed;
import br.com.curso.tarefa.utils.CondicaoUtils;
import br.com.curso.tarefa.utils.FiltroUtils;

public class TarefaBO extends AbstractBO {

	private TarefaDAO tarDAO = new TarefaDAO();
	private EtapaTarefaDAO ettaDAO = new EtapaTarefaDAO();
	private PessoaTarefaDAO petaDAO = new PessoaTarefaDAO();
	private TarefaBean tarBean;
	private EtapaTarefaBean ettaBean;
	private PessoaTarefaBean petaBean;
	private List<TarefaBean> tarList;
	private List<EtapaTarefaBean> ettaList;

	public TarefaBO() {

	}

	@Override
	public void iniciar() {
		tarBean = new TarefaBean();
		tarList = new ArrayList<TarefaBean>();
	}
	public void iniciarEtapaTarefa() {
		ettaBean = new EtapaTarefaBean();
		ettaList = new ArrayList<EtapaTarefaBean>();
	}

	public void iniciarPessoaTarefa() {
		petaBean = new PessoaTarefaBean();
	}

	@Override
	public void carregar(Integer id) throws Exception {
		if(id != null) {
			tarBean = tarDAO.listarPorId(id);
		}

		tarList = tarDAO.listarTarefa(null);
		//No operations allowed after connection closed.
	}

	public void carregarEtapaTarefa(Integer id) throws Exception {
		if(id != null) {
			ettaBean = ettaDAO.listarPorId(id);
		}

		FiltroUtils filUtils = new FiltroUtils();
		filUtils.adicionar("tar.tar_id", CondicaoUtils.EQUALS, id);
		ettaList = ettaDAO.listar(filUtils);
	}


	public void definirDadosTarefa(Integer numero, String descricao, BigDecimal percentual, Date dataInicio, Date dataFim) {

		this.tarBean.setNumero(numero);
		this.tarBean.setDescricao(descricao);
		this.tarBean.setPercentual(percentual);
		this.tarBean.getCategoriaId().setId(CategoriaSeed.PENDENTE);
		this.tarBean.setDataInicio(dataInicio);
		this.tarBean.setDataFim(dataFim);
		this.tarBean.setAtivo(CategoriaSeed.ATIVO);	

	}

	public void definirDadosEtapaTarefa(Integer tarefaId, Integer etapaId) {

		this.ettaBean.getTarefa().setId(tarefaId);
		this.ettaBean.getEtapa().setId(etapaId);
	}

	public void definirDadosPessoaTarefa(Integer pessoaId, Integer tarefaId) {

		this.petaBean.getPessoa().setId(pessoaId);
		this.petaBean.getTarefa().setId(tarefaId);

	}

	public void inativarTarefa(Integer id) {

		this.tarBean.setAtivo(CategoriaSeed.INATIVO);
	}
	
	public void definirTarefaConcluida() {
		this.tarBean.getCategoriaId().setId(CategoriaSeed.CONCLUIDO);
		BigDecimal perc = new BigDecimal(100);
		this.tarBean.setPercentual(perc);
	}

	public void validarPerc() {
		/*coloca que se for maior que 100, vai ser 100. */
	}

	public void gravar() throws Exception {

		if(tarBean != null) {
			if(tarBean.getId() == null) {
				tarDAO.inserir(tarBean);
			}else {
				tarDAO.atualizar(tarBean);
			}
		}

		if(ettaBean != null) {
			if(ettaBean.getId() == null) {
				ettaDAO.inserir(ettaBean);
			}
		}

		if(petaBean != null) {
			if(petaBean.getId() == null) {
				petaDAO.inserir(petaBean);
			}
		}

	}

	public List<TarefaBean> getTarefa(){

		List<TarefaBean> list = new ArrayList<TarefaBean>();
		for(TarefaBean tarBean : tarList) {
			list.add(tarBean);
		}
		return list;
	}

	public List<EtapaTarefaBean> getEtapa() {
		List<EtapaTarefaBean> list = new ArrayList<EtapaTarefaBean>();
		
		for(EtapaTarefaBean ettaBean : ettaList) {
			list.add(ettaBean);
		}
		return list;
	}
}
