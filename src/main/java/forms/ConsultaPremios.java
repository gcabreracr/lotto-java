/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import interfaces.SorteoDAO;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import metodos.HttpClient;
import modelo.DAO.SorteoDAOImpl;
import modelo.PO.PremiosVO;
import modelo.PO.SorteoUsuVO;
import modelo.Variables;
import modelo.tableModel.ConsultaPremiosTM;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class ConsultaPremios extends javax.swing.JInternalFrame {

    SorteoDAO sorteoDAO;
    Vector<SorteoUsuVO> listaSorteosUsu;

    ArrayList<PremiosVO> listaPremios;
    ConsultaPremiosTM modeloTabla;

    DecimalFormat fMonto = new DecimalFormat("###,###,##0");
    DecimalFormat fNumero = new DecimalFormat("00");
    DecimalFormat fTkt = new DecimalFormat("0000000000");

    SimpleDateFormat formatoDMY = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formatoYMD = new SimpleDateFormat("yyyy-MM-dd");

    int codSorteo = 0;
    int mTotalPremios = 0;
    String mFecSorteo;

    public ConsultaPremios() {
        initComponents();

        sorteoDAO = new SorteoDAOImpl();
        listaSorteosUsu = new Vector();
        listaPremios = new ArrayList<>();
        txtFechaSorteo.setDate(new Date());
        crearTabla();
        llenarListaSorteos();
        cbSorteos.requestFocus();

    }

    private void crearTabla() {

        modeloTabla = new ConsultaPremiosTM();
        jtPremios.setModel(modeloTabla);

        //Configura columnas 
        DefaultTableCellRenderer rightDTCR = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerDTCR = new DefaultTableCellRenderer();
        rightDTCR.setHorizontalAlignment(SwingConstants.RIGHT);
        centerDTCR.setHorizontalAlignment(SwingConstants.CENTER);
        if (jtPremios.getColumnModel().getColumnCount() > 0) {
            jtPremios.getColumnModel().getColumn(0).setResizable(false);
            jtPremios.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtPremios.getColumnModel().getColumn(0).setCellRenderer(centerDTCR);
            jtPremios.getColumnModel().getColumn(0).setHeaderRenderer(centerDTCR);
            jtPremios.getColumnModel().getColumn(1).setResizable(false);
            jtPremios.getColumnModel().getColumn(1).setPreferredWidth(25);
            jtPremios.getColumnModel().getColumn(1).setCellRenderer(rightDTCR);
            jtPremios.getColumnModel().getColumn(1).setHeaderRenderer(centerDTCR);
            jtPremios.getColumnModel().getColumn(2).setResizable(false);
            jtPremios.getColumnModel().getColumn(2).setPreferredWidth(25);
            jtPremios.getColumnModel().getColumn(2).setCellRenderer(rightDTCR);
            jtPremios.getColumnModel().getColumn(2).setHeaderRenderer(centerDTCR);
        }

    }

    private void llenarListaSorteos() {

        try {
            listaSorteosUsu = sorteoDAO.llenarComboSorteosUsu(Variables.mCODUSU);
            cbSorteos.setModel(new DefaultComboBoxModel(listaSorteosUsu));
        } catch (SQLException ex) {
            Logger.getLogger(TktsEmitidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFechaSorteo = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbSorteos = new javax.swing.JComboBox<>();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPremios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNumPremiado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPremios = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta Premios");
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

        jLabel3.setText("Fecha Sorteo");

        txtFechaSorteo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaSorteoPropertyChange(evt);
            }
        });

        jLabel4.setText("Sorteo");

        cbSorteos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un sorteo" }));
        cbSorteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSorteosActionPerformed(evt);
            }
        });

        panelTable.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiquetes premiados"));

        jtPremios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "# Tkt", "Apuesta", "Premio", "Referencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPremios);
        if (jtPremios.getColumnModel().getColumnCount() > 0) {
            jtPremios.getColumnModel().getColumn(0).setResizable(false);
            jtPremios.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtPremios.getColumnModel().getColumn(1).setResizable(false);
            jtPremios.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtPremios.getColumnModel().getColumn(2).setResizable(false);
            jtPremios.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtPremios.getColumnModel().getColumn(3).setResizable(false);
            jtPremios.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Numero Premiado");

        txtNumPremiado.setEditable(false);
        txtNumPremiado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumPremiado.setEnabled(false);
        txtNumPremiado.setFocusable(false);
        txtNumPremiado.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel2.setText("Monto Premios");

        txtTotalPremios.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalPremios.setText("0");
        txtTotalPremios.setEnabled(false);
        txtTotalPremios.setFocusable(false);
        txtTotalPremios.setPreferredSize(new java.awt.Dimension(50, 20));

        btnImprimir.setText("Imprimir");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnConsultar)
                                .addGap(26, 26, 26)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumPremiado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTotalPremios, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnConsultar)
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumPremiado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotalPremios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSorteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSorteosActionPerformed
        // TODO add your handling code here:

        if (cbSorteos.getSelectedIndex() > 0) {
            codSorteo = listaSorteosUsu.get(cbSorteos.getSelectedIndex()).getCod_sorteo();
            btnConsultar.requestFocus();
        }
    }//GEN-LAST:event_cbSorteosActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        Variables.frmConPremios = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:

        if (cbSorteos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleeccione un sorteo");
            cbSorteos.requestFocus();
            return;
        }

        consultaPremios();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtFechaSorteoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaSorteoPropertyChange
        // TODO add your handling code here:
        btnConsultar.requestFocus();
    }//GEN-LAST:event_txtFechaSorteoPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cbSorteos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPremios;
    private javax.swing.JPanel panelTable;
    private com.toedter.calendar.JDateChooser txtFechaSorteo;
    private javax.swing.JTextField txtNumPremiado;
    private javax.swing.JTextField txtTotalPremios;
    // End of variables declaration//GEN-END:variables

    private void consultaPremios() {

        mFecSorteo = formatoYMD.format(txtFechaSorteo.getDate());

        listaPremios = new ArrayList<>();

        JSONObject jsonSend = new JSONObject();
        jsonSend.put("w", "apiLotto");
        jsonSend.put("r", "consulta_tkts_premiados");
        jsonSend.put("fecha_sorteo", mFecSorteo);
        jsonSend.put("cod_sorteo", codSorteo);
        jsonSend.put("cod_usuario", Variables.mCODUSU);

        String url = Variables.URL_API;

        mTotalPremios = 0;

        JSONObject respuesta;
        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        try {
            respuesta = HttpClient.httpPOST(url, jsonSend).optJSONObject("resp");
            if (respuesta != null) {
                txtNumPremiado.setText(respuesta.optString("num_premiado"));
                JSONArray lista_premios = respuesta.optJSONArray("tkts_premiados");
                if (lista_premios.length() > 0) {
                    for (int i = 0; i < lista_premios.length(); i++) {
                        PremiosVO premio = new PremiosVO();
                        premio.setNum_tkt(lista_premios.optJSONObject(i).optInt("num_tkt"));
                        premio.setMon_jugado(lista_premios.optJSONObject(i).optInt("mon_jugado"));
                        premio.setMon_premio(lista_premios.optJSONObject(i).optInt("mon_premio"));
                        premio.setReferencia(lista_premios.optJSONObject(i).optString("nom_cliente"));
                        mTotalPremios += lista_premios.optJSONObject(i).optInt("mon_premio");
                        listaPremios.add(premio);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay tiquete premiados para este sorteo");
                }

            } else {
                txtNumPremiado.setText("");
               JOptionPane.showMessageDialog(this, "No hay tiquete premiados para este sorteo");
            }
            txtTotalPremios.setText(fMonto.format(mTotalPremios));
            modeloTabla.llenaLista(listaPremios);

        } catch (IOException ex) {
            Logger.getLogger(ConsultaPremios.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
