/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Camargo
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
