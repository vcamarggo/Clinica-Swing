package model;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class MensagemEmail extends GerenciadorMensagem {

    /**
     * Método que imprime a mensagem referente ao email
     *
     * @param consulta
     * @return mensagemEmail
     */
    @Override
    public String gerarMensagem(Consulta consulta) {
        StringBuilder sb = new StringBuilder();
        sb.append(" -------------------------");
        sb.append("\n|***EMAIL***");
        sb.append("\n|De: ").append(this.getEmailConsultorio());
        sb.append("\n|Para: ").append(consulta.getPaciente().getEmail());
        sb.append("\n|");
        sb.append("\n|Ola senhor(a) ").append(consulta.getPaciente()).append(",");
        sb.append("\n|A clinica Saude e CIA gostaria de lembra-lo que amanha (")
                .append(this.getDateFormat().format(consulta.getDataConsulta()))
                .append(") o senhor(a) \n|tem uma consulta agendada as ")
                .append(consulta.getHora()).append(" com o Doutor(a) ")
                .append(consulta.getMedico());
        sb.append("\n|Qualquer dúvida mande nos um email ou ligue para o telefone ")
                .append(this.getNumeroConsultorio());
        sb.append("\n --------------------------------------------\n");
        return sb.toString();
    }

}
