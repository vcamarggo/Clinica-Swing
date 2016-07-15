package view;

import java.util.Scanner;
import javax.swing.JFrame;
import model.AtestadoMedico;
import model.DeclaracaoAcompanhamento;
import model.ReceitaMedica;
import model.RelatorioMedico;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class RelatoriosMedicosView extends JFrame {
  
    /**
     * Construtor padrao.
     */
    public RelatoriosMedicosView() {
    }

    public void exibeInterface(){ 
        Scanner scan = new Scanner(System.in);
        
        //Objeto abstrato que receberá uma instancia de seu tipo em tempo de execução.
        RelatorioMedico relatorioMedico;
    
        System.out.println("\nPerfil Médico para relatórios");
        System.out.println("Criacao de Relatórios Médicos");
        System.out.println("Selecione o relatório desejado:");
        System.out.println("1. Receita médica");
        System.out.println("2. Atestado");
        System.out.println("3. Declaração de Acompanhamento");
        System.out.println("4. Retornar à seleção de usuários");
        
        switch (scan.nextInt()) {
            case 1:
                relatorioMedico = new ReceitaMedica();
                relatorioMedico.preencheDados();
                relatorioMedico.gerarRelatorio();
                break;
            case 2:
                relatorioMedico = new AtestadoMedico();
                relatorioMedico.preencheDados();
                relatorioMedico.gerarRelatorio();
                break;
            case 3:
                relatorioMedico = new DeclaracaoAcompanhamento();
                relatorioMedico.preencheDados();
                relatorioMedico.gerarRelatorio();
                break;
            case 4:
                fecharInterface();
                break;
            default:
                System.err.println("Opção inválida! \n");
                exibeInterface();
                break;
        }
    }

    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }
 
}
