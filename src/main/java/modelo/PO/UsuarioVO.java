/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PO;

/**
 *
 * @author Gonzalo Cabrera
 */
public class UsuarioVO {
    
    private int cod_usuario;
    private String id_usuario;
    private int cod_suc;
    private String nom_suc;
    private String nom_usuario;
    private int tipo_usuario;
    private int pin_pass;
    private int est_usuario;

    public UsuarioVO() {
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getCod_suc() {
        return cod_suc;
    }

    public String getNom_suc() {
        return nom_suc;
    }

    public void setNom_suc(String nom_suc) {
        this.nom_suc = nom_suc;
    }
    
    
    public void setCod_suc(int cod_suc) {
        this.cod_suc = cod_suc;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getPin_pass() {
        return pin_pass;
    }

    public void setPin_pass(int pin_pass) {
        this.pin_pass = pin_pass;
    }

    public int getEst_usuario() {
        return est_usuario;
    }

    public void setEst_usuario(int est_usuario) {
        this.est_usuario = est_usuario;
    }
    
    
    
}
