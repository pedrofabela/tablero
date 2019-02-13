/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.escuelasDescripcionBean;
import beans.escuelasNacionalBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class escuelasDescripcionMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
		escuelasDescripcionBean mod = new escuelasDescripcionBean();

		
                mod.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
                 mod.setDESCRIPCION_HISTORICO(rs.getString("DESCRIPCION_HISTORICO").trim());
               mod.setDESCRIPCION_MUNICIPIO(rs.getString("DESCRIPCION_MUNICIPIO").trim());
               mod.setDESCRIPCION_NACIONAL(rs.getString("DESCRIPCION_NACIONAL").trim());
               mod.setDESCRIPCION_NIVEL(rs.getString("DESCRIPCION_NIVEL").trim());
               mod.setDESCRIPCION_REGION(rs.getString("DESCRIPCION_REGION").trim());
       
		return mod;
	}
    
    
    
}
