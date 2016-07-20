/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Camargo
 */
public class Util {

    public static Date geraDataString(String data) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String geraDataDate(Date data) {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

}
