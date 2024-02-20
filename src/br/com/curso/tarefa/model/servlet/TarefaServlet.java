package br.com.curso.tarefa.model.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.tarefa.controller.ViewController;

/**
 * Servlet implementation class TarefaServlet
 */
@WebServlet("/TarefaServlet")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TarefaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			doExecute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		doGet(request, response);
		try {
			doExecute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=iso-8859-1");
		
		ViewController view = new ViewController();

		view.executeHead(request, response);
		view.executeBody(request, response);
		view.executeFooter(request, response);

		/**
		 * TODO: tem que criar um controller, para enviar pro controler resolver essa parada, de executar a tela.
		 */
	}
}
