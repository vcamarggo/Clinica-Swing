package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Consulta;
import model.Paciente;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class RelatorioConsultasView extends JFrame {

    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
    private static Calendar dataDesejadaFormatada = Calendar.getInstance();
    private static String dataDesejada;

    /**
     * Construtor padrao.
     */
    public RelatorioConsultasView() {
    }

    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nPerfil Secretária para relatórios");
        System.out.println("Criacao de Relatórios de Consultas");
        System.out.println("Insira a data desejada");
        dataDesejada = scan.nextLine();

        System.out.println("Selecione o Filtro:");
        System.out.println("1. Pacientes que possuem Email");
        System.out.println("2. Pacientes que possuem Celular");
        System.out.println("3. Retornar à seleção de usuários");

        formatarData();

        switch (scan.nextInt()) {
            case 1:
                gerarRelatorioEmail();
                break;
            case 2:
                gerarRelatorioCelular();
                break;
            case 3:
                fecharInterface();
                break;
            default:
                System.err.println("Opção inválida! \n");
                exibeInterface();
                break;
        }
    }

    /**
     * Transformo a string recebida na formatação certa. Tratamento de erro em
     * caso de erro na formatação.
     */
    public void formatarData() {
        try {
            dataDesejadaFormatada.setTime(FORMATTER.parse(dataDesejada));
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioConsultasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gera o relatorio de pacientes que possuem email e cunsulta no dia a
     * partir da lista criada no RelatoriosController.
     */
    private void gerarRelatorioEmail() {
        System.out.println("\nPacientes que tem consulta nesta data e possuem Email cadastrado no sistema:\n");
        for (Consulta consulta : Paciente.pacientesComEmail(dataDesejadaFormatada)) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Cod. da consulta: " + consulta.getCodigo());
            System.out.println("Nome do Paciente: " + consulta.getPaciente());
            System.out.println("Data: " + FORMATTER.format(consulta.getDataConsulta()));
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("Tipo: " + consulta.getTipoConsulta().getDuracao());
            System.out.println("Doutor: " + consulta.getMedico());
            System.out.println("------------------------------------------------------------\n");
        }
    }

    /**
     * Gera o relatorio de pacientes que possuem celular e consulta no dia a
     * partir da lista criada no RelatoriosController.
     */
    private void gerarRelatorioCelular() {
        System.out.println("\nPacientes que tem consulta nesta data e possuem Celular cadastrado no sistema:\n");
        for (Consulta consulta : Paciente.pacientesComCelular(dataDesejadaFormatada)) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Cod.: " + consulta.getCodigo());
            System.out.println("Data: " + FORMATTER.format(consulta.getDataConsulta()));
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("Tipo: " + consulta.getTipoConsulta().getDuracao());
            System.out.println("Nome do Paciente: " + consulta.getPaciente());
            System.out.println("Doutor: " + consulta.getMedico());
            System.out.println("------------------------------------------------------------\n");
        }

    }

    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }
}
