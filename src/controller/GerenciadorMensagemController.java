package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Consulta;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorMensagemController {


    /**
     * Construtor padrao.
     */
    public GerenciadorMensagemController() {
    }

    private static List<Consulta> consultasDoDiaSeguinte;

    /**
     * Método que recebe como parâmetro a data de amanhã e verifica todas as
     * consultas cadastradas. Insere na lista consultasDoDiaSeguinte apenas os
     * pacientes que possuem que tem consulta no dia seguinte.
     *
     * @param dataAmanha
     * @return
     */
    public static List<Consulta> consultasDoDiaSeguinte(Calendar dataAmanha) {
        consultasDoDiaSeguinte = new ArrayList<>();
        //Percorre a lista de Consultas cadastradas
        for (Consulta consulta : ConsultaController.getConsultas()) {
            if (consulta.getDataConsulta().compareTo(dataAmanha.getTime()) == 0) {
                consultasDoDiaSeguinte.add(consulta);
            }
        }
        if (consultasDoDiaSeguinte.isEmpty()) {
            System.out.println("O Consultório nao tem consultas agendadas para amanhã.");
        }
        return consultasDoDiaSeguinte;
    }
    
    /**
     * Método que recebe uma Consulta como parâmetro e retorna true se o paciente possui celular.
     * @param consulta
     * @return 
     */
    public static boolean pacientePossuiCelular(Consulta consulta) {

        if (PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null) {
            return true;
        }
        return false;
        

    }
    
    /**
     * Método que recebe uma consulta como parâmetro e retorna false se o paciente possui email
     * @param consulta
     * @return 
     */
    public static boolean pacientePossuiEmail(Consulta consulta) {
        if (PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail() != null) {
            return true;
        }
        return false;
    }

}
