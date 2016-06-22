/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GerenciadorMensagemController;
import controller.PacienteController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Consulta;
import model.MensagemEmail;
import model.MensagemSMS;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorDeMensagensView implements View {

    /**
     * Construtor padrao.
     */
    public GerenciadorDeMensagensView() {
    }

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        String dataHoje;

        System.out.println("\n-----------------------------------");
        System.out.println("| Perfil Gerenciador de Mensagens |");
        System.out.println("-----------------------------------");
        System.out.println("Favor, entre com a data de hoje (dd/mm/aaaa): ");
        dataHoje = scan.nextLine();
        
        System.out.println("\nO Sistema está verificando se possui consultas relativas ao dia seguinte. . . .");

        /**
         * Transformo a string que contêm a data de usamoshoje em um tipo Date. 
         * Como pode ocorrer erro na transformação, usamos o try catch
         */
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Calendar dataAmanha = Calendar.getInstance();
        
        /**
         * Transformo a string recebida no formato certo da data e adiciono um dia.
         */
        try {
            dataAmanha.setTime(formatter.parse(dataHoje));
            dataAmanha.add(Calendar.DAY_OF_MONTH,1);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciadorDeMensagensView.class.getName()).log(Level.SEVERE, null, ex);
        }    

        /**
         * Envia SMS ou email. Se o paciente tiver tanto SMS quanto EMAIL, envia apenas SMS
         */
        System.out.println("\nEnviando SMS/Email para os pacientes que tem consulta amanhã. . . .");
        for (Consulta consulta : GerenciadorMensagemController.consultasDoDiaSeguinte(dataAmanha)) {
            if (GerenciadorMensagemController.pacientePossuiCelular(consulta)) {
                MensagemSMS sms = new MensagemSMS();
                sms.ExibirMensagem(consulta);    
            } 
            else if(GerenciadorMensagemController.pacientePossuiEmail(consulta)){
                MensagemEmail email = new MensagemEmail();
                email.ExibirMensagem(consulta);
            }
            else{
                System.out.println("Há uma consulta do paciente " + consulta.getPaciente() +" mas este não possui celular/email");
            }
        }
        System.out.println("Tecle para sair");
        scan.nextLine();
        fecharInterface();

    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }
}
