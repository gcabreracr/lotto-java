/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tableModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.PO.MovCtaUsuVO;

/**
 *
 * @author Usuario
 */
public class ConsultaEstCtaTM extends AbstractTableModel {

    DecimalFormat fMonto = new DecimalFormat("###,###,###");

    private ArrayList<MovCtaUsuVO> listaMovimientos;
    private final String[] nombreColumnas = {"Fecha", "Doc.Ref.", "Detalle", "Monto"};

    public ConsultaEstCtaTM() {

        listaMovimientos = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return listaMovimientos.size();
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
        MovCtaUsuVO registro = listaMovimientos.get(i);

        switch (i1) {
            case 0:
                return registro.getFechaMov();
            case 1:
                return registro.getDocRefe();
            case 2:
                return registro.getDetMov();
            case 3:
                return fMonto.format(registro.getMontoMov());

            default:
                return null;
        }

    }

    public void llenaLista(ArrayList<MovCtaUsuVO> nuevaLista) {
        listaMovimientos = nuevaLista;
        fireTableDataChanged();
    }

}
