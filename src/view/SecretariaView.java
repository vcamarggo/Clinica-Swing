/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author guest-xc8RJZ
 */
public class SecretariaView implements View {

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Perfil Secretária.");
        System.out.println("Selecione uma ação: ");
        System.out.println("1 - Pacientes");
        System.out.println("2 - Consultas");
        System.out.println("3 - Relatórios");
        System.out.println("4 - Voltar");
        System.out.println("5 - Sair");

        switch (scan.nextInt()) {
            case 1:
                PacienteView pacienteView = new PacienteView();
                pacienteView.exibeInterface();
                break;
            case 2:
                ConsultaView consultaView = new ConsultaView();
                consultaView.exibeInterface();
                break;
            case 3:
                break;
            case 4:
                fecharInterface();
                break;
            default:
                System.exit(0);
                break;

        }

    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

}
