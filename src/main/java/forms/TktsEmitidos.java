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
import modelo.PO.SorteoUsuVO;
import modelo.PO.VentaDiariaTktVO;
import modelo.Variables;
import modelo.tableModel.TktsEmitidosTM;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author RV_5
 */
public class TktsEmitidos extends javax.swing.JInternalFrame {

    SorteoDAO sorteoDAO;
    Vector<SorteoUsuVO> listaSorteosUsu;
    TktsEmitidosTM modeloTabla;
    ArrayList<VentaDiariaTktVO> listaDiariaTkts;

    DecimalFormat fMonto = new DecimalFormat("###,###,##0");
    DecimalFormat fNumero = new DecimalFormat("00");
    DecimalFormat fTkt = new DecimalFormat("0000000000");

    SimpleDateFormat formatoDMY = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formatoYMD = new SimpleDateFormat("yyyy-MM-dd");

    int codSorteo = 0;
    String mFecSorteo;
    int mVentaTotal = 0;

    public TktsEmitidos() {
        initComponents();

        listaDiariaTkts = new ArrayList<>();
        sorteoDAO = new SorteoDAOImpl();
        listaSorteosUsu = new Vector();
        txtFechaSorteo.setDate(new Date());
        txtFechaSorteo.setEnabled(false);
        crearTabla();
        llenarListaSorteos();
        cbSorteos.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbSorteos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtFechaSorteo = new com.toedter.calendar.JDateChooser();
        btnConsultar = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTiquetes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbVentaTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();

        setClosable(true);
        setTitle("Tiquetes emitidos");
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

        panelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Sorteo");

        cbSorteos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un sorteo" }));
        cbSorteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSorteosActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(btnConsultar)
                .addGap(127, 127, 127))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelSuperior, java.awt.BorderLayout.NORTH);

        jtTiquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "# Tkt", "Monto", "Referencia"
            }
        ));
        jtTiquetes.setName(""); // NOI18N
        jScrollPane1.setViewportView(jtTiquetes);
        if (jtTiquetes.getColumnModel().getColumnCount() > 0) {
            jtTiquetes.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtTiquetes.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtTiquetes.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Venta Total");

        lbVentaTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbVentaTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVentaTotal.setText("0");

        btnImprimir.setText("Imprimir");

        btnAnular.setText("Anular");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnular)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbVentaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVentaTotal)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

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
        Variables.frmTktsEmi = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        if (cbSorteos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione un Sorteo");
            cbSorteos.requestFocus();
            return;
        }

        consultaTkts();
    }//GEN-LAST:event_btnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cbSorteos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTiquetes;
    private javax.swing.JLabel lbVentaTotal;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelSuperior;
    private com.toedter.calendar.JDateChooser txtFechaSorteo;
    // End of variables declaration//GEN-END:variables

    private void crearTabla() {

        modeloTabla = new TktsEmitidosTM();
        jtTiquetes.setModel(modeloTabla);

        //Configura columnas 
        DefaultTableCellRenderer rightDTCR = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerDTCR = new DefaultTableCellRenderer();
        rightDTCR.setHorizontalAlignment(SwingConstants.RIGHT);
        centerDTCR.setHorizontalAlignment(SwingConstants.CENTER);
        if (jtTiquetes.getColumnModel().getColumnCount() > 0) {
            jtTiquetes.getColumnModel().getColumn(0).setResizable(false);
            jtTiquetes.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtTiquetes.getColumnModel().getColumn(0).setCellRenderer(centerDTCR);
            jtTiquetes.getColumnModel().getColumn(0).setHeaderRenderer(centerDTCR);
            jtTiquetes.getColumnModel().getColumn(1).setResizable(false);
            jtTiquetes.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtTiquetes.getColumnModel().getColumn(1).setCellRenderer(rightDTCR);
            jtTiquetes.getColumnModel().getColumn(1).setHeaderRenderer(centerDTCR);
            jtTiquetes.getColumnModel().getColumn(2).setResizable(false);
            jtTiquetes.getColumnModel().getColumn(2).setPreferredWidth(100);
            //jtTiquetes.getColumnModel().getColumn(2).setCellRenderer(rightDTCR);
            //jtTiquetes.getColumnModel().getColumn(2).setHeaderRenderer(centerDTCR);
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

    private void consultaTkts() {

        mFecSorteo = formatoYMD.format(txtFechaSorteo.getDate());

        listaDiariaTkts = new ArrayList<>();
        JSONObject jsonSend = new JSONObject();
        jsonSend.put("w", "apiLotto");
        jsonSend.put("r", "lista_venta_tkts_usu");
        jsonSend.put("cod_sorteo", codSorteo);
        jsonSend.put("cod_usuario", Variables.mCODUSU);

        mVentaTotal = 0;

        String url = Variables.URL_API;

        JSONObject respuesta;
        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        try {
            respuesta = HttpClient.httpPOST(url, jsonSend).optJSONObject("resp");
            if (respuesta != null) {
                JSONArray arrayTkts = respuesta.optJSONArray("tkts");
                for (int i = 0; i < arrayTkts.length(); i++) {
                    VentaDiariaTktVO tkt = new VentaDiariaTktVO();
                    tkt.setNum_tkt(arrayTkts.optJSONObject(i).optInt("num_tkt"));
                    int montoTkt = arrayTkts.optJSONObject(i).optInt("total_tkt");
                    tkt.setMon_tkt(montoTkt);
                    tkt.setReferencia(arrayTkts.optJSONObject(i).optString("nom_cliente"));
                    mVentaTotal += montoTkt;
                    listaDiariaTkts.add(tkt);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No hay tiquetes registrados");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No hay tiquetes registrados");
            //Logger.getLogger(TktsEmitidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lbVentaTotal.setText(fMonto.format(mVentaTotal));
        modeloTabla.llenaLista(listaDiariaTkts);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }
}
