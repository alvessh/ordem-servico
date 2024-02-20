package br.com.curso.tarefa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.tarefa.model.bean.EtapaBean;
import br.com.curso.tarefa.model.bean.EtapaTarefaBean;
import br.com.curso.tarefa.model.bean.PessoaBean;
import br.com.curso.tarefa.model.bean.TarefaBean;
import br.com.curso.tarefa.view.FormView;
import br.com.curso.tarefa.view.HtmlView;
import br.com.curso.tarefa.view.TableView;

public class ViewController {
	/*TODO: criar constantes para as ações*/
	HtmlView html = new HtmlView();
	FormView formView = new FormView();
	TableView tableView = new TableView();
	public static final String HOME = "TarefaServlet";

	public void executeHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.print(html.createHead().toString());
	}

	public void menu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.print(html.createMenu().toString());
	}

	public void executePrincipal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		menu(request, response);

		TarefaController tarControll = new TarefaController();
		List<TarefaBean> tarList = new ArrayList<TarefaBean>();
		tarList = tarControll.listarTable(null);

		out.print(tableView.creataTable(tarList));
	}

	public void executeBody(HttpServletRequest request, HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");

		if(acao == null) {
			executePrincipal(request, response);
		}else if(acao.equals("definirTarefa")){
			menu(request, response);
			out.print(formView.createFormTarefaNovo());
		}else if(acao.equals("cadastrarTarefa")) {
			TarefaController tarController = new TarefaController();
			tarController.cadastrarTarefa(request, response);

			response.sendRedirect(HOME);
		}else if(acao.equals("alterarTarefa")) {
			menu(request, response);
			Integer id = Integer.parseInt(request.getParameter("id"));

			TarefaBean tarBean = new TarefaBean();
			TarefaController tarCont = new TarefaController();
			List<TarefaBean> etaList = tarCont.listarTable(id);
			tarBean = etaList.get(0);

			out.print(formView.createFormTarefaAlterar(tarBean));
		}else if(acao.equals("atualizarTarefa")) {
			Integer id = Integer.parseInt(request.getParameter("id"));

			TarefaController tarCont = new TarefaController();
			tarCont.atualizarTarefa(id, request, response);

			response.sendRedirect(HOME);
		}else if(acao.equals("definirPessoa")){
			menu(request, response);
			out.print(formView.createFormPessoaNovo());
		}
		else if(acao.equals("cadastrarPessoa")) {
			PessoaController pesCont = new PessoaController();
			pesCont.cadastrarPessoa(request, response);

			response.sendRedirect(HOME);
		}else if(acao.equals("definirEtapa")){
			menu(request, response);
			out.print(formView.createFormEtapa());
		}else if(acao.equals("cadastrarEtapa")) {
			EtapaController etaCont = new EtapaController();
			etaCont.cadastrarEtapa(request, response);

			response.sendRedirect(HOME);
		}else if(acao.equals("adicionarEtapa")) {
			menu(request, response);
			Integer tarefaId = Integer.parseInt(request.getParameter("id")); 

			EtapaController etaCont = new EtapaController();
			List<EtapaBean> etaList = new ArrayList<EtapaBean>();
			etaList = etaCont.listarTable();

			out.print(formView.createFormEtapaTarefa(tarefaId, etaList));
		}else if(acao.equals("cadastrarEtTa")) {
			TarefaController tarController = new TarefaController();
			tarController.cadastrarEtapaTarefa(request, response);

			response.sendRedirect(HOME);
		}else if(acao.equals("adicionarPessoa")) {
			menu(request, response);
			Integer tarefaId = Integer.parseInt(request.getParameter("id")); 

			PessoaController pesCont = new PessoaController();
			List<PessoaBean> pesList = new ArrayList<PessoaBean>();
			pesList = pesCont.listarTable();

			out.print(formView.createFormPessoaTarefa(tarefaId, pesList));
		}else if(acao.equals("cadastrarPeTa")) {
			TarefaController tarCont = new TarefaController();
			tarCont.cadastrarPessoaTarefa(request, response);

			response.sendRedirect(HOME);
		}else if(acao.equals("detalharTarefa")) {
			menu(request, response);
			Integer tarefaId = Integer.parseInt(request.getParameter("id"));
			
			TarefaController tarCont = new TarefaController();
			List<EtapaTarefaBean> etaList = tarCont.listarTableEtapaTarefa(tarefaId);

			out.print(tableView.creataTableEtapa(etaList));
		}else if(acao.equals("inativarTarefa")) {
			Integer id = Integer.parseInt(request.getParameter("id"));

			TarefaController tarCont = new TarefaController();
			tarCont.inativarTarefa(id);

			response.sendRedirect(HOME);
		}else if(acao.equals("concluirEtapa")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			EtapaController etaCont = new EtapaController();
			etaCont.concluirEtapa(id);

			response.sendRedirect(HOME);
		}

	}

	public void executeFooter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.print(html.createFooter().toString());
	}
}
