package model;

import enumeration.TipoConvenio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    private Long id;
    private String nome;
    @Temporal(value = TemporalType.DATE)
    private Date dataNascimento;
    private String endereco;
    private String telefone;
    private String celular;
    private String email;
    private TipoConvenio tipoConvenio;

    private Boolean fuma;
    private Boolean bebe;
    private Boolean colesterol;
    private Boolean diabete;
    private String diagnostico;
    private String tratamento;
    private List<String> cirurgias = new ArrayList<>();
    private List<String> alergias = new ArrayList<>();
    private List<String> sintomas = new ArrayList<>();

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

    /**
     *
     * @return lista de cirurgias que foram feitas no paciente
     */
    public List<String> getCirurgias() {
        return cirurgias;
    }

    /**
     * seta lista cirurgias que ja foram feitas no paciente
     *
     * @param cirurgias
     */
    public void setCirurgias(List<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    /**
     *
     * @return lista de alergia
     */
    public List<String> getAlergias() {
        return alergias;
    }

    /**
     * seta lista de alergias
     *
     * @param alergias
     */
    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
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

    /**
     *
     * @return lista de sintomas
     */
    public List<String> getSintomas() {
        return sintomas;
    }

    /**
     * seta lista de sintomas
     *
     * @param sintomas
     */
    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
