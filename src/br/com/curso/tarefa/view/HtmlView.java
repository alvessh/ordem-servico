package br.com.curso.tarefa.view;

import br.com.curso.tarefa.controller.ViewController;
import br.com.curso.tarefa.utils.ConstantsUtils;

public class HtmlView {
	
	public String createHead() {
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("<!DOCTYPE html>"+ConstantsUtils.PL);
		strBuilder.append("<html lang=\"pt-br\">"+ConstantsUtils.PL);
		strBuilder.append("<head>"+ConstantsUtils.PL);
		strBuilder.append("<title>Home</title>"+ConstantsUtils.PL);
		strBuilder.append("<meta charset=\"UTF-8\">"+ConstantsUtils.PL);
		strBuilder.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+ConstantsUtils.PL);
		strBuilder.append("<link href=\"estilos/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>"+ConstantsUtils.PL);
		strBuilder.append("</head>"+ConstantsUtils.PL);
		strBuilder.append("<body id=\"cpbody\">"+ConstantsUtils.PL);
		return strBuilder.toString();
	}
	
	public String createMenu() {
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("<div id=\"mnform\">"+ConstantsUtils.PL);
		strBuilder.append("<ul class=\"menuitem\">"+ConstantsUtils.PL);
		strBuilder.append("<li><a href="+ViewController.HOME+">HOME</a></li>"+ConstantsUtils.PL);
		strBuilder.append("<li><a href=\"TarefaServlet?acao=definirTarefa\">Cadastrar Tarefa</a></li>"+ConstantsUtils.PL);
		strBuilder.append("<li><a href=\"TarefaServlet?acao=definirPessoa\">Cadastrar Pessoa</a></li>"+ConstantsUtils.PL);
		strBuilder.append("<li><a href=\"TarefaServlet?acao=definirEtapa\">Cadastrar Etapa</a></li>"+ConstantsUtils.PL);
		strBuilder.append("</ul>"+ConstantsUtils.PL);
		strBuilder.append("</div>"+ConstantsUtils.PL);
		
		return strBuilder.toString();
	}
	
	public String createFooter() {
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("</body>"+ConstantsUtils.PL);
		strBuilder.append("</html>"+ConstantsUtils.PL);
		
		return strBuilder.toString();
	}

}
