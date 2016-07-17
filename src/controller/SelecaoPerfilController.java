package controller;

import java.awt.event.ActionEvent;
import model.GerenciadorMensagem;
import model.Medico;
import model.Secretaria;
import view.MedicoView;
import view.SecretariaView;
import view.SelecaoPerfilView;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class SelecaoPerfilController {

    public SelecaoPerfilController() {
    }

    public SelecaoPerfilController(SelecaoPerfilView view) {
        this.view = view;
        this.view.setVisible(true);
    }

    private SelecaoPerfilView view;

    public void controla() {

        view.getBtnGerenMsg().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            GerenciadorMensagemController gerenciadorMensagemController = new GerenciadorMensagemController();
            gerenciadorMensagemController.controla();
        });
        view.getBtnSouMedico().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            MedicoController medicoController = new MedicoController(new Medico(), new MedicoView());
            medicoController.controla();
        });
        view.getBtnSouSecretaria().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            SecretariaController secretariaController = new SecretariaController(new Secretaria(), new SecretariaView());
            secretariaController.controla();
        });
        view.getBtnGerenMsg().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            /*GerenciadorMensagemController secretariaController = new GerenciadorMensagemController(new GerenciadorMensagem(), new SecretariaView());
            secretariaController.controla();*/
        });
    }

}
