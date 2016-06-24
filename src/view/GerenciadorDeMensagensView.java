package view;

import controller.GerenciadorMensagemController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Consulta;
import model.Mensagem;
import model.MensagemEmail;
import model.MensagemSMS;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorDeMensagensView implements View {

    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
    private static String dataHoje;
    private static Calendar dataAmanha = Calendar.getInstance();

    /**
     * Construtor padrao.
     */
    public GerenciadorDeMensagensView() {
    }

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n-----------------------------------");
        System.out.println("| Perfil Gerenciador de Mensagens |");
        System.out.println("-----------------------------------");
        System.out.println("O Gerenciador de Mensagens irá enviar mensagem para os pacientes que tem consulta amanhã.");
        System.out.println("Favor, entre com a data de HOJE (dd/mm/aaaa): ");
        dataHoje = scan.nextLine();

        transformaDataHojeParaDataAmanha();
        verificaSeHaConsultasParaAmanha();

        System.out.println("\nTecle para voltar");
        scan.nextLine();
        fecharInterface();

    }

    /**
     * Transformo a string dataHoje recebida na formatação certa e adiciono um dia.
     * Tratamento de erro em caso de erro na formatação.
     */
    public void transformaDataHojeParaDataAmanha() {
        try {
            dataAmanha.setTime(FORMATTER.parse(dataHoje));
            dataAmanha.add(Calendar.DAY_OF_MONTH, 1);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciadorDeMensagensView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Verifica todas as consultas da data de amanhã. Envia SMS ou email. Se o
     * paciente tiver tanto SMS quanto EMAIL, envia apenas SMS.
     */
    public void verificaSeHaConsultasParaAmanha() {
        //Objeto abstrato, poderá receber instancia de qlq classe que herde dela. É instanciada em tempo de execução.
        Mensagem mensagem = null;

        System.out.println("\nO Sistema está verificando se possui consultas relativas ao dia seguinte. . . .");

        //Percorre a lista de consultas da data de amanhã. 
        for (Consulta consulta : GerenciadorMensagemController.consultasDoDiaSeguinte(dataAmanha)) {
            //Verifica se o Paciente da Consulta possui celular/email ou nada.
            if (GerenciadorMensagemController.pacientePossuiCelular(consulta)) {
                mensagem = new MensagemSMS();
            } else if (GerenciadorMensagemController.pacientePossuiEmail(consulta)) {
                mensagem = new MensagemEmail();
            } else {
                System.out.println("\n*Há uma consulta do paciente " + consulta.getPaciente() + " mas este não possui celular/email.");
                return;
            }
            mensagem.exibirMensagem(consulta);
        }
    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

}
