package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.GerenciadorMensagem;
import util.Util;
import view.GerenciadorDeMensagensView;
import view.PacientesNotificadosView;
import view.SelecaoPerfilView;
//</editor-fold>

/**
 * Classe responsável por gerenciar a entrada da view do gerenciador de mensagens. 
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
public class GerenciadorMensagemController {
    
    private GerenciadorMensagem usuario;
    private GerenciadorDeMensagensView view;

    /* Contrutor padrão */
    public GerenciadorMensagemController() {
    }
    
    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public GerenciadorMensagemController(GerenciadorMensagem usuario, GerenciadorDeMensagensView view) {
        this.usuario = usuario;
        this.view = view;
        this.view.setVisible(true);
    }
    
    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla(){
        //Se acionado o botão "Voltar à Seleção de Perfis": retorna a tela de Seleção de Perfis.
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new SelecaoPerfilController(new SelecaoPerfilView()).controla();
        });
        //Pede-se a digitação da data e a seleção do botão "Enviar Email": gera view dos pacientes com email e com consulta para o dia seguinte.
        view.getBtnNotificarEmail().addActionListener((ActionEvent actionEvent) -> {
            Date dataConsulta;
            try {
                dataConsulta = Util.geraDataString(view.getTxtDataConsulta().getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(view, "Sua data não tem o padrão correto dd/mm/aaaa!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new ConsultasDoDiaSeguinteController(new PacientesNotificadosView(view), usuario, false, dataConsulta).controla();
        });
        //Pede-se a digitação da data e a seleção do botão "Enviar SMS": gera view dos pacientes com celular e com consulta para o dia seguinte.
        view.getBtnNotificarSMS().addActionListener((ActionEvent actionEvent) -> {
            Date dataConsulta;
            try {
                dataConsulta = Util.geraDataString(view.getTxtDataConsulta().getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(view, "Sua data não tem o padrão correto dd/mm/aaaa!", "Erro", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new ConsultasDoDiaSeguinteController(new PacientesNotificadosView(view), usuario, true, dataConsulta).controla();
        });
    }

}
