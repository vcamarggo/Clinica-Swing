package controller;

import java.util.Scanner;
import view.View;

/**
 *
 * @author guest-xc8RJZ
 */
public class GerenciadorMensagemController implements View{

    @Override
    public void exibeInterface() {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
    }

    @Override
    public void fecharInterface() {
    }

    public GerenciadorMensagemController() {
    }

}
