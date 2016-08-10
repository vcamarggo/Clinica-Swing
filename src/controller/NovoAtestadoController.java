package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.Medico;
import util.Util;
import view.AtestadoView;
import view.NovoAtestadoView;
//</editor-fold>

/**
 * Classe responsável por gerenciar o recebimento dos dados do novo Atestado.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
public class NovoAtestadoController {
    
    private Medico usuario;
    private NovoAtestadoView view;
    
    private String lblAssinaturaMedico;
    private String lblDataConsulta;
    private String lblDias;
    private String lblHorario;
    private String lblNomePaciente;
    private String lblNumRG;
    
    /* Contrutor padrão */
    public NovoAtestadoController(){
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public NovoAtestadoController(NovoAtestadoView view) {
        this.view = view;
    }
    
    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        //Ao acionar o botão "Gerar Atestado!": gera o atestado com as informações que foram digitadas nos campos da view "NovoAtestadoView".
        view.getBtnGerarAtestado().addActionListener((ActionEvent actionEvent) -> {
            Long rg;
            Date dataConsulta;
            try {
                rg = new Long(view.getTxtRgPaciente().getText());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "Houve um erro, RG deve conter apenas números!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                dataConsulta = Util.geraDataString(view.getTxtDataConsulta().getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(view, "Sua data não tem o padrão correto dd/mm/aaaa!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
                       
            lblAssinaturaMedico = view.getTxtAssinaturaMedico().getText();
            lblDataConsulta = view.getTxtDataConsulta().getText();
            lblDias = view.getTxtDiasDescanso().getText();
            lblHorario = view.getTxtHorarioConsulta().getText();
            lblNomePaciente = view.getTxtNomePaciente().getText();
            lblNumRG = view.getTxtRgPaciente().getText();
            view.dispose();
            new GerarAtestadoController(new AtestadoView(view), lblAssinaturaMedico, lblDataConsulta, lblDias, lblHorario, lblNomePaciente, lblNumRG).controla();
        });
        //Ao acionar o botão "Cancelar": não será gerado nenhum atestado.
        view.getBtnCancelar()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }
}
