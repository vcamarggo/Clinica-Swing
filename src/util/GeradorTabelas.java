package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.swing.table.DefaultTableModel;
import model.Paciente;
import model.Usuario;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * Classe responsável por gerar uma Tabela de Pacientes
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GeradorTabelas {

    /**
     *  Gera as tabelas de pacientes
     * @param usuario
     * @return tabela de pacientes
     */
    public static DefaultTableModel geraTabelaPacientes(Usuario usuario) {
        String[] header = {"RG", "Nome", "Data nascimento", "Endereço",
            "Telefone", "Celular", "Email", "Convênio"};
        Object[][] pacientes = new Object[usuario.listaPacientes().size()][Paciente.class.getDeclaredFields().length];
        int i = 0;
        int j = 0;
        for (Paciente p : usuario.listaPacientes()) {
            for (Field field : p.getClass().getDeclaredFields()) {
                try {
                    pacientes[i][j] = PropertyUtils.getSimpleProperty(p, field.getName());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                    pacientes[i][j] = "";
                }
                j++;
            }
            j = 0;
            i++;
        }
        return new javax.swing.table.DefaultTableModel(
                pacientes, header);
    }

}
