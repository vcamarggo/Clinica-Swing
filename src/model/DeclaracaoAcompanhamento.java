package model;

import java.util.Scanner;

/**
 *
 * @author MayzaHirose
 */
public class DeclaracaoAcompanhamento extends RelatorioMedico{
    
    private String nomeAcompanhante;    
    private String horarioConsulta;
    
    @Override
    public void preencheDados(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nome do paciente: ");
        this.setNomePaciente(scan.nextLine());
        System.out.println("Nome do Acompanhante: ");
        setNomeAcompanhante(scan.nextLine());
        System.out.println("Data da Consulta (dd/mm/aaaa): ");
        this.setDataConsulta(scan.nextLine());
        System.out.println("Horario da Consulta: ");
        setHorarioConsulta(scan.nextLine());
        System.out.println("Assinatura do medico: ");
        this.setAssinaturaMedico(scan.nextLine());
        System.out.println("Declaracao de Acompanhamento criada com sucesso!\n");
    }   
    
    @Override
    public void exibeRelatorio(){
        
    }

    public String getNomeAcompanhante() {
        return nomeAcompanhante;
    }

    public void setNomeAcompanhante(String nomeAcompanhante) {
        this.nomeAcompanhante = nomeAcompanhante;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }
    
    
    
}
