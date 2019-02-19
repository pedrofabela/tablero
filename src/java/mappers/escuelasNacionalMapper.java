/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.escuelasNacionalBean;
import beans.progNivelBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class escuelasNacionalMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
		escuelasNacionalBean mod = new escuelasNacionalBean();

		
                mod.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
                mod.setNOMBRE_ESTADO(rs.getString("NOMBRE_ESTADO").trim());
                mod.setNO_ESCUELAS(rs.getString("NO_ESCUELAS").trim());
                 mod.setCOLOR(rs.getString("COLOR").trim());
                    mod.setCVEESTADO(rs.getString("CVEESTADO").trim());
                 
       
		return mod;
	}
	
    
}
