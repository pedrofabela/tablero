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
public class serlineaAlcanceMapper implements Mapper{
    
    
     public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();


               
                
                if (rs.getString("ORDEN") != null) {
            mod.setORDEN(rs.getString("ORDEN").trim());
        } else {
            mod.setORDEN(rs.getString("ORDEN"));
        }
                
                 if (rs.getString("DESCRIPCION") != null) {
            mod.setDESCRIPCION(rs.getString("DESCRIPCION").trim());
        } else {
            mod.setDESCRIPCION(rs.getString("DESCRIPCION"));
        }
       
                 if (rs.getString("UNIVERSO") != null) {
            mod.setUNIVERSO(rs.getString("UNIVERSO").trim());
        } else {
            mod.setUNIVERSO(rs.getString("UNIVERSO"));
        }
                
                  if (rs.getString("BENEFICIARIOS") != null) {
            mod.setBENEFICIARIOS(rs.getString("BENEFICIARIOS").trim());
        } else {
            mod.setBENEFICIARIOS(rs.getString("BENEFICIARIOS"));
        }
                  
                  
        if (rs.getString("PORCE_BENEFICIARIO") != null) {
            mod.setPORCE_BENEFICIARIO(rs.getString("PORCE_BENEFICIARIO").trim());
        } else {
            mod.setPORCE_BENEFICIARIO(rs.getString("PORCE_BENEFICIARIO"));
        }
        
        
        
        
       
    
        
		return mod;
	}
    
}
