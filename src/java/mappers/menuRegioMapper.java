/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;
import beans.RegioBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class menuRegioMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
		RegioBean reg = new RegioBean();

		
                reg.setIDREGION(rs.getString("IDREGION").trim());
                 reg.setNOMREGION(rs.getString("NOMREGION").trim());
                
       
		return reg;
	}
    
    
}
