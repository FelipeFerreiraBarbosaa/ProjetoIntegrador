
package projetointegrador.negocio;

//Classe com utilitários para facilitar o uso do Calendar

import static java.lang.Integer.parseInt;
import java.util.Calendar;

//Autor: Enzo

public class CalendarFactory {
    
    public String CalendarToString (Calendar calendar) {
        
        //Pega um Calendar e retorna um String no formato ddmmyyyy
        
        String dia = "";
        
        if (calendar.get(Calendar.DAY_OF_MONTH) <= 9) {
            dia = "0"+calendar.get(Calendar.DAY_OF_MONTH);
        } else {
            dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
        }
        
        String mes = "";
        if (calendar.get(Calendar.MONTH)+1 <= 9) {
            mes = "0" + (calendar.get(Calendar.MONTH)+1);
        } else {
            mes = calendar.get(Calendar.MONTH) + "";
        }
        
        String dataString = dia + mes + "" + calendar.get(Calendar.YEAR);
        return dataString;        
    }
    
    public int[] StringToDayMonthYear (String date) {
        
        //Recebe uma string no formato ddmmyyyy e retorna um vetor com dia na posição 0, mes na posição 1 e ano na posição 2
            
        int dia = parseInt(date.substring(0, 2));
        int mes = parseInt(date.substring(3, 5)) - 1; //O -1 é importante pois o mês começa do 0 no Calendar, exemplo: 5 é maio, porém no Calendar é 4
        int ano = parseInt(date.substring(6));
        
        int[] dmy = {dia, mes, ano};
        return dmy;
        
    }
    
}
