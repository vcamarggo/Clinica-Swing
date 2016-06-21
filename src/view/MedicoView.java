package view;

import controller.PacienteController;
import java.util.Scanner;

/**
 *
 * @author guest-xc8RJZ
 */
public class MedicoView implements View {

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Perfil Médico.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Pacientes");
        System.out.println("2 - Relatórios");
        System.out.println("3 - Voltar");
        System.out.println("4 - Sair");

        switch (scan.nextInt()) {
            case 1:
                exibeSubInterfacePaciente();
                break;
            case 2:
                RelatorioConsultasView relatorioView = new RelatorioConsultasView();
                relatorioView.exibeInterface();
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

    public MedicoView() {
    }
    
    public void exibeSubInterfacePaciente(){
        Scanner scan = new Scanner(System.in);
        PacienteView pacienteView = new PacienteView();
        int opcao;
        do {
            System.out.println("\nPerfil Médico para Pacientes.");
            System.out.println("Selecione uma ação: ");
            System.out.println("1 - Inserir Dados Adicionais Paciente");
            System.out.println("2 - Alterar Dados Adicionais Paciente");
            System.out.println("3 - Remover Dados Adicionais Paciente");
            System.out.println("4 - Relatório Dados Adicionais Paciente");
            System.out.println("5 - Voltar");
            System.out.println("6 - Sair");
        
            switch ( opcao = scan.nextInt()) {
                case 1:
                    pacienteView.dadosAdicionaisPaciente( false );
                    break;
                case 2:
                    pacienteView.dadosAdicionaisPaciente( true );
                    break;
                case 3:
                    pacienteView.removerDadosAdicionaisPaciente();
                    break;
                case 4:
                    pacienteView.gerarRelatorioMedicoPaciente();
                    break;
                case 5:
                    fecharInterface();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }while( opcao != 5);
    }
}
