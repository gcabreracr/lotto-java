
package modelo.PO;

/**
 *
 * @author Gonzalo Cabrera
 */
public class ItemLiqDiaSorteosVO extends SorteoVO{    
  
    private int mon_venta;
    private int mon_comision;
    private int mon_premios;

    public ItemLiqDiaSorteosVO() {
    }

 
    public int getMon_venta() {
        return mon_venta;
    }

    public void setMon_venta(int mon_venta) {
        this.mon_venta = mon_venta;
    }

    public int getMon_comision() {
        return mon_comision;
    }

    public void setMon_comision(int mon_comision) {
        this.mon_comision = mon_comision;
    }

    public int getMon_premios() {
        return mon_premios;
    }

    public void setMon_premios(int mon_premios) {
        this.mon_premios = mon_premios;
    }    
    
    
}
