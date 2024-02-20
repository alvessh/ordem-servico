package br.com.curso.tarefa.view;

import java.io.IOException;
import java.util.List;

import br.com.curso.tarefa.model.bean.EtapaBean;
import br.com.curso.tarefa.model.bean.PessoaBean;
import br.com.curso.tarefa.model.bean.TarefaBean;
import br.com.curso.tarefa.utils.ConstantsUtils;

public class FormView {

	public String createFormTarefaNovo() throws IOException {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("<div id=\"cpform\">"+ConstantsUtils.PL);
		strBuilder.append("<form id=\"form\" method = \"POST\"  action = \"TarefaServlet\">"+ConstantsUtils.PL);
		strBuilder.append("<fieldset>"+ConstantsUtils.PL);
		strBuilder.append("<legend>Tarefa</legend>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"acao\" value = \"cadastrarTarefa\"/>"+ConstantsUtils.PL);
//		strBuilder.append("<input type = \"hidden\" name = \"percentual\" value=\"0\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Número</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"number\" name = \"numero\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Descricao</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"descricao\"/>"+ConstantsUtils.PL);
//		strBuilder.append("<label>Data Inicio</label>"+ConstantsUtils.PL);
//		strBuilder.append("<input type = \"text\" name = \"dataInicio\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Data Fim</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"dataFim\"/>"+ConstantsUtils.PL);
		strBuilder.append("<input class=\"btn\" type = \"submit\" value = \"Salvar\"/>"+ConstantsUtils.PL);
		strBuilder.append("</fieldset>"+ConstantsUtils.PL);
		strBuilder.append("</form>"+ConstantsUtils.PL);
		strBuilder.append("</div>"+ConstantsUtils.PL);

		return strBuilder.toString();
	}

	public String createFormTarefaAlterar(TarefaBean tarBean) throws IOException {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("<div id=\"cpform\">"+ConstantsUtils.PL);
		strBuilder.append("<form id=\"form\" method = \"POST\"  action = \"TarefaServlet\">"+ConstantsUtils.PL);
		strBuilder.append("<fieldset>"+ConstantsUtils.PL);
		strBuilder.append("<legend>Tarefa</legend>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"acao\" value = \"atualizarTarefa\"/>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"id\" value ="+tarBean.getId()+" />"+ConstantsUtils.PL);
		strBuilder.append("<label>Número</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"number\" name = \"numero\" value ="+tarBean.getNumero()+" />"+ConstantsUtils.PL);
		strBuilder.append("<label>Descricao</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"descricao\" value ="+tarBean.getDescricao()+"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Percentual</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"percentual\" value ="+tarBean.getPercentual()+"/>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"dataInicio\" value ="+tarBean.getDataInicio()+"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Data Fim</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"dataFim\" value ="+tarBean.getDataFim()+"/>"+ConstantsUtils.PL);
		strBuilder.append("<input class=\"btn\" type = \"submit\" value = \"Salvar\"/>"+ConstantsUtils.PL);
		strBuilder.append("</fieldset>"+ConstantsUtils.PL);
		strBuilder.append("</form>"+ConstantsUtils.PL);
		strBuilder.append("</div>"+ConstantsUtils.PL);

		return strBuilder.toString();
	}
	
	public String createFormPessoaNovo() throws IOException {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("<div id=\"cpform\">"+ConstantsUtils.PL);
		strBuilder.append("<form id=\"form\" method = \"POST\"  action = \"TarefaServlet\">"+ConstantsUtils.PL);
		strBuilder.append("<fieldset>"+ConstantsUtils.PL);
		strBuilder.append("<legend>Pessoa</legend>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"acao\" value = \"cadastrarPessoa\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Nome</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"nome\" />"+ConstantsUtils.PL);
		strBuilder.append("<label>Idade</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"number\" name = \"idade\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Endereco</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"endereco\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>E-mail</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"email\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Telefone</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"telefone\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Descrição</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"descricao\"/>"+ConstantsUtils.PL);
		strBuilder.append("<input class=\"btn\" type = \"submit\" value = \"Salvar\"/>"+ConstantsUtils.PL);
		strBuilder.append("</fieldset>"+ConstantsUtils.PL);
		strBuilder.append("</form>"+ConstantsUtils.PL);
		strBuilder.append("</div>"+ConstantsUtils.PL);

		return strBuilder.toString();
	}
	
	public String createFormEtapa() throws IOException {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("<div id=\"cpform\">"+ConstantsUtils.PL);
		strBuilder.append("<form id=\"form\" method = \"POST\"  action = \"TarefaServlet\">"+ConstantsUtils.PL);
		strBuilder.append("<fieldset>"+ConstantsUtils.PL);
		strBuilder.append("<legend>Etapa</legend>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"acao\" value = \"cadastrarEtapa\"/>"+ConstantsUtils.PL);
		strBuilder.append("<label>Descrição</label>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"text\" name = \"descricao\" />"+ConstantsUtils.PL);
		strBuilder.append("<input class=\"btn\" type = \"submit\" value = \"Salvar\"/>"+ConstantsUtils.PL);
		strBuilder.append("</fieldset>"+ConstantsUtils.PL);
		strBuilder.append("</form>"+ConstantsUtils.PL);
		strBuilder.append("</div>"+ConstantsUtils.PL);

		return strBuilder.toString();
	}
	
	public String createFormEtapaTarefa(Integer id, List<EtapaBean> etaList) throws IOException {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("<div id=\"cpform\">"+ConstantsUtils.PL);
		strBuilder.append("<form id=\"form\" method = \"POST\"  action = \"TarefaServlet\">"+ConstantsUtils.PL);
		strBuilder.append("<fieldset>"+ConstantsUtils.PL);
		strBuilder.append("<legend>Adicionar Etapa</legend>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"acao\" value = \"cadastrarEtTa\"/>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"id\" value ="+id+" />"+ConstantsUtils.PL);
		strBuilder.append("<label>Etapa</label>"+ConstantsUtils.PL);
		strBuilder.append("<select name =\"etapaId\">"+ConstantsUtils.PL);
		for(EtapaBean etaBean : etaList) {
			strBuilder.append("<option value="+etaBean.getId()+">"+etaBean.getDescricao()+"</option>"+ConstantsUtils.PL);
		}
		strBuilder.append("</select>"+ConstantsUtils.PL);
		strBuilder.append("<input class=\"btn\" type = \"submit\" value = \"Salvar\"/>"+ConstantsUtils.PL);
		strBuilder.append("</fieldset>"+ConstantsUtils.PL);
		strBuilder.append("</form>"+ConstantsUtils.PL);
		strBuilder.append("</div>"+ConstantsUtils.PL);

		return strBuilder.toString();
	}
	
	public String createFormPessoaTarefa(Integer id, List<PessoaBean> pesList) throws IOException {
		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("<div id=\"cpform\">"+ConstantsUtils.PL);
		strBuilder.append("<form id=\"form\" method = \"POST\"  action = \"TarefaServlet\">"+ConstantsUtils.PL);
		strBuilder.append("<fieldset>"+ConstantsUtils.PL);
		strBuilder.append("<legend>Adicionar Pessoa</legend>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"acao\" value = \"cadastrarPeTa\"/>"+ConstantsUtils.PL);
		strBuilder.append("<input type = \"hidden\" name = \"id\" value ="+id+" />"+ConstantsUtils.PL);
		strBuilder.append("<label>Etapa</label>"+ConstantsUtils.PL);
		strBuilder.append("<select name =\"pessoaId\">"+ConstantsUtils.PL);
		for(PessoaBean pesBean : pesList) {
			strBuilder.append("<option value="+pesBean.getId()+">"+pesBean.getNome()+"</option>"+ConstantsUtils.PL);
		}
		strBuilder.append("</select>"+ConstantsUtils.PL);
		strBuilder.append("<input class=\"btn\" type = \"submit\" value = \"Salvar\"/>"+ConstantsUtils.PL);
		strBuilder.append("</fieldset>"+ConstantsUtils.PL);
		strBuilder.append("</form>"+ConstantsUtils.PL);
		strBuilder.append("</div>"+ConstantsUtils.PL);

		return strBuilder.toString();
	}

}
