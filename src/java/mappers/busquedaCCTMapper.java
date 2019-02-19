/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.CatalogoBean;
import beans.busquedaCCTBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class busquedaCCTMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        busquedaCCTBean cat = new     busquedaCCTBean();


              
        
        if (rs.getString("CCT") != null) {
            cat.setCCT(rs.getString("CCT").trim());
        } else {
            cat.setCCT(rs.getString("CCT"));
        }
        
         if (rs.getString("NOMBRE_ESCUELA") != null) {
            cat.setNOMBRE_ESCUELA(rs.getString("NOMBRE_ESCUELA").trim());
        } else {
            cat.setNOMBRE_ESCUELA(rs.getString("NOMBRE_ESCUELA"));
        }
         
          if (rs.getString("DOMICILIO") != null) {
            cat.setDOMICILIO(rs.getString("DOMICILIO").trim());
        } else {
            cat.setDOMICILIO(rs.getString("DOMICILIO"));
        }
          
           if (rs.getString("MUNICIPIO") != null) {
            cat.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
        } else {
            cat.setMUNICIPIO(rs.getString("MUNICIPIO"));
        }
         
         
          if (rs.getString("CLAVE_MUNICIPIO") != null) {
            cat.setCLAVE_MUNICIPIO(rs.getString("CLAVE_MUNICIPIO").trim());
        } else {
            cat.setCLAVE_MUNICIPIO(rs.getString("CLAVE_MUNICIPIO"));
        }
         
           if (rs.getString("NIVEL") != null) {
            cat.setNIVEL(rs.getString("NIVEL").trim());
        } else {
            cat.setNIVEL(rs.getString("NIVEL"));
        }
        
           
            if (rs.getString("VERTIENTE") != null) {
            cat.setVERTIENTE(rs.getString("VERTIENTE").trim());
        } else {
            cat.setVERTIENTE(rs.getString("VERTIENTE"));
        }
         
           if (rs.getString("MATRICULA") != null) {
            cat.setMATRICULA(rs.getString("MATRICULA").trim());
        } else {
            cat.setMATRICULA(rs.getString("MATRICULA"));
        }  
            
          if (rs.getString("REGION") != null) {
            cat.setREGION(rs.getString("REGION").trim());
        } else {
            cat.setREGION(rs.getString("REGION"));
        }
           if (rs.getString("LATITUD") != null) {
            cat.setLATITUD(rs.getString("LATITUD").trim());
        } else {
            cat.setLATITUD(rs.getString("LATITUD"));
        }
           
            if (rs.getString("LONGITUD") != null) {
            cat.setLONGITUD(rs.getString("LONGITUD").trim());
        } else {
            cat.setLONGITUD(rs.getString("LONGITUD"));
        }
            
             if (rs.getString("NO_DOCENTES") != null) {
            cat.setNO_DOCENTES(rs.getString("NO_DOCENTES").trim());
        } else {
            cat.setNO_DOCENTES(rs.getString("NO_DOCENTES"));
        }
             
              if (rs.getString("IDREGION") != null) {
            cat.setIDREGION(rs.getString("IDREGION").trim());
        } else {
            cat.setIDREGION(rs.getString("IDREGION"));
        }
              
                  if (rs.getString("LOCALIDAD") != null) {
            cat.setLOCALIDAD(rs.getString("LOCALIDAD").trim());
        } else {
            cat.setLOCALIDAD(rs.getString("LOCALIDAD"));
        }
                  
                   if (rs.getString("TURNO") != null) {
            cat.setTURNO(rs.getString("TURNO").trim());
        } else {
            cat.setTURNO(rs.getString("TURNO"));
        }
        
        return cat;
    }
}
