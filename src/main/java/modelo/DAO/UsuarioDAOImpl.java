/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import interfaces.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import metodos.PoolConexion;
import modelo.PO.UsuarioVO;

/**
 *
 * @author Gonzalo Cabrera
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public boolean Login(UsuarioVO usr) throws SQLException {

        String sql = "SELECT u.cod_usuario,u.nom_usuario,u.pin_pass,u.tipo_usuario,u.cod_suc,a.nom_suc,u.tit_tkt,u.msg_tkt,u.nom_imp,u.est_usuario"
                + " FROM usuarios AS u"
                + " INNER JOIN sucursales AS a ON u.cod_suc=a.cod_suc"
                + " WHERE u.id_usuario=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, usr.getId_usuario());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usr.setPin_pass(rs.getString("pin_pass"));
                    usr.setCod_usuario(rs.getInt("cod_usuario"));
                    usr.setNom_usuario(rs.getString("nom_usuario"));
                    usr.setTipo_usuario(rs.getInt("tipo_usuario"));
                    usr.setCod_suc(rs.getInt("cod_suc"));
                    usr.setNom_suc(rs.getString("nom_suc"));
                    usr.setTit_tkt(rs.getString("tit_tkt"));
                    usr.setMsg_tkt(rs.getString("msg_tkt"));
                    usr.setNom_imp(rs.getString("nom_imp"));
                    usr.setEst_usuario(rs.getInt("est_usuario"));
                    return true;

                } else {
                    return false;
                }
            }
        }

    }

    @Override
    public void actualizaConfig(UsuarioVO usr) throws SQLException {

        String sql = "UPDATE usuarios SET tit_tkt=?, msg_tkt=?, nom_imp=? WHERE cod_usuario=? ";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, usr.getTit_tkt());
            ps.setString(2, usr.getMsg_tkt());
            ps.setString(3, usr.getNom_imp());
            ps.setInt(4, usr.getCod_usuario());
            ps.executeUpdate();

        }

    }
    
    @Override
    public void actualizaPin(UsuarioVO usr) throws SQLException {

        String sql = "UPDATE usuarios SET pin_pass=?"
                + " WHERE cod_usuario=?";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, usr.getPin_pass());
            ps.setInt(2, usr.getCod_usuario());
            ps.execute();

        } 
    }

}
