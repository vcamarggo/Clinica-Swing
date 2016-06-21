package view;

import java.util.Scanner;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class MedicoView implements View {

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n-----------------");
            System.out.println("| Perfil Médico |");
            System.out.println("-----------------");
            System.out.println(" Selecione uma ação: ");
            System.out.println(" 1 - Pacientes");
            System.out.println(" 2 - Relatórios");
            System.out.println(" 3 - Voltar à seleção de usuários");
            System.out.println(" 4 - Sair");

            switch (opcao = scan.nextInt()) {
                case 1:
                    exibeSubInterfacePaciente();
                    break;
                case 2:
                    RelatorioPacienteView relatorioView = new RelatorioPacienteView();
                    relatorioView.exibeInterface();
                    break;
                case 3:
                    fecharInterface();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 4);

    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    /**
     * Construtor padrao.
     */
    public MedicoView() {
    }

    /**
     * Exibe a subinterface referente ao paciente com as ações que a secretária
     * pode executar.
     */
    public void exibeSubInterfacePaciente() {
        Scanner scan = new Scanner(System.in);
        PacienteView pacienteView = new PacienteView();
        int opcao;

        System.out.println("\nPerfil Médico para Pacientes.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir Dados Adicionais Paciente");
        System.out.println("2 - Alterar Dados Adicionais Paciente");
        System.out.println("3 - Remover Dados Adicionais Paciente");
        System.out.println("4 - Relatório Dados Adicionais Paciente");
        System.out.println("5 - Voltar à menu Médico");
        System.out.println("6 - Volta à seleção de usuários");

        switch (opcao = scan.nextInt()) {
            case 1:
                pacienteView.dadosAdicionaisPaciente(false);
                break;
            case 2:
                pacienteView.dadosAdicionaisPaciente(true);
                break;
            case 3:
                pacienteView.removerDadosAdicionaisPaciente();
                break;
            case 4:
                pacienteView.gerarRelatorioMedicoPaciente();
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
}
