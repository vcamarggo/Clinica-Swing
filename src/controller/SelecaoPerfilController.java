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
 * @author F.Carvalho / M. Hirose / V.Camargo
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
        view.getBtnGerenMsg().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new GerenciadorMensagemController(new GerenciadorMensagem(), new GerenciadorDeMensagensView()).controla();
        });
        view.getBtnSouMedico().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new MedicoController(new Medico(), new MedicoView()).controla();
        });
        view.getBtnSouSecretaria().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new SecretariaController(new Secretaria(), new SecretariaView()).controla();
        });
    }

}
