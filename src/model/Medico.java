package model;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class Medico extends Usuario {

    /**
     * Remove informações relacionadas aos dados adicionais do paciente
     *
     * @param paciente
     */
    public void removeDadosAdicionaisPaciente(Paciente paciente) {
        // Colocar isso no MedicoController
        paciente.removeDadosAdicionaisPaciente();
        atualizaPaciente(paciente);
    }

    /**
     * Remove informações relacionadas ao prontuario do paciente
     *
     * @param paciente
     */
    public void removeDadosProntuarioPaciente(Paciente paciente) {
        paciente.removeDadosProntuarioPaciente();
        atualizaPaciente(paciente);
    }
}
