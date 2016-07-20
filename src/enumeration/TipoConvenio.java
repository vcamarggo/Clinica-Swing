package enumeration;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public enum TipoConvenio {

    PARTICULAR,
    EMPRESARIAL;

    public static String[] enumsToStringArray() {
        String[] results = new String[TipoConvenio.values().length];
        int count = 0;
        for (TipoConvenio each : TipoConvenio.values()) {
            results[count] = each.toString();
            count++;
        }
        return results;
    }
}
