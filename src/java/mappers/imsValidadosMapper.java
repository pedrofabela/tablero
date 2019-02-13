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
public class imsValidadosMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        CatalogoBean cat = new    CatalogoBean();


              
        
        if (rs.getString("TOTAL_ASPIRANTES") != null) {
            cat.setTOTAL_ASPIRANTES(rs.getString("TOTAL_ASPIRANTES").trim());
        } else {
            cat.setTOTAL_ASPIRANTES(rs.getString("TOTAL_ASPIRANTES"));
        }
        
         if (rs.getString("TOTAL_VALIDADOS") != null) {
            cat.setTOTAL_VALIDADOS(rs.getString("TOTAL_VALIDADOS").trim());
        } else {
            cat.setTOTAL_VALIDADOS(rs.getString("TOTAL_VALIDADOS"));
        }
         
          if (rs.getString("TOTAL_NOVALIDADOS") != null) {
            cat.setTOTAL_NOVALIDADOS(rs.getString("TOTAL_NOVALIDADOS").trim());
        } else {
            cat.setTOTAL_NOVALIDADOS(rs.getString("TOTAL_NOVALIDADOS"));
        }
        
        return cat;

     }
}
