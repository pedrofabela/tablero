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
public class porcentajeAvanceMapper  implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();


        if (rs.getString("PORCENTAJE_AVANCE") != null) {
            mod.setPORCENTAJE_AVANCE(rs.getString("PORCENTAJE_AVANCE").trim());
        } else {
            mod.setPORCENTAJE_AVANCE(rs.getString("PORCENTAJE_AVANCE"));
        }
       
       
        
        
		return mod;
	}
    
}
