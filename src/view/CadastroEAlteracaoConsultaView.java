package view;

import enumeration.TipoConsulta;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class CadastroEAlteracaoConsultaView extends javax.swing.JDialog {

    /**
     * Creates new form CadastroEAlteracaoConsultaView
     *
     * @param parent
     */
    public CadastroEAlteracaoConsultaView(JFrame parent) {
        super(parent, true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPaciente = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        panelOK = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelAlterarPaciente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodConsulta = new javax.swing.JTextField();
        txtDataConsulta = new javax.swing.JTextField();
        txtHorarioConsulta = new javax.swing.JTextField();
        txtMedicoResponsavel = new javax.swing.JTextField();
        boxTipoConsulta = new javax.swing.JComboBox<>();
        txtRGPaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPaciente.setBackground(new java.awt.Color(255, 255, 255));

        lblPaciente.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone-consulta.png"))); // NOI18N
        lblPaciente.setText("Consulta");

        javax.swing.GroupLayout panelPacienteLayout = new javax.swing.GroupLayout(panelPaciente);
        panelPaciente.setLayout(panelPacienteLayout);
        panelPacienteLayout.setHorizontalGroup(
            panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPaciente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPacienteLayout.setVerticalGroup(
            panelPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPaciente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGravar.setText("Gravar Consulta");
        btnGravar.setSelected(true);

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout panelOKLayout = new javax.swing.GroupLayout(panelOK);
        panelOK.setLayout(panelOKLayout);
        panelOKLayout.setHorizontalGroup(
            panelOKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOKLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelOKLayout.setVerticalGroup(
            panelOKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOKLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelOKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        panelAlterarPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Código da Consulta:");

        jLabel3.setText("Data da Consulta:");

        jLabel4.setText("Horario da Consulta:");

        jLabel5.setText("Medico Responsavel:");

        jLabel7.setText("Tipo de Consulta:");

        txtCodConsulta.setEditable(false);

        boxTipoConsulta.setModel(new DefaultComboBoxModel<String>(TipoConsulta.enumsToStringArray()));

        jLabel6.setText("RG do Paciente:");

        javax.swing.GroupLayout panelAlterarPacienteLayout = new javax.swing.GroupLayout(panelAlterarPaciente);
        panelAlterarPaciente.setLayout(panelAlterarPacienteLayout);
        panelAlterarPacienteLayout.setHorizontalGroup(
            panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlterarPacienteLayout.createSequentialGroup()
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodConsulta)
                    .addComponent(txtDataConsulta)
                    .addComponent(txtHorarioConsulta)
                    .addComponent(txtMedicoResponsavel)
                    .addComponent(boxTipoConsulta, 0, 193, Short.MAX_VALUE)
                    .addComponent(txtRGPaciente))
                .addContainerGap())
        );
        panelAlterarPacienteLayout.setVerticalGroup(
            panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlterarPacienteLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRGPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHorarioConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMedicoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlterarPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAlterarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelAlterarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTipoConsulta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JPanel panelAlterarPaciente;
    private javax.swing.JPanel panelOK;
    private javax.swing.JPanel panelPaciente;
    private javax.swing.JTextField txtCodConsulta;
    private javax.swing.JTextField txtDataConsulta;
    private javax.swing.JTextField txtHorarioConsulta;
    private javax.swing.JTextField txtMedicoResponsavel;
    private javax.swing.JTextField txtRGPaciente;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtCodConsulta() {
        return txtCodConsulta;
    }

    public JComboBox<String> getBoxTipoConsulta() {
        return boxTipoConsulta;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnGravar() {
        return btnGravar;
    }

    public JTextField getTxtRGPaciente() {
        return txtRGPaciente;
    }

    public JTextField getTxtDataConsulta() {
        return txtDataConsulta;
    }

    public JTextField getTxtHorarioConsulta() {
        return txtHorarioConsulta;
    }

    public JTextField getTxtMedicoResponsavel() {
        return txtMedicoResponsavel;
    }

}
