/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 *
 * @author Camargo
 */
public abstract class Usuario {

    private static final long serialVersionUID = 1L;

    protected static EntityManager entityManager = Persistence.createEntityManagerFactory("PU").createEntityManager();

    public List<Paciente> listaPacientes() {
        return entityManager.createQuery(
                new StringBuilder("SELECT ob FROM Paciente  ob ")
                .toString(),
                Paciente.class).getResultList();
    }

    public List<Consulta> listaConsultas() {
        return entityManager.createQuery(
                new StringBuilder("SELECT ob FROM Consulta  ob ")
                .toString(),
                Consulta.class).getResultList();
    }

    protected void remove(Object entidade) {
        entidade = entityManager.merge(entidade);
        entityManager.getTransaction().begin();
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();
    }

    protected void atualiza(Object entidade) {
        entityManager.getTransaction().begin();
        entityManager.merge(entidade);
        entityManager.getTransaction().commit();
    }

    protected void adiciona(Object entidade) {
        entityManager.getTransaction().begin();
        entityManager.persist(entidade);
        entityManager.setFlushMode(FlushModeType.COMMIT);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void atualizaPaciente(Paciente paciente) {
        atualiza(paciente);
    }

    /**
     * Método que recebe uma Consulta como parâmetro e retorna true se o
     * paciente possui celular.
     *
     * @param consulta
     * @return
     */
    public boolean pacientePossuiCelular(Consulta consulta) {
        return consulta.getPaciente().getCelular() != null;
    }

    /**
     * Método que recebe uma Consulta como parâmetro e retorna true se o
     * paciente possui email.
     *
     * @param consulta
     * @return
     */
    public boolean pacientePossuiEmail(Consulta consulta) {
        return consulta.getPaciente().getEmail() != null;
    }

}
