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
public class regioMunMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
		RegioBean reg = new RegioBean();

                 reg.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
                 reg.setCLAVE_MUNICIPIO(rs.getString("CLAVE_MUNICIPIO").trim());
                 reg.setNO_ESCUELAS(rs.getString("NO_ESCUELAS").trim());
                 reg.setMATRICULA(rs.getString("MATRICULA").trim());
                 reg.setNO_DOCENTES(rs.getString("NO_DOCENTES").trim());
       
		return reg;
	}
    
    
}
