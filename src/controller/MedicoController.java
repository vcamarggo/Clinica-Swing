/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import model.Medico;
import view.MedicoView;
import view.SelecaoPerfilView;

/**
 *
 * @author Camargo
 */
class MedicoController {

    private Medico usuario;
    private MedicoView view;

    public MedicoController() {
    }

    public MedicoController(Medico usuario, MedicoView view) {
        this.usuario = usuario;
        this.view = view;
        this.view.setVisible(true);
    }

    public void controla() {
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            SelecaoPerfilController selecaoPerfilController = new SelecaoPerfilController(new SelecaoPerfilView());
            selecaoPerfilController.controla();
        });
    }

}
