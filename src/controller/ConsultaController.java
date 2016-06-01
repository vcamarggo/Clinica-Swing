package controller;

import java.util.ArrayList;
import java.util.List;
import model.Consulta;

/**
 *
 * @author Camargo
 */
public class ConsultaController {

    private static List<Consulta> consultas = new ArrayList<Consulta>();

    public static int adicionarConsulta(Consulta consulta) {
        if (getConsultaByCodigo(consulta.getCodigo()) != null) {
            return 1;
        } else if (PacienteController.
                getPacienteByNome(consulta.getPaciente()) != null) {
            return 2;
        } else {
            consultas.add(consulta);
            return 0;
        }
    }

    public static void removeConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    public static List<Consulta> getConsultas() {
        return consultas;
    }

    public static Consulta getConsultaByCodigo(int codigo) {
        for (Consulta consulta : consultas) {
            if (consulta.getCodigo() == codigo) {
                return consulta;
            }
        }
        return null;
    }

    public ConsultaController() {
    }

}
