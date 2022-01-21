/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import interfaces.UsuarioDAO;
import java.sql.SQLException;
import modelo.PO.UsuarioVO;

/**
 *
 * @author Gonzalo Cabrera
 */
public class UsuarioDAOImpl implements UsuarioDAO{

   

    @Override
    public boolean Login(UsuarioVO usr) throws SQLException {
        
        return false;
    }
    
    
    
}
