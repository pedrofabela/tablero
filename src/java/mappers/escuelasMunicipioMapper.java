/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;
import beans.escuelasMunicipioBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class escuelasMunicipioMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
		escuelasMunicipioBean mod = new escuelasMunicipioBean();

		
                mod.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());
                  mod.setCVEMUNICIPIO(rs.getString("CVEMUNICIPIO").trim());
                 mod.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
                   mod.setNOMBRE_MUNICIPIO(rs.getString("NOMBRE_MUNICIPIO").trim());
                     mod.setTOTAL_MUNICIPIO(rs.getString("TOTAL_MUNICIPIO").trim());
       
		return mod;
	}
    
}
