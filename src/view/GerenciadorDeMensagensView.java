package view;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class GerenciadorDeMensagensView extends javax.swing.JFrame {
    
    /**
     * Creates new form GerenciadorDeMensagensView
     */
    public GerenciadorDeMensagensView() {
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

        panelHeader = new javax.swing.JPanel();
        lblGerenciador = new javax.swing.JLabel();
        panelDescricaoGerenciador = new javax.swing.JPanel();
        lblDescricaoGerenciador = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDataAtual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEnviarEmail = new javax.swing.JButton();
        btnEnviarSMS = new javax.swing.JButton();
        panelOkVoltar = new javax.swing.JPanel();
        btnVoltarSelecaoPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));

        lblGerenciador.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblGerenciador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone-gerenciador.png"))); // NOI18N
        lblGerenciador.setText("Gerenciador de Mensagens");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addComponent(lblGerenciador)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGerenciador)
        );

        lblDescricaoGerenciador.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblDescricaoGerenciador.setText("<html>O Gerenciador de Mensagens envia uma notificacao (por email ou SMS) aos Pacientes que possuem Consulta agendada no dia seguinte. Para isto, insira a data desejada e selecione o tipo de notificacao.</html>");

        javax.swing.GroupLayout panelDescricaoGerenciadorLayout = new javax.swing.GroupLayout(panelDescricaoGerenciador);
        panelDescricaoGerenciador.setLayout(panelDescricaoGerenciadorLayout);
        panelDescricaoGerenciadorLayout.setHorizontalGroup(
            panelDescricaoGerenciadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDescricaoGerenciador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelDescricaoGerenciadorLayout.setVerticalGroup(
            panelDescricaoGerenciadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescricaoGerenciadorLayout.createSequentialGroup()
                .addComponent(lblDescricaoGerenciador, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione uma Opcao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Insira a Data Desejada (dd/MM/yyyy)");

        jLabel5.setText("Enviar Email");

        jLabel6.setText("Enviar SMS");

        btnEnviarEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone-email.png"))); // NOI18N
        btnEnviarEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEnviarSMS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icone-sms.png"))); // NOI18N
        btnEnviarSMS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviarEmail)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnEnviarSMS)))
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(btnEnviarEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(btnEnviarSMS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVoltarSelecaoPerfil.setText("Voltar a Selecao de Perfil");

        javax.swing.GroupLayout panelOkVoltarLayout = new javax.swing.GroupLayout(panelOkVoltar);
        panelOkVoltar.setLayout(panelOkVoltarLayout);
        panelOkVoltarLayout.setHorizontalGroup(
            panelOkVoltarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOkVoltarLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnVoltarSelecaoPerfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOkVoltarLayout.setVerticalGroup(
            panelOkVoltarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVoltarSelecaoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDescricaoGerenciador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOkVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDescricaoGerenciador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOkVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarEmail;
    private javax.swing.JButton btnEnviarSMS;
    private javax.swing.JButton btnVoltarSelecaoPerfil;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblDescricaoGerenciador;
    private javax.swing.JLabel lblGerenciador;
    private javax.swing.JPanel panelDescricaoGerenciador;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelOkVoltar;
    private javax.swing.JTextField txtDataAtual;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnVoltarSelecaoPerfil() {
        return btnVoltarSelecaoPerfil;
    }
    
     public JButton getBtnNotificarEmail() {
        return btnEnviarEmail;
    }

    public JButton getBtnNotificarSMS() {
        return btnEnviarSMS;
    }
    
    public JTextField getTxtDataConsulta() {
        return txtDataAtual;
    }
    
}
