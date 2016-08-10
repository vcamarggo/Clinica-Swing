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
    
    /*Método construtor da controller "DetalhesPacientesController" parametrizada*/
    public DetalhesPacienteMedicoController(DetalhesPacienteMedicoView view, Medico usuario, Paciente paciente) {
        this.usuario = usuario;
        this.view = view;
        this.model = paciente;
        preencheCampos();
    }
    /*Método que preenche os campos da view "DetalhesPacienteMedicoView" com todas as informações armazenadas no banco de dados do paciente selecionado.*/
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
    
    /*Método que controla a view "DetalhesPacienteMedicoView".*/
    public void controla(){
        //Ao acionar o botão "OK": encerra a view
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
