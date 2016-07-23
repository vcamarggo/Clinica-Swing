package controller;

import java.awt.event.ActionEvent;
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
            new GerenciadorMensagemController().controla();
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
