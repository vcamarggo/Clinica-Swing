package view;

import java.util.Scanner;

/**
 *
 * @author guest-xc8RJZ
 */
public class SecretariaView implements View {

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Perfil Secretária.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Pacientes");
        System.out.println("2 - Consultas");
        System.out.println("3 - Relatórios");
        System.out.println("4 - Voltar");
        System.out.println("5 - Sair");

        switch (scan.nextInt()) {
            case 1:
                exibeSubInterfacePaciente();
                break;
            case 2:
                ConsultaView consultaView = new ConsultaView();
                consultaView.exibeInterface();
                break;
            case 3:
                RelatorioConsultasView relatorioView = new RelatorioConsultasView();
                relatorioView.exibeInterface();
                break;
            case 4:
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
    
    
    public void exibeSubInterfacePaciente(){
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

    public SecretariaView() {
    }
    
}
