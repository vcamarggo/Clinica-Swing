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
     * 
     */
    public void exibeInterfaceDadosAdicionais(){
        Scanner scan = new Scanner(System.in);
        PacienteView pacienteView = new PacienteView();
        int opcao;

        System.out.println("\nPerfil Médico para Pacientes.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir Dados Adicionais Paciente");
        System.out.println("2 - Alterar Dados Adicionais Paciente");
        System.out.println("3 - Remover Dados Adicionais Paciente");
        System.out.println("4 - Voltar à menu Médico");
        System.out.println("5 - Volta à seleção de usuários");

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
                exibeInterface();
                break;
            case 5:
                fecharInterface();
                break;
            default:
                System.err.println("Opção inválida! \n");
                exibeSubInterfacePaciente();
                break;
        }
    }
    
    /**
     * 
     */
    public void exibeInterfaceProntuario(){
        Scanner scan = new Scanner(System.in);
        PacienteView pacienteView = new PacienteView();
        int opcao;

        System.out.println("\nPerfil Médico para Pacientes.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir Prontuário Paciente");
        System.out.println("2 - Alterar Prontuário Paciente");
        System.out.println("3 - Remover Prontuário Paciente");
        System.out.println("4 - Voltar à menu Médico");
        System.out.println("5 - Volta à seleção de usuários");

        switch (opcao = scan.nextInt()) {
            case 1:
                pacienteView.prontuarioPaciente(false);
                break;
            case 2: 
                pacienteView.prontuarioPaciente(true);
                break;
            case 3:
                pacienteView.removerDadosAdicionaisPaciente();
                break;
            case 4:
                exibeInterface();
                break;
            case 5:
                fecharInterface();
                break;
            default:
                System.err.println("Opção inválida! \n");
                exibeSubInterfacePaciente();
                break;
        }    
    }

    /**
     * Exibe a subinterface referente ao paciente com as ações que o médico
     * pode executar.
     */
    public void exibeSubInterfacePaciente() {
       Scanner scan = new Scanner(System.in);
        PacienteView pacienteView = new PacienteView();
        int opcao;

        System.out.println("\nPerfil Médico para Pacientes.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Dados Adicionais");
        System.out.println("2 - Prontuário");
        System.out.println("3 - Gerar Relatório" );
        System.out.println("3 - Volta à seleção de usuários");

        switch (opcao = scan.nextInt()) {
            case 1:
                exibeInterfaceDadosAdicionais();
                break;
            case 2: 
                exibeInterfaceProntuario();
                break;
            case 3:
                pacienteView.gerarRelatorioMedicoPaciente();
                break;
            case 4:
                fecharInterface();
                break;
            default:
                System.err.println("Opção inválida! \n");
                exibeSubInterfacePaciente();
                break;
        }  

    }
}