package br.com.curso.tarefa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
    public static final String FORMAT_DATE = "dd/MM/yyyy";

    public static String format(Date data) {
        return format(data, FORMAT_DATE);
    }

    public static String format(Date data, String format) {
        if (data == null) return null;
        String dataStr = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        dataStr = sdf.format(data);

        return dataStr;
    }

    public static Date parse(String dataStr) throws Exception {
        return parse(dataStr, FORMAT_DATE);
    }

    public static Date parse(String dataStr, String format) throws Exception {
        if (dataStr.equals("")) return null;
        Date dataObj = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            dataObj = sdf.parse(dataStr);
        } catch (Exception e) {
            throw new Exception("Erro ao converter a data, por favor verifique.");
        }
        return dataObj;
    }
    
    public static Date getDataAtual() {
    	Date dataAtual = new Date();
    	return dataAtual;
    }

}
