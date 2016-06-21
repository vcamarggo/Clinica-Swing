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
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class RelatorioConsultasController {
    private static List<Consulta> consultasDesejadas;

    /**
     * Construtor padrao.
     */
    public RelatorioConsultasController() {
    }

    /**
     * Adiciona na lista os pacientes que possuem email cadastrado no sistema
     *
     * @return
     */
    public static List<Consulta> pacientesComEmail() {
        consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : ConsultaController.getConsultas()) {
            if (PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail() != null) {
                consultasDesejadas.add(consulta);            
            }
        }
        return consultasDesejadas;
    }

    /**
     * Adiciona na lista os pacientes que possuem celular cadastrado no sistema
     *
     * @return
     */
    public static List<Consulta> pacientesComCelular() {
        consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : ConsultaController.getConsultas()) {
            if (PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null) {
                //if(consulta.getDataConsulta())
                consultasDesejadas.add(consulta);
            }
        }
        return consultasDesejadas;
    }
}
