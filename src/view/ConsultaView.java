package view;

import controller.ConsultaController;
import enumeration.TipoConsulta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Consulta;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class ConsultaView implements View {

    //private static List<Consulta> consultas;
    //static Scanner scan = new Scanner(System.in);
    static final String CONSULTA_NAO_ENCONTRADA = "Consulta não encontrada.";

    @Override
    public void exibeInterface() {
       /* Scanner scan = new Scanner(System.in);

        System.out.println("\nPerfil Secretária.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Inserir Consulta");
        System.out.println("2 - Alterar Consulta");
        System.out.println("3 - Remover Consulta");
        System.out.println("4 - Gerar Relatório de Consulta");
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

        }*/
    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    /**
     * Pega consulta atraves do codigo digitado.
     */
    private Consulta getConsulta() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira o cód da consulta desejada: ");
        return ConsultaController.getConsultaByCodigo(scan.nextInt());
    }

    /**
     * Insere uma consulta para um paciente caso o mesmo exista.
     */
    public void inserirConsulta() {
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

    /**
     * Gera um relatorio de uma consulta atraves do codigo.
     */
    public void gerarRelatorioConsulta() {
        Consulta consulta = getConsulta();
        if (consulta == null) {
            System.out.println(CONSULTA_NAO_ENCONTRADA);
        } else {
            System.out.println("Cod.: " + consulta.getCodigo());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            System.out.println("Data: " + formatter.format(consulta.getDataConsulta()));
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("Tipo: " + consulta.getTipoConsulta().getDuracao());
            System.out.println("Nome do Paciente: " + consulta.getPaciente());
            System.out.println("Doutor: " + consulta.getMedico());

        }
        exibeInterface();
    }

    /**
     * Gera uma consulta correspondente ao codigo digitado.
     */
    public void removerConsulta() {
        Consulta consulta = getConsulta();
        if (consulta == null) {
            System.out.println(CONSULTA_NAO_ENCONTRADA);
        } else {
            ConsultaController.removeConsulta(consulta);
            System.out.println("Consulta removida com sucesso.");
        }
        exibeInterface();

    }

    /**
     * Pega os dados inseridos da consulta ate os mesmos serem validos.
     */
    public void pegaDadosConsulta(Consulta consulta) {
        Scanner scan = new Scanner(System.in);
        boolean dadosCorretos = true;
        do {
            try {
                System.out.print("Insira cod: ");
                consulta.setCodigo(Integer.parseInt(scan.nextLine()));
                System.out.print("Insira data: ");
                DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                consulta.setDataConsulta((Date) formatter.parse(scan.nextLine()));
                System.out.print("Insira hora: ");
                consulta.setHora(scan.nextLine());
                System.out.print("Insira nome do paciente: ");
                consulta.setPaciente(scan.nextLine());
                System.out.print("Insira médico: ");
                consulta.setMedico(scan.nextLine());
                System.out.print("Insira tipo de consulta: (1) NORMAL,"
                        + " (2) RETORNO   ");
                consulta.setTipoConsulta(TipoConsulta.values()[scan.nextInt() - 1]);
            } catch (Exception ex) {
                System.out.println("Houve um erro nos dados inseridos. "
                        + "Favor reiniciar o preenchimento dos dados do consulta.");
                dadosCorretos = false;
            }
        } while (!dadosCorretos);
    }

    public void alterarConsulta() {
        Consulta consulta = getConsulta();
        if (consulta == null) {
            System.out.println(CONSULTA_NAO_ENCONTRADA);
        } else {
            pegaDadosConsulta(consulta);
            System.out.println("Consulta alterado com sucesso.");
        }
        exibeInterface();
    }

    /**
     * Construtor padrao.
     */
    public ConsultaView() {
    }

}
