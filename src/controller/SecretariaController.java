package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.Paciente;
import model.Secretaria;
import org.apache.commons.beanutils.PropertyUtils;
import util.GeradorTabelas;
import view.CadastroEAlteracaoConsultaView;
import view.CadastroEAlteracaoPacienteSecretariaView;
import view.ConsultaPorDataView;
import view.DetalhesPacienteSecretariaView;
import view.SecretariaView;
import view.SelecaoPerfilView;
//</editor-fold>

/**
 * Classe responsável por gerenciar as ações do usuário Secretária.
 *
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
class SecretariaController {

    private Secretaria usuario;
    private SecretariaView view;

    /* Contrutor padrão */
    public SecretariaController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public SecretariaController(Secretaria usuario, SecretariaView view) {
        this.usuario = usuario;
        this.view = view;
        this.view.setVisible(true);
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        atualizaTabelaPacientes();
        atualizaTabelaConsultas();
        //Se acionado o botão "Voltar à Seleção de Perfis": retorna a tela de Seleção de Perfis.
        view.getBtnVoltarSelecaoPerfil().addActionListener((ActionEvent actionEvent) -> {
            view.dispose();
            new SelecaoPerfilController(new SelecaoPerfilView()).controla();
        });
        //Se acionado o botão "Detalhes do Paciente": mostra view com as informações do paciente selecionado na tabela de pacientes.
        view.getBtnDetalhesPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                new DetalhesPacienteSecretariaController(new DetalhesPacienteSecretariaView(view), paciente).controla();
            }
        });
        //Se acionado o botão "Alterar Dados Paciente": mostra view com as informações do paciente, em campos editáveis. 
        view.getBtnAlterarPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                new CadastroAlteracaoPacienteController(new CadastroEAlteracaoPacienteSecretariaView(view), usuario, paciente).controla();
            }
            atualizaTabelaPacientes();
        });
        //Se acionado o botão "Remover Paciente": remove o paciente selecionado do banco de dados.
        view.getBtnRemoverPaciente().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Paciente paciente = usuario.getPacienteByRG((Long) view.getTabelaPacientes().getModel().getValueAt(linhaSelecionada, 0));
                try {
                    usuario.removePaciente(paciente);
                } catch (RollbackException cve) {
                    JOptionPane.showMessageDialog(view, "Paciente com consulta não pode ser removido.", "Erro", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            atualizaTabelaPacientes();
        });
        //Se acionado o botão "Novo Paciente": abre uma view para inserção das informações do novo paciente.
        view.getBtnNovoPaciente().addActionListener((ActionEvent actionEvent) -> {
            new CadastroAlteracaoPacienteController(new CadastroEAlteracaoPacienteSecretariaView(view), usuario).controla();
            atualizaTabelaPacientes();
        });
        //Se acionado o botão "Alterar Consulta": mostra view com as informações da consulta, em campos editáveis.
        view.getBtnAlterarConsulta().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaConsultas().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Consulta paciente = usuario.getConsultaByCodigo((Long) view.getTabelaConsultas().getModel().getValueAt(linhaSelecionada, 0));
                new CadastroAlteracaoConsultaController(new CadastroEAlteracaoConsultaView(view), usuario, paciente).controla();
            }
            atualizaTabelaConsultas();
        });
        //Se acionado o botão "Remover Consulta": remove a consulta selecionada do banco de dados.
        view.getBtnRemoverConsulta().addActionListener((ActionEvent actionEvent) -> {
            int linhaSelecionada = view.getTabelaConsultas().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Consulta paciente = usuario.getConsultaByCodigo((Long) view.getTabelaConsultas().getModel().getValueAt(linhaSelecionada, 0));
                usuario.removeConsulta(paciente);
            }
            atualizaTabelaConsultas();
        });
        //Se acionado o botão "Nova Consulta": abre uma view para inserção das informações da nova consulta.
        view.getBtnNovaConsulta().addActionListener((ActionEvent actionEvent) -> {
            new CadastroAlteracaoConsultaController(new CadastroEAlteracaoConsultaView(view), usuario).controla();
            atualizaTabelaConsultas();
        });
        //Se acionado o botão "Consultas do dia seguinte - Email": mostra view dos pacientes com email, com consulta para o dia seguinte.
        view.getBtnConsultasDiaSeguinteEmail().addActionListener((ActionEvent actionEvent) -> {
            new ConsultaPorDataController(new ConsultaPorDataView(view), usuario, false).controla();
        });
        //Se acionado o botão "Consultas do dia seguinte - SMS": mostra view dos pacientes com celular, com consulta para o dia seguinte.
        view.getBtnConsultasDiaSeguinteSMS().addActionListener((ActionEvent actionEvent) -> {
            new ConsultaPorDataController(new ConsultaPorDataView(view), usuario, true).controla();
        });
    }

    /**
     * Atualiza a tabela dos pacientes
     */
    private void atualizaTabelaPacientes() {
        view.getTabelaPacientes().setModel(GeradorTabelas.geraTabelaPacientes(usuario));
    }

    /**
     * Atualiza as tabelas de consulta
     */
    private void atualizaTabelaConsultas() {
        view.getTabelaConsultas().setModel(geraTabelaConsultas());
    }

    /**
     * Gera as tabelas de consulta
     */
    private DefaultTableModel geraTabelaConsultas() {
        Object[][] consultas = new Object[usuario.listaConsultas().size()][Consulta.class.getDeclaredFields().length];
        int i = 0;
        int j = 0;
        for (Consulta c : usuario.listaConsultas()) {
            for (Field field : c.getClass().getDeclaredFields()) {
                try {
                    consultas[i][j] = PropertyUtils.getSimpleProperty(c, field.getName());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                    consultas[i][j] = "";
                }
                j++;
            }
            j = 0;
            i++;
        }
        return new javax.swing.table.DefaultTableModel(
                consultas, new String[]{
                    "Código", "Data Consulta", "Hora", "Médico", "Paciente", "Tipo"
                });

    }

}
