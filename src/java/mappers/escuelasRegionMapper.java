/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.escuelasNivelBean;
import beans.escuelasRegionBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class escuelasRegionMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
		escuelasRegionBean mod = new escuelasRegionBean();




                
                mod.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
                mod.setCVEREGION(rs.getString("CVEREGION").trim());
                mod.setNOMBRE_REGION(rs.getString("NOMBRE_REGION").trim());
                mod.setTOTAL_REGION(rs.getString("TOTAL_REGION").trim());
                 mod.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());
                mod.setCOLOR(rs.getString("COLOR").trim());
                 mod.setNOMBRE_PROGRAMA(rs.getString("NOMBRE_PROGRAMA").trim());
       
       
       
		return mod;
	}
    
}
