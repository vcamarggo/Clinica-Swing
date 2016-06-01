package enumeration;

/**
 *
 * @author Camargo
 */
public enum TipoConsulta {

    NORMAL(60), RETORNO(30);

    private final int duracaoEmMinutos;

    private TipoConsulta(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getDuracao() {
        return duracaoEmMinutos + " minutos";
    }

}
