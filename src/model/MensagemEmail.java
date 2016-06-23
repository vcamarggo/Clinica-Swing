package model;

import controller.PacienteController;

/**
 *
 * @author MayzaHirose
 */
public class MensagemEmail extends Mensagem {

    /**
     * Método que imprime a mensagem referente ao email 
     * @param consulta 
     */
    @Override
    public void ExibirMensagem(Consulta consulta) {
        System.out.println("\n***EMAIL***");
        System.out.println("De: " + this.getEmailConsultorio());
        System.out.println("Para: " + PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail());
        System.out.println("\nOla senhor(a) " + consulta.getPaciente() + ",");
        System.out.println("A clinica Saude e CIA gostaria de lembra-lo que amanha (" + this.getDateFormat().format(consulta.getDataConsulta()) + ") o senhor(a) tem uma consulta as " + consulta.getHora() + " com o Doutor(a) " + consulta.getMedico());
        System.out.println("Qualquer dúvida mande nos um email ou ligue para o telefone " + this.getNumeroConsultorio() + "\n");
    }

}
