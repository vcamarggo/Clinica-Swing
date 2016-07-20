/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enumeration.TipoConvenio;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.sql.Date;
import model.Paciente;
import model.Secretaria;
import util.Util;
import view.CadastroEAlteracaoPacienteSecretariaView;
import view.DialogErrorView;

/**
 *
 * @author Camargo
 */
public class CadastroAlteracaoPacienteController {

    private Secretaria usuario;
    private CadastroEAlteracaoPacienteSecretariaView view;
    private Paciente model;

    public CadastroAlteracaoPacienteController() {
    }

    public CadastroAlteracaoPacienteController(CadastroEAlteracaoPacienteSecretariaView view, Secretaria usuario, Paciente model) {
        this.usuario = usuario;
        this.view = view;
        this.model = model;
        this.view.getTxtRG().setEnabled(false);
        preencheCampos();
    }

    public CadastroAlteracaoPacienteController(CadastroEAlteracaoPacienteSecretariaView view, Secretaria usuario) {
        this.usuario = usuario;
        this.view = view;
        this.model = new Paciente();
    }

    private void criaPaciente(Long rg, String nome, Date dataNascimento, String endereco, String telefone, String celular, String email, String tipoConvenio) {
        model = new Paciente(rg, nome, dataNascimento, endereco, telefone, celular, email, TipoConvenio.valueOf(tipoConvenio));
        usuario.adicionaPaciente(model);
    }

    public void controla() {
        view.getBtnGravar().addActionListener((ActionEvent actionEvent) -> {
            Long rg;
            Date dataNascimento;
            try {
                rg = new Long(view.getTxtRG().getText());
            } catch (NumberFormatException nfe) {
                new DialogErrorView(view, "Houve um erro, RG deve conter apenas números!").setVisible(true);
                return;
            }
            try {
                dataNascimento = Util.geraDataString(view.getTxtNascimento().getText());
            } catch (ParseException pe) {
                new DialogErrorView(view, "Sua data não tem o padrão correto dd/mm/aaaa!").setVisible(true);
                return;
            }
            view.dispose();
            criaPaciente(rg, view.getTxtNome().getText(),
                    dataNascimento, view.getTxtEndereco().getText(),
                    view.getTxtTelefone().getText(), view.getTxtCelular().getText(),
                    view.getTxtEmail().getText(), view.getBoxConvenio().getSelectedItem().toString());
        });
        view.getBtnCancelar()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }

    private void preencheCampos() {
        view.getTxtRG().setText(model.getRg().toString());
        view.getTxtNome().setText(model.getNome());
        view.getTxtNascimento().setText(model.getDataNascimentoString());
        view.getTxtEndereco().setText(model.getEndereco());
        view.getTxtTelefone().setText(model.getTelefone());
        view.getTxtCelular().setText(model.getCelular());
        view.getTxtEmail().setText(model.getEmail());
        view.getBoxConvenio().setSelectedItem(model.getTipoConvenio().toString());
    }
}
