package view;

import controller.ConsultaController;
import enumeration.TipoConsulta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Consulta;

/**
 *
 * @author guest-xc8RJZ
 */
public class ConsultaView implements View {

    private static List<Consulta> consultas;

    static Scanner scan = new Scanner(System.in);
    static final String CONSULTA_NAO_ENCONTRADA = "Consulta não encontrada.";

    @Override
    public void exibeInterface() {
        System.out.println("\nPerfil Secretária.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir Consulta");
        System.out.println("2 - Alterar Consulta");
        System.out.println("3 - Remover Consulta");
        System.out.println("4 - Gerar Relatório do Consulta");
        System.out.println("5 - Voltar à seleção de usuários");
        System.out.println("6 - Sair");

        switch (scan.nextInt()) {
            case 1:
                inserirConsulta();
                break;
            case 2:
                alterarConsulta();
                break;
            case 3:
                removerConsulta();
                break;
            case 4:
                gerarRelatorioConsulta();
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

    private Consulta getConsulta() {
        System.out.print("Insira o cód da consulta desejada: ");
        return ConsultaController.getConsultaByCodigo(scan.nextInt());
    }

    private void inserirConsulta() {
        Consulta consulta = new Consulta();
        pegaDadosConsulta(consulta);
        switch (ConsultaController.adicionarConsulta(consulta)) {
            case 0:
                System.out.println("Consulta inserida com sucesso.");
                break;
            case 1:
                System.out.println("Consulta não inserida com sucesso. "
                        + " Código da consulta já existente.");
                break;
            case 2:
                System.out.println("Consulta não inserida com sucesso."
                        + " Paciente não existe.");
                break;
        }
        exibeInterface();
    }

    private void gerarRelatorioConsulta() {
        Consulta consulta = getConsulta();
        if (consulta == null) {
            System.out.println(CONSULTA_NAO_ENCONTRADA);
        } else {
            System.out.println("Nome: " + consulta.getCodigo());
            // Mayza, use DateFormat aqui pra pegar o Date e converter em String dd/MM/yyyy
            System.out.println("Data nascimento: " + consulta.getDataConsulta());
        }
        exibeInterface();
    }

    private void removerConsulta() {
        Consulta consulta = getConsulta();
        if (consulta == null) {
            System.out.println(CONSULTA_NAO_ENCONTRADA);
        } else {
            ConsultaController.removeConsulta(consulta);
            System.out.println("Consulta removida com sucesso.");
        }
        exibeInterface();

    }

    private void pegaDadosConsulta(Consulta consulta) {
        boolean dadosCorretos = true;
        do {
            try {
                System.out.print("Insira cod: ");
                consulta.setCodigo(scan.nextInt());
                System.out.print("Insira data: ");
                DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                consulta.setDataConsulta((Date) formatter.parse(scan.next()));
                System.out.print("Insira hora: ");
                consulta.setHora(scan.next());
                System.out.print("Insira nome do paciente: ");
                consulta.setPaciente(scan.next());
                System.out.print("Insira médico: ");
                consulta.setMedico(scan.next());
                System.out.print("Insira convênio: (1) NORMAL,"
                        + " (2) RETORNO   ");
                consulta.setTipoConsulta(TipoConsulta.values()[scan.nextInt() - 1]);
            } catch (Exception ex) {
                System.out.println("Houve um erro nos dados inseridos. "
                        + "Favor reiniciar o preenchimento dos dados do consulta.");
                dadosCorretos = false;
            }
        } while (!dadosCorretos);
    }

    private void alterarConsulta() {
        Consulta consulta = getConsulta();
        if (consulta == null) {
            System.out.println(CONSULTA_NAO_ENCONTRADA);
        } else {
            pegaDadosConsulta(consulta);
            System.out.println("Consulta alterado com sucesso.");
        }
        exibeInterface();
    }

    public ConsultaView() {
    }

}
