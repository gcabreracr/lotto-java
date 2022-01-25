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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import metodos.HttpClient;
import modelo.DAO.SorteoDAOImpl;
import modelo.PO.SorteoUsuVO;
import modelo.PO.VentaDiariaTktVO;
import modelo.PO.VentaTktVO;
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
    ArrayList<VentaTktVO> listaVentaTkt;

    DecimalFormat fMonto = new DecimalFormat("###,###,##0");
    DecimalFormat fNumero = new DecimalFormat("00");
    DecimalFormat fTkt = new DecimalFormat("0000000000");

    SimpleDateFormat formatoDMY = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat formatoYMD = new SimpleDateFormat("yyyy-MM-dd");

    int codSorteo = 0;
    String mFecSorteo, mHoraTkt, mFechaTkt, mReferencia;
    int mVentaTotal = 0;
    int mTotalTkt = 0;
    int mNumTkt = 0;
    boolean reimprime = true;

    public TktsEmitidos() {
        initComponents();

        listaDiariaTkts = new ArrayList<>();
        listaVentaTkt = new ArrayList<>();
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

            },
            new String [] {

            }
        ));
        jtTiquetes.setName(""); // NOI18N
        jScrollPane1.setViewportView(jtTiquetes);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Venta Total");

        lbVentaTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbVentaTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVentaTotal.setText("0");

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

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

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        if (jtTiquetes.getSelectedRow() > 0) {

            int fila = jtTiquetes.getSelectedRow();
            mNumTkt = listaDiariaTkts.get(fila).getNum_tkt();
            if (consultaTkt()) {
                imprimeTiquete();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un tiquete");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        if (jtTiquetes.getSelectedRow() > 0) {

            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "Desea anular el tiquete ?",
                    "Confirmacion de anulación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null para icono por defecto.
                    new Object[]{"Si", "No"},
                    "No");

            if (seleccion != 0) {// Opcion diferente a SI

                return;
            }

            int fila = jtTiquetes.getSelectedRow();
            mNumTkt = listaDiariaTkts.get(fila).getNum_tkt();

            anulaTiquete();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un tiquete");
        }
    }//GEN-LAST:event_btnAnularActionPerformed


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

    private boolean consultaTkt() {

        JSONObject jsonSend = new JSONObject();
        jsonSend.put("w", "apiLotto");
        jsonSend.put("r", "consulta_venta_tkt");
        jsonSend.put("num_tkt", mNumTkt);

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        String url = Variables.URL_API;

        JSONObject respuesta;

        try {

            respuesta = HttpClient.httpPOST(url, jsonSend).getJSONObject("resp");
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            if (respuesta != null) {

                mHoraTkt = respuesta.optString("hora_tkt");
                mReferencia = respuesta.optString("nom_cliente");

                Date fechaJson = null;

                try {
                    fechaJson = formatoYMD.parse(respuesta.optString("fecha_tkt"));
                } catch (ParseException ex) {
                    Logger.getLogger(TktsEmitidos.class.getName()).log(Level.SEVERE, null, ex);
                }

                mFechaTkt = formatoDMY.format(fechaJson);

                JSONArray listaNumeros = respuesta.optJSONArray("numeros");
                mTotalTkt = 0;
                for (int i = 0; i < listaNumeros.length(); i++) {
                    VentaTktVO ventaTkt = new VentaTktVO();
                    ventaTkt.setNumero(listaNumeros.optJSONObject(i).optString("num_jugado"));
                    ventaTkt.setMonto(listaNumeros.optJSONObject(i).optInt("mon_jugado"));
                    mTotalTkt += ventaTkt.getMonto();
                    listaVentaTkt.add(ventaTkt);
                }
                return true;
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(TktsEmitidos.class.getName()).log(Level.SEVERE, null, ex);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return false;
        }

    }

    private void imprimeTiquete() {

        DocFlavor formatoDoc = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintService[] impresoras = PrintServiceLookup.lookupPrintServices(formatoDoc, null);

        if (impresoras.length > 0) {

            PrintService impresora = (PrintService) JOptionPane.showInputDialog(this, "Elija impresora:", "Imprime tiquete", JOptionPane.QUESTION_MESSAGE, null, impresoras, impresoras[0]);
            if (impresora != null) {

                DocPrintJob printJob = impresora.createPrintJob();
                Doc documento = new SimpleDoc(llenaDetalleTkt().getBytes(), formatoDoc, null);

                try {
                    printJob.print(documento, null);
                } catch (PrintException ex) {
                    Logger.getLogger(VentaTkts.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error de impresion: " + ex.toString());
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay impresoras definidas");
        }

    }

    private String llenaDetalleTkt() {

        Collections.sort(listaVentaTkt, new Comparator<VentaTktVO>() {
            @Override
            public int compare(VentaTktVO o1, VentaTktVO o2) {
                String a = fMonto.format(o1.getMonto()) + o1.getNumero();
                String b = fMonto.format(o2.getMonto()) + o2.getNumero();
                return a.compareTo(b);
            }
        });

        String sNum, sMon;
        String mNomSorteo = listaSorteosUsu.get(cbSorteos.getSelectedIndex()).getNom_sorteo();
        int mFacPremio = listaSorteosUsu.get(cbSorteos.getSelectedIndex()).getFac_premio_usu();

        StringBuilder builder = new StringBuilder();
        builder.append(new char[]{27, '@'});
        builder.append(new char[]{27, 'd', 3}); // Avance de 3 lineas

        if (Variables.TIT_TKT.length() > 0) {
            builder.append(new char[]{27, '!', 24}); // doble altura
            builder.append(new char[]{27, 'a', 1}); // Alineacion centrada
            builder.append(Variables.TIT_TKT).append("\r\n");
        }

        builder.append(new char[]{27, '!', 8}); // Negrita, 10cpp
        builder.append("Tiquete de compra").append("\r\n");
        builder.append("Numero Tiquete: ").append(fTkt.format(mNumTkt)).append("\r\n");

        if (reimprime) {
            builder.append("*** REIMPRESION ***").append("\r\n");
        }

        builder.append(new char[]{27, '!', 0}); // 10cpp
        builder.append(new char[]{27, 'a', 0}); // Alineacion izquierda

        builder.append("\r\n");
        builder.append("Fecha: ").append(mFechaTkt).append(String.format("%12s", mHoraTkt)).append("\r\n");
        builder.append("Sorteo: ").append(mNomSorteo).append("\r\n");

        if (mReferencia.length() > 0) {
            builder.append("Cliente: ").append(mReferencia).append("\r\n");
        }

        builder.append("Detalle\r\n");
        builder.append("==============================\r\n");

        int montoGrupo = 0;
        int numLinea = 1;

        for (int i = 0; i < listaVentaTkt.size(); i++) {

            int mon_jugado = listaVentaTkt.get(i).getMonto();
            String num_jugado = listaVentaTkt.get(i).getNumero();

            if (mon_jugado != montoGrupo) {
                if (montoGrupo > 0) {
                    builder.append("\r\n");
                }
                montoGrupo = mon_jugado;
                numLinea = 1;
                builder.append(String.format("%9s", fMonto.format(montoGrupo))).append(" x ");
            } else {
                if (numLinea == 1) {
                    //builder.append("####,###").append("   ");
                    builder.append(String.format("%12s", " "));
                }
            }
            builder.append(num_jugado.trim()).append(", ");
            numLinea += 1;

            /*if (numLinea < 5) {
                builder.append(", ");
            }
            if (numLinea == 5) {
                numLinea = 1;
                builder.append("\r\n");
            }*/
        }
        builder.append("\n");
        builder.append("==============================\r\n");
        builder.append("Total Tiquete: ").append(String.format("%10s", fMonto.format(mVentaTotal))).append("\r\n").append("\r\n");

        builder.append(new char[]{27, '!', 8}); // Negrita, 10cpp
        builder.append(new char[]{27, 'a', 1}); // Alineacion centrada
        builder.append("PAGAMOS AL  ").append(String.valueOf(mFacPremio)).append("\r\n").append("\r\n");

        if (Variables.MSG_TKT != null || Variables.MSG_TKT.length() > 0) {
            builder.append(new char[]{27, '!', 0}); // 10cpp
            builder.append(Variables.MSG_TKT).append("\r\n").append("\r\n");
        }

        builder.append(new char[]{27, '!', 1}); // 12cpp
        builder.append("Emitido por: ").append(Variables.mNOMUSU).append("\r\n");
        builder.append("Generado por LOTTOBANCACR").append("\r\n");

        builder.append(new char[]{27, '!', 0}); // 10 CPP
        builder.append(new char[]{27, 'd', 5}); // Avance de lineas

        return builder.toString();

    }

    private void anulaTiquete() {

        JSONObject jsonSend = new JSONObject();
        jsonSend.put("w", "apiLotto");
        jsonSend.put("r", "anula_tkt");
        jsonSend.put("num_tkt", mNumTkt);

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        String url = Variables.URL_API;

        JSONObject respuesta;

        try {
            respuesta = HttpClient.httpPOST(url, jsonSend).getJSONObject("resp");

            if (respuesta != null) {

                JOptionPane.showMessageDialog(this, respuesta.optString("msg"));

            }

        } catch (IOException ex) {
            Logger.getLogger(TktsEmitidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

}
