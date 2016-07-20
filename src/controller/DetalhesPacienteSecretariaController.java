/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import model.Paciente;
import model.Secretaria;
import view.DetalhesPacienteSecretariaView;

/**
 *
 * @author Camargo
 */
public class DetalhesPacienteSecretariaController {
    
    private Secretaria usuario;
    private Paciente model;
    private DetalhesPacienteSecretariaView view;
    
    public DetalhesPacienteSecretariaController() {
    }
    
    public DetalhesPacienteSecretariaController(DetalhesPacienteSecretariaView view, Secretaria usuario, Paciente model) {
        this.usuario = usuario;
        this.model = model;
        this.view = view;
    }
    
    public void controla() {
        view.getLblNomePaciente().setText(model.getNome());
        view.getLblEnderecoPaciente().setText(model.getEndereco());
        view.getLblNascimentoPaciente().setText(model.getDataNascimentoString());
        view.getLblTelefonePaciente().setText(model.getTelefone());
        view.getLblCelularPaciente().setText(model.getCelular());
        view.getLblEmailPaciente().setText(model.getEmail());
        view.getLblConvenioPaciente().setText(model.getTipoConvenio().toString());
        view.getBtnOK1().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        this.view.setVisible(true);
    }
}
