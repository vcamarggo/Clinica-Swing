/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.Paciente;
import model.Secretaria;
import org.apache.commons.beanutils.PropertyUtils;
import util.GeradorTabelas;
import view.CadastroEAlteracaoConsultaView;
import view.CadastroEAlteracaoPacienteSecretariaView;
import view.ConsultaPorDataView;
import view.DetalhesPacienteSecretariaView;
import view.SecretariaView;
import view.SelecaoPerfilView;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
class SecretariaController {

    private Secretaria usuario;
    private SecretariaView view;

    public SecretariaController() {
    }

    public SecretariaController(Secretaria usuario, SecretariaView view) {
        this.usuario = usuario;
        this.view = view;
        this.view.setVisible(true);
    }

    public void controla() {
        atualizaTabelaPacientes();
        atualizaTabelaConsultas();
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new SelecaoPerfilController(new SelecaoPerfilView()).controla();
        });
        view.getBtnDetalhesPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                new DetalhesPacienteSecretariaController(new DetalhesPacienteSecretariaView(view), paciente).controla();
            }
        });
        view.getBtnAlterarPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                new CadastroAlteracaoPacienteController(new CadastroEAlteracaoPacienteSecretariaView(view), usuario, paciente).controla();
            }
            atualizaTabelaPacientes();
        });
        view.getBtnRemoverPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                usuario.removePaciente(paciente);
            }
            atualizaTabelaPacientes();
        });
        view.getBtnNovoPaciente().addActionListener((ActionEvent actionEvent) -> {
            new CadastroAlteracaoPacienteController(new CadastroEAlteracaoPacienteSecretariaView(view), usuario).controla();
            atualizaTabelaPacientes();
        });
        view.getBtnAlterarConsulta().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaConsultas().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Consulta paciente = usuario.getConsultaByCodigo((Long) view.getTabelaConsultas().getModel().getValueAt(linhaSelecionada, 0));
                new CadastroAlteracaoConsultaController(new CadastroEAlteracaoConsultaView(view), usuario, paciente).controla();
            }
            atualizaTabelaConsultas();
        });
        view.getBtnRemoverConsulta().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaConsultas().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Consulta paciente = usuario.getConsultaByCodigo((Long) view.getTabelaConsultas().getModel().getValueAt(linhaSelecionada, 0));
                usuario.removeConsulta(paciente);
            }
            atualizaTabelaConsultas();
        });
        view.getBtnNovaConsulta().addActionListener((ActionEvent actionEvent) -> {
            new CadastroAlteracaoConsultaController(new CadastroEAlteracaoConsultaView(view), usuario).controla();
            atualizaTabelaConsultas();
        });
        view.getBtnConsultasDiaSeguinteEmail().addActionListener((ActionEvent actionEvent) -> {
            new ConsultaPorDataController(new ConsultaPorDataView(view), usuario, false).controla();
        });
        view.getBtnConsultasDiaSeguinteSMS().addActionListener((ActionEvent actionEvent) -> {
            new ConsultaPorDataController(new ConsultaPorDataView(view), usuario, true).controla();
        });
    }

    private void atualizaTabelaPacientes() {
        view.getTabelaPacientes().setModel(GeradorTabelas.geraTabelaPacientes(usuario));
    }

    private void atualizaTabelaConsultas() {
        view.getTabelaConsultas().setModel(geraTabelaConsultas());
    }

    private DefaultTableModel geraTabelaConsultas() {
        Object[][] consultas = new Object[usuario.listaConsultas().size()][Consulta.class.getDeclaredFields().length];
        int i = 0;
        int j = 0;
        for (Consulta c : usuario.listaConsultas()) {
            for (Field field : c.getClass().getDeclaredFields()) {
                try {
                    consultas[i][j] = PropertyUtils.getSimpleProperty(c, field.getName());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                    consultas[i][j] = "";
                }
                j++;
            }
            j = 0;
            i++;
        }
        return new javax.swing.table.DefaultTableModel(
                consultas, new String[]{
                    "Código", "Data Consulta", "Hora", "Médico", "Paciente", "Tipo"
                });

    }

}
