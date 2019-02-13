/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.serviciosLineaBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class serlineaConsultaMapper implements Mapper{
    
    
    public Object mapRow(ResultSet rs) throws SQLException {
		serviciosLineaBean mod = new serviciosLineaBean();

   

                 if (rs.getString("ACRONIMO") != null) {
            mod.setACRONIMO(rs.getString("ACRONIMO").trim());
        } else {
            mod.setACRONIMO(rs.getString("ACRONIMO"));
        }
                
                 
                 if (rs.getString("NOMBRE_SISTEMA") != null) {
            mod.setNOMBRE_SISTEMA(rs.getString("NOMBRE_SISTEMA").trim());
        } else {
            mod.setNOMBRE_SISTEMA(rs.getString("NOMBRE_SISTEMA"));
        }
                
                    if (rs.getString("VIGENCIA") != null) {
            mod.setVIGENCIA(rs.getString("VIGENCIA").trim());
        } else {
            mod.setVIGENCIA(rs.getString("VIGENCIA"));
        }
        
                    if (rs.getString("STATUS") != null) {
            mod.setSTATUS(rs.getString("STATUS").trim());
        } else {
            mod.setSTATUS(rs.getString("STATUS"));
        }    
                      if (rs.getString("NOTA") != null) {
            mod.setNOTA(rs.getString("NOTA").trim());
        } else {
            mod.setNOTA(rs.getString("NOTA"));
        }    
                      
                       if (rs.getString("OBJETIVO") != null) {
            mod.setOBJETIVO(rs.getString("OBJETIVO").trim());
        } else {
            mod.setOBJETIVO(rs.getString("OBJETIVO"));
        }    
                         if (rs.getString("VER_MAS") != null) {
            mod.setVER_MAS(rs.getString("VER_MAS").trim());
        } else {
            mod.setVER_MAS(rs.getString("VER_MAS"));
        }    
                       
                        if (rs.getString("ALCANCE") != null) {
            mod.setALCANCE(rs.getString("ALCANCE").trim());
        } else {
            mod.setALCANCE(rs.getString("ALCANCE"));
        }    
                        
                           if (rs.getString("USUARIOS") != null) {
            mod.setUSUARIOS(rs.getString("USUARIOS").trim());
        } else {
            mod.setUSUARIOS(rs.getString("USUARIOS"));
        }    
                           
                           if (rs.getString("URL_SISTEMA") != null) {
            mod.setURL_SISTEMA(rs.getString("URL_SISTEMA").trim());
        } else {
            mod.setURL_SISTEMA(rs.getString("URL_SISTEMA"));
        }    
                           
                              
                           if (rs.getString("ID_APLICACION") != null) {
            mod.setID_APLICACION(rs.getString("ID_APLICACION").trim());
        } else {
            mod.setID_APLICACION(rs.getString("ID_APLICACION"));
        }    
        
                           
                                 
                           if (rs.getString("FECHA_INICIO") != null) {
            mod.setFECHA_INICIO(rs.getString("FECHA_INICIO").trim());
        } else {
            mod.setFECHA_INICIO(rs.getString("FECHA_INICIO"));
        }    
                           
                            if (rs.getString("FECHA_TERMINO") != null) {
            mod.setFECHA_TERMINO(rs.getString("FECHA_TERMINO").trim());
        } else {
            mod.setFECHA_TERMINO(rs.getString("FECHA_TERMINO"));
        }  
                            
               if (rs.getString("PAG_INICIO") != null) {
            mod.setPAG_INICIO(rs.getString("PAG_INICIO").trim());
        } else {
            mod.setPAG_INICIO(rs.getString("PAG_INICIO"));
        }                   
        
                   if (rs.getString("PRIORIDAD") != null) {
            mod.setPRIORIDAD(rs.getString("PRIORIDAD").trim());
        } else {
            mod.setPRIORIDAD(rs.getString("PRIORIDAD"));
        }        
                            
               if (rs.getString("IMPACTO_SOCIEDAD") != null) {
            mod.setIMPACTO_SOCIEDAD(rs.getString("IMPACTO_SOCIEDAD").trim());
        } else {
            mod.setIMPACTO_SOCIEDAD(rs.getString("IMPACTO_SOCIEDAD"));
        }        
         
                 if (rs.getString("PORCENTAJE_AVANCE") != null) {
            mod.setPORCENTAJE_AVANCE(rs.getString("PORCENTAJE_AVANCE").trim());
        } else {
            mod.setPORCENTAJE_AVANCE(rs.getString("PORCENTAJE_AVANCE"));
        }    
                 
                  if (rs.getString("ENTRADA_DIRECTA") != null) {
            mod.setENTRADA_DIRECTA(rs.getString("ENTRADA_DIRECTA").trim());
        } else {
            mod.setENTRADA_DIRECTA(rs.getString("ENTRADA_DIRECTA"));
        }      
                  
                    if (rs.getString("SITIOS_INTERNET") != null) {
            mod.setSITIOS_INTERNET(rs.getString("SITIOS_INTERNET").trim());
        } else {
            mod.setSITIOS_INTERNET(rs.getString("SITIOS_INTERNET"));
        }        
               
                     if (rs.getString("MOTORES_BUSQUEDA") != null) {
            mod.setMOTORES_BUSQUEDA(rs.getString("MOTORES_BUSQUEDA").trim());
        } else {
            mod.setMOTORES_BUSQUEDA(rs.getString("MOTORES_BUSQUEDA"));
        }        
                     
                        if (rs.getString("TIPO_TEL") != null) {
            mod.setTIPO_TEL(rs.getString("TIPO_TEL").trim());
        } else {
            mod.setTIPO_TEL(rs.getString("TIPO_TEL"));
        }        
                if (rs.getString("TIPO_TABLETA") != null) {
            mod.setTIPO_TABLETA(rs.getString("TIPO_TABLETA").trim());
        } else {
            mod.setTIPO_TABLETA(rs.getString("TIPO_TABLETA"));
        }        
                
                  if (rs.getString("TIPO_ESCRITORIO") != null) {
            mod.setTIPO_ESCRITORIO(rs.getString("TIPO_ESCRITORIO").trim());
        } else {
            mod.setTIPO_ESCRITORIO(rs.getString("TIPO_ESCRITORIO"));
        }        
            
                  if (rs.getString("TIPO_OTROS") != null) {
            mod.setTIPO_OTROS(rs.getString("TIPO_OTROS").trim());
        } else {
            mod.setTIPO_OTROS(rs.getString("TIPO_OTROS"));
        }              
                  
                  
                  
                  
		return mod;
	}
    
    
}
