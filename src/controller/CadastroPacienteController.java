/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import enumeration.TipoConvenio;
import java.awt.event.ActionEvent;
import model.Paciente;
import model.Secretaria;
import util.Util;
import view.CadastroEAlteracaoPacienteSecretariaView;

/**
 *
 * @author Camargo
 */
public class CadastroPacienteController {

    private Secretaria usuario;
    private CadastroEAlteracaoPacienteSecretariaView view;

    public CadastroPacienteController() {
    }

    public CadastroPacienteController(CadastroEAlteracaoPacienteSecretariaView view, Secretaria usuario) {
        this.usuario = usuario;
        this.view = view;
    }

    private void criaPaciente(String rg, String nome, String dataNascimentoString, String endereco, String telefone, String celular, String email, String tipoConvenio) {
        Long rgLong = new Long(rg);
        Paciente paciente = new Paciente(rgLong, nome, Util.geraDataString(dataNascimentoString), endereco, telefone, celular, email, TipoConvenio.valueOf(tipoConvenio));
        usuario.adicionaPaciente(paciente);
    }

    public void controla() {
        view.getBtnGravar().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            criaPaciente(view.getTxtRG().getText(), view.getTxtNome().getText(),
                    view.getTxtNascimento().getText(), view.getTxtEndereco().getText(),
                    view.getTxtTelefone().getText(), view.getTxtCelular().getText(),
                    view.getTxtEmail().getText(), view.getBoxConvenio().getSelectedItem().toString());
        });
        view.getBtnCancelar().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        this.view.setVisible(true);
    }
}
