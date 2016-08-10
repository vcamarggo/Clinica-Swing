package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.Medico;
import util.Util;
import view.NovaReceitaView;
import view.ReceitaView;
//</editor-fold>

/**
 * Classe responsável por gerenciar o recebimento dos dados da nova Receita.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
public class NovaReceitaController {
    private NovaReceitaView view;
    
    private String lblPaciente;
    private String lblDataConsulta;
    private String lblRemedios;
    private String lblAssinaturaMedico;
    
    /* Contrutor padrão */
    public NovaReceitaController(){
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public NovaReceitaController(NovaReceitaView view) {
        this.view = view;
    }
       
    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        view.getBtnGerarReceita().addActionListener((ActionEvent actionEvent) -> {
            Date dataConsulta;
            try {
                dataConsulta = Util.geraDataString(view.getTxtDataConsulta().getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(view, "Sua data não tem o padrão correto dd/mm/aaaa!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
                       
            lblPaciente = view.getTxtNomePaciente().getText();
            lblDataConsulta = view.getTxtDataConsulta().getText();
            lblRemedios = view.getTxtRemedios().getText();
            lblAssinaturaMedico = view.getTxtAssinaturaMedico().getText();
            view.dispose();
            new GerarReceitaController(new ReceitaView(view), lblAssinaturaMedico, lblDataConsulta, lblRemedios, lblPaciente).controla();
        });
        view.getBtnCancelar()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }
    
    
}
