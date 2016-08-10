package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import view.ReceitaView;
//</editor-fold>

/**
 * Classe responsável por organizar e exibir os dados da nova Receita. 
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
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
        //Copia as informações parametrizadas em "GerarReceitaController" para a view "ReceitaView" gerada.
        view.getLblAssinatura().setText(lblAssinaturaMedico);
        view.getLblDataConsulta().setText(lblDataConsulta);
        view.getLblNomePaciente().setText(lblPaciente);
        view.getTxtRemedios().setText(lblRemedios);
        //Ao acionar o botão "OK": encerra a view da receita.
        view.getBtnOK().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        view.setVisible(true);
    }
}
