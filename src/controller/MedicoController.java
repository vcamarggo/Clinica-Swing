/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Medico;
import model.Paciente;
import util.GeradorTabelas;
import view.CadastroEAlteracaoDadosAdicionaisMedicoView;
import view.CadastroEAlteracaoProntuarioMedicoView;
import view.DetalhesPacienteMedicoView;
import view.MedicoView;
import view.NovaDeclaracaoAcompanhamentoView;
import view.NovaReceitaView;
import view.NovoAtestadoView;
import view.SelecaoPerfilView;
//</editor-fold>

/**
 * Classe responsável por gerenciar as ações do usuário Médico. 
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
class MedicoController {

    private Medico usuario;
    private MedicoView view;

    /* Contrutor padrão */
    public MedicoController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public MedicoController(Medico usuario, MedicoView view) {
        this.usuario = usuario;
        this.view = view;
        this.view.setVisible(true);
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        atualizaTabelaPacientes();
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            SelecaoPerfilController selecaoPerfilController = new SelecaoPerfilController(new SelecaoPerfilView());
            selecaoPerfilController.controla();
        });

        view.getBtnInserirDadosAdicionais().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                new CadastroAlteracaoDadosAdicionaisController(new CadastroEAlteracaoDadosAdicionaisMedicoView(view), usuario, paciente).controla();
            }
        });

        view.getBtnRemoverDadosAdicionais().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                paciente.removeDadosAdicionaisPaciente();
                usuario.atualizaPaciente(paciente);
                JOptionPane.showMessageDialog(null, "Dados removidos com sucesso");
            }
        });
        
        view.getBtnDetalhesPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                DetalhesPacienteMedicoController detalhesPacienteMedicoController =  new DetalhesPacienteMedicoController( new DetalhesPacienteMedicoView(view), usuario, paciente);
                detalhesPacienteMedicoController.controla();
            }
        });
        
        view.getBtnCadastrarProntuario().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                CadastroEAlteracaoProntuarioMedicoController cadastroEAlteracaoProntuarioMedicoController =  new CadastroEAlteracaoProntuarioMedicoController( new CadastroEAlteracaoProntuarioMedicoView(view), usuario, paciente);
                cadastroEAlteracaoProntuarioMedicoController.controla();
            }
        });
        
        view.getBtnRemoverProntuario().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
            paciente.removeDadosProntuarioPaciente();
            usuario.atualizaPaciente(paciente);
            JOptionPane.showMessageDialog(null, "Prontuario removido com sucesso");
        });
        
        view.getBtnGerarAtestado().addActionListener((ActionEvent actionEvent) -> {
            new NovoAtestadoController(new NovoAtestadoView(view)).controla();
        });
        
        view.getBtnGerarReceita().addActionListener((ActionEvent actionEvent) -> {
            new NovaReceitaController(new NovaReceitaView(view)).controla();
        });
        
        view.getBtnGerarDeclaracaoAcompanhamento().addActionListener((ActionEvent actionEvent) ->   {
            new NovaDeclaracaoController(new NovaDeclaracaoAcompanhamentoView(view)).controla();
        });
    }

    /* Método responsável pela atualização da tabela de pacientes */
    private void atualizaTabelaPacientes() {
        view.getTabelaPacientes().setModel(GeradorTabelas.geraTabelaPacientes(usuario));
    }

}
