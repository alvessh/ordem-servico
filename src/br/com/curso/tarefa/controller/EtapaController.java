package br.com.curso.tarefa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.tarefa.bo.EtapaBO;
import br.com.curso.tarefa.model.bean.EtapaBean;

public class EtapaController {

	public List<EtapaBean> listarTable() throws Exception{
		EtapaBO etaBO = new EtapaBO();
		etaBO.carregar(null);

		List<EtapaBean> etaList = etaBO.getEtapa();
		return etaList;
	}

	public void cadastrarEtapa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String descricao = request.getParameter("descricao");

		EtapaBO etaBO = new EtapaBO();
		etaBO.iniciar();
		etaBO.definirDadosEtapa(descricao);
		etaBO.gravar();

		System.out.println("Inserido com Sucesso");

		//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
	}

	public void atualizarTarefa(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String descricao = request.getParameter("descricao");

		EtapaBO etaBO = new EtapaBO();
		etaBO.carregar(id);
		etaBO.definirDadosEtapa(descricao);
		etaBO.gravar();

		//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
		System.out.println("Alterado com Sucesso");
	}

	public void concluirEtapa(Integer id) throws Exception {
		
		EtapaBO etaBO = new EtapaBO();
		etaBO.carregar(id);
		etaBO.definirEtapaConcluida();
		etaBO.gravar();
		etaBO.validar(id);
	}
}
