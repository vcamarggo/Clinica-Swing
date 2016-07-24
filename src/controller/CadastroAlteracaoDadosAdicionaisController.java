/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Medico;
import model.Paciente;
import util.Util;
import view.CadastroEAlteracaoDadosAdicionaisMedicoView;
//</editor-fold>

/**
 * Classe responsável por controlar as ações da View de cadastro e alteração de Dados.
 * adicionais dos pacientes
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class CadastroAlteracaoDadosAdicionaisController {
    
    private Medico usuario;
    private CadastroEAlteracaoDadosAdicionaisMedicoView view;
    private Paciente model;
    
    /* Contrutor padrão */
    public CadastroAlteracaoDadosAdicionaisController(){
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador*/
    public CadastroAlteracaoDadosAdicionaisController(CadastroEAlteracaoDadosAdicionaisMedicoView view, Medico usuario, Paciente paciente) {
        this.usuario = usuario;
        this.view = view;
        this.model = paciente;
        preencheCampos();
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
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
    
    /*Preenche os textfields com os valores correspondentes, caso seja solicitada alteração de dados adicionais*/
    private void preencheCampos(){
        view.getTxtAlergias().setText(model.getAlergias());
        view.getTxtCirurgias().setText(model.getCirurgias());
        view.getBoxBebe().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao(model.getBebe()));
        view.getBoxFuma().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao(model.getFuma()));
        view.getBoxColesterol().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao(model.getColesterol() ));
        view.getBoxDiabetes().setSelectedIndex( Util.retornaValorParaCampoBoxSimNao( model.getDiabete()));
    };    
    
}
