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
        System.out.println("Relatório de Consultas");
        System.out.println("Selecione o Filtro:");
        System.out.println("1. por email");
        System.out.println("2. por celular");
        
        switch(scan.nextInt()){
            case 1:
                
        }
    }

    @Override
    public void fecharInterface() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
