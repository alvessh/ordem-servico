package br.com.curso.tarefa.utils;

import java.util.ArrayList;
import java.util.List;

public class FiltroUtils {

	List<String> colunaLista = new ArrayList<String>();
    List<CondicaoUtils> condicaoLista = new ArrayList<CondicaoUtils>();
    List<Object> valorLista = new ArrayList<Object>();

    public String criarCondicao(){
        StringBuilder sb = new StringBuilder();

        for (int i =0; i < colunaLista.size(); i++){
            String coluna = colunaLista.get(i);
            CondicaoUtils conUtils = condicaoLista.get(i);
            sb.append(" AND " + coluna + " " + conUtils.get() + " " + valorLista.get(i));
        }

        return sb.toString();
    }

    public void adicionar(String coluna, CondicaoUtils conUtils, Object valor){
        colunaLista.add(coluna);
        condicaoLista.add(conUtils);
        valorLista.add(valor);
    }
}
