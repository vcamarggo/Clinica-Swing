/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Paciente;
import model.Secretaria;
import view.CadastroEAlteracaoPacienteSecretariaView;
import view.SecretariaView;

/**
 *
 * @author Camargo
 */
public class CadastraPacienteController {

    private Secretaria usuario;
    private CadastroEAlteracaoPacienteSecretariaView view;

    public CadastraPacienteController() {
    }

    public CadastraPacienteController(CadastroEAlteracaoPacienteSecretariaView view, Secretaria usuario) {
        this.usuario = usuario;
        this.view = view;
        this.view.setVisible(true);
    }

    private void criaPaciente(String rg, String nome, String dataNascimentoString, String endereco, String telefone, String celular, String email) {
        Long rgLong = new Long(rg);
        Date dataNascimento;
        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoString);
        } catch (ParseException ex) {
            dataNascimento = null;
        }
        Paciente paciente = new Paciente(rgLong, nome, dataNascimento, endereco, telefone, celular, email);
        usuario.adicionaPaciente(paciente);
    }

    public void controla() {
        view.getBtnGravar().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            criaPaciente(view.getTxtRG().getText(), view.getTxtNome().getText(),
                    view.getTxtNascimento().getText(), view.getTxtEndereco().getText(),
                    view.getTxtTelefone().getText(), view.getTxtCelular().getText(),
                    view.getTxtEmail().getText());
            new SecretariaController(usuario, new SecretariaView()).controla();
        });
        view.getBtnCancelar().addActionListener((ActionEvent actionEvent) -> {
            new SecretariaController(usuario, new SecretariaView()).controla();
            view.dispose();
        });
    }
}
