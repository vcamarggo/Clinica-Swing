/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import view.DeclaracaoAcompanhamentoView;
//</editor-fold>

/**
 * Classe responsável por organizar e exibir os dados da nova Declaração de acompanhamento. 
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerarDeclaracaoAcompanhamentoController {
    
    private DeclaracaoAcompanhamentoView view;
    private String lblPaciente;
    private String lblDataConsulta;
    private String lblAcompanhante;
    private String lblHorario;
    private String lblAssinaturaMedico;
    
    /* Contrutor padrão */
    public GerarDeclaracaoAcompanhamentoController(){
    }
    
    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public GerarDeclaracaoAcompanhamentoController(DeclaracaoAcompanhamentoView view, String lblAssinaturaMedico, String lblDataConsulta, String lblAcompanhante, String lblHorario, String lblPaciente) {
        this.view = view;
        this.lblAssinaturaMedico = lblAssinaturaMedico;
        this.lblDataConsulta = lblDataConsulta;
        this.lblAcompanhante = lblAcompanhante;
        this.lblPaciente = lblPaciente;
        this.lblHorario = lblHorario;
    }
    
    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        view.getLblAssinatura().setText(lblAssinaturaMedico);
        view.getLblDataConsulta().setText(lblDataConsulta);
        view.getLblNomePaciente().setText(lblPaciente);
        view.getLblNomeAcompanhante().setText(lblAcompanhante);
        view.getLblHorario().setText(lblHorario);
        
        view.getBtnOK().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        view.setVisible(true);
    }
}
