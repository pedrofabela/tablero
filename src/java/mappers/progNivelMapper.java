/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.progNivelBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class progNivelMapper implements Mapper {
    
     public Object mapRow(ResultSet rs) throws SQLException {
		progNivelBean mod = new progNivelBean();

		
                mod.setNOMBRE_PROGRAMA(rs.getString("NOMBRE_PROGRAMA").trim());
                mod.setNO_ESC_PROG(rs.getString("NO_ESC_PROG").trim());
                mod.setPORCENTAJE_AVANCE(rs.getString("PORCENTAJE_AVANCE").trim());
       
		return mod;
	}
	
    
}
