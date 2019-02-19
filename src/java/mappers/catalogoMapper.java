/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;
import beans.CatalogoBean;
import beans.moduloBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class catalogoMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		CatalogoBean mod = new CatalogoBean();

		
                mod.setID_OPCION(rs.getString("ID_OPCION").trim());
                mod.setVALOR(rs.getString("VALOR").trim());
                mod.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());
       
		return mod;
	}
	
    
    
}
