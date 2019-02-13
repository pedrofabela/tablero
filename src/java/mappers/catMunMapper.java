/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class catMunMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		CatalogoBean mod = new CatalogoBean();

		
                mod.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
                mod.setCLAVE_MUNICIPIO(rs.getString("CLAVE_MUNICIPIO").trim());
               
       
		return mod;
	}
    
}
