package view;

import enumeration.Usuario;
import java.util.Scanner;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class TrabalhoPOO1 {

    private static Usuario usuario;

    /**
     * Metodo main. Inicia o sistema.
     * @param args.
     */
    public static void main(String[] args) {
        iniciaSistema();
    }

    /**
     * Abre a primeira interface para selecao de usuario e redireciona para a
     * view correspondente.
     */
    public static void iniciaSistema() {
        Scanner scan = new Scanner(System.in);
        int opcao;

        System.out.println("Bem Vindo ao Sistema Saúde & Cia");
        System.out.println("Selecione um perfil de usuário: ");
        System.out.println("1 - Médico");
        System.out.println("2 - Secretária");
        System.out.println("3 - Gerenciador de mensagens");
        System.out.println("4 - Sair \n");
        do {
            opcao = scan.nextInt() - 1;
        } while (opcao < -1 && opcao > 5);
        if (opcao == 3) {
            System.exit(0);
        }

        usuario = Usuario.values()[opcao];

        View view = usuario.iniciaView();
        view.exibeInterface();
    }

    /**
     * Construtor padrao.
     */
    public TrabalhoPOO1() {
    }

}
