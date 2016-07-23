/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class Medico extends Usuario {

    /**
     * Remove informações relacionadas aos dados adicionais do paciente
     *
     * @param paciente
     */
    public void removeDadosAdicionaisPaciente(Paciente paciente) {
        // Colocar isso no MedicoController
        paciente.removeDadosAdicionaisPaciente();
        atualizaPaciente(paciente);
    }

    /**
     * Remove informações relacionadas ao prontuario do paciente
     *
     * @param paciente
     */
    public void removeDadosProntuarioPaciente(Paciente paciente) {
        paciente.removeDadosProntuarioPaciente();
        atualizaPaciente(paciente);
    }
}
