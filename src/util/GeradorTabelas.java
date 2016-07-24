/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
