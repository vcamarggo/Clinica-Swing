/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.Medico;
import util.Util;
import view.DeclaracaoAcompanhamentoView;
import view.NovaDeclaracaoAcompanhamentoView;
//</editor-fold>

/**
 * Classe responsável por gerenciar o recebimento dos dados da nova Declaração de Acompanhamento.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class NovaDeclaracaoController {
    private Medico usuario;
    private NovaDeclaracaoAcompanhamentoView view;
    
    private String lblPaciente;
    private String lblDataConsulta;
    private String lblAcompanhante;
    private String lblHorario;
    private String lblAssinaturaMedico;
    
    /* Contrutor padrão */
    public NovaDeclaracaoController(){
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public NovaDeclaracaoController(NovaDeclaracaoAcompanhamentoView view) {
        this.view = view;
    }
    
    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        view.getBtnGerarDeclaracao().addActionListener((ActionEvent actionEvent) -> {
            Date dataConsulta;
            try {
                dataConsulta = Util.geraDataString(view.getTxtDataConsulta().getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(view, "Sua data não tem o padrão correto dd/mm/aaaa!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
            lblHorario = view.getTxtHorarioConsulta().getText();
            lblPaciente = view.getTxtNomePaciente().getText();
            lblDataConsulta = view.getTxtDataConsulta().getText();
            lblAcompanhante = view.getTxtNomeAcompanhante().getText();
            lblAssinaturaMedico = view.getTxtAssinaturaMedico().getText();
            view.dispose();
            new GerarDeclaracaoAcompanhamentoController(new DeclaracaoAcompanhamentoView(view), lblAssinaturaMedico, lblDataConsulta, lblAcompanhante, lblHorario, lblPaciente).controla();
        });
        view.getBtnCancelar()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }
    
    
}
