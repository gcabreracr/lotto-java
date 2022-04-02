/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import modelo.PO.UsuarioVO;

/**
 *
 * @author Gonzalo Cabrera
 */
public interface UsuarioDAO {

    public boolean Login(UsuarioVO usr) throws SQLException;

    public void actualizaConfig(UsuarioVO usr) throws SQLException;

    public void actualizaPin(UsuarioVO usr) throws SQLException;
}
