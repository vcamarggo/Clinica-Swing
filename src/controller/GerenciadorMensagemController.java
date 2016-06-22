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
     * Método que recebe como parâmetro a data de hoje e verifica todas as
     * consultas cadastradas. Insere na lista apenas os pacientes que possuem
     * email/celular e que tem consulta no dia seguinte
     *
     * @param data
     * @return
     */
    public static List<Consulta> consultasDoDiaSeguinte(Calendar dataAmanha) {
        consultasDoDiaSeguinte = new ArrayList<>();
        //Percorre a lista de Consultas cadastradas
        for (Consulta consulta : ConsultaController.getConsultas()) {
            //Pega as consultas do dia seguinte em que o paciente tem celular/email põe na lista de consultas;
            if (consulta.getDataConsulta().compareTo(dataAmanha.getTime()) == 0) {
                /*if (((PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null)
                        || (PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail() != null))) {
                    //&& (consulta.getDataConsulta().compareTo(data) == 0)) {

                    consultasDoDiaSeguinte.add(consulta);
                } else {
                    System.out.println("Há uma consulta mas o paciente não possui celular/email");
                }*/
            consultasDoDiaSeguinte.add(consulta);
            }
        }
        if (consultasDoDiaSeguinte.isEmpty()) {
            System.err.println("O Consultório nao tem consultas agendadas para esta data");
        }

        return consultasDoDiaSeguinte;
    }

    public static boolean pacientePossuiCelular(Consulta consulta) {

        if (PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null) {
            return true;
        }
        return false;
    }
    
    public static boolean pacientePossuiEmail(Consulta consulta){
        if(PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail() != null){
            return true;
        }
        return false;
    }

}
