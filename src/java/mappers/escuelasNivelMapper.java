/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;
import beans.escuelasNivelBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class escuelasNivelMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		escuelasNivelBean mod = new escuelasNivelBean();


                
                mod.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
                mod.setCVENIVEL(rs.getString("CVENIVEL").trim());
                mod.setSUBNIVEL(rs.getString("SUBNIVEL").trim());
                
                mod.setDATO_ESTATAL(rs.getString("DATO_ESTATAL").trim());
                mod.setDATO_FEDERALIZADO(rs.getString("DATO_FEDERALIZADO").trim());
                mod.setTOTAL_NIVEL(rs.getString("TOTAL_NIVEL").trim());
                mod.setNOMBRE_NIVEL(rs.getString("NOMBRE_NIVEL").trim());
                
                 mod.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());
                mod.setCOLOR(rs.getString("COLOR").trim());
       
       
       
		return mod;
	}
    
}
