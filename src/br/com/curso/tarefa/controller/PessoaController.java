package br.com.curso.tarefa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.tarefa.bo.PessoaBO;
import br.com.curso.tarefa.model.bean.PessoaBean;

public class PessoaController {

	public List<PessoaBean> listarTable() throws Exception{
		PessoaBO pesBO = new PessoaBO();
		pesBO.carregar(null);

		List<PessoaBean> pesList = pesBO.getPessoa();
		return pesList;
	}

	public void cadastrarPessoa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nome = request.getParameter("nome");
		Integer idade = Integer.parseInt(request.getParameter("idade"));
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String descricao = request.getParameter("descricao");

		PessoaBO pesBO = new PessoaBO();
		pesBO.iniciar();
		pesBO.definirDadosTarefa(nome, idade, endereco, email, telefone, descricao);
		pesBO.gravar();

		System.out.println("Inserido com Sucesso");

		//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
	}

	public void atualizarTarefa(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nome = request.getParameter("nome");
		Integer idade = Integer.parseInt(request.getParameter("idade"));
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String descricao = request.getParameter("descricao");

		PessoaBO pesBO = new PessoaBO();
		pesBO.carregar(id);
		pesBO.definirDadosTarefa(nome, idade, endereco, email, telefone, descricao);
		pesBO.gravar();

		//		MensagemUtils.mensagemUsuarioSucesso("Inserido com Sucesso", request, response);
		System.out.println("Alterado com Sucesso");
	}
}


