/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.progApoyoBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class progApoyoMapper implements Mapper{
    
    
    public Object mapRow(ResultSet rs) throws SQLException {
		progApoyoBean mod = new progApoyoBean();

		
               
                
                
               
                
               
                mod.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
               
                mod.setNOMBRE_PROGRAMA(rs.getString("NOMBRE_PROGRAMA").trim());
              
                
                mod.setTIPO_PROGRAMA(rs.getString("TIPO_PROGRAMA").trim());
               
               
       
		return mod;
	}
	
    
    
    
    
}
