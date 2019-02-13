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
public class serlineaInfografiaMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();
               
                
      
                 if (rs.getString("ACRONIMO") != null) {
            mod.setACRONIMO(rs.getString("ACRONIMO").trim());
        } else {
            mod.setACRONIMO(rs.getString("ACRONIMO"));
        }
                
                 if (rs.getString("DESCRIPCION") != null) {
            mod.setDESCRIPCION(rs.getString("DESCRIPCION").trim());
        } else {
            mod.setDESCRIPCION(rs.getString("DESCRIPCION"));
        }
      
                 if (rs.getString("CONSULTA_AVANCE") != null) {
            mod.setCONSULTA_AVANCE(rs.getString("CONSULTA_AVANCE").trim());
        } else {
            mod.setCONSULTA_AVANCE(rs.getString("CONSULTA_AVANCE"));
        }
                 
                 
                  if (rs.getString("NOTA_AVANCE") != null) {
            mod.setNOTA_AVANCE(rs.getString("NOTA_AVANCE").trim());
        } else {
            mod.setNOTA_AVANCE(rs.getString("NOTA_AVANCE"));
            
            
            
            
        }
        if (rs.getString("CONSULTA_ALCANCE") != null) {
            mod.setCONSULTA_ALCANCE(rs.getString("CONSULTA_ALCANCE").trim());
        } else {
            mod.setCONSULTA_ALCANCE(rs.getString("CONSULTA_ALCANCE"));
        }
        
        
       
        if (rs.getString("NOTA_ALCANCE") != null) {
            mod.setNOTA_ALCANCE(rs.getString("NOTA_ALCANCE").trim());
        } else {
            mod.setNOTA_ALCANCE(rs.getString("NOTA_ALCANCE"));
        }
        
        
        
        
        
         if (rs.getString("TITULO_SEC3") != null) {
            mod.setTITULO_SEC3(rs.getString("TITULO_SEC3").trim());
        } else {
            mod.setTITULO_SEC3(rs.getString("TITULO_SEC3"));
        }
                 
                 
                  if (rs.getString("CONSULTA_SEC3MENU") != null) {
            mod.setCONSULTA_SEC3MENU(rs.getString("CONSULTA_SEC3MENU").trim());
        } else {
            mod.setCONSULTA_SEC3MENU(rs.getString("CONSULTA_SEC3MENU"));
            
            
            
            
        }
        if (rs.getString("CONSULTA_SEC3GRAF") != null) {
            mod.setCONSULTA_SEC3GRAF(rs.getString("CONSULTA_SEC3GRAF").trim());
        } else {
            mod.setCONSULTA_SEC3GRAF(rs.getString("CONSULTA_SEC3GRAF"));
        }
        
        
       
        if (rs.getString("NOTA_SEC3") != null) {
            mod.setNOTA_SEC3(rs.getString("NOTA_SEC3").trim());
        } else {
            mod.setNOTA_SEC3(rs.getString("NOTA_SEC3"));
        }
        
        
        
        
        
		return mod;
	}
    
    
}
