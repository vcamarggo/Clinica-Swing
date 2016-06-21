package controller;

import java.util.ArrayList;
import java.util.List;
import model.Consulta;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class ConsultaController {

    private static List<Consulta> consultas = new ArrayList<Consulta>();

    /**
     * Adiciona uma consulta para um paciente.
     *
     * @param consulta
     * @return 1 caso consulta com codigo ja existe, 2 caso nao exista o
     * paciente, 0 se tudo OK.
     */
    public static int adicionarConsulta(Consulta consulta) {
        if (getConsultaByCodigo(consulta.getCodigo()) != null) {
            return 1;
        } else if (PacienteController.
                getPacienteByNome(consulta.getPaciente()) == null) {
            return 2;
        } else {
            consultas.add(consulta);
            return 0;
        }
    }

    /**
     * Remove a consulta passada como parametro.
     *
     * @param consulta
     */
    public static void removeConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    /**
     *
     * @return Retorna lista de consultas.
     */
    public static List<Consulta> getConsultas() {
        return consultas;
    }

    /**
     * @param codigo
     * @return A consulta com o codigo passado no parametro.
     */
    public static Consulta getConsultaByCodigo(int codigo) {
        for (Consulta consulta : consultas) {
            if (consulta.getCodigo() == codigo) {
                return consulta;
            }
        }
        return null;
    }

    /**
     * Construtor padrao.
     */
    public ConsultaController() {
    }

}
