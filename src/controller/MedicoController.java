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
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
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
        //Se acionado o botão "Voltar à Seleção de Perfis": retorna a tela de Seleção de Perfis.
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            SelecaoPerfilController selecaoPerfilController = new SelecaoPerfilController(new SelecaoPerfilView());
            selecaoPerfilController.controla();
        });
        //Se acionado o botão "Inserir/Alterar Dados Adicionais: mostra view para inserção de informações adicionais do paciente selecionado.
        view.getBtnInserirDadosAdicionais().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                new CadastroAlteracaoDadosAdicionaisController(new CadastroEAlteracaoDadosAdicionaisMedicoView(view), usuario, paciente).controla();
            }
        });
        //Se acionado o botão "Remover Dados Adicionais": remove as informações adicionais do paciente selecionado do banco de dados.
        view.getBtnRemoverDadosAdicionais().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                paciente.removeDadosAdicionaisPaciente();
                usuario.atualizaPaciente(paciente);
                JOptionPane.showMessageDialog(null, "Dados removidos com sucesso");
            }
        });
        //Se acionado o botão "Detalhes do Paciente": mostra todas as informações referentes ao paciente selecionado.
        view.getBtnDetalhesPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                DetalhesPacienteMedicoController detalhesPacienteMedicoController =  new DetalhesPacienteMedicoController( new DetalhesPacienteMedicoView(view), usuario, paciente);
                detalhesPacienteMedicoController.controla();
            }
        });
        //Se acionado o botão "Cadastrar/Alterar Prontuário": mostra view para as inserções das informações do prontuário do paciente selecionado.
        view.getBtnCadastrarProntuario().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                CadastroEAlteracaoProntuarioMedicoController cadastroEAlteracaoProntuarioMedicoController =  new CadastroEAlteracaoProntuarioMedicoController( new CadastroEAlteracaoProntuarioMedicoView(view), usuario, paciente);
                cadastroEAlteracaoProntuarioMedicoController.controla();
            }
        });
        //Se acionado o botão "Remover Prontuário": remove as informações do prontuário do paciente selecionado do banco de dados.
        view.getBtnRemoverProntuario().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
            paciente.removeDadosProntuarioPaciente();
            usuario.atualizaPaciente(paciente);
            JOptionPane.showMessageDialog(null, "Prontuario removido com sucesso");
        });
        //Se acionado o botão "Gerar Atestado": mostra a view para inserção das informações para gerar o atestado.
        view.getBtnGerarAtestado().addActionListener((ActionEvent actionEvent) -> {
            new NovoAtestadoController(new NovoAtestadoView(view)).controla();
        });
        //Se acionado o botão "Gerar Receita": mostra a view para inserção das informações para gerar a receita.
        view.getBtnGerarReceita().addActionListener((ActionEvent actionEvent) -> {
            new NovaReceitaController(new NovaReceitaView(view)).controla();
        });
        //Se acionado o botão "Gerar Declaração de Acompanhamentoa": mostra a view para inserção das informações para gerar a declar~ção de acompanhamento.
        view.getBtnGerarDeclaracaoAcompanhamento().addActionListener((ActionEvent actionEvent) ->   {
            new NovaDeclaracaoController(new NovaDeclaracaoAcompanhamentoView(view)).controla();
        });
    }

    /* Método responsável pela atualização da tabela de pacientes */
    private void atualizaTabelaPacientes() {
        view.getTabelaPacientes().setModel(GeradorTabelas.geraTabelaPacientes(usuario));
    }

}
