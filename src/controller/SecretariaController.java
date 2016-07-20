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
import view.CadastroEAlteracaoPacienteSecretariaView;
import view.SecretariaView;
import view.SelecaoPerfilView;

/**
 *
 * @author Camargo
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
        view.getTabelaPacientes().setModel(geraTabelaPacientes());
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new SelecaoPerfilController(new SelecaoPerfilView()).controla();
        });
        view.getBtnNovoPaciente().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new CadastraPacienteController(new CadastroEAlteracaoPacienteSecretariaView(), usuario).controla();
        });
    }

    private DefaultTableModel geraTabelaPacientes() {
        String[] header = {"RG", "Nome", "Data nascimento", "Endereço",
            "Telefone", "Celular", "Email", "Convênio"};
        Object[][] pacientes = new Object[usuario.listaPacientes().size()][Paciente.class.getDeclaredFields().length];
        int i = 0;
        int j = 0;
        for (Paciente p : usuario.listaPacientes()) {
            for (Field field : p.getClass().getDeclaredFields()) {
                try {
                    pacientes[i][j] = PropertyUtils.getSimpleProperty(p, field.getName());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                    pacientes[i][j] = "";
                }
                j++;
            }
            j = 0;
            i++;
        }
        return new javax.swing.table.DefaultTableModel(
                pacientes, header);

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
