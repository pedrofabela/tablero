/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.RegioBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class regioGrafNivMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		RegioBean reg = new RegioBean();

                 reg.setCVENIV(rs.getString("CVENIV").trim());
                 reg.setNOMNIV(rs.getString("NOMNIV").trim());
                 reg.setTOTALNIV(rs.getString("TOTALNIV").trim());
                 
       
		return reg;
	}
    
    
}
