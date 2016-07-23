/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import model.Medico;
import model.Paciente;
import view.DetalhesPacienteMedicoView;

/**
 *
 * @author Fernando
 */
class DetalhesPacienteMedicoController {
    
    private Medico usuario;
    private DetalhesPacienteMedicoView view;
    private Paciente model;
    
    
    public DetalhesPacienteMedicoController(DetalhesPacienteMedicoView view, Medico usuario, Paciente paciente) {
        this.usuario = usuario;
        this.view = view;
        this.model = paciente;
        preencheCampos();
    }

    private void preencheCampos() {
        view.getLblBebe().setText( converteCamposBooleanosParaString(model.getBebe()));
        view.getLblCelularPaciente().setText(model.getCelular());
        view.getLblColesterol().setText( converteCamposBooleanosParaString(model.getColesterol()) );
        view.getLblConvenioPaciente( );
        view.getLblDiabetes().setText( converteCamposBooleanosParaString(model.getDiabete()) );
        view.getLblEmailPaciente().setText( model.getEmail());
        view.getLblEnderecoPaciente().setText( model.getEndereco());
        view.getLblFuma().setText( converteCamposBooleanosParaString(model.getFuma()) );
        view.getLblNascimentoPaciente().setText(model.getDataNascimentoString());
        view.getLblNomePaciente().setText( model.getNome());
        view.getLblTelefonePaciente().setText(model.getTelefone());
        view.getLblConvenioPaciente().setText(model.getTipoConvenio().toString());
        view.getTxtAlergias().setText( model.getAlergias());
        view.getTxtCirurgias().setText( model.getCirurgias());
        view.getTxtDiagnostico().setText( model.getDiagnostico());
        view.getTxtSintomas().setText( model.getSintomas());
        view.getTxtTratamento().setText( model.getTratamento());
    }
    
    
    public void controla(){
        view.getBtnOK().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        view.setVisible(true);
    }
    
    
    private String converteCamposBooleanosParaString(Boolean campo){
        if (campo == null){
            return "Não respondido";
        }else if( campo ){
            return "Sim";
        }
        return "Não";
    }
    
}
