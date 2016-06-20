package model;

import enumeration.TipoConvenio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author V.Camargo
 */
public class Paciente {

    private String nome;
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
    private List<String> cirurgias = new ArrayList<>();
    private List<String> alergias = new ArrayList<>();
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoConvenio getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(TipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

     public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        if(celular.equals(""))
            return null;
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        if(email.equals(""))
            return null;
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFuma() {
        return fuma;
    }

    public void setFuma(Boolean fuma) {
        this.fuma = fuma;
    }

    public Boolean getBebe() {
        return bebe;
    }

    public void setBebe(Boolean bebe) {
        this.bebe = bebe;
    }

    public Boolean getColesterol() {
        return colesterol;
    }

    public void setColesterol(Boolean colesterol) {
        this.colesterol = colesterol;
    }

    public Boolean getDiabete() {
        return diabete;
    }

    public void setDiabete(Boolean diabete) {
        this.diabete = diabete;
    }

    public List<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(List<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }    
    
}
