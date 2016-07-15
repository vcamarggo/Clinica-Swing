package view;

import java.util.Scanner;
import javax.swing.JFrame;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class SecretariaView extends JFrame {

    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n---------------------");
            System.out.println("| Perfil Secretária |");
            System.out.println("---------------------");
            System.out.println(" Selecione uma ação: ");
            System.out.println(" 1 - Pacientes");
            System.out.println(" 2 - Consultas");
            System.out.println(" 3 - Relatórios");
            System.out.println(" 4 - Voltar à seleção de usuários");
            System.out.println(" 5 - Sair");

            switch (opcao = scan.nextInt()) {
                case 1:
                    exibeSubInterfacePaciente();
                    break;
                case 2:
                    exibeSubInterfaceConsulta();
                    break;
                case 3:
                    RelatorioConsultasView relatorioView = new RelatorioConsultasView();
                    relatorioView.exibeInterface();
                    break;
                case 4:
                    fecharInterface();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        } while (opcao != 4);

    }

    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    /**
     * Exibe a subinterface referente ao paciente com as ações que a secretária
     * pode executar.
     */
    public void exibeSubInterfacePaciente() {
        Scanner scan = new Scanner(System.in);
        PacienteView pacienteView = new PacienteView();

        System.out.println("\nPerfil Secretária para Pacientes.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir paciente");
        System.out.println("2 - Alterar paciente");
        System.out.println("3 - Remover paciente");
        System.out.println("4 - Gerar relatório do paciente");
        System.out.println("5 - Voltar à menu secretária");
        System.out.println("6 - Voltar à seleção de usuários");

        switch (scan.nextInt()) {
            case 1:
                pacienteView.inserirPaciente();
                break;
            case 2:
                pacienteView.alterarPaciente();
                break;
            case 3:
                pacienteView.removerPaciente();
                break;
            case 4:
                pacienteView.gerarRelatorioPaciente();
                break;
            case 5:
                exibeInterface();
                break;
            case 6:
                fecharInterface();
                break;
            default:
                System.err.println("Opção inválida!\n");
                exibeSubInterfacePaciente();
                break;

        }
    }

    public void exibeSubInterfaceConsulta() {
        Scanner scan = new Scanner(System.in);
        ConsultaView consultaView = new ConsultaView();

        System.out.println("\nPerfil Secretária para Consultas.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir Consulta");
        System.out.println("2 - Alterar Consulta");
        System.out.println("3 - Remover Consulta");
        System.out.println("4 - Gerar Relatório de Consulta");
        System.out.println("5 - Voltar à menu secretária");
        System.out.println("6 - Voltar à seleção de usuários");

        switch (scan.nextInt()) {
            case 1:
                consultaView.inserirConsulta();
                break;
            case 2:
                consultaView.alterarConsulta();
                break;
            case 3:
                consultaView.removerConsulta();
                break;
            case 4:
                consultaView.gerarRelatorioConsulta();
                break;
            case 5:
                exibeInterface();
                break;
            case 6:
                fecharInterface();
                break;
            default:
                System.err.println("Opção inválida!\n");
                exibeSubInterfaceConsulta();
                break;

        }
    }

    /**
     * Construtor padrao.
     */
    public SecretariaView() {
    }

}
