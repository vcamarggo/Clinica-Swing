package view;

import java.util.Scanner;
import model.AtestadoMedico;
import model.DeclaracaoAcompanhamento;
import model.ReceitaMedica;
import model.RelatorioMedico;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class RelatoriosMedicosView implements View {
  
    /**
     * Construtor padrao.
     */
    public RelatoriosMedicosView() {
    }

    @Override
    public void exibeInterface(){ 
        
        RelatorioMedico relatorioMedico;
    
        Scanner scan = new Scanner(System.in);

        System.out.println("\nPerfil Médico para relatórios");
        System.out.println("Criacao de Relatórios Médicos");
        System.out.println("Selecione o relatório desejado:");
        System.out.println("1. Receita médica");
        System.out.println("2. Atestado");
        System.out.println("3. Declaração de Acompanhamento");
        System.out.println("4. Retornar");
        
        switch (scan.nextInt()) {
            case 1:
                relatorioMedico = new ReceitaMedica();
                relatorioMedico.preencheDados();
                relatorioMedico.exibeRelatorio();
                break;
            case 2:
                relatorioMedico = new AtestadoMedico();
                relatorioMedico.preencheDados();
                relatorioMedico.exibeRelatorio();
                break;
            case 3:
                relatorioMedico = new DeclaracaoAcompanhamento();
                relatorioMedico.preencheDados();
                relatorioMedico.exibeRelatorio();
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
