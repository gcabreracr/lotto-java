/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.Vector;
import modelo.PO.SorteoUsuVO;

/**
 *
 * @author Usuario
 */
public interface SorteoDAO {
    
    public Vector<SorteoUsuVO> llenarComboSorteosUsu(int codUsuario) throws SQLException;
    
}
