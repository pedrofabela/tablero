/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.serviciosLineaBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class menuSerlineaMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();


                 if (rs.getString("ACRONIMO") != null) {
            mod.setACRONIMO(rs.getString("ACRONIMO").trim());
        } else {
            mod.setACRONIMO(rs.getString("ACRONIMO"));
        }
                
                 if (rs.getString("NOMBRE_SISTEMA") != null) {
            mod.setNOMBRE_SISTEMA(rs.getString("NOMBRE_SISTEMA").trim());
        } else {
            mod.setNOMBRE_SISTEMA(rs.getString("NOMBRE_SISTEMA"));
        }
      
                 if (rs.getString("ID_APLICACION") != null) {
            mod.setID_APLICACION(rs.getString("ID_APLICACION").trim());
        } else {
            mod.setID_APLICACION(rs.getString("ID_APLICACION"));
                       
        }
                 
                 
                  if (rs.getString("PRIORIDAD") != null) {
            mod.setPRIORIDAD(rs.getString("PRIORIDAD").trim());
        } else {
            mod.setPRIORIDAD(rs.getString("PRIORIDAD"));
        }
        
        
        
		return mod;
	}
    
}
