package br.com.senaijandira.alunos.util;

public class DateUtil {

    public int convertToInt(String data){

        String[] dataSplit = data.split("/");
        String ano = dataSplit[2];
        String mes = dataSplit[1];
        String dia = dataSplit[0];
        return Integer.parseInt(ano+mes+dia);
    }

}
