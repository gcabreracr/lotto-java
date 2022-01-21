/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.PO.VentaTktVO;

/**
 *
 * @author Gonzalo Cabrera
 */
public class VentaTktTM extends AbstractTableModel {

    private ArrayList<VentaTktVO> listaNumeros;
    private final String[] nombreColumnas = {"Numero", "Monto"};

    public VentaTktTM() {
        listaNumeros = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return listaNumeros.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VentaTktVO registro = listaNumeros.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return registro.getNumero();
            case 1:
                return registro.getMonto();
            default:
                return null;
        }
    }
    
    public VentaTktVO getRegistro(int fila){
        return listaNumeros.get(fila);        
    }
    
    public void addRegistro(VentaTktVO fila){
        listaNumeros.add(fila);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public void deleteRegistro(int fila){
        listaNumeros.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }

}
