package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class ReceitaMedica extends RelatorioMedico {

    private List<String> remedios = new ArrayList<>();

    /**
     * Método que recebe os dados para criacao da receita médica.
     */
    @Override
    public void preencheDados() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nNome do paciente: ");
        this.setNomePaciente(scan.nextLine());
        System.out.println("Data da Consulta (dd/mm/aaaa): ");
        this.setDataConsulta(scan.nextLine());
        System.out.println("Assinatura do medico: ");
        this.setAssinaturaMedico(scan.nextLine());
        System.out.println("Insira o nome do remédio e tecle Enter. Tecle 0 para encerrar.");
        String remedio;
        remedio = scan.nextLine();
        do {
            setRemedios(remedio);
            remedio = scan.nextLine();
        } while (!(remedio.equals("0")));
        System.out.println("*Receita criada com sucesso!\n");
    }

    /**
     * Método que exibe a receita medica com os dados fornecidos pelo médico
     */
    @Override
    public String gerarRelatorio() {
        System.out.println("---------------------------------------------");
        System.out.println("*****Receita Médica*****\n");
        System.out.println("Nome do paciente: " + this.getNomePaciente());
        System.out.println("Remédios:\n");
        for (String remedio : getRemedios()) {
            System.out.println("      -" + remedio);
        }
        System.out.println("\n\nData da Consulta: " + this.getDataConsulta());
        System.out.println("\nAssinatura do medico responsável: " + this.getAssinaturaMedico());
        System.out.println("---------------------------------------------\n");
        return "";
    }

    /**
     * @return lista de remedios receitados.
     */
    public List<String> getRemedios() {
        return remedios;
    }

    /**
     * Seta remedios para inserir na receita.
     *
     * @param remedio
     */
    public void setRemedios(String remedio) {
        this.remedios.add(remedio);
    }

}
