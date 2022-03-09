/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import interfaces.UsuarioDAO;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.DAO.UsuarioDAOImpl;
import modelo.PO.UsuarioVO;
import modelo.Variables;

/**
 *
 * @author Gonzalo Cabrera
 */
public class ConfiguraTkt extends javax.swing.JInternalFrame {

    UsuarioVO usr;
    UsuarioDAO usuarioDAO;
    Vector<String> listaImpresoras;

    public ConfiguraTkt() {
        initComponents();

        usr = new UsuarioVO();
        usuarioDAO = new UsuarioDAOImpl();

        llenarComboImpresoras();
       
        txtMsg_Tkt.setText(Variables.MSG_TKT);
        txtTit_Tkt.setText(Variables.TIT_TKT);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTit_Tkt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMsg_Tkt = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cbImpresoras = new javax.swing.JComboBox<>();
        btnActualiza = new javax.swing.JButton();

        setClosable(true);
        setTitle("Configuracion");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Título tiquete");

        txtTit_Tkt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTit_TktActionPerformed(evt);
            }
        });

        jLabel2.setText("Mensaje ");

        txtMsg_Tkt.setColumns(40);
        txtMsg_Tkt.setLineWrap(true);
        txtMsg_Tkt.setRows(3);
        txtMsg_Tkt.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtMsg_Tkt);

        jLabel3.setText("Impresora");

        cbImpresoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una impresora" }));
        cbImpresoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbImpresorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(txtTit_Tkt)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbImpresoras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTit_Tkt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbImpresoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnActualiza.setText("Actualizar");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualiza)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnActualiza)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed

        try {
            actualizaDatos();
        } catch (SQLException ex) {
            
            Logger.getLogger(ConfiguraTkt.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnActualizaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        Variables.frmConTkt = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtTit_TktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTit_TktActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTit_TktActionPerformed

    private void cbImpresorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbImpresorasActionPerformed


    }//GEN-LAST:event_cbImpresorasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JComboBox<String> cbImpresoras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMsg_Tkt;
    private javax.swing.JTextField txtTit_Tkt;
    // End of variables declaration//GEN-END:variables

    private void actualizaDatos() throws SQLException {

        Variables.TIT_TKT = txtTit_Tkt.getText();
        Variables.MSG_TKT = txtMsg_Tkt.getText();
        Variables.NOM_IMP = cbImpresoras.getItemAt(cbImpresoras.getSelectedIndex());
        
        usr=new UsuarioVO();
        usr.setCod_usuario(Variables.mCODUSU);
        usr.setTit_tkt(Variables.TIT_TKT);
        usr.setMsg_tkt(Variables.MSG_TKT);
        usr.setNom_imp(Variables.NOM_IMP);
        
        usuarioDAO.actualizaConfig(usr);       

        //Actualiza datos en servidor
        JOptionPane.showMessageDialog(null, "Datos Actualizados\n" + Variables.TIT_TKT + "\n" + Variables.MSG_TKT + "\n"+Variables.NOM_IMP);

    }

    private void llenarComboImpresoras() {
        
        listaImpresoras = new Vector<>();
        listaImpresoras.add("Seleccione una impresora");

        PrintService[] impresoras = PrintServiceLookup.lookupPrintServices(null, null);     
                
        for (int i = 0; i < impresoras.length; i++) {
            listaImpresoras.add(impresoras[i].getName());          
                     
        }
        cbImpresoras.setModel(new DefaultComboBoxModel(listaImpresoras));
        cbImpresoras.setSelectedItem(Variables.NOM_IMP);
        
    }
}
