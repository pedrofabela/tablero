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
public class resultadosPlaneaMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        busquedaCCTBean cat = new     busquedaCCTBean();



        
        if (rs.getString("CICLO_ESCOLAR") != null) {
            cat.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());
        } else {
            cat.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR"));
        }
       
         if (rs.getString("LC_I") != null) {
            cat.setLC_I(rs.getString("LC_I").trim());
        } else {
            cat.setLC_I(rs.getString("LC_I"));
        }
         
            if (rs.getString("LC_II") != null) {
            cat.setLC_II(rs.getString("LC_II").trim());
        } else {
            cat.setLC_II(rs.getString("LC_II"));
        }
        
             if (rs.getString("LC_III") != null) {
            cat.setLC_III(rs.getString("LC_III").trim());
        } else {
            cat.setLC_III(rs.getString("LC_III"));
        }
            if (rs.getString("LC_IV") != null) {
            cat.setLC_IV(rs.getString("LC_IV").trim());
        } else {
            cat.setLC_IV(rs.getString("LC_IV"));
        }   
            
            if (rs.getString("M_I") != null) {
            cat.setM_I(rs.getString("M_I").trim());
        } else {
            cat.setM_I(rs.getString("M_I"));
        }   
            
             if (rs.getString("M_II") != null) {
            cat.setM_II(rs.getString("M_II").trim());
        } else {
            cat.setM_II(rs.getString("M_II"));
        }   
               if (rs.getString("M_III") != null) {
            cat.setM_III(rs.getString("M_III").trim());
        } else {
            cat.setM_III(rs.getString("M_III"));
        }   
               
               if (rs.getString("M_IV") != null) {
            cat.setM_IV(rs.getString("M_IV").trim());
        } else {
            cat.setM_IV(rs.getString("M_IV"));
        }   
                 if (rs.getString("MAYOR") != null) {
            cat.setMAYOR(rs.getString("MAYOR").trim());
        } else {
            cat.setMAYOR(rs.getString("MAYOR"));
        }   
                 
           if (rs.getString("MAYOR_M") != null) {
            cat.setMAYOR_M(rs.getString("MAYOR_M").trim());
        } else {
            cat.setMAYOR_M(rs.getString("MAYOR_M"));
        }       
        return cat;
    }
    
}
