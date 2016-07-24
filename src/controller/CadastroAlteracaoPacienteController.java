/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import enumeration.TipoConvenio;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Paciente;
import model.Secretaria;
import util.Util;
import view.CadastroEAlteracaoPacienteSecretariaView;
//</editor-fold>

/**
 * Classe responsável por controlar as ações da View de cadastro e alteração de Pacientes.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class CadastroAlteracaoPacienteController {

    private Secretaria usuario;
    private CadastroEAlteracaoPacienteSecretariaView view;
    private Paciente model;

    /* Contrutor padrão */
    public CadastroAlteracaoPacienteController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. 
      Este é chamado quando é solicitada a edição de um Paciente, por isso recebe um Paciente como parametro*/
    public CadastroAlteracaoPacienteController(CadastroEAlteracaoPacienteSecretariaView view, Secretaria usuario, Paciente model) {
        this.usuario = usuario;
        this.view = view;
        this.model = model;
        this.view.getTxtRG().setEnabled(false);
        preencheCampos();
    }
    /*Contrutor parametrizado chamado para novo paciente*/
    public CadastroAlteracaoPacienteController(CadastroEAlteracaoPacienteSecretariaView view, Secretaria usuario) {
        this.usuario = usuario;
        this.view = view;
        this.model = new Paciente();
    }

    /*Cria um novo paciente*/
    private void criaPaciente(Long rg, String nome, Date dataNascimento, String endereco, String telefone, String celular, String email, String tipoConvenio) {
        model = new Paciente(rg, nome, dataNascimento, endereco, telefone, celular, email, TipoConvenio.valueOf(tipoConvenio));
        usuario.adicionaPaciente(model);
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        view.getBtnGravar().addActionListener((ActionEvent actionEvent) -> {
            Long rg;
            Date dataNascimento;
            try {
                rg = new Long(view.getTxtRG().getText());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "Houve um erro, RG deve conter apenas números!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                dataNascimento = Util.geraDataString(view.getTxtNascimento().getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(view, "Sua data não tem o padrão correto dd/mm/aaaa!", "Erro", JOptionPane.WARNING_MESSAGE);
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

    /*Preenche os textfields com os valores correspondentes, caso seja solicitada alteração de um paciente*/
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
