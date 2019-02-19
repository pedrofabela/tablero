/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.idicadoresProgBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class indicadoresProgMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        idicadoresProgBean cat = new    idicadoresProgBean();


              
        
        if (rs.getString("ID_PROGRAMA") != null) {
            cat.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
        } else {
            cat.setID_PROGRAMA(rs.getString("ID_PROGRAMA"));
        }
        
         if (rs.getString("NO_ALUMNOS") != null) {
            cat.setNO_ALUMNOS(rs.getString("NO_ALUMNOS").trim());
        } else {
            cat.setNO_ALUMNOS(rs.getString("NO_ALUMNOS"));
        }
        
        if (rs.getString("NO_ESCUELAS") != null) {
            cat.setNO_ESCUELAS(rs.getString("NO_ESCUELAS").trim());
        } else {
            cat.setNO_ESCUELAS(rs.getString("NO_ESCUELAS"));
        }
        
        if (rs.getString("NO_MUNIICIPIOS") != null) {
            cat.setNO_MUNIICIPIOS(rs.getString("NO_MUNIICIPIOS").trim());
        } else {
            cat.setNO_MUNIICIPIOS(rs.getString("NO_MUNIICIPIOS"));
        }
        
        if (rs.getString("INVERSION") != null) {
            cat.setINVERSION(rs.getString("INVERSION").trim());
        } else {
            cat.setINVERSION(rs.getString("INVERSION"));
        }
        
         if (rs.getString("CICLO_ESCOLAR") != null) {
            cat.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());
        } else {
            cat.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR"));
        }
         if (rs.getString("NOTA") != null) {
            cat.setNOTA(rs.getString("NOTA").trim());
        } else {
            cat.setNOTA(rs.getString("NOTA"));
        }
        
        
        return cat;
    }
    
    
   
    
    
    
    
}
