package model;

import java.util.Scanner;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class AtestadoMedico extends RelatorioMedico {

    private String rg;
    private String horarioConsulta;
    private String diasDescanso;

    /**
     * Método que recebe os dados para criacao do atestado médico
     */
    @Override
    public void preencheDados() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nNome do paciente: ");
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
        System.out.println("*Atestado gerado com sucesso!\n");
    }

    /**
     * Método que exibe o atestado com os dados fornecidos pelo médico
     *
     * @return atestado
     */
    @Override
    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------------------------------\n");
        sb.append("*****Atestado Médico*****\n");
        sb.append("Atesto, para os devidos fins, a pedido do interessado, que o paciente ")
                .append(this.getNomePaciente()).append(",").append("\nportador do RG ").append(getRg())
                .append(", foi submetido à consulta médica nesta data, no horário das ")
                .append(getHorarioConsulta()).append(" horas.");
        sb.append("\nEm decorrência, deverá permanecer afastado de suas atividades por um perídio de ");
        sb.append(getDiasDescanso());
        sb.append(" dias.");
        sb.append("\n\nData: ").append(this.getDataConsulta());
        sb.append("\nAssinatura do medico responsável: ").append(this.getAssinaturaMedico());
        sb.append("\n----------------------------------------------------------\n");
        return sb.toString();
    }

    /**
     * @return rg do paciente.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Seta o rg do paciente.
     *
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return horario da consulta.
     */
    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    /**
     * Seta o horario da consulta do paciente.
     *
     * @param horarioConsulta
     */
    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    /**
     * @return quantidade de dias de descanso.
     */
    public String getDiasDescanso() {
        return diasDescanso;
    }

    /**
     * Seta a quantidade de dias de descanso para o paciente.
     *
     * @param diasDescanso
     */
    public void setDiasDescanso(String diasDescanso) {
        this.diasDescanso = diasDescanso;
    }

}
