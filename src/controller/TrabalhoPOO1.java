package controller;

import javax.swing.UIManager;
import view.SelecaoPerfilView;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class TrabalhoPOO1 {

    public static void main(String[] args) {
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* Tenta usar o Look and Feel Windows Classic. 
//         * Se nao achar, usa outra.
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                //System.out.println(info);//teste pra mostrar as look and feel do SO
//                if ("Windows Classic".equals(info.getName())) {
//                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TrabalhoPOO1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
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
