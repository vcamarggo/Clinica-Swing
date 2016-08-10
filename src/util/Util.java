package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Camargo / Hirose / Carvalho
 */
public class Util {

    public static Date geraDataString(String data) throws ParseException {
        return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(data).getTime());
    }

    public static String geraDataDate(Date data) {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public static int retornaValorParaCampoBoxSimNao( Boolean campo ){
        if (campo == null || !campo ){
            return 0;
        }
        return 1;
    }

}
