/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Camargo
 */
public class Secretaria extends Usuario {

    /**
     * Remove um paciente recebido como parametro.
     *
     * @param paciente
     */
    public void removePaciente(Paciente paciente) {
        remove(paciente);
    }

    /**
     * Adiciona um paciente recebido como parametro.
     *
     * @param paciente
     */
    public void adicionaPaciente(Paciente paciente) {
        adiciona(paciente);
    }

    /**
     * Adiciona na lista os pacientes que tem consulta na data solicitada e
     * possuem email cadastrado no sistema.
     *
     * @param dataDesejada
     * @return
     */
    public List<Consulta> getConsultasDataDesejadaParaPacientesComEmail(Calendar dataDesejada) {
        Query q = entityManager.createQuery(
                new StringBuilder("SELECT c FROM Consulta c WHERE"
                        + " c.paciente.email IS NOT NULL AND c.dataConsulta = :dataDesejada")
                .toString(),
                Consulta.class);
        q.setParameter("dataDesejada", dataDesejada.getTime());
        return q.getResultList();
    }

    /**
     * Adiciona na lista os pacientes que tem consulta na data solicitada e
     * possuem celular cadastrado no sistema.
     *
     * @param dataDesejada
     * @return
     */
    public List<Consulta> getConsultasDataDesejadaParaPacientesComCelular(Calendar dataDesejada) {
        Query q = entityManager.createQuery(
                new StringBuilder("SELECT c FROM Consulta c WHERE"
                        + " c.paciente.celular IS NOT NULL AND dataConsulta = :dataDesejada")
                .toString(),
                Consulta.class);
        q.setParameter("dataDesejada", dataDesejada.getTime());
        return q.getResultList();
    }

    /**
     * Adiciona uma consulta para um paciente.
     *
     * @param consulta
     */
    public void adicionaConsulta(Consulta consulta) {
        adiciona(consulta);
    }

    /**
     * Remove a consulta passada como parametro.
     *
     * @param consulta
     */
    public void removeConsulta(Consulta consulta) {
        remove(consulta);
    }

    /**
     * @param codigo
     * @return A consulta com o codigo passado no parametro.
     */
    public Consulta
            getConsultaByCodigo(int codigo) {
        return entityManager.find(Consulta.class, codigo);
    }

    /**
     * Método que recebe como parâmetro a data de amanhã e verifica todas as
     * consultas cadastradas no sistema. Insere na lista consultasDoDiaSeguinte
     * apenas os pacientes que tem consulta nesta data recebida.
     *
     * @return consultasDeAmanha
     */
    public List<Consulta> listaConsultasDeAmanha() {
        Query q = entityManager.createQuery(
                new StringBuilder("SELECT ob FROM Consulta ob where dataConsulta = :dataAmanha")
                .toString(),
                Consulta.class
        );
        Calendar dataAmanha = Calendar.getInstance();
        dataAmanha.add(Calendar.DAY_OF_MONTH, 1);
        q.setParameter("dataAmanha", dataAmanha.getTime());
        return q.getResultList();
    }

}
