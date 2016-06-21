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

    /**
     * Construtor padrao.
     */
    public GerenciadorDeMensagensView() {
    }

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        String dataHoje;

        System.out.println("Perfil Gerenciador de Mensagens.");
        System.out.println("Favor, entre com a data de hoje: ");
        dataHoje = scan.nextLine();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date data = null;
        try {
            data = formatter.parse(dataHoje);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciadorDeMensagensView.class.getName()).log(Level.SEVERE, null, ex);
        }    
        System.out.println("Enviando SMS/Email para os pacientes . . .");
        for (Consulta consulta : GerenciadorMensagemController.consultasDoDia(data)) {
            if (PacienteController.getPacienteByNome(consulta.getPaciente()).getCelular() != null) {
                System.out.println("\n***SMS***");
            } else {
                System.out.println("\n***EMAIL***");

            }
            System.out.println("Ola senhor(a) " + consulta.getPaciente() + ",");
            System.out.println("A clinica Saude e CIA gostaria de lembra-lo que amanha o senhor tem uma consulta as " + consulta.getHora() + " com o Doutor(a) " + consulta.getMedico());
            System.out.println("Qualquer dúvida nos mande um email ou ligue para o telefone 3030-2021");

        }
        fecharInterface();

    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    /*private void exibeSubInterfacePaciente() {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }*/
}
