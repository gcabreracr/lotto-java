/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PO;

/**
 *
 * @author Usuario
 */
public class SorteoUsuVO extends SorteoVO {
    
    private int cod_usuario;
    private int fac_premio_usu;
    private double por_comision_usu;
    private int estado_sor_usu;

    public SorteoUsuVO() {
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public int getFac_premio_usu() {
        return fac_premio_usu;
    }

    public void setFac_premio_usu(int fac_premio_usu) {
        this.fac_premio_usu = fac_premio_usu;
    }

    public double getPor_comision_usu() {
        return por_comision_usu;
    }

    public void setPor_comision_usu(double por_comision_usu) {
        this.por_comision_usu = por_comision_usu;
    }

    public int getEstado_sor_usu() {
        return estado_sor_usu;
    }

    public void setEstado_sor_usu(int estado_sor_usu) {
        this.estado_sor_usu = estado_sor_usu;
    }

      
    
    
}
