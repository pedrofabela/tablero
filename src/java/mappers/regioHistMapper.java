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
public class regioHistMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
		RegioBean reg = new RegioBean();

                 reg.setIDPROGRAMA(rs.getString("IDPROGRAMA").trim());
                 reg.setDESCRIPCION_PROGRAMA(rs.getString("DESCRIPCION_PROGRAMA").trim());
                 reg.setID_CLASEPROG(rs.getString("ID_CLASEPROG").trim());
                 reg.setCLASIFICACION_PROGRAMA(rs.getString("CLASIFICACION_PROGRAMA").trim());
                 reg.setCICLO_PROGRAMA(rs.getString("CICLO_PROGRAMA").trim());
                 reg.setIDREGION(rs.getString("IDREGION").trim());
                 reg.setCLAVE_MUNICIPIO(rs.getString("CLAVE_MUNICIPIO").trim());
                 reg.setNO_ESCUELAS(rs.getString("NO_ESCUELAS").trim());
                 
                 reg.setAREA_EJECUTORA(rs.getString("AREA_EJECUTORA").trim());
                 reg.setRECURSOS(rs.getString("RECURSOS").trim());
                 
       
		return reg;
	}
    
}
