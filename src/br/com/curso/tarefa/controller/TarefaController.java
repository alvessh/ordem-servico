package br.com.curso.tarefa.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.tarefa.bo.TarefaBO;
import br.com.curso.tarefa.helper.UtilsHelper;
import br.com.curso.tarefa.model.bean.EtapaTarefaBean;
import br.com.curso.tarefa.model.bean.TarefaBean;
import br.com.curso.tarefa.utils.DateUtils;

public class TarefaController {
	
	public List<TarefaBean> listarTable(Integer id) throws Exception{
		TarefaBO tarBO = new TarefaBO();
		tarBO.carregar(id);
		
		List<TarefaBean> tarList = tarBO.getTarefa();
		return tarList;
	}
	
	public List<EtapaTarefaBean> listarTableEtapaTarefa(Integer id) throws Exception {
		TarefaBO tarBO = new TarefaBO();
		tarBO.carregarEtapaTarefa(id);
		
		List<EtapaTarefaBean> ettaList = tarBO.getEtapa();
		
		return ettaList;
	}

	public void cadastrarTarefa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer numero = Integer.parseInt(request.getParameter("numero"));
		String descricao = request.getParameter("descricao");
		BigDecimal percentual = BigDecimal.ZERO;
		percentual = UtilsHelper.casasDecimais(2, percentual);
		Date dataInicio = DateUtils.getDataAtual();
		Date dataFim = DateUtils.parse(request.getParameter("dataFim"));

		TarefaBO tarBO = new TarefaBO();
		tarBO.iniciar();
		tarBO.definirDadosTarefa(numero, descricao, percentual, dataInicio, dataFim);
		tarBO.gravar();

		System.out.println("Inserido com Sucesso");

//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
	}
	
	public void atualizarTarefa(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer numero = Integer.parseInt(request.getParameter("numero"));
		String descricao = request.getParameter("descricao");
		Date dataInicio = DateUtils.parse("29/06/2019");
		Date dataFim = DateUtils.parse(request.getParameter("dataFim"));

		TarefaBO tarBO = new TarefaBO();
		tarBO.carregar(id);
		tarBO.definirDadosTarefa(numero, descricao, null, dataInicio, dataFim);
		tarBO.gravar();

//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
		System.out.println("Alterado com Sucesso");
	}
	
	public void cadastrarEtapaTarefa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer tarefaId = Integer.parseInt(request.getParameter("id"));
		Integer etapaId = Integer.parseInt(request.getParameter("etapaId"));

		TarefaBO tarBO = new TarefaBO();
		tarBO.iniciarEtapaTarefa();
		tarBO.definirDadosEtapaTarefa(tarefaId, etapaId);
		tarBO.gravar();

		System.out.println("Inserido com Sucesso");

//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
	}
	
	public void cadastrarPessoaTarefa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer pessoaId = Integer.parseInt(request.getParameter("pessoaId"));
		Integer tarefaId = Integer.parseInt(request.getParameter("id"));

		TarefaBO tarBO = new TarefaBO();
		tarBO.iniciarPessoaTarefa();
		tarBO.definirDadosPessoaTarefa(pessoaId, tarefaId);
		tarBO.gravar();

		System.out.println("Inserido com Sucesso");

//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
	}

	public void inativarTarefa(Integer id) throws Exception {
		
		TarefaBO tarBO = new TarefaBO();
		tarBO.carregar(id);
		tarBO.inativarTarefa(id);
		tarBO.gravar();
	}

}


