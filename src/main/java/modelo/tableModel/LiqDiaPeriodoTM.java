/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tableModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.PO.ItemLiqDiaPeriodoVO;

/**
 *
 * @author Usuario
 */
public class LiqDiaPeriodoTM extends AbstractTableModel {

    DecimalFormat fMonto = new DecimalFormat("###,###,###");

    private ArrayList<ItemLiqDiaPeriodoVO> datos;
    private final String[] nombreColumnas = {"Fecha", "Venta", "Comisión", "Premio", "Liq. Neta"};

    public LiqDiaPeriodoTM() {

        datos = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return datos.size();
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
        ItemLiqDiaPeriodoVO registro = datos.get(i);
        int liqNeta = registro.getMon_venta()-registro.getMon_comision()-registro.getMon_premios();

        switch (i1) {
            case 0:
                return registro.getFec_sorteo();
            case 1:
                return fMonto.format(registro.getMon_venta());
            case 2:
                return fMonto.format(registro.getMon_comision());
            case 3:
                return fMonto.format(registro.getMon_premios());
            case 4:
                return fMonto.format(liqNeta);

            default:
                return null;
        }

    }

    public void llenaLista(ArrayList<ItemLiqDiaPeriodoVO> nuevaLista) {
        datos = nuevaLista;
        fireTableDataChanged();
    }

}
