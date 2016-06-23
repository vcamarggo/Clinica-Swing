/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import model.Atestado;
import model.DeclaracaoAcompanhamento;
import model.Receita;
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

        System.out.println("\n***Perfil Secretária***");
        System.out.println("Criacao de Relatórios Médicos");
        System.out.println("Selecione o relatório desejado:");
        System.out.println("1. Receita médica");
        System.out.println("2. Atestado");
        System.out.println("3. Declaração de Acompanhamento");
        System.out.println("4. Clientes Atendidos no Mês");
        System.out.println("5. Retornar");
        
        switch (scan.nextInt()) {
            case 1:
                relatorioMedico = new Receita();
                relatorioMedico.preencheDados();
                relatorioMedico.exibeRelatorio();
                break;
            case 2:
                relatorioMedico = new Atestado();
                relatorioMedico.preencheDados();
                relatorioMedico.exibeRelatorio();
                break;
            case 3:
                relatorioMedico = new DeclaracaoAcompanhamento();
                relatorioMedico.preencheDados();
                relatorioMedico.exibeRelatorio();
                break;
            case 4:
                gerarRelatorioClientesAtendidosNoMes();
                break;
            case 5:
                fecharInterface();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    @Override
    public void fecharInterface() {

    }
    
    public void gerarReceita(){
        
    }

    public void gerarAtestado(){
        
    }
    
    public void gerarDeclaracaoAcompanhamento(){
        
    }
    
    public void gerarRelatorioClientesAtendidosNoMes(){
        
    }
    
}
