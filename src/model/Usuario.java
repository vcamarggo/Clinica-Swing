package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public abstract class Usuario {

    private static final long serialVersionUID = 1L;

    protected static EntityManager entityManager = Persistence.createEntityManagerFactory("PU").createEntityManager();

    /**
     *  Lista todas os pacientes
     * @return pacientes
     */
    public List<Paciente> listaPacientes() {
        return entityManager.createQuery(
                new StringBuilder("SELECT ob FROM Paciente  ob ")
                .toString(),
                Paciente.class).getResultList();
    }

     /**
     *  Lista todas as consultas
     * @return consultas
     */
    public List<Consulta> listaConsultas() {
        return entityManager.createQuery(
                new StringBuilder("SELECT ob FROM Consulta  ob ")
                .toString(),
                Consulta.class).getResultList();
    }

     /**
     *  Remove um objeto passado como parâmetro
     * @param entidade 
     */
    protected void remove(Object entidade) {
        entidade = entityManager.merge(entidade);
        entityManager.getTransaction().begin();
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();
    }

    /**
     *  Dá merge em um objeto passado como parâmetro
     * @param entidade 
     */
    protected void atualiza(Object entidade) {
        entityManager.getTransaction().begin();
        entityManager.merge(entidade);
        entityManager.getTransaction().commit();
    }

     /**
     *  Commita um objeto passado como parâmetro
     * @param entidade 
     */
    protected void adiciona(Object entidade) {
        entityManager.getTransaction().begin();
        entityManager.merge(entidade);
        entityManager.setFlushMode(FlushModeType.COMMIT);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    /**
     * Atualiza um paciente passado como parâmetro
     * @param paciente
     */
    public void atualizaPaciente(Paciente paciente) {
        atualiza(paciente);
    }

    /**
     * Método que recebe uma Consulta como parâmetro e retorna true se o
     * paciente possui celular.
     *
     * @param consulta
     * @return indicacao se paciente possui celular
     */
    public boolean pacientePossuiCelular(Consulta consulta) {
        return consulta.getPaciente().getCelular() != null;
    }

    /**
     * Método que recebe uma Consulta como parâmetro e retorna true se o
     * paciente possui email.
     *
     * @param consulta
     * @return indicacao se paciente possui email
     */
    public boolean pacientePossuiEmail(Consulta consulta) {
        return consulta.getPaciente().getEmail() != null;
    }

    /**
     * @param codigo
     * @return A consulta com o codigo passado no parametro.
     */
    public Consulta
            getConsultaByCodigo(Long codigo) {
        return entityManager.find(Consulta.class, codigo);
    }

    /**
     * @param rg
     * @return O paciente com o codigo passado no parametro.
     */
    public Paciente
            getPacienteByRG(Long rg) {
        return entityManager.find(Paciente.class, rg);
    }

}
