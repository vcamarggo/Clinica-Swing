package view;

import controller.RelatorioConsultasController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Consulta;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class RelatorioConsultasView implements View {
    
    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
    private static Calendar dataFormatada = Calendar.getInstance();
    private static String dataDesejada;
    
    /**
     * Construtor padrao.
     */
    public RelatorioConsultasView() {
    }

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n***Perfil Secretária***");
        System.out.println("Criacao de Relatórios de Consultas");
        System.out.println("Insira a data desejada");
        dataDesejada = scan.nextLine();
        
        System.out.println("Selecione o Filtro:");
        System.out.println("1. Email");
        System.out.println("2. Celular");
        System.out.println("3. Retornar");
        
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
                System.exit(0);
                break;
        }
    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    /**
     * Transformo a string recebida no formato certo da data
     * Tratamento de erro em caso de erro na formatação
     */
    public void formatarData(){
        try {
            dataFormatada.setTime(FORMATTER.parse(dataDesejada));
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioConsultasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gera o relatorio de email a partir da lista criada no RelatorioConsultasController referente aos emails
     */
    private void gerarRelatorioEmail() {   
        System.out.println("\nPacientes que possuem Email cadastrado no sistema:");
        for (Consulta consulta : RelatorioConsultasController.pacientesComEmail()) {
            System.out.println("\n");
            System.out.println("Cod. da consulta: " + consulta.getCodigo());
            System.out.println("Nome do Paciente: " + consulta.getPaciente());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            System.out.println("Data: " + formatter.format(consulta.getDataConsulta()));
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("Tipo: " + consulta.getTipoConsulta().getDuracao());
            System.out.println("Doutor: " + consulta.getMedico());
        }
    }

    /**
     * Gera o relatorio de celular a partir da lista criada no RelatorioConsultasController referente aos pacientes que tem celular celular
     */
    private void gerarRelatorioCelular() {
        for (Consulta consulta : RelatorioConsultasController.pacientesComCelular()) {
            System.out.println("\n");
            System.out.println("Cod.: " + consulta.getCodigo());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            System.out.println("Data: " + formatter.format(consulta.getDataConsulta()));
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("Tipo: " + consulta.getTipoConsulta().getDuracao());
            System.out.println("Nome do Paciente: " + consulta.getPaciente());
            System.out.println("Doutor: " + consulta.getMedico());
        }

    }
}
