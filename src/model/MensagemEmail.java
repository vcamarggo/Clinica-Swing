package model;

import controller.PacienteController;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class MensagemEmail extends Mensagem {

    /**
     * Método que imprime a mensagem referente ao email
     *
     * @param consulta
     */
    @Override
    public void exibirMensagem(Consulta consulta) {
        System.out.println(" -------------------------");
        System.out.println("|***EMAIL***");
        System.out.println("|De: " + this.getEmailConsultorio());
        System.out.println("|Para: " + PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail());
        System.out.println("|");
        System.out.println("|Ola senhor(a) " + consulta.getPaciente() + ",");
        System.out.println("|A clinica Saude e CIA gostaria de lembra-lo que amanha (" + this.getDateFormat().format(consulta.getDataConsulta())
                + ") o senhor(a) tem uma consulta agendada as " + consulta.getHora() + " com o Doutor(a) " + consulta.getMedico());
        System.out.println("|Qualquer dúvida mande nos um email ou ligue para o telefone " + this.getNumeroConsultorio());
        System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------\n");
    }

}
