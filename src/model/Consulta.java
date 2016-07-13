package model;

import enumeration.TipoConsulta;
import java.util.ArrayList;
import java.util.Calendar;
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
    private String paciente;
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
    public String getPaciente() {
        return paciente;
    }

    /**
     * atribui um paciente à consulta
     *
     * @param paciente
     */
    public void setPaciente(String paciente) {
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
     * Adiciona uma consulta para um paciente.
     *
     * @param consulta
     * @return 1 caso consulta com codigo ja existe, 2 caso nao exista o
     * paciente, 0 se tudo OK.
     */
    public static int adicionarConsulta(Consulta consulta) {
        if (getConsultaByCodigo(consulta.getCodigo()) != null) {
            return 1;
        } else if (Paciente.
                getPacienteByNome(consulta.getPaciente()) == null) {
            return 2;
        } else {
            consultas.add(consulta);
            return 0;
        }
    }

    /**
     * Remove a consulta passada como parametro.
     *
     * @param consulta
     */
    public static void removeConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    /**
     *
     * @return Retorna lista de consultas.
     */
    public static List<Consulta> getConsultas() {
        return consultas;
    }

    /**
     * @param codigo
     * @return A consulta com o codigo passado no parametro.
     */
    public static Consulta getConsultaByCodigo(int codigo) {
        for (Consulta consulta : consultas) {
            if (consulta.getCodigo() == codigo) {
                return consulta;
            }
        }
        return null;
    }

    private static List<Consulta> consultasDoDiaSeguinte;

    /**
     * Método que recebe como parâmetro a data de amanhã e verifica todas as
     * consultas cadastradas no sistema. Insere na lista consultasDoDiaSeguinte
     * apenas os pacientes que tem consulta nesta data recebida.
     *
     * @param dataAmanha
     * @return
     */
    public static List<Consulta> consultasDoDiaSeguinte(Calendar dataAmanha) {
        consultasDoDiaSeguinte = new ArrayList<>();
        //Percorre a lista de Consultas cadastradas
        for (Consulta consulta : Consulta.getConsultas()) {
            if (consulta.getDataConsulta().compareTo(dataAmanha.getTime()) == 0) {
                consultasDoDiaSeguinte.add(consulta);
            }
        }
        if (consultasDoDiaSeguinte.isEmpty()) {
            System.out.println("*O Consultório nao tem consultas agendadas para amanhã.\n");
        }
        return consultasDoDiaSeguinte;
    }

   

}
