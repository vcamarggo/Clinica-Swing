package model;

import enumeration.TipoConsulta;
import java.util.Date;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class Consulta {

    private int codigo;
    private Date dataConsulta;
    private String hora;
    private String medico;
    private String paciente;
    private TipoConsulta tipoConsulta;

    /**
     * PREENCHER AQUI!
     *
     * @return
     */
    public Date getDataConsulta() {
        return dataConsulta;
    }

    /**
     * PREENCHER AQUI!
     *
     * @param dataConsulta
     */
    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     * PREENCHER AQUI!
     *
     * @return
     */
    public String getHora() {
        return hora;
    }

    /**
     * PREENCHER AQUI!
     *
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * PREENCHER AQUI!
     *
     * @return
     */
    public String getMedico() {
        return medico;
    }

    /**
     * PREENCHER AQUI!
     *
     * @param medico
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }

    /**
     * PREENCHER AQUI!
     *
     * @return
     */
    public String getPaciente() {
        return paciente;
    }

    /**
     * PREENCHER AQUI!
     *
     * @param paciente
     */
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    /**
     * PREENCHER AQUI!
     *
     * @return
     */
    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    /**
     * PREENCHER AQUI!
     *
     * @param tipoConsulta
     */
    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    /**
     * PREENCHER AQUI!
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * PREENCHER AQUI!
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Construtor padrao.
     */
    public Consulta() {
    }

}
