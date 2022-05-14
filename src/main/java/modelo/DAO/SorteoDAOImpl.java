/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import interfaces.SorteoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import metodos.PoolConexion;
import modelo.PO.SorteoUsuVO;

/**
 *
 * @author Usuario
 */
public class SorteoDAOImpl implements SorteoDAO {

    @Override
    public Vector<SorteoUsuVO> llenarComboSorteosUsu(int codUsuario) throws SQLException {
        Vector<SorteoUsuVO> lista = new Vector<>();
        SorteoUsuVO sorteo = new SorteoUsuVO();
        sorteo.setCod_sorteo(0);
        sorteo.setNom_sorteo("Sellecione un sorteo");
        lista.add(sorteo);

        String sql = "SELECT su.cod_sorteo,nom_sorteo,reventado,num_digitos,su.fac_premio_usu,su.por_comision_usu FROM sorteos_usu AS su"
                + " INNER JOIN sorteos AS s ON su.cod_sorteo=s.cod_sorteo"
                + " WHERE cod_usuario=?"
                + " ORDER BY nom_sorteo";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, codUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    sorteo = new SorteoUsuVO();
                    sorteo.setCod_sorteo(rs.getInt("cod_sorteo"));
                    sorteo.setNom_sorteo(rs.getString("nom_sorteo"));
                    sorteo.setFac_premio_usu(rs.getInt("fac_premio_usu"));
                    sorteo.setPor_comision_usu(rs.getDouble("por_comision_usu"));
                    sorteo.setReventado(rs.getBoolean("reventado"));
                    sorteo.setNum_digitos(rs.getInt("num_digitos"));
                    lista.add(sorteo);
                }
            }
        }
        return lista;
    }

}
