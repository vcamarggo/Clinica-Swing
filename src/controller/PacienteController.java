package controller;

import java.util.ArrayList;
import java.util.List;
import model.Paciente;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class PacienteController {

    private static List<Paciente> pacientes = new ArrayList<Paciente>();

    /**
     * Se o paciente nao esta na lista, adiciona.
     *
     * @param paciente
     * @return 1, caso deu tudo certo, 0 caso haja erro.
     */
    public static int adicionarPaciente(Paciente paciente) {
        if (getPacienteByNome(paciente.getNome()) != null) {
            return 0;
        }
        pacientes.add(paciente);
        return 1;
    }

    /**
     * Remove um paciente recebido como parametro.
     *
     * @param paciente
     */
    public static void removePaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    /**
     *
     * @return lista de pacientes da aplicacao.
     */
    public static List<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Procura um paciente na lista atraves do seu nome
     *
     * @param nome
     * @return paciente encontrado.
     */
    public static Paciente getPacienteByNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(nome)) {
                return paciente;
            }
        }
        return null;
    }

    /**
     * Remove informações relacionadas aos dados adicionais do paciente
     * @param paciente
     */
    public static void removeDadosAdicionaisPaciente(Paciente paciente) {
        paciente.setFuma(null);
        paciente.setBebe(null);
        paciente.setColesterol(null);
        paciente.setDiabete(null);
        paciente.setCirurgias(new ArrayList<>());
    }
    
    
    /**
     * Remove informações relacionadas ao prontuario do paciente
     * @param paciente 
     */
    public static void removeDadosProntuarioPaciente(Paciente paciente) {
        paciente.setDiagnostico(null);
        paciente.setTratamento(null);
        paciente.setSintomas(new ArrayList<>());
    }

    /**
     * Construtor padrao.
     */
    public PacienteController() {
    }

}
