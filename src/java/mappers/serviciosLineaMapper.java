/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.escuelasNivelBean;
import beans.serviciosLineaBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class serviciosLineaMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();


                 if (rs.getString("ACRONIMO") != null) {
            mod.setACRONIMO(rs.getString("ACRONIMO").trim());
        } else {
            mod.setACRONIMO(rs.getString("ACRONIMO"));
        }
                
                 if (rs.getString("NOMBRE_SISTEMA") != null) {
            mod.setNOMBRE_SISTEMA(rs.getString("NOMBRE_SISTEMA").trim());
        } else {
            mod.setNOMBRE_SISTEMA(rs.getString("NOMBRE_SISTEMA"));
        }
      
                 if (rs.getString("NOTA") != null) {
            mod.setNOTA(rs.getString("NOTA").trim());
        } else {
            mod.setNOTA(rs.getString("NOTA"));
        }
                  if (rs.getString("IMPACTO_SOCIEDAD") != null) {
            mod.setIMPACTO_SOCIEDAD(rs.getString("IMPACTO_SOCIEDAD").trim());
        } else {
            mod.setIMPACTO_SOCIEDAD(rs.getString("IMPACTO_SOCIEDAD"));
        }
        if (rs.getString("PORCENTAJE_AVANCE") != null) {
            mod.setPORCENTAJE_AVANCE(rs.getString("PORCENTAJE_AVANCE").trim());
        } else {
            mod.setPORCENTAJE_AVANCE(rs.getString("PORCENTAJE_AVANCE"));
        }
       
        if (rs.getString("VIGENCIA") != null) {
            mod.setVIGENCIA(rs.getString("VIGENCIA").trim());
        } else {
            mod.setVIGENCIA(rs.getString("VIGENCIA"));
        }
        
        
		return mod;
	}
    
    
}
