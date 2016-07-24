/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


//<editor-fold defaultstate="collapsed" desc="Importações">
import enumeration.TipoConsulta;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Consulta;
import model.Paciente;
import model.Secretaria;
import util.Util;
import view.CadastroEAlteracaoConsultaView;
//</editor-fold>

/**
 * Classe responsável por controlar as ações da View de cadastro e alteração de Consultas.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class CadastroAlteracaoConsultaController {

    private Secretaria usuario;
    private CadastroEAlteracaoConsultaView view;
    private Consulta model;

    /* Contrutor padrão */
    public CadastroAlteracaoConsultaController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. 
      Este é chamado quando é solicitada a edição de uma consulta, por isso recebe uma Consulta como parametro*/
    public CadastroAlteracaoConsultaController(CadastroEAlteracaoConsultaView view, Secretaria usuario, Consulta model) {
        this.usuario = usuario;
        this.view = view;
        this.model = model;
        preencheCampos();
    }
    /*Construtor parametrizado chamado para nova Consulta*/
    public CadastroAlteracaoConsultaController(CadastroEAlteracaoConsultaView view, Secretaria usuario) {
        this.usuario = usuario;
        this.view = view;
        this.model = new Consulta();
    }

    /*Cria uma nova consulta*/
    private void criaConsulta(Long codConsulta, Date dataConsulta, String hora, String medico, Paciente paciente, String tipoConsulta) {
        model = new Consulta(codConsulta, dataConsulta, hora, medico, paciente, TipoConsulta.valueOf(tipoConsulta));
        usuario.adicionaConsulta(model);
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        view.getBtnGravar().addActionListener((ActionEvent actionEvent) -> {
            Long rg;
            Date dataConsulta;
            Paciente paciente;
            Long codConsulta;
            try {
                codConsulta = Long.parseLong(view.getTxtCodConsulta().getText());
            } catch (NumberFormatException nfe) {
                codConsulta = null;
            }
            try {
                rg = new Long(view.getTxtRGPaciente().getText());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "Houve um erro, RG deve conter apenas números!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                dataConsulta = Util.geraDataString(view.getTxtDataConsulta().getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(view, "Sua data não tem o padrão correto dd/mm/aaaa!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
            paciente = usuario.getPacienteByRG(rg);
            if (paciente == null) {
                JOptionPane.showMessageDialog(view, "Paciente não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                view.dispose();
                criaConsulta(codConsulta, dataConsulta, view.getTxtHorarioConsulta().getText(),
                        view.getTxtMedicoResponsavel().getText(), paciente,
                        view.getBoxTipoConsulta().getSelectedItem().toString());
            }
        });
        view.getBtnCancelar()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }

    /*Preenche os textfields com os valores correspondentes, caso seja solicitada alteração de uma consulta*/
    private void preencheCampos() {
        view.getTxtCodConsulta().setText(model.getCodigo().toString());
        view.getTxtRGPaciente().setText(model.getPaciente().getRg().toString());
        view.getTxtDataConsulta().setText(model.getDataConsultaString());
        view.getTxtHorarioConsulta().setText(model.getHora());
        view.getTxtMedicoResponsavel().setText(model.getMedico());
        view.getBoxTipoConsulta().setSelectedItem(model.getTipoConsulta().toString());
    }
}
