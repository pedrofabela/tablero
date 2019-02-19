/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.DescripcionProgBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class DescripcionProgMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        DescripcionProgBean cat = new    DescripcionProgBean();


              







        
        if (rs.getString("ID_PROGRAMA") != null) {
            cat.setID_PROGRAMA(rs.getString("ID_PROGRAMA").trim());
        } else {
            cat.setID_PROGRAMA(rs.getString("ID_PROGRAMA"));
        }
        
         if (rs.getString("OBJETIVO") != null) {
            cat.setOBJETIVO(rs.getString("OBJETIVO").trim());
        } else {
            cat.setOBJETIVO(rs.getString("OBJETIVO"));
        }
        
        if (rs.getString("ALCANCE") != null) {
            cat.setALCANCE(rs.getString("ALCANCE").trim());
        } else {
            cat.setALCANCE(rs.getString("ALCANCE"));
        }
        
        if (rs.getString("PERIODO") != null) {
            cat.setPERIODO(rs.getString("PERIODO").trim());
        } else {
            cat.setPERIODO(rs.getString("PERIODO"));
        }
        
        if (rs.getString("MONTO_APOYO") != null) {
            cat.setMONTO_APOYO(rs.getString("MONTO_APOYO").trim());
        } else {
            cat.setMONTO_APOYO(rs.getString("MONTO_APOYO"));
        }
        
         if (rs.getString("DESCRIPCION_APOYO") != null) {
            cat.setDESCRIPCION_APOYO(rs.getString("DESCRIPCION_APOYO").trim());
        } else {
            cat.setDESCRIPCION_APOYO(rs.getString("DESCRIPCION_APOYO"));
        }
         
         if (rs.getString("NORMATIVIDAD") != null) {
            cat.setNORMATIVIDAD(rs.getString("NORMATIVIDAD").trim());
        } else {
            cat.setNORMATIVIDAD(rs.getString("NORMATIVIDAD"));
        }
         
         if (rs.getString("CICLO_ESCOLAR") != null) {
            cat.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());
        } else {
            cat.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR"));
        }
        
         
          if (rs.getString("LISTA_DOC") != null) {
            cat.setLISTA_DOC(rs.getString("LISTA_DOC").trim());
        } else {
            cat.setLISTA_DOC(rs.getString("LISTA_DOC"));
        }
          
           if (rs.getString("INFO_DOC") != null) {
            cat.setINFO_DOC(rs.getString("INFO_DOC").trim());
        } else {
            cat.setINFO_DOC(rs.getString("INFO_DOC"));
        }
           
            if (rs.getString("REGLAS_DOC") != null) {
            cat.setREGLAS_DOC(rs.getString("REGLAS_DOC").trim());
        } else {
            cat.setREGLAS_DOC(rs.getString("REGLAS_DOC"));
        }
         
         
         
        
        return cat;
    }
    
    
   
    
    
    
    
}
