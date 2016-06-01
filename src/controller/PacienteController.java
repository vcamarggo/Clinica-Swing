package controller;

import java.util.ArrayList;
import java.util.List;
import model.Paciente;

/**
 *
 * @author Camargo
 */
public class PacienteController {

    private static List<Paciente> pacientes = new ArrayList<Paciente>();

    public static int adicionarPaciente(Paciente paciente) {
        if (getPacienteByNome(paciente.getNome()) == null) {
            return 0;
        }
        pacientes.add(paciente);
        return 1;
    }

    public static void removePaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public static List<Paciente> getPacientes() {
        return pacientes;
    }

    public static Paciente getPacienteByNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(nome)) {
                return paciente;
            }
        }
        return null;
    }

    public PacienteController() {
    }

}
