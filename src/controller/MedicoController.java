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
import util.GeradorTabelas;
import view.CadastroEAlteracaoDadosAdicionaisMedicoView;
import view.MedicoView;
import view.SelecaoPerfilView;

/**
 *
 * @author Camargo
 */
class MedicoController {

    private Medico usuario;
    private MedicoView view;

    public MedicoController() {
    }

    public MedicoController(Medico usuario, MedicoView view) {
        this.usuario = usuario;
        this.view = view;
        this.view.setVisible(true);
    }

    public void controla() {
        atualizaTabelaPacientes();
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            SelecaoPerfilController selecaoPerfilController = new SelecaoPerfilController(new SelecaoPerfilView());
            selecaoPerfilController.controla();
        });
        
        view.getBtnInserirDadosAdicionais().addActionListener((ActionEvent actionEvent) ->{
           int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
           if(linhaSelecionada >= 0){
               Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                new CadastroAlteracaoDadosAdicionaisController(new CadastroEAlteracaoDadosAdicionaisMedicoView(view), usuario, paciente).controla();
           }
        });
        
        view.getBtnRemoverDadosAdicionais().addActionListener((ActionEvent actionEvent) ->{
           int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
           if(linhaSelecionada >= 0){
               Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
               paciente.removeDadosAdicionaisPaciente();System.out.println(paciente.getCirurgias());
               usuario.atualizaPaciente(paciente);
               JOptionPane.showMessageDialog(null, "Dados removidos com sucesso");
           }
        });
    }

    private void atualizaTabelaPacientes() {
        view.getTabelaPacientes().setModel(GeradorTabelas.geraTabelaPacientes(usuario));
    }

}
