/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Consulta;

/**
 *
 * @author MayzaHirose
 */
public class RelatorioConsultasController {
    //private ConsultaController consultaController = new ConsultaController();
    /*private List<Consulta> consultasEmail = new ArrayList<>();
    private List<Consulta> consultaCelular = new ArrayList<>();*/
    private static List<Consulta> consultasDesejadas = new ArrayList<>();
    
    public static List<Consulta> relatoriosEmail(){
        System.out.println("TESTE");
        for(Consulta consulta: ConsultaController.getConsultas()){
            System.out.println("TESTE2222");
            if(PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail() != null){
                consultasDesejadas.add(consulta);
                System.out.println("OK");
            }
        }
    return consultasDesejadas;
    }
    
    public static List<Consulta> relatoriosCelular(){
        for(Consulta consulta: ConsultaController.getConsultas()){
            if(PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null){
                //if(consulta.getDataConsulta())
                    consultasDesejadas.add(consulta);
            }
        }
    return consultasDesejadas;
    }
}
