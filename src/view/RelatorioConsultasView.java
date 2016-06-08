/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void gerarRelatorioCelular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
