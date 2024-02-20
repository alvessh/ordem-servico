package br.com.curso.tarefa.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.tarefa.view.ScriptView;

public class MensagemUtils {
	
	public static void mensagemProgramdor(String mensagem) {
		System.out.println(mensagem);
	}

	public static void mensagemUsuarioSucesso(String mensagem, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		ScriptView scrView = new ScriptView();
		out.print(scrView.mensagemSucesso(mensagem));
	}
}
