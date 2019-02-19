/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;
import beans.mapaBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class mapaMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
		mapaBean mod = new mapaBean();

		
                mod.setCLAVE(rs.getString("CLAVE").trim());
                mod.setLATITUD(rs.getString("LATITUD").trim());
                mod.setLONGITUD(rs.getString("LONGITUD").trim());
                 mod.setNOMBRE(rs.getString("NOMBRE").trim());
                 mod.setCVE_NIVEDU(rs.getString("CVE_NIVEDU").trim());
                 mod.setDOMICILIO(rs.getString("DOMICILIO").trim());
                 mod.setFILTRO_PARA_TABLERO(rs.getString("FILTRO_PARA_TABLERO").trim());
                 mod.setMATRICULA(rs.getString("MATRICULA").trim());
                  mod.setLOCALIDAD(rs.getString("LOCALIDAD").trim());
                 
                 
                 
                 
		return mod;
	}
}
