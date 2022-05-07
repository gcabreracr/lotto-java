/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import interfaces.UsuarioDAO;
import java.awt.Cursor;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import metodos.HttpClient;
import modelo.PO.ItemLiqDiaPeriodoVO;
import modelo.PO.MovCtaUsuVO;
import modelo.Variables;
import modelo.tableModel.LiqDiaPeriodoTM;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class LiqDiaPeriodo extends javax.swing.JInternalFrame {

    ArrayList<ItemLiqDiaPeriodoVO> listaMovimientos;

    UsuarioDAO usuarioDAO;
    LiqDiaPeriodoTM modeloTabla;

    String mFechaInicial, mFechaFinal;
    int mTotVenta, mTotComision, mTotPremios, mTotNeto;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dfDMY = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat fEntero = new DecimalFormat("###,###,###");
    DecimalFormat fCeros = new DecimalFormat("00");

    public LiqDiaPeriodo() {
        initComponents();

        listaMovimientos = new ArrayList<>();
        txtFechaIni.setDate(new Date());
        txtFechaFin.setDate(new Date());
        crearTabla();
        btnConsultar.requestFocus();

    }

    private void crearTabla() {

        modeloTabla = new LiqDiaPeriodoTM();
        jtMovimientos.setModel(modeloTabla);

        //Configura columnas 
        DefaultTableCellRenderer rightDTCR = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerDTCR = new DefaultTableCellRenderer();
        rightDTCR.setHorizontalAlignment(SwingConstants.RIGHT);
        centerDTCR.setHorizontalAlignment(SwingConstants.CENTER);
        if (jtMovimientos.getColumnModel().getColumnCount() > 0) {
            jtMovimientos.getColumnModel().getColumn(0).setResizable(false);
            jtMovimientos.getColumnModel().getColumn(0).setPreferredWidth(25);
            jtMovimientos.getColumnModel().getColumn(0).setCellRenderer(centerDTCR);
            jtMovimientos.getColumnModel().getColumn(0).setHeaderRenderer(centerDTCR);
            
            jtMovimientos.getColumnModel().getColumn(1).setResizable(false);
            jtMovimientos.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtMovimientos.getColumnModel().getColumn(1).setCellRenderer(rightDTCR);
            jtMovimientos.getColumnModel().getColumn(1).setHeaderRenderer(centerDTCR);
            
            jtMovimientos.getColumnModel().getColumn(2).setResizable(false);
            jtMovimientos.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtMovimientos.getColumnModel().getColumn(2).setCellRenderer(rightDTCR);
            jtMovimientos.getColumnModel().getColumn(2).setHeaderRenderer(centerDTCR);
            
            jtMovimientos.getColumnModel().getColumn(3).setResizable(false);
            jtMovimientos.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtMovimientos.getColumnModel().getColumn(3).setCellRenderer(rightDTCR);
            jtMovimientos.getColumnModel().getColumn(3).setHeaderRenderer(centerDTCR);
            
            jtMovimientos.getColumnModel().getColumn(4).setResizable(false);
            jtMovimientos.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtMovimientos.getColumnModel().getColumn(4).setCellRenderer(rightDTCR);
            jtMovimientos.getColumnModel().getColumn(4).setHeaderRenderer(centerDTCR);
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
        txtFechaIni = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalComsion = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotalPremios = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalNeto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMovimientos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Consulta Liquidaciones Diarias por Periodo");
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

        jLabel3.setText("Del");

        txtFechaIni.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaIniPropertyChange(evt);
            }
        });

        jLabel4.setText("Al");

        txtFechaFin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtFechaFinPropertyChange(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel1.setText("Periodo");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen"));

        jLabel2.setText("Total Ventas");
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 20));

        txtTotalVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalVenta.setText("0");
        txtTotalVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTotalVenta.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel7.setText("Total Comisiones");
        jLabel7.setPreferredSize(new java.awt.Dimension(60, 20));

        txtTotalComsion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalComsion.setText("0");
        txtTotalComsion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTotalComsion.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel9.setText("Total Premios");
        jLabel9.setPreferredSize(new java.awt.Dimension(60, 20));

        txtTotalPremios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalPremios.setText("0");
        txtTotalPremios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTotalPremios.setPreferredSize(new java.awt.Dimension(40, 20));

        jLabel5.setText("Total Neto");
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 20));

        txtTotalNeto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalNeto.setText("0");
        txtTotalNeto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTotalNeto.setPreferredSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalPremios, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalComsion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalComsion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPremios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de movimientos"));

        jtMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Venta", "Comision", "Premios", "Liq. Neta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtMovimientos);
        if (jtMovimientos.getColumnModel().getColumnCount() > 0) {
            jtMovimientos.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtMovimientos.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtMovimientos.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtMovimientos.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnConsultar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultar)
                            .addComponent(txtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:

        Variables.frmLiqDiaPeriodo = null;

    }//GEN-LAST:event_formInternalFrameClosing

    private void txtFechaIniPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaIniPropertyChange
        // TODO add your handling code here:
        txtFechaFin.requestFocus();
    }//GEN-LAST:event_txtFechaIniPropertyChange

    private void txtFechaFinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtFechaFinPropertyChange

        btnConsultar.requestFocus();
    }//GEN-LAST:event_txtFechaFinPropertyChange

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        if (txtFechaFin.getDate().compareTo(txtFechaIni.getDate()) < 0) {

            JOptionPane.showMessageDialog(this, "Fecha Final es menor que la fecha Inicial");
            txtFechaFin.requestFocus();
            return;
        }

        consultaEstadoCuenta();
    }//GEN-LAST:event_btnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMovimientos;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaIni;
    private javax.swing.JLabel txtTotalComsion;
    private javax.swing.JLabel txtTotalNeto;
    private javax.swing.JLabel txtTotalPremios;
    private javax.swing.JLabel txtTotalVenta;
    // End of variables declaration//GEN-END:variables

    private void consultaEstadoCuenta() {

        mFechaInicial = df.format(txtFechaIni.getDate());
        mFechaFinal = df.format(txtFechaFin.getDate());

        listaMovimientos = new ArrayList<>();

        JSONObject jsonSend = new JSONObject();
        jsonSend.put("w", "apiLotto");
        jsonSend.put("r", "consulta_liq_dia_periodo");
        jsonSend.put("fecha_inicial", mFechaInicial);
        jsonSend.put("fecha_final", mFechaFinal);
        jsonSend.put("cod_usuario", Variables.mCODUSU);

        mTotVenta = 0;
        mTotComision = 0;
        mTotPremios = 0;
        mTotNeto = 0;

        String url = Variables.URL_API;

        JSONObject respuesta;
        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        try {
            respuesta = HttpClient.httpPOST(url, jsonSend).optJSONObject("resp");

            JSONArray movimientos = respuesta.optJSONArray("movimientos");
            if (movimientos.length() > 0) {
                for (int i = 0; i < movimientos.length(); i++) {
                    ItemLiqDiaPeriodoVO mov = new ItemLiqDiaPeriodoVO();

                    Date fechaJson = null;
                    try {
                        fechaJson = df.parse(movimientos.optJSONObject(i).optString("fec_mov"));
                    } catch (ParseException ex) {
                        Logger.getLogger(LiqDiaPeriodo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    mov.setFec_sorteo(dfDMY.format(fechaJson));

                    int monVenta = movimientos.optJSONObject(i).optInt("mon_venta");
                    mTotVenta += monVenta;
                    mov.setMon_venta(monVenta);
                    int monComision = movimientos.optJSONObject(i).optInt("mon_comision");
                    mTotComision += monComision;
                    mov.setMon_comision(monComision);
                    int monPremios = movimientos.optJSONObject(i).optInt("mon_premios");
                    mTotPremios += monPremios;
                    mov.setMon_premios(monPremios);
                    int monNeto = monVenta - monComision - monPremios;
                    mTotNeto += mTotNeto;

                    listaMovimientos.add(mov);
                }

            } else {
                JOptionPane.showMessageDialog(this, "NO hay movimientos en el periodo seleccionado");

            }

            txtTotalVenta.setText(fEntero.format(mTotVenta));
            txtTotalComsion.setText(fEntero.format(mTotComision));
            txtTotalPremios.setText(fEntero.format(mTotPremios));
            txtTotalNeto.setText(fEntero.format(mTotNeto));
            modeloTabla.llenaLista(listaMovimientos);

        } catch (IOException ex) {
            Logger.getLogger(LiqDiaPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
