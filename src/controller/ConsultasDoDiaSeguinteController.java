/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.GerenciadorMensagem;
import view.PacientesNotificadosView;
//</editor-fold>

/**
 * Classe responsável por filtrar e notificar os pacientes que possuem Consultas relativas 
 * ao dia seguinte a data inserida.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class ConsultasDoDiaSeguinteController {

    private GerenciadorMensagem usuario;
    private PacientesNotificadosView view;
    private boolean isCelular;
    private Date dataConsulta;
    public List<Consulta> consultas;

    /* Contrutor padrão */
    public ConsultasDoDiaSeguinteController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public ConsultasDoDiaSeguinteController(PacientesNotificadosView view, GerenciadorMensagem usuario, boolean isCelular, Date dataConsulta) {
        this.usuario = usuario;
        this.view = view;
        this.isCelular = isCelular;
        this.dataConsulta = dataConsulta;
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        Calendar amanha = Calendar.getInstance();
        amanha.setTime(dataConsulta);
        amanha.add(Calendar.DAY_OF_MONTH, 1);
        if (isCelular) {
            consultas = usuario.getConsultasDataDesejadaParaPacientesComCelular(amanha);
        } else {
            consultas = usuario.getConsultasDataDesejadaParaPacientesComEmail(amanha);
        }
        view.getTabelaPacientesComConsulta().setModel(geraTabelaConsulta());
        view.getBtnOK()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.getBtnOK()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);

    }

    /* Método responsável por criar uma tabela personalizada dos pacientes que tem consulta no dia seguinte. 
       Verifica se o gerenciador de mensagens solicitou enviar email ou sms */
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
