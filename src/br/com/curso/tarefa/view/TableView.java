package br.com.curso.tarefa.view;

import java.util.List;

import br.com.curso.tarefa.model.bean.EtapaTarefaBean;
import br.com.curso.tarefa.model.bean.TarefaBean;

public class TableView {

	private static final String PL = "\n";

	public String creataTable(List<TarefaBean> tarList) throws Exception {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("               <div id=\"cpTable\">" + PL);
		strBuilder.append("                   <h3>Tarefas</h3>" + PL);
		strBuilder.append("               </div>" + PL);
		strBuilder.append("                   <table id=\"tabela\"  style=\"width:100%\">" + PL);
		strBuilder.append("                           <thead>" + PL);
		strBuilder.append("                               <tr>" + PL);
		strBuilder.append("                                   <th>Categoria</th>" + PL);
		strBuilder.append("                                   <th>Numero</th>" + PL);
		strBuilder.append("                                   <th>Descrição</th>" + PL);
		strBuilder.append("                                   <th>Percentual %</th>" + PL);
		strBuilder.append("                                   <th>Data Inicio</th>" + PL);
		strBuilder.append("                                   <th>Data Fim</th>" + PL);
		strBuilder.append("                                   <th>Ações</th>" + PL);
		strBuilder.append("                               </tr>" + PL);
		strBuilder.append("                           </thead>" + PL);
		strBuilder.append("                           <tbody>" + PL);


		for ( TarefaBean tarBean : tarList ) {

			strBuilder.append("                               <tr>" + PL);
			strBuilder.append("                                   <td> " + tarBean.getCategoriaId().getDescricao() + "</td>" + PL);
			strBuilder.append("                                   <td>" +  tarBean.getNumero() + "</td>" + PL);
			strBuilder.append("                                   <td>" +  tarBean.getDescricao() + "</td>" + PL);
			strBuilder.append("                                   <td> " + tarBean.getPercentual() + "</td>" + PL);
			strBuilder.append("                                   <td> " + tarBean.getDataInicio() + "</td>" + PL);
			strBuilder.append("                                   <td> " + tarBean.getDataFim() + "</td>" + PL);
			strBuilder.append("                                   <td>" + PL);
			strBuilder.append("                                       <a href=\"TarefaServlet?acao=adicionarEtapa&id=" + tarBean.getId() + "\"><img src=\"img/add.jpeg\"></span></a>" + PL);
			strBuilder.append("                                       <a href=\"TarefaServlet?acao=adicionarPessoa&id=" + tarBean.getId() + "\"><img src=\"img/add.jpeg\"></span></a>" + PL);
			strBuilder.append("                                       <a href=\"TarefaServlet?acao=alterarTarefa&id=" + tarBean.getId() + "\" ><img src=\"img/alt.png\"></span></a>" + PL);
			strBuilder.append("                                       <a href=\"TarefaServlet?acao=detalharTarefa&id=" + tarBean.getId() + "\" ><img src=\"img/alt.png\"></span></a>" + PL);
			strBuilder.append("                                       <a href=\"TarefaServlet?acao=inativarTarefa&id=" + tarBean.getId() + "\" ><img src=\"img/delete.png\"></a>" + PL);

			strBuilder.append("                                   </td>" + PL);
			strBuilder.append("                               </tr>" + PL);
		}

		strBuilder.append("                           </tbody>" + PL);
		strBuilder.append("                       </table>" + PL);

		return strBuilder.toString();
	}
	
	public String creataTableEtapa(List<EtapaTarefaBean> ettaList) throws Exception {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("               <div id=\"cpTable\">" + PL);
		strBuilder.append("                   <h3>Etapas</h3>" + PL);
		strBuilder.append("               </div>" + PL);
		strBuilder.append("                   <table id=\"tabela\"  style=\"width:100%\">" + PL);
		strBuilder.append("                           <thead>" + PL);
		strBuilder.append("                               <tr>" + PL);
		strBuilder.append("                                   <th>#</th>" + PL);
		strBuilder.append("                                   <th>Descrição</th>" + PL);
		strBuilder.append("                                   <th>Categoria</th>" + PL);
		strBuilder.append("                                   <th>Ações</th>" + PL);
		strBuilder.append("                               </tr>" + PL);
		strBuilder.append("                           </thead>" + PL);
		strBuilder.append("                           <tbody>" + PL);


		for ( EtapaTarefaBean ettaBean : ettaList ) {

			strBuilder.append("                               <tr>" + PL);
			strBuilder.append("                                   <td> " + ettaBean.getEtapa().getId() + "</td>" + PL);
			strBuilder.append("                                   <td>" +  ettaBean.getEtapa().getDescricao() + "</td>" + PL);
			strBuilder.append("                                   <td>" +  ettaBean.getEtapa().getCategoria().getDescricao() + "</td>" + PL);
			strBuilder.append("                                   <td>" + PL);
			strBuilder.append("                                       <a href=\"TarefaServlet?acao=concluirEtapa&id=" + ettaBean.getEtapa().getId() + "\"><img src=\"img/add.jpeg\"></span></a>" + PL);
			strBuilder.append("                                       <a href=\"TarefaServlet?acao=deletarEtapa&id=" + ettaBean.getEtapa().getId() + "\" ><img src=\"img/delete.png\"></a>" + PL);

			strBuilder.append("                                   </td>" + PL);
			strBuilder.append("                               </tr>" + PL);
		}

		strBuilder.append("                           </tbody>" + PL);
		strBuilder.append("                       </table>" + PL);

		return strBuilder.toString();
	}

}
