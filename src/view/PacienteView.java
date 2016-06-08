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
        System.out.print("Insira o nome do paciente desejado: ");
        return PacienteController.getPacienteByNome(scan.next());
    }

    private void inserirPaciente() {
        Paciente paciente = new Paciente();
        pegaDadosPaciente(paciente);
        if (PacienteController.adicionarPaciente(paciente) == 0) {
            System.out.println("Paciente não inserido com sucesso.");
        } else {
            System.out.println("Paciente inserido com sucesso.");
        }
        exibeInterface();
    }

    private void gerarRelatorioPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            System.out.println(PACIENTE_NAO_ENCONTRADO);
        } else {
            System.out.println("Nome: " + paciente.getNome());
            // Mayza, use DateFormat aqui pra pegar o Date e converter em String dd/MM/yyyy
            System.out.println("Data nascimento: " + paciente.getDataNascimento());
            System.out.println("Telefone: " + paciente.getTelefone());
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
            System.out.println("Paciente removido com sucesso.");
        }
        exibeInterface();

    }

    private void pegaDadosPaciente(Paciente paciente) {
        boolean dadosCorretos = true;
        do {
            try {
                System.out.print("Insira nome: ");
                paciente.setNome(scan.next());
                System.out.print("Insira data de nascimento: ");
                DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                paciente.setDataNascimento((Date) formatter.parse(scan.next()));
                System.out.print("Insira endereço: ");
                paciente.setEndereco(scan.next());
                System.out.print("Insira telefone residencial: ");
                paciente.setTelefone(scan.next());
                
                //ARRUMAR OPCIONAL QQ O SCAN VAI PEGAR
                System.out.print("Insira celular (opcional): ");
                paciente.setCelular(scan.next());
                System.out.print("Insira email (opcional): ");
                paciente.setEmail(scan.next());
                System.out.print("Insira convênio: (1) PARTICULAR,"
                        + " (2) PLANO DE SAÚDE  ");
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
            System.out.println("Paciente alterado com sucesso.");
        }
        exibeInterface();
    }

    public PacienteView() {
    }

}
