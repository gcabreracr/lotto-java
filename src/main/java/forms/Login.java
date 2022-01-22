package forms;

import interfaces.UsuarioDAO;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import metodos.Propiedades;
import modelo.DAO.UsuarioDAOImpl;
import modelo.PO.UsuarioVO;

import modelo.Variables;

public class Login extends javax.swing.JDialog {

    Propiedades prop;
    UsuarioVO usr;
    UsuarioDAO usuarioDAO;
    Inicio principal;

    public Login(JFrame padre) {

        initComponents();

        principal = (Inicio) padre;

        prop = new Propiedades();
        usuarioDAO = new UsuarioDAOImpl();

        try {
            txtIdUsu.setText(prop.leerUsuario());
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!txtIdUsu.getText().isEmpty()) {
            txtPassUsu.requestFocus();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdUsu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassUsu = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acceso al sistema");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        jLabel4.setText("LOTTO BANCA CR");

        jLabel5.setText("Version 1.0");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelSuperior, java.awt.BorderLayout.NORTH);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(panelBotones, java.awt.BorderLayout.EAST);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Usuario");

        txtIdUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuActionPerformed(evt);
            }
        });
        txtIdUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdUsuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdUsuKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdUsuKeyTyped(evt);
            }
        });

        jLabel2.setText("PIN");

        txtPassUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassUsuActionPerformed(evt);
            }
        });
        txtPassUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassUsuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassUsuKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(txtIdUsu))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuActionPerformed

        if (txtIdUsu.getText().length() > 0) {
            txtPassUsu.requestFocus();
        }


    }//GEN-LAST:event_txtIdUsuActionPerformed

    private void txtIdUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdUsuKeyPressed


    }//GEN-LAST:event_txtIdUsuKeyPressed

    private void txtIdUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdUsuKeyTyped


    }//GEN-LAST:event_txtIdUsuKeyTyped

    private void txtPassUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassUsuKeyTyped

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }


    }//GEN-LAST:event_txtPassUsuKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (txtIdUsu.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Se requiere digitar un ID de usuario");
            txtPassUsu.requestFocus();
            return;
        }

        if (txtPassUsu.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Se requiere digitar un PIN");
            txtPassUsu.requestFocus();
            return;
        }

        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        usr = new UsuarioVO();

        String passUsuario = new String(txtPassUsu.getPassword());

        usr.setId_usuario(txtIdUsu.getText());
        usr.setPin_pass(Integer.valueOf(passUsuario));

        try {
            if (usuarioDAO.Login(usr)) {
                if (usr.getEst_usuario() == 0) {
                    JOptionPane.showMessageDialog(this, "Usuario inactivo");
                    this.txtIdUsu.requestFocus();
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    return;
                }
                String pin = new String(txtPassUsu.getPassword());
                
                if(usr.getPin_pass()!= Integer.valueOf(pin)){
                    JOptionPane.showMessageDialog(this, "PIN invalido");
                    this.txtPassUsu.requestFocus();
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    return;                    
                }
                

                Variables.mCODUSU = usr.getCod_usuario();
                Variables.mNOMUSU = usr.getNom_usuario();
                Variables.mIDUSU = txtIdUsu.getText();
                Variables.mTIPOUSU = usr.getTipo_usuario();
                Variables.mAGEUSU = usr.getCod_suc();
                Variables.mNOMAGEUSU = usr.getNom_suc();

                principal.setTitle("Lotto Banca CR -- Usuario: " + Variables.mNOMUSU);

                // Actualiza el usuario en el archivo properties
                prop.updateUsuario(txtIdUsu.getText());

                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Usuario NO Existe");
                txtIdUsu.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void txtPassUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassUsuKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtPassUsuKeyPressed

    private void txtPassUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassUsuActionPerformed

        if (txtPassUsu.getPassword().length > 0) {

            btnAceptarActionPerformed(evt);

        }

        //btnAceptar.requestFocus();
    }//GEN-LAST:event_txtPassUsuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (Variables.mIDUSU == null) {
            System.exit(0);
        } else {
            Variables.frmLogin = null;
        }


    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        if (Variables.mIDUSU == null) {
            System.exit(0);
        } else {
            Variables.frmLogin = null;
            dispose();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtIdUsuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdUsuKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtIdUsuKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField txtIdUsu;
    private javax.swing.JPasswordField txtPassUsu;
    // End of variables declaration//GEN-END:variables
}
