package model;

import enumeration.TipoConvenio;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import util.Util;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
@Entity
public class Paciente implements Serializable {

    /**
     * Construtor padrao.
     */
    public Paciente() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rg;
    private String nome;
    private Date dataNascimento;
    private String endereco;
    private String telefone;
    private String celular;
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoConvenio tipoConvenio;

    private Boolean fuma;
    private Boolean bebe;
    private Boolean colesterol;
    private Boolean diabete;
    private String diagnostico;
    private String tratamento;
    private String cirurgias;
    private String alergias;
    private String sintomas;

    public Paciente(Long rg, String nome, Date dataNascimento, String endereco, String telefone, String celular, String email, TipoConvenio tipoConvenio) {
        this.rg = rg;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.tipoConvenio = tipoConvenio;
    }

    /**
     * @return nome do paciente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta um nome para o paciente.
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return data de nascimento.
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @return data de nascimento.
     */
    public String getDataNascimentoString() {
        return Util.geraDataDate(dataNascimento);
    }

    /**
     * Seta uma data de nascimento para o paciente.
     *
     * @param dataNascimento
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return endereco do paciente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Seta um endereço para o paciente.
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return tipo de convenio do paciente.
     */
    public TipoConvenio getTipoConvenio() {
        return tipoConvenio;
    }

    /**
     * Seta um tipo de convenio para o paciente.
     *
     * @param tipoConvenio
     */
    public void setTipoConvenio(TipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    /**
     *
     * @return telefone do paciente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Seta um telefone para o paciente.
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return celular do paciente.
     */
    public String getCelular() {
        if (celular.equals("")) {
            return null;
        }
        return celular;
    }

    /**
     * Seta um celular para o paciente.
     *
     * @param celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     *
     * @return email do paciente.
     */
    public String getEmail() {
        if (email.equals("")) {
            return null;
        }
        return email;
    }

    /**
     * Seta um email para o paciente.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return booleano se o paciente fuma.
     */
    public Boolean getFuma() {
        return fuma;
    }

    /**
     * Seta se paciente fuma.
     *
     * @param fuma
     */
    public void setFuma(Boolean fuma) {
        this.fuma = fuma;
    }

    /**
     *
     * @return booleano se paciente bebe
     */
    public Boolean getBebe() {
        return bebe;
    }

    /**
     * Seta se paciente bebe.
     *
     * @param bebe
     */
    public void setBebe(Boolean bebe) {
        this.bebe = bebe;
    }

    /**
     *
     * @return booleano se paciente tem colesterol.
     */
    public Boolean getColesterol() {
        return colesterol;
    }

    /**
     * Seta se paciente tem colesterol.
     *
     * @param colesterol
     */
    public void setColesterol(Boolean colesterol) {
        this.colesterol = colesterol;
    }

    /**
     *
     * @return booleano se paciente tem diabetes.
     */
    public Boolean getDiabete() {
        return diabete;
    }

    /**
     * Seta se paciente tem diabetes.
     *
     * @param diabete
     */
    public void setDiabete(Boolean diabete) {
        this.diabete = diabete;
    }

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    /**
     *
     * @return diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * seta diagnostico
     *
     * @param diagnostico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     *
     * @return tratamento
     */
    public String getTratamento() {
        return tratamento;
    }

    /**
     * seta tratamento
     *
     * @param tratamento
     */
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    /**
     * Remove informações relacionadas aos dados adicionais do paciente
     *
     */
    public void removeDadosAdicionaisPaciente() {
        setFuma(null);
        setBebe(null);
        setColesterol(null);
        setDiabete(null);
        setCirurgias(null);
    }

    /**
     * Remove informações relacionadas ao prontuario do paciente
     *
     */
    public void removeDadosProntuarioPaciente() {
        setDiagnostico(null);
        setTratamento(null);
        setSintomas(null);
    }

    @Override
    public String toString() {
        return getNome();
    }

}
