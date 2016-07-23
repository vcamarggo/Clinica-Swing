package model;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorMensagem extends Usuario {

    private static final String NUMERO_CONSULTORIO = "(44) 3034-0608";
    private static final String CELULAR_CONSULTORIO = "(44) 9809-6677";
    private static final String EMAIL_CONSULTORIO = "consultoriosaudeecia@gmail.com";

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

}
