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
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Consulta;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorDeMensagensView implements View {

    private static final String NUMERO_CONSULTORIO =  "(44) 3034-0608";
    private static final String CELULAR_CONSULTORIO = "(44) 9809-6677";
    /**
     * Construtor padrao.
     */
    public GerenciadorDeMensagensView() {
    }

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        String dataHoje;

        System.out.println("\nPerfil Gerenciador de Mensagens.");
        System.out.println("Favor, entre com a data de hoje: ");
        dataHoje = scan.nextLine();
        
        System.out.println("\nO Sistema está verificando as consultas relativas ao dia seguinte. . . .");

        /**
         * Transformo a string que contêm a data de usamoshoje em um tipo Date. 
         * Como pode ocorrer erro na transformação, usamos o try catch
         */
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date data = null;
        try {
            data = formatter.parse(dataHoje);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciadorDeMensagensView.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        /**
         * Preciso somar +1 dia na data
         */
        
        /**
         * Envia SMS ou email. Se o paciente tiver tanto SMS quanto EMAIL, envia apenas SMS
         */
        System.out.println("\nEnviando SMS/Email para os pacientes que tem consulta amanhã. . . .");
        for (Consulta consulta : GerenciadorMensagemController.consultasDoDiaSeguinte(data)) {
            if (PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null) {
                System.out.println("\n***SMS***");
                System.out.println("De: " + CELULAR_CONSULTORIO);
                System.out.println("Para: " + PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular());
            } 
            else {
                System.out.println("\n***EMAIL***");
                System.out.println("De: saudeecia@gmail.com");
                System.out.println("Para: " + PacienteController.getPacienteByNome(consulta.getPaciente()).getEmail());
            }
            System.out.println("\nOla senhor(a) " + consulta.getPaciente() + ",");
            System.out.println("A clinica Saude e CIA gostaria de lembra-lo que amanha (" + consulta.getDataConsulta() + ") o senhor(a) tem uma consulta as " + consulta.getHora() + " com o Doutor(a) " + consulta.getMedico());
            System.out.println("Qualquer dúvida mande nos um email ou ligue para o telefone " + NUMERO_CONSULTORIO + "\n");           
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
