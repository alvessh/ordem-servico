package br.com.curso.tarefa.view;

public class ScriptView {

	private static final String PL = "\n";
	
	public String mensagemSucesso(String mensagem) {
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("<SCRIPT LANGUAGE=\"JavaScript\" TYPE=\"text/javascript\">"+PL);
		strBuilder.append("alert ("+mensagem+")"+PL);
		strBuilder.append("</SCRIPT>"+PL);
		
		return strBuilder.toString();
	}
}
