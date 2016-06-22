/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author MayzaHirose
 */
public abstract class Mensagem {
    
    private static final String NUMERO_CONSULTORIO =  "(44) 3034-0608";
    private static final String CELULAR_CONSULTORIO = "(44) 9809-6677";
    private static final String EMAIL_CONSULTORIO = "saudeecia@gmail.com";
    private static final DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    
    public String getNumeroConsultorio(){
        return NUMERO_CONSULTORIO;
    }
    
    public String getCelularConsultorio(){
        return CELULAR_CONSULTORIO;
    }
    
    public String getEmailConsultorio(){
        return EMAIL_CONSULTORIO;
    }
    
    public DateFormat getDateFormat(){
        return formatter;
    }
    
    public abstract void ExibirMensagem(Consulta consulta);
}