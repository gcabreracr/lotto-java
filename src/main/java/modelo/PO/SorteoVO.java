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
public class SorteoVO {
    
    private int cod_sorteo;
    private String nom_sorteo;
    private int fac_premio;
    private double por_comision;
    private int estado;
    private int ven_lun;
    private int ven_mar;
    private int ven_mie;
    private int ven_jue;
    private int ven_vie;
    private int ven_sab;
    private int ven_dom;
    private String hora_sorteo;
    private String hora_cierre;
    private int num_digitos;
    private boolean reventado;

    public SorteoVO() {
    }

    public int getCod_sorteo() {
        return cod_sorteo;
    }

    public void setCod_sorteo(int cod_sorteo) {
        this.cod_sorteo = cod_sorteo;
    }

    public String getNom_sorteo() {
        return nom_sorteo;
    }

    public void setNom_sorteo(String nom_sorteo) {
        this.nom_sorteo = nom_sorteo;
    }

    public int getFac_premio() {
        return fac_premio;
    }

    public void setFac_premio(int fac_premio) {
        this.fac_premio = fac_premio;
    }

    public double getPor_comision() {
        return por_comision;
    }

    public void setPor_comision(double por_comision) {
        this.por_comision = por_comision;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getVen_lun() {
        return ven_lun;
    }

    public void setVen_lun(int ven_lun) {
        this.ven_lun = ven_lun;
    }

    public int getVen_mar() {
        return ven_mar;
    }

    public void setVen_mar(int ven_mar) {
        this.ven_mar = ven_mar;
    }

    public int getVen_mie() {
        return ven_mie;
    }

    public void setVen_mie(int ven_mie) {
        this.ven_mie = ven_mie;
    }

    public int getVen_jue() {
        return ven_jue;
    }

    public void setVen_jue(int ven_jue) {
        this.ven_jue = ven_jue;
    }

    public int getVen_vie() {
        return ven_vie;
    }

    public void setVen_vie(int ven_vie) {
        this.ven_vie = ven_vie;
    }

    public int getVen_sab() {
        return ven_sab;
    }

    public void setVen_sab(int ven_sab) {
        this.ven_sab = ven_sab;
    }

    public int getVen_dom() {
        return ven_dom;
    }

    public void setVen_dom(int ven_dom) {
        this.ven_dom = ven_dom;
    }

    public String getHora_sorteo() {
        return hora_sorteo;
    }

    public void setHora_sorteo(String hora_sorteo) {
        this.hora_sorteo = hora_sorteo;
    }

    public String getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(String hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    @Override
    public String toString() {
        return nom_sorteo;
    }

    public int getNum_digitos() {
        return num_digitos;
    }

    public void setNum_digitos(int num_digitos) {
        this.num_digitos = num_digitos;
    }

    public boolean isReventado() {
        return reventado;
    }

    public void setReventado(boolean reventado) {
        this.reventado = reventado;
    }
    
    
    
}
