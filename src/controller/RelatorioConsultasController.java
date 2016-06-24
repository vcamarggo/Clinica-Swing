package controller;

import java.util.ArrayList;
import java.util.Calendar;
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
     * Adiciona na lista os pacientes que possuem email cadastrado no sistema e que tem consulta na data solicitada
     *
     * @param dataDesejada
     * @return
     */
    public static List<Consulta> pacientesComEmail(Calendar dataDesejada) {
        consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : ConsultaController.getConsultas()) {
            if(consulta.getDataConsulta().compareTo(dataDesejada.getTime()) == 0){
                if (PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail() != null) {
                    consultasDesejadas.add(consulta);            
                }
            }
        }
        return consultasDesejadas;
    }

    /**
     * Adiciona na lista os pacientes que possuem celular cadastrado no sistema e que tem consulta na data solicitda
     *
     * @param dataDesejada
     * @return
     */
    public static List<Consulta> pacientesComCelular(Calendar dataDesejada) {
        consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : ConsultaController.getConsultas()) {
            if(consulta.getDataConsulta().compareTo(dataDesejada.getTime()) == 0){
                if (PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null) {
                    consultasDesejadas.add(consulta);
                }
            }
        }
        return consultasDesejadas;
    }
}
