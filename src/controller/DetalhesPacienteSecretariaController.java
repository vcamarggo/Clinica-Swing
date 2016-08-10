package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import model.Paciente;
import view.DetalhesPacienteSecretariaView;
//</editor-fold>

/**
 * Classe responsável por carregar os detalhes do paciente solicitado.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
public class DetalhesPacienteSecretariaController {

    private Paciente model;
    private DetalhesPacienteSecretariaView view;

    /* Contrutor padrão */
    public DetalhesPacienteSecretariaController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public DetalhesPacienteSecretariaController(DetalhesPacienteSecretariaView view, Paciente model) {
        this.model = model;
        this.view = view;
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        //Mostra as informações cadastradas do paciente selecionado através da view "DetalhesPacienteSecretariaView".
        view.getLblNomePaciente().setText(model.getNome());
        view.getLblEnderecoPaciente().setText(model.getEndereco());
        view.getLblNascimentoPaciente().setText(model.getDataNascimentoString());
        view.getLblTelefonePaciente().setText(model.getTelefone());
        view.getLblCelularPaciente().setText(model.getCelular());
        view.getLblEmailPaciente().setText(model.getEmail());
        view.getLblConvenioPaciente().setText(model.getTipoConvenio().toString());
        //Ao acionar o botão "OK": encerra a view.
        view.getBtnOK1().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
        });
        this.view.setVisible(true);
    }
}
