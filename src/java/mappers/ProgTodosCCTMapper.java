/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.busquedaCCTBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class ProgTodosCCTMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        busquedaCCTBean cat = new     busquedaCCTBean();


              
        
        
        
         if (rs.getString("CCT") != null) {
            cat.setCCT(rs.getString("CCT").trim());
        } else {
            cat.setCCT(rs.getString("CCT"));
        }
         
          if (rs.getString("IDPROGRAMA") != null) {
            cat.setIDPROGRAMA(rs.getString("IDPROGRAMA").trim());
        } else {
            cat.setIDPROGRAMA(rs.getString("IDPROGRAMA"));
        }
          
            if (rs.getString("DESC_PROG") != null) {
            cat.setDESC_PROG(rs.getString("DESC_PROG").trim());
        } else {
            cat.setDESC_PROG(rs.getString("DESC_PROG"));
        }
            if (rs.getString("CICLOESCOLAR") != null) {
            cat.setCICLOESCOLAR(rs.getString("CICLOESCOLAR").trim());
        } else {
            cat.setCICLOESCOLAR(rs.getString("CICLOESCOLAR"));
        }
            
              if (rs.getString("CONCEPTO") != null) {
            cat.setCONCEPTO(rs.getString("CONCEPTO").trim());
        } else {
            cat.setCONCEPTO(rs.getString("CONCEPTO"));
        }
              
                if (rs.getString("MONTO") != null) {
            cat.setMONTO(rs.getString("MONTO").trim());
        } else {
            cat.setMONTO(rs.getString("MONTO"));
        }
         
               
        
        return cat;
    }
    
}
