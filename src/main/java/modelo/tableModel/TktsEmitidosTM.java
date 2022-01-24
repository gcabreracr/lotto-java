/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tableModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.PO.VentaDiariaTktVO;

/**
 *
 * @author Usuario
 */
public class TktsEmitidosTM extends AbstractTableModel {

    DecimalFormat fMonto = new DecimalFormat("###,###,###");
    DecimalFormat fTkt = new DecimalFormat("000000");

    private ArrayList<VentaDiariaTktVO> listaTktsEmitidos;
    private final String[] nombreColumnas = {" Tkt", "Monto", "Referencia"};

    public TktsEmitidosTM() {

        listaTktsEmitidos = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return listaTktsEmitidos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int i) {
        return nombreColumnas[i];
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        VentaDiariaTktVO registro = listaTktsEmitidos.get(i);

        switch (i1) {
            case 0:
                return fTkt.format(registro.getNum_tkt());
            case 1:
                return fMonto.format(registro.getMon_tkt());
            case 2:
                return registro.getReferencia();

            default:
                return null;
        }

    }

    public void llenaLista(ArrayList<VentaDiariaTktVO> nuevaLista) {
        listaTktsEmitidos = nuevaLista;
        fireTableDataChanged();
    }

}
