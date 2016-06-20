package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Consulta;

/**
 *
 * @author guest-xc8RJZ
 */
public class GerenciadorMensagemController {

    private static List<Consulta> consultasDoDia = new ArrayList<>();

    public static List<Consulta> consultasDoDia(Date data) {
        for (Consulta consulta : ConsultaController.getConsultas()) {
            //pega as consultas em que o paciente tem celular/email e põe na lista de consultas;
            if (((PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null) || (PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail()!= null)) && (consulta.getDataConsulta().compareTo(data) == 0)) {

                consultasDoDia.add(consulta);
            } else {
                System.out.println("O paciente não possui celular/email");
            }
        }

        return consultasDoDia;
    }

}
