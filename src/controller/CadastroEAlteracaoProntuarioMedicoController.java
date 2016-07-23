/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Medico;
import model.Paciente;
import view.CadastroEAlteracaoProntuarioMedicoView;

/**
 *
 * @author Fernando
 */
class CadastroEAlteracaoProntuarioMedicoController {

    private Medico usuario;
    private CadastroEAlteracaoProntuarioMedicoView view;
    private Paciente model;

    CadastroEAlteracaoProntuarioMedicoController(CadastroEAlteracaoProntuarioMedicoView view, Medico usuario, Paciente paciente) {
        this.usuario = usuario;
        this.view = view;
        this.model = paciente;
        preencheCampos();
    }

    public void controla() {
        view.getBtnCancelar().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        view.getBtnGravar2().addActionListener((ActionEvent actionEvent) -> {
            if (this.model == null) {
                JOptionPane.showMessageDialog(view, "Paciente não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                model.setSintomas(view.getTxtSintomas().getText());
                model.setDiagnostico(view.getTxtDiagnostico().getText());
                model.setTratamento(view.getTxtTratamento().getText());
                usuario.atualizaPaciente(model);
                view.dispose();
            }
        });
        view.setVisible(true);
    }

    private void preencheCampos() {
        view.getTxtSintomas().setText(model.getSintomas());
        view.getTxtDiagnostico().setText(model.getDiagnostico());
        view.getTxtTratamento().setText(model.getTratamento());
    }
}
