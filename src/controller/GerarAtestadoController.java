package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import view.AtestadoView;
//</editor-fold>

/**
 * Classe responsável por organizar e exibir os dados do novo Atestado. 
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
public class GerarAtestadoController {

    private AtestadoView view;
    private String lblAssinaturaMedico;
    private String lblDataConsulta;
    private String lblDias;
    private String lblHorario;
    private String lblNomePaciente;
    private String lblNumRG;
    
    /* Contrutor padrão */
    public GerarAtestadoController(){
    }
    
    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public GerarAtestadoController(AtestadoView view, String lblAssinaturaMedico, String lblDataConsulta, String lblDias, String lblHorario, String lblNomePaciente, String lblNumRG) {
        this.view = view;
        this.lblAssinaturaMedico = lblAssinaturaMedico;
        this.lblDataConsulta = lblDataConsulta;
        this.lblDias = lblDias;
        this.lblHorario = lblHorario;
        this.lblNomePaciente = lblNomePaciente;
        this.lblNumRG = lblNumRG;
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        //Copia as informações parametrizadas em "GerarAtestadoController" para a view "AtestadoView" gerada.
        view.getLblAssinaturaMedico().setText(lblAssinaturaMedico);
        view.getLblDataConsulta().setText(lblDataConsulta);
        view.getLblDias().setText(lblDias);
        view.getLblHorario().setText(lblHorario);
        view.getLblNomePaciente().setText(lblNomePaciente);
        view.getLblNumRG().setText(lblNumRG);
        //Ao acionar o botão "OK": encerra a view do atestado.
        view.getBtnOK().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        view.setVisible(true);
    }

}
