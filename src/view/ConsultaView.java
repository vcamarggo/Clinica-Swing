package view;

import enumeration.TipoConsulta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import model.Consulta;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class ConsultaView extends JFrame {

    static final String CONSULTA_NAO_ENCONTRADA = "Consulta não encontrada.";

    public void exibeInterface() {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        System.out.println("Operação realizada às: " + formatter.format(Calendar.getInstance().getTime()));
    }

    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    /**
     * Pega consulta atraves do codigo digitado.
     */
    private Consulta getConsulta() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira o cód da consulta desejada: ");
        return Consulta.getConsultaByCodigo(scan.nextInt());
    }

    /**
     * Insere uma consulta para um paciente caso o mesmo exista.
     */
    public void inserirConsulta() {
        Consulta consulta = new Consulta();
        pegaDadosConsulta(consulta);
        switch (Consulta.adicionarConsulta(consulta)) {
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
            System.out.println(" -------------------------");
            System.out.println("Cod.: " + consulta.getCodigo());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            System.out.println("Data: " + formatter.format(consulta.getDataConsulta()));
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("Tipo: " + consulta.getTipoConsulta().getDuracao());
            System.out.println("Nome do Paciente: " + consulta.getPaciente());
            System.out.println("Doutor: " + consulta.getMedico());
            System.out.println(" -------------------------\n");

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
            Consulta.removeConsulta(consulta);
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
