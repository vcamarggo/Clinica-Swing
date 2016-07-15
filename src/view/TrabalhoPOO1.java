package view;

import enumeration.Usuario;
import java.util.Scanner;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class TrabalhoPOO1 {

    public static void main(String[] args) {
        iniciaSistema();
    }

    /**
     * Abre a primeira interface para selecao de usuario e redireciona para a
     * view correspondente.
     */
    public static void iniciaSistema() {
        ViewInicial view = new ViewInicial();
        ControllerInicial controllerInicial = new ControllerInicial();
    }

    /**
     * Construtor padrao.
     */
    public TrabalhoPOO1() {
    }

}
