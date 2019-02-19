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
public class mesLineaMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();


                 if (rs.getString("MES") != null) {
            mod.setMES(rs.getString("MES").trim());
        } else {
            mod.setMES(rs.getString("MES"));
        }
                
                 if (rs.getString("MES_LETRA") != null) {
            mod.setMES_LETRA(rs.getString("MES_LETRA").trim());
        } else {
            mod.setMES_LETRA(rs.getString("MES_LETRA"));
        }
      
        
        
        
		return mod;
	}
    
    
}
