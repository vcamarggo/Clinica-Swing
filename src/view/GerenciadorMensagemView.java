package view;

import controller.GerenciadorMensagemController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorMensagemView implements View {

    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
    private static String dataHoje;
    private static Calendar dataAmanha = Calendar.getInstance();
    private GerenciadorMensagemController gerenciadorDeMensagemController;

    /**
     * Construtor padrao.
     */
    public GerenciadorMensagemView() {
    }

    public GerenciadorMensagemView(GerenciadorMensagemController gerenciadorDeMensagemController) {
        this.gerenciadorDeMensagemController = gerenciadorDeMensagemController;
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
        gerenciadorDeMensagemController.verificaSeHaConsultasParaAmanha(dataAmanha);

        System.out.println("\nTecle para voltar");
        scan.nextLine();
        fecharInterface();

    }

    /**
     * Transformo a string dataHoje recebida na formatação certa e adiciono um
     * dia. Tratamento de erro em caso de erro na formatação.
     */
    public void transformaDataHojeParaDataAmanha() {
        try {
            dataAmanha.setTime(FORMATTER.parse(dataHoje));
            dataAmanha.add(Calendar.DAY_OF_MONTH, 1);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciadorMensagemView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

}
