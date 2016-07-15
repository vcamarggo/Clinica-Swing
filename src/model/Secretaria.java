/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        Paciente.getPacientes().remove(paciente);
    }

    /**
     * Se o paciente nao esta na lista, adiciona.
     *
     * @param paciente
     * @return 1, caso deu tudo certo, 0 caso haja erro.
     */
    public int adicionarPaciente(Paciente paciente) {
        if (getPacienteByNome(paciente.getNome()) != null) {
            return 0;
        }
        Paciente.getPacientes().add(paciente);
        return 1;
    }

    /**
     * Adiciona na lista os pacientes que tem consulta na data solicitada e
     * possuem email cadastrado no sistema.
     *
     * @param dataDesejada
     * @return
     */
    public List<Consulta> getConsultasDataDesejadaParaPacientesComEmail(Calendar dataDesejada) {
        List<Consulta> consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : Consulta.getConsultas()) {
            if (consulta.getDataConsulta().compareTo(dataDesejada.getTime()) == 0) {
                if (consulta.getPaciente().getEmail() != null) {
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
    public List<Consulta> getConsultasDataDesejadaParaPacientesComCelular(Calendar dataDesejada) {
        List<Consulta> consultasDesejadas = new ArrayList<>();
        for (Consulta consulta : Consulta.getConsultas()) {
            if (consulta.getDataConsulta().compareTo(dataDesejada.getTime()) == 0) {
                if (consulta.getPaciente().getCelular() != null) {
                    consultasDesejadas.add(consulta);
                }
            }
        }
        return consultasDesejadas;
    }

    /**
     * Adiciona uma consulta para um paciente.
     *
     * @param consulta
     * @return 1 caso consulta com codigo ja existe, 2 caso nao exista o
     * paciente, 0 se tudo OK.
     */
    public int adicionarConsulta(Consulta consulta) {
        if (getConsultaByCodigo(consulta.getCodigo()) != null) {
            return 1;
        } else if (consulta.getPaciente() == null) {
            return 2;
        } else {
            Consulta.getConsultas().add(consulta);
            return 0;
        }
    }

    /**
     * Remove a consulta passada como parametro.
     *
     * @param consulta
     */
    public void removeConsulta(Consulta consulta) {
        Consulta.getConsultas().remove(consulta);
    }

    /**
     * @param codigo
     * @return A consulta com o codigo passado no parametro.
     */
    public Consulta getConsultaByCodigo(int codigo) {
        for (Consulta consulta : Consulta.getConsultas()) {
            if (consulta.getCodigo() == codigo) {
                return consulta;
            }
        }
        return null;
    }

    /**
     * Método que recebe como parâmetro a data de amanhã e verifica todas as
     * consultas cadastradas no sistema. Insere na lista consultasDoDiaSeguinte
     * apenas os pacientes que tem consulta nesta data recebida.
     *
     * @param dataAmanha
     * @return
     */
    public List<Consulta> consultasDoDiaSeguinte(Calendar dataAmanha) {
        List<Consulta> consultasDoDiaSeguinte = new ArrayList<>();
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
