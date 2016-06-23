package model;

import java.util.Scanner;

/**
 *
 * @author MayzaHirose
 */
public class Atestado extends RelatorioMedico{   
    private String rg;
    private String horarioConsulta;
    private String diasDescanso;
    
    @Override
    public void preencheDados(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nome do paciente: ");
        this.setNomePaciente(scan.nextLine());
        System.out.println("RG do paciente: ");
        setRg(scan.nextLine());
        System.out.println("Data da Consulta (dd/mm/aaaa): ");
        this.setDataConsulta(scan.nextLine());
        System.out.println("Horario da Consulta: ");
        setHorarioConsulta(scan.nextLine());
        System.out.println("Quantos dias de descanso?: ");
        setDiasDescanso(scan.nextLine());
        System.out.println("Assinatura do medico: ");
        this.setAssinaturaMedico(scan.nextLine());
        System.out.println("Atestado gerado com sucesso!\n");
    }   
    
    @Override
    public void exibeRelatorio(){
        
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getDiasDescanso() {
        return diasDescanso;
    }

    public void setDiasDescanso(String diasDescanso) {
        this.diasDescanso = diasDescanso;
    }
    
    
}
