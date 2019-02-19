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
public class serlineaInfografiaAvanceMapper implements Mapper{
    
    
     public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();


               
                
                if (rs.getString("ACRONIMO") != null) {
            mod.setACRONIMO(rs.getString("ACRONIMO").trim());
        } else {
            mod.setACRONIMO(rs.getString("ACRONIMO"));
        }
                
                 if (rs.getString("TITULO") != null) {
            mod.setTITULO(rs.getString("TITULO").trim());
        } else {
            mod.setTITULO(rs.getString("TITULO"));
        }
       
                 if (rs.getString("ORDEN") != null) {
            mod.setORDEN(rs.getString("ORDEN").trim());
        } else {
            mod.setORDEN(rs.getString("ORDEN"));
        }
                
                  if (rs.getString("ALUMNOS") != null) {
            mod.setALUMNOS(rs.getString("ALUMNOS").trim());
        } else {
            mod.setALUMNOS(rs.getString("ALUMNOS"));
        }
        if (rs.getString("PORCE_ALUMNOS") != null) {
            mod.setPORCE_ALUMNOS(rs.getString("PORCE_ALUMNOS").trim());
        } else {
            mod.setPORCE_ALUMNOS(rs.getString("PORCE_ALUMNOS"));
        }
        
        
        
        
       
        if (rs.getString("DOCENTES") != null) {
            mod.setDOCENTES(rs.getString("DOCENTES").trim());
        } else {
            mod.setDOCENTES(rs.getString("DOCENTES"));
        }
        
        
        if (rs.getString("PORCE_DOCENTES") != null) {
            mod.setPORCE_DOCENTES(rs.getString("PORCE_DOCENTES").trim());
        } else {
            mod.setPORCE_DOCENTES(rs.getString("PORCE_DOCENTES"));
        }
        
        
          
        if (rs.getString("ESCUELAS") != null) {
            mod.setESCUELAS(rs.getString("ESCUELAS").trim());
        } else {
            mod.setESCUELAS(rs.getString("ESCUELAS"));
        }
        
          if (rs.getString("PORCE_ESCUELAS") != null) {
            mod.setPORCE_ESCUELAS(rs.getString("PORCE_ESCUELAS").trim());
        } else {
            mod.setPORCE_ESCUELAS(rs.getString("PORCE_ESCUELAS"));
        }
        
         if (rs.getString("MUNICIPIOS") != null) {
            mod.setMUNICIPIOS(rs.getString("MUNICIPIOS").trim());
        } else {
            mod.setMUNICIPIOS(rs.getString("MUNICIPIOS"));
        }
         
          if (rs.getString("PORCE_MUNICIPIOS") != null) {
            mod.setPORCE_MUNICIPIOS(rs.getString("PORCE_MUNICIPIOS").trim());
        } else {
            mod.setPORCE_MUNICIPIOS(rs.getString("PORCE_MUNICIPIOS"));
        }
        
		return mod;
	}
    
}
