/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Medico;
import model.Paciente;
import util.Util;
import view.CadastroEAlteracaoDadosAdicionaisMedicoView;

/**
 *
 * @author Fernando
 */
public class CadastroAlteracaoDadosAdicionaisController {
    
    private Medico usuario;
    private CadastroEAlteracaoDadosAdicionaisMedicoView view;
    private Paciente model;

    public CadastroAlteracaoDadosAdicionaisController(CadastroEAlteracaoDadosAdicionaisMedicoView view, Medico usuario, Paciente paciente) {
        this.usuario = usuario;
        this.view = view;
        this.model = paciente;
        preencheCampos();
    }

    public void controla() {
        view.getBtnGravar2().addActionListener((ActionEvent actionEvent) -> {
            if (this.model == null) {
                JOptionPane.showMessageDialog(view, "Paciente não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                model.setAlergias(view.getTxtAlergias().getText());
                model.setCirurgias(view.getTxtCirurgias().getText());
                model.setBebe(view.getBoxBebe().getSelectedIndex() == 1);
                model.setFuma(view.getBoxFuma().getSelectedIndex() == 1);
                model.setColesterol(view.getBoxColesterol().getSelectedIndex() == 1);
                model.setDiabete(view.getBoxDiabetes().getSelectedIndex() == 1);
                usuario.atualizaPaciente(model);
                view.dispose();
            }
        });
        view.getBtnCancelar()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }
    
    private void preencheCampos(){
        view.getTxtAlergias().setText(model.getAlergias());
        view.getTxtCirurgias().setText(model.getCirurgias());
        view.getBoxBebe().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao(model.getBebe()));
        view.getBoxFuma().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao(model.getFuma()));
        view.getBoxColesterol().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao(model.getColesterol() ));
        view.getBoxDiabetes().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao( model.getDiabete()));
    };    
    
}
