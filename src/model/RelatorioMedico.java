/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MayzaHirose
 */
public abstract class RelatorioMedico{
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
