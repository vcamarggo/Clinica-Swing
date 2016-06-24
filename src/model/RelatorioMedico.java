package model;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo 
 */

/** Classe abstrata para criação de relatórios médicos. 
 * Os relatórios de consultas não possui tipos (atestado,
 * receita, etc), por isso nao foi criada uma classe modelo só para ela.
 */
public abstract class RelatorioMedico {

    private String nomePaciente;
    private String dataConsulta;
    private String assinaturaMedico;

    public abstract void preencheDados();

    public abstract void exibeRelatorio();

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getAssinaturaMedico() {
        return assinaturaMedico;
    }

    public void setAssinaturaMedico(String assinaturaMedico) {
        this.assinaturaMedico = assinaturaMedico;
    }
}
