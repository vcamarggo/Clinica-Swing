package model;

import enumeration.TipoConvenio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class Paciente {

    /**
     * Construtor padrao.
     */
    public Paciente() {
    }

    private static List<Paciente> pacientes = new ArrayList<Paciente>();

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

    /**
     * Se o paciente nao esta na lista, adiciona.
     *
     * @param paciente
     * @return 1, caso deu tudo certo, 0 caso haja erro.
     */
    public static int adicionarPaciente(Paciente paciente) {
        if (getPacienteByNome(paciente.getNome()) != null) {
            return 0;
        }
        pacientes.add(paciente);
        return 1;
    }

    /**
     * Remove um paciente recebido como parametro.
     *
     * @param paciente
     */
    public static void removePaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    /**
     *
     * @return lista de pacientes da aplicacao.
     */
    public static List<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Procura um paciente na lista atraves do seu nome
     *
     * @param nome
     * @return paciente encontrado.
     */
    public static Paciente getPacienteByNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(nome)) {
                return paciente;
            }
        }
        return null;
    }

    /**
     * Remove informações relacionadas aos dados adicionais do paciente
     *
     * @param paciente
     */
    public static void removeDadosAdicionaisPaciente(Paciente paciente) {
        paciente.setFuma(null);
        paciente.setBebe(null);
        paciente.setColesterol(null);
        paciente.setDiabete(null);
        paciente.setCirurgias(new ArrayList<>());
    }

    /**
     * Remove informações relacionadas ao prontuario do paciente
     *
     * @param paciente
     */
    public static void removeDadosProntuarioPaciente(Paciente paciente) {
        paciente.setDiagnostico(null);
        paciente.setTratamento(null);
        paciente.setSintomas(new ArrayList<>());
    }

    /**
     * Adiciona na lista os pacientes que tem consulta na data solicitada e
     * possuem email cadastrado no sistema.
     *
     * @param dataDesejada
     * @return
     */
    public static List<Consulta> pacientesComEmail(Calendar dataDesejada) {
        List<Consulta> consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : Consulta.getConsultas()) {
            if (consulta.getDataConsulta().compareTo(dataDesejada.getTime()) == 0) {
                if (getPacienteByNome(consulta.getPaciente()).getEmail() != null) {
                    consultasDesejadas.add(consulta);
                }
            }
        }
        return consultasDesejadas;
    }

    /**
     * Adiciona na lista os pacientes que tem consulta na data solicitada e
     * possuem celular cadastrado no sistema.
     *
     * @param dataDesejada
     * @return
     */
    public static List<Consulta> pacientesComCelular(Calendar dataDesejada) {
        List<Consulta> consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : Consulta.getConsultas()) {
            if (consulta.getDataConsulta().compareTo(dataDesejada.getTime()) == 0) {
                if (getPacienteByNome(consulta.getPaciente()).getCelular() != null) {
                    consultasDesejadas.add(consulta);
                }
            }
        }
        return consultasDesejadas;
    }

    /**
     * Método que recebe uma Consulta como parâmetro e retorna true se o
     * paciente possui celular.
     *
     * @param consulta
     * @return
     */
    public static boolean pacientePossuiCelular(Consulta consulta) {
        return getPacienteByNome(consulta.getPaciente()).getCelular() != null;
    }

    /**
     * Método que recebe uma Consulta como parâmetro e retorna true se o
     * paciente possui email.
     *
     * @param consulta
     * @return
     */
    public static boolean pacientePossuiEmail(Consulta consulta) {
        return Paciente.getPacienteByNome(consulta.getPaciente()).getEmail() != null;
    }

}
