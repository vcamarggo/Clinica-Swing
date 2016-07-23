/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.Secretaria;
import view.ConsultaPorDataView;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class ConsultaPorDataController {

    private Secretaria usuario;
    private ConsultaPorDataView view;
    private boolean isCelular;
    public List<Consulta> consultas;

    public ConsultaPorDataController() {
    }

    public ConsultaPorDataController(ConsultaPorDataView view, Secretaria usuario, boolean isCelular) {
        this.usuario = usuario;
        this.view = view;
        this.isCelular = isCelular;
    }

    public void controla() {
        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH, 1);
        if (isCelular) {
            consultas = usuario.getConsultasDataDesejadaParaPacientesComCelular(amanha);
        } else {
            consultas = usuario.getConsultasDataDesejadaParaPacientesComEmail(amanha);
        }
        view.getTabelaPacientesComConsulta().setModel(geraTabelaConsulta());
        view.getBtnOK1()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }

    private DefaultTableModel geraTabelaConsulta() {
        String[] header = {"Paciente", "Email/Celular", "Data consulta"};
        Object[][] consultasObject = new Object[consultas.size()][3];
        int i = 0;
        int j;
        for (Consulta c : consultas) {
            j = 0;
            consultasObject[i][j] = c.getPaciente();
            j++;
            if (isCelular) {
                consultasObject[i][j] = c.getPaciente().getCelular();
                j++;
            } else {
                consultasObject[i][j] = c.getPaciente().getEmail();
                j++;
            }
            consultasObject[i][j] = c.getDataConsultaString();
            i++;
        }
        return new javax.swing.table.DefaultTableModel(
                consultasObject, header);
    }

}
