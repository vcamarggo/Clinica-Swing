package controller;

import java.util.Calendar;
import model.Consulta;
import model.Mensagem;
import model.MensagemEmail;
import model.MensagemSMS;
import model.Paciente;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorMensagemController {

    /**
     * Construtor padrao.
     */
    public GerenciadorMensagemController() {
    }

    /**
     * Verifica todas as consultas da data de amanhã. Envia SMS ou email. Se o
     * paciente tiver tanto SMS quanto EMAIL, envia apenas SMS.
     */
    public void verificaSeHaConsultasParaAmanha(Calendar dataAmanha) {
        //Objeto abstrato, poderá receber instancia de qlq classe que herde dela. É instanciada em tempo de execução.
        Mensagem mensagem = null;

        System.out.println("\nO Sistema está verificando se possui consultas relativas ao dia seguinte. . . .");

        //Percorre a lista de consultas da data de amanhã. 
        for (Consulta consulta : Consulta.consultasDoDiaSeguinte(dataAmanha)) {
            //Verifica se o Paciente da Consulta possui celular/email ou nada.
            if (Paciente.pacientePossuiCelular(consulta)) {
                mensagem = new MensagemSMS();
            } else if (Paciente.pacientePossuiEmail(consulta)) {
                mensagem = new MensagemEmail();
            } else {
                System.out.println("\n*Há uma consulta do paciente " + consulta.getPaciente() + " mas este não possui celular/email.");
                return;
            }
            mensagem.exibirMensagem(consulta);
        }
    }

}
