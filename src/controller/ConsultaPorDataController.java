package controller;

//<editor-fold defaultstate="collapsed" desc="Importações">
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.Secretaria;
import view.ConsultaPorDataView;
//</editor-fold>

/**
 * Classe responsável por gerenciar os relatórios da secretária a respeito das Consultas agendadas.
 * 
 * @author F.Carvalho / M. Hirose / V.Camargo / T. Hara
 */
public class ConsultaPorDataController {

    private Secretaria usuario;
    private ConsultaPorDataView view;
    private boolean isCelular;
    public List<Consulta> consultas;

    /* Contrutor padrão */
    public ConsultaPorDataController() {
    }

    /*Contrutor parametrizado. Define os elementos que serão utilizados dentro do controlador. */
    public ConsultaPorDataController(ConsultaPorDataView view, Secretaria usuario, boolean isCelular) {
        this.usuario = usuario;
        this.view = view;
        this.isCelular = isCelular;
    }

    /*Método responsável por gerenciar os eventos dos botões e solicitar criação de models e novas Views*/
    public void controla() {
        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH, 1);
        if (isCelular) {
            consultas = usuario.getConsultasDataDesejadaParaPacientesComCelular(amanha);
        } else {
            consultas = usuario.getConsultasDataDesejadaParaPacientesComEmail(amanha);
        }
        view.getTabelaPacientesComConsulta().setModel(geraTabelaConsulta());
        view.getBtnOK1()
                .addActionListener((ActionEvent actionEvent) -> {
                    view.dispose();
                });
        view.setVisible(true);
    }

    /* Método responsável por criar uma tabela personalizada das consultas do dia seguinte. 
       Verifica se o usuário solicitou filtro por email ou sms */
    private DefaultTableModel geraTabelaConsulta() {
        String[] header = {"Paciente", "Email/Celular", "Data consulta"};
        Object[][] consultasObject = new Object[consultas.size()][3];
        int i = 0;
        int j;
        for (Consulta c : consultas) {
            j = 0;
            consultasObject[i][j] = c.getPaciente();
            j++;
            if (isCelular) {
                consultasObject[i][j] = c.getPaciente().getCelular();
                j++;
            } else {
                consultasObject[i][j] = c.getPaciente().getEmail();
                j++;
            }
            consultasObject[i][j] = c.getDataConsultaString();
            i++;
        }
        return new javax.swing.table.DefaultTableModel(
                consultasObject, header);
    }

}
