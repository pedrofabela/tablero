/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;
import beans.busquedaCCTBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class ProgVigentesCCTMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        busquedaCCTBean cat = new     busquedaCCTBean();


              
        
        
        
         if (rs.getString("IDPROGRAMA") != null) {
            cat.setIDPROGRAMA(rs.getString("IDPROGRAMA").trim());
        } else {
            cat.setIDPROGRAMA(rs.getString("IDPROGRAMA"));
        }
         
          if (rs.getString("DESCRIPCION_PROGRAMA") != null) {
            cat.setDESC_PROG(rs.getString("DESCRIPCION_PROGRAMA").trim());
        } else {
            cat.setDESC_PROG(rs.getString("DESCRIPCION_PROGRAMA"));
        }
          
           
        
        return cat;
    }
}
