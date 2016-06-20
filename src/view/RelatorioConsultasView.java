/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RelatorioConsultasController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.Consulta;

/**
 *
 * @author MayzaHirose
 */
public class RelatorioConsultasView implements View{

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nPerfil Secretária.");
        System.out.println("Selecione o Filtro:");
        System.out.println("1. Email");
        System.out.println("2. Celular");
        
        switch(scan.nextInt()){
            case 1:
                gerarRelatorioEmail();
                break;
            case 2:
                gerarRelatorioCelular();
                break;
            case 3:
                fecharInterface();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    @Override
    public void fecharInterface() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void gerarRelatorioEmail() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("oookk");
        for(Consulta consulta: RelatorioConsultasController.relatoriosEmail()){
            System.out.println("\n");
            System.out.println("Cod.: " + consulta.getCodigo());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            System.out.println("Data: " + formatter.format(consulta.getDataConsulta()));
            System.out.println("Hora: " + consulta.getHora());
            System.out.println("Tipo: " + consulta.getTipoConsulta().getDuracao());
            System.out.println("Nome do Paciente: " + consulta.getPaciente());
            System.out.println("Doutor: " + consulta.getMedico());
        }  
    }

    private void gerarRelatorioCelular() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
}
