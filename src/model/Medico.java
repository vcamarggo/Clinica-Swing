/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.pojo.Paciente;

/**
 *
 * @author Camargo
 */
public class Medico extends Usuario {

    /**
     * Remove informações relacionadas aos dados adicionais do paciente
     *
     * @param paciente
     */
    public void removeDadosAdicionaisPaciente(Paciente paciente) {
        paciente.setFuma(null);
        paciente.setBebe(null);
        paciente.setColesterol(null);
        paciente.setDiabete(null);
//        paciente.setCirurgias(new ArrayList<>());
    }

    /**
     * Remove informações relacionadas ao prontuario do paciente
     *
     * @param paciente
     */
    public void removeDadosProntuarioPaciente(Paciente paciente) {
        paciente.setDiagnostico(null);
        paciente.setTratamento(null);
//        paciente.setSintomas(new ArrayList<>());
    }
}
