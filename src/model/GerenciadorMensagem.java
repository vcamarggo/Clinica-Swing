package model;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import static model.Usuario.entityManager;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorMensagem extends Usuario {

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
                        + " coalesce(c.paciente.email, '') <> '' AND c.dataConsulta = :dataDesejada")
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
                        + "  coalesce(c.paciente.celular, '') <> '' AND dataConsulta = :dataDesejada")
                .toString(),
                Consulta.class);
        q.setParameter("dataDesejada", dataDesejada.getTime());
        return q.getResultList();
    }
}
