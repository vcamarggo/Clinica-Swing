package model;

/**
 *
 * Classe abstrata para criação de relatórios médicos.
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public abstract class RelatorioMedico {

    //Atributos em comum para todos os relatórios.
    private String nomePaciente;
    private String dataConsulta;
    private String assinaturaMedico;

    /**
     * Assinatura de método para preenchimento de dados do relatório
     */
    public abstract void preencheDados();

    /**
     * Assinatura de método para exibição dos dados do relatório.
     *
     * @return relatorioGerado
     */
    public abstract String geraRelatorio();

    /**
     * @return nome do paciente.
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * Seta o nome do paciente do atestado.
     *
     * @param nomePaciente
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    /**
     * @return data da consulta.
     */
    public String getDataConsulta() {
        return dataConsulta;
    }

    /**
     * Seta uma data de consulta.
     *
     * @param dataConsulta
     */
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     * @return assinatura do médico.
     */
    public String getAssinaturaMedico() {
        return assinaturaMedico;
    }

    /**
     * Seta uma assinatura do medico.
     *
     * @param assinaturaMedico
     */
    public void setAssinaturaMedico(String assinaturaMedico) {
        this.assinaturaMedico = assinaturaMedico;
    }
}
