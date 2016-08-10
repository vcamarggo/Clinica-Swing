package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Medico;
import model.Paciente;
import view.CadastroEAlteracaoProntuarioMedicoView;

/**
 *
 * @author Fernando
 */
class CadastroEAlteracaoProntuarioMedicoController {

    private Medico usuario;
    private CadastroEAlteracaoProntuarioMedicoView view;
    private Paciente model;

    CadastroEAlteracaoProntuarioMedicoController(CadastroEAlteracaoProntuarioMedicoView view, Medico usuario, Paciente paciente) {
        this.usuario = usuario;
        this.view = view;
        this.model = paciente;
        preencheCampos();
    }
    /*Método que controla a view "CadastroEAlteracaoProntuarioMedicoView"*/
    public void controla() {
        //Se acionar o botão "Cancelar": sai da view sem salvar as alterações feitas.
        view.getBtnCancelar().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        //Se acionar o botão "Gravar Dados": grava as informações dos campos editáveis do prontuário do paciente no Banco de Dados.
        view.getBtnGravar2().addActionListener((ActionEvent actionEvent) -> {
            if (this.model == null) {
                JOptionPane.showMessageDialog(view, "Paciente não encontrado!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                model.setSintomas(view.getTxtSintomas().getText());
                model.setDiagnostico(view.getTxtDiagnostico().getText());
                model.setTratamento(view.getTxtTratamento().getText());
                usuario.atualizaPaciente(model);
                view.dispose();
            }
        });
        view.setVisible(true);
    }
    /*Método que preenche os campos da view do prontuário com as informações anteriormente gravadas no Banco de Dados*/
    private void preencheCampos() {
        view.getTxtSintomas().setText(model.getSintomas());
        view.getTxtDiagnostico().setText(model.getDiagnostico());
        view.getTxtTratamento().setText(model.getTratamento());
    }
}
