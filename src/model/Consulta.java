package model;

import enumeration.TipoConsulta;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import util.Util;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private Date dataConsulta;
    private String hora;
    private String medico;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;

    public Consulta(Long codConsulta, Date dataConsulta, String hora, String medico, Paciente paciente, TipoConsulta tipoConsulta) {
        this.codigo = codConsulta;
        this.dataConsulta = dataConsulta;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.tipoConsulta = tipoConsulta;
    }

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
    public Long getCodigo() {
        return codigo;
    }

    /**
     * atribui um código à consulta
     *
     * @param codigo
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return data de consulta como string.
     */
    public String getDataConsultaString() {
        return Util.geraDataDate(dataConsulta);
    }

    /**
     * Construtor padrao.
     */
    public Consulta() {
    }

}
