/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import view.ReceitaView;
//</editor-fold>

/**
 * Classe responsável por organizar e exibir os dados da nova Receita. 
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerarReceitaController {
    
    private ReceitaView view;
    private String lblPaciente;
    private String lblDataConsulta;
    private String lblRemedios;
    private String lblAssinaturaMedico;
    
    /* Contrutor padrão */
    public GerarReceitaController(){
    }
    
    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public GerarReceitaController(ReceitaView view, String lblAssinaturaMedico, String lblDataConsulta, String lblRemedios, String lblPaciente) {
        this.view = view;
        this.lblAssinaturaMedico = lblAssinaturaMedico;
        this.lblDataConsulta = lblDataConsulta;
        this.lblRemedios = lblRemedios;
        this.lblPaciente = lblPaciente;
    }
    
    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        view.getLblAssinatura().setText(lblAssinaturaMedico);
        view.getLblDataConsulta().setText(lblDataConsulta);
        view.getLblNomePaciente().setText(lblPaciente);
        view.getTxtRemedios().setText(lblRemedios);
        
        view.getBtnOK().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        view.setVisible(true);
    }
}
