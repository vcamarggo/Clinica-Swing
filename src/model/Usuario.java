/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Camargo
 */
public abstract class Usuario {

    /**
     * Procura um paciente na lista atraves do seu nome
     *
     * @param nome
     * @return paciente encontrado.
     */
    protected Paciente getPacienteByNome(String nome) {
        for (Paciente paciente : Paciente.getPacientes()) {
            if (paciente.getNome().equals(nome)) {
                return paciente;
            }
        }
        return null;
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
