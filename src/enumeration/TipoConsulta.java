package enumeration;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public enum TipoConsulta {

    NORMAL(60),
    RETORNO(30);

    private final int duracaoEmMinutos;

    private TipoConsulta(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    /**
     * transforma a duracao enum em String.
     *
     * @return duracao em String.
     */
    public String getDuracao() {
        return duracaoEmMinutos + " minutos";
    }

    public static String[] enumsToStringArray() {
        String[] results = new String[TipoConsulta.values().length];
        int count = 0;
        for (TipoConsulta each : TipoConsulta.values()) {
            results[count] = each.toString();
            count++;
        }
        return results;
    }

}
