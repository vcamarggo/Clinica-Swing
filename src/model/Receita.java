package model;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MayzaHirose
 */
public class Receita extends RelatorioMedico{
    
    private List<String> remedios;
    
    @Override
    public void preencheDados(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nome do paciente: ");
        this.setNomePaciente(scan.nextLine());
        System.out.println("Data da Consulta (dd/mm/aaaa): ");
        this.setDataConsulta(scan.nextLine());
        System.out.println("Assinatura do medico: ");
        this.setAssinaturaMedico(scan.nextLine());
        System.out.println("Insira o nome dos remédios. Tecle 0 para encerrar.");
        String remedio;
        while (!(remedio = scan.nextLine()).equals("0")) {
            getRemedios().add(remedio);
        }
        System.out.println("Receita criada com sucesso!\n");                
    }  
    
    @Override
    public void exibeRelatorio(){
        
    }

    public List<String> getRemedios() {
        return remedios;
    }

    public void setRemedios(List<String> remedios) {
        this.remedios = remedios;
    }
   
    
    
}
