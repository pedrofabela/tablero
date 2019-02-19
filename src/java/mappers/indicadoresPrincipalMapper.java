/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class indicadoresPrincipalMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        CatalogoBean cat = new    CatalogoBean();


              
        
        if (rs.getString("CVEINDICADOR") != null) {
            cat.setCVEINDICADOR(rs.getString("CVEINDICADOR").trim());
        } else {
            cat.setCVEINDICADOR(rs.getString("CVEINDICADOR"));
        }
        
         if (rs.getString("PORCENTAJE") != null) {
            cat.setPORCENTAJE(rs.getString("PORCENTAJE").trim());
        } else {
            cat.setPORCENTAJE(rs.getString("PORCENTAJE"));
        }
         
          if (rs.getString("DIFERENCIA") != null) {
            cat.setDIFERENCIA(rs.getString("DIFERENCIA").trim());
        } else {
            cat.setDIFERENCIA(rs.getString("DIFERENCIA"));
        }
        
        return cat;
    }
    
    
   
    
    
    
}
