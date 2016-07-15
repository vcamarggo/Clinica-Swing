package model;

import enumeration.TipoConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class Consulta {

    private int codigo;
    private Date dataConsulta;
    private String hora;
    private String medico;
    private Paciente paciente;
    private TipoConsulta tipoConsulta;

    /**
     *
     * @return data da consulta
     */
    public Date getDataConsulta() {
        return dataConsulta;
    }

    /**
     * atribui uma data à consulta
     *
     * @param dataConsulta
     */
    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     *
     * @return hora da consulta
     */
    public String getHora() {
        return hora;
    }

    /**
     * atribui hora à consulta
     *
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     *
     * @return medico responsável
     */
    public String getMedico() {
        return medico;
    }

    /**
     * atribui o médico responsável pela consulta
     *
     * @param medico
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }

    /**
     *
     * @return paciente relacionado à consulta
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * atribui um paciente à consulta
     *
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     *
     * @return tipo de consulta
     */
    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    /**
     * atribui um tipo de consulta
     *
     * @param tipoConsulta
     */
    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    /**
     *
     * @return código da consulta
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * atribui um código à consulta
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

    private static List<Consulta> consultas = new ArrayList<Consulta>();

    /**
     *
     * @return Retorna lista de consultas.
     */
    public static List<Consulta> getConsultas() {
        return consultas;
    }

}
