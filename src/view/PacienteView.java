/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PacienteController;
import enumeration.TipoConvenio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Paciente;

/**
 *
 * @author V.Camargo
 */
public class PacienteView implements View {

    static Scanner scan = new Scanner(System.in);
    static final String PACIENTE_NAO_ENCONTRADO = "Paciente não encontrado.";

    @Override
    public void exibeInterface() {
        System.out.println("\nPerfil Secretária.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir Paciente");
        System.out.println("2 - Alterar Paciente");
        System.out.println("3 - Remover Paciente");
        System.out.println("4 - Gerar Relatório do Paciente");
        System.out.println("5 - Voltar à seleção de usuários");
        System.out.println("6 - Sair");

        switch (scan.nextInt()) {
            case 1:
                inserirPaciente();
                break;
            case 2:
                alterarPaciente();
                break;
            case 3:
                removerPaciente();
                break;
            case 4:
                gerarRelatorioPaciente();
                break;
            case 5:
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

    private Paciente getPaciente() {
        System.out.println("Insira o nome do paciente desejado:");
        return PacienteController.getPacienteByNome(scan.next());
    }

    private void inserirPaciente() {
        Paciente paciente = new Paciente();
        pegaDadosPaciente(paciente);
        exibeInterface();
    }

    private void gerarRelatorioPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            System.out.println(PACIENTE_NAO_ENCONTRADO);
        } else {
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Data nascimento: " + paciente.getDataNascimento());
            System.out.println("Contato: " + paciente.getContato());
            System.out.println("Endereço: " + paciente.getEndereco());
            System.out.println("Tipo convênio: " + paciente.getTipoConvenio().toString());
        }
        exibeInterface();
    }

    private void removerPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            System.out.println(PACIENTE_NAO_ENCONTRADO);
        } else {
            PacienteController.removePaciente(paciente);
        }
        exibeInterface();

    }

    private void pegaDadosPaciente(Paciente paciente) {
        boolean dadosCorretos = true;
        do {
            try {
                System.out.println("Insira nome:");
                paciente.setNome(scan.next());
                System.out.println("Insira data de nascimento:");
                DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                paciente.setDataNascimento((Date) formatter.parse(scan.next()));
                System.out.println("Insira endereço:");
                paciente.setEndereco(scan.next());
                System.out.println("Insira contato:");
                paciente.setContato(scan.next());
                System.out.println("Insira convênio: (1) PARTICULAR,"
                        + " (2) PLANO DE SAÚDE");
                paciente.setTipoConvenio(TipoConvenio.values()[scan.nextInt() - 1]);
            } catch (Exception ex) {
                System.out.println("Houve um erro nos dados inseridos. "
                        + "Favor reiniciar o preenchimento dos dados do paciente.");
                dadosCorretos = false;
            }
        } while (!dadosCorretos);
    }

    private void alterarPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            System.out.println(PACIENTE_NAO_ENCONTRADO);
        } else {
            pegaDadosPaciente(paciente);
        }
        exibeInterface();
    }

}