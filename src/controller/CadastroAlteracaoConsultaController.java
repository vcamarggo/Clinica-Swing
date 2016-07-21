/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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

/**
 *
 * @author Camargo
 */
public class CadastroAlteracaoConsultaController {

    private Secretaria usuario;
    private CadastroEAlteracaoConsultaView view;
    private Consulta model;

    public CadastroAlteracaoConsultaController() {
    }

    public CadastroAlteracaoConsultaController(CadastroEAlteracaoConsultaView view, Secretaria usuario, Consulta model) {
        this.usuario = usuario;
        this.view = view;
        this.model = model;
        preencheCampos();
    }

    public CadastroAlteracaoConsultaController(CadastroEAlteracaoConsultaView view, Secretaria usuario) {
        this.usuario = usuario;
        this.view = view;
        this.model = new Consulta();
    }

    private void criaConsulta(Long codConsulta, Date dataConsulta, String hora, String medico, Paciente paciente, String tipoConsulta) {
        model = new Consulta(codConsulta, dataConsulta, hora, medico, paciente, TipoConsulta.valueOf(tipoConsulta));
        usuario.adicionaConsulta(model);
    }

    public void controla() {
        view.getBtnGravar().addActionListener((ActionEvent actionEvent) -> {
            Long rg;
            Date dataConsulta;
            Paciente paciente;
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
                criaConsulta(Long.parseLong(view.getTxtCodConsulta().getText()), dataConsulta, view.getTxtHorarioConsulta().getText(),
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

    private void preencheCampos() {
        view.getTxtCodConsulta().setText(model.getCodigo().toString());
        view.getTxtRGPaciente().setText(model.getPaciente().getRg().toString());
        view.getTxtDataConsulta().setText(model.getDataConsultaString());
        view.getTxtHorarioConsulta().setText(model.getHora());
        view.getTxtMedicoResponsavel().setText(model.getMedico());
        view.getBoxTipoConsulta().setSelectedItem(model.getTipoConsulta().toString());
    }
}
