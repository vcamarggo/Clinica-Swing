/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RelatorioConsultasController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.Consulta;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class RelatorioConsultasView implements View {

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
        
        
        System.out.println("Selecione o Filtro:");
        System.out.println("1. Email");
        System.out.println("2. Celular");

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
