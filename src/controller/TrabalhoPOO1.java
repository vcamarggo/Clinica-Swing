package controller;

import view.SelecaoPerfilView;

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
        SelecaoPerfilController controller = new SelecaoPerfilController(new SelecaoPerfilView());
        controller.controla();
    }

    /**
     * Construtor padrao.
     */
    public TrabalhoPOO1() {
    }

}
