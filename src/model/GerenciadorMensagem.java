package model;

import model.pojo.Consulta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public abstract class GerenciadorMensagem {

    private static final String NUMERO_CONSULTORIO = "(44) 3034-0608";
    private static final String CELULAR_CONSULTORIO = "(44) 9809-6677";
    private static final String EMAIL_CONSULTORIO = "consultoriosaudeecia@gmail.com";
    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");

    /**
     * @return telefone do consultório
     */
    public String getNumeroConsultorio() {
        return NUMERO_CONSULTORIO;
    }

    /**
     * *
     * @return celular do consultório
     */
    public String getCelularConsultorio() {
        return CELULAR_CONSULTORIO;
    }

    /**
     * @return email do consultório
     */
    public String getEmailConsultorio() {
        return EMAIL_CONSULTORIO;
    }

    /**
     * @return formato padrão das datas
     */
    public DateFormat getDateFormat() {
        return FORMATTER;
    }

    /**
     * Método abstrato para a exibição de mensagens.
     *
     * @param consulta
     * @return mensagemGerada
     */
    public abstract String gerarMensagem(Consulta consulta);
}
