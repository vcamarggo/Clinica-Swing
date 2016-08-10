package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import model.GerenciadorMensagem;
import model.Medico;
import model.Secretaria;
import view.GerenciadorDeMensagensView;
import view.MedicoView;
import view.SecretariaView;
import view.SelecaoPerfilView;
//</editor-fold>

/**
 * Classe responsável por gerenciar a tela de login do sistema e retornar a interface correta.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
public class SelecaoPerfilController {
    
    private SelecaoPerfilView view;

    /* Contrutor padrão */
    public SelecaoPerfilController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public SelecaoPerfilController(SelecaoPerfilView view) {
        this.view = view;
        this.view.setVisible(true);
    }

    public void controla() {
        //Se acionado o botão "Gerenciador de Mensagens": instancia o controller, o gerenciador e e a view correspondentes e ativa o controller.
        view.getBtnGerenMsg().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new GerenciadorMensagemController(new GerenciadorMensagem(), new GerenciadorDeMensagensView()).controla();
        });
        //Se acionado o botão "Sou Médico": instancia o controller, o gerenciador e e a view correspondentes e ativa o controller.
        view.getBtnSouMedico().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new MedicoController(new Medico(), new MedicoView()).controla();
        });
        //Se acionado o botão "Sou Secretaria": instancia o controller, o gerenciador e e a view correspondentes e ativa o controller.
        view.getBtnSouSecretaria().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new SecretariaController(new Secretaria(), new SecretariaView()).controla();
        });
    }

}
