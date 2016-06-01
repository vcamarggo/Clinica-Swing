/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public static void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
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

}
