package model;

import java.util.Scanner;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class DeclaracaoAcompanhamento extends RelatorioMedico {

    private String nomeAcompanhante;
    private String horarioConsulta;

    /**
     * Método que recebe os dados para criacao da declaração de acompanhamento.
     */
    @Override
    public void preencheDados() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nNome do paciente: ");
        this.setNomePaciente(scan.nextLine());
        System.out.println("Nome do Acompanhante: ");
        setNomeAcompanhante(scan.nextLine());
        System.out.println("Data da Consulta (dd/mm/aaaa): ");
        this.setDataConsulta(scan.nextLine());
        System.out.println("Horario da Consulta: ");
        setHorarioConsulta(scan.nextLine());
        System.out.println("Assinatura do medico: ");
        this.setAssinaturaMedico(scan.nextLine());
        System.out.println("*Declaracao de Acompanhamento criada com sucesso!\n");
    }

    /**
     * Método que exibe a declaração de acompanhamento com os dados fornecidos
     * pelo médico
     *
     * @return declaracaoAcompanhamento
     */
    @Override
    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------------");
        sb.append("\n*****Declaracao de Acompanhamento*****\n");
        sb.append("Atesto, para os devidos fins, a pedido do interessado, que o senhor(a) ")
                .append(getNomeAcompanhante())
                .append("\n" + "acompanhou o paciente ").append(this.getNomePaciente()).append(
                ", à consulta médica nesta data, no horário das ")
                .append(getHorarioConsulta()).append(" horas.");
        sb.append("\n\nData: ").append(this.getDataConsulta());
        sb.append("\nAssinatura do medico responsável: ").append(this.getAssinaturaMedico());
        sb.append("\n--------------------------------------------------------\n");
        return sb.toString();
    }

    /**
     * @return nome do acompanhante do paciente.
     */
    public String getNomeAcompanhante() {
        return nomeAcompanhante;
    }

    /**
     * Seta um nome para o acompanhante do paciente.
     *
     * @param nomeAcompanhante
     */
    public void setNomeAcompanhante(String nomeAcompanhante) {
        this.nomeAcompanhante = nomeAcompanhante;
    }

    /**
     * @return horario da consulta.
     */
    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    /**
     * Seta o horario da consulta realizada.
     *
     * @param horarioConsulta
     */
    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

}
