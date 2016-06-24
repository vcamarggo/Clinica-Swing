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

    private static String dataHoje;
    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
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
        System.out.println("Favor, entre com a data de hoje (dd/mm/aaaa): ");
        dataHoje = scan.nextLine();

        transformaDataHojeParaDataAmanha();
        verificaSeHaConsultasParaAmanha();
      
        System.out.println("\nTecle para voltar");
        scan.nextLine();
        fecharInterface();

    }

    /**
     * Transformo a string recebida no formato certo da data e adiciono um dia.
     * Tratamento de erro em caso de erro na formatação 
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
     * Verifica todas as consultas da data de amanhã.
     * Envia SMS ou email. Se o paciente tiver tanto SMS quanto EMAIL, envia apenas SMS.
     */
    public void verificaSeHaConsultasParaAmanha() {
        //Objeto abstrato, poderá receber instancia de qlq classe que herde dela. é instanciada em tempo de execução
        Mensagem mensagem;
        
        System.out.println("\nO Sistema está verificando se possui consultas relativas ao dia seguinte. . . .");
        
        //percorre a lista de consultas da data de amanhã
        for (Consulta consulta : GerenciadorMensagemController.consultasDoDiaSeguinte(dataAmanha)) {
            if (GerenciadorMensagemController.pacientePossuiCelular(consulta)) {
                mensagem = new MensagemSMS();
                mensagem.ExibirMensagem(consulta);
            } else if (GerenciadorMensagemController.pacientePossuiEmail(consulta)) {
                mensagem = new MensagemEmail();
                mensagem.ExibirMensagem(consulta);
            } else {
                System.out.println("Há uma consulta do paciente " + consulta.getPaciente() + " mas este não possui celular/email");
            }
        }
    }
    
    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }
    
}
