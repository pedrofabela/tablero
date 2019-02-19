
package daos;

import java.sql.*;
import java.util.List;

import beans.usuarioBean;
import java.util.ArrayList;
import mappers.moduloAuxMapper;
import mappers.moduloMapper;

import mappers.usuarioMapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;
 
 
public class AccesoUsarioDAOImpl extends OracleDAOFactory implements AccesoUsarioDAO {

		OracleDAOFactory oraDaoFac = new OracleDAOFactory();
   
    	//buscando los datos del USUARIO 
	 public usuarioBean consultaAcceso(String cveUsuario, String pswUsuario) throws Exception{
    		
    		String query=  " select NAMEUSUARIO, PASSWORD, PERFIL, NAMEPERFIL, USUARIO, PUESTO " +
                           " from " + Constantes.TablaUsuarios + " where usuario = '" + cveUsuario +"' AND PASSWORD = '" + pswUsuario + "'"; 
    		 Constantes.enviaMensajeConsola(" query consulta usuario--> "+query);	
    		 usuarioBean usu = (usuarioBean) oraDaoFac.queryForObject(query, new usuarioMapper());
       	    return usu;
       	}     
    
   
    public List consultaModulosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception{
    	 String query = "SELECT MP.CVEMODULO,NAMEMOD,ACTION,MODPADRE,IMAGEN FROM " + Constantes.TablaModulosPerfiles + " MP "
         + " LEFT OUTER JOIN " + Constantes.TablaModulos + " M ON MP.CVEMODULO=M.CVEMODULO "
         + " WHERE PERFIL='" + cvePer + "' ORDER BY ORDEN";
		 System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
		 List list = null;
		 list = queryForList(query, new moduloMapper());
		 return list;
    }
    
    
    public List consultaModulosHijosPerfilMenu(Integer cvePer, String cvemodpadre) throws Exception{
    	 String query = "SELECT MP.CVEMODULO,NAMEMOD,ACTION,MODPADRE FROM " + Constantes.TablaModulosPerfiles + " MP "
         + " LEFT OUTER JOIN " + Constantes.TablaModulos + " M ON MP.CVEMODULO=M.CVEMODULO "
         + " WHERE PERFIL='" + cvePer + "' ORDER BY ORDEN";
		 System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
		 List list = null;
		 list = queryForList(query, new moduloAuxMapper());
		 return list;
    }
    
     public boolean logEntrada(usuarioBean usr) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        
         System.out.println("llegue a guardar log");
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("USUARIO", "STRING",usr.getUSUARIO());
        arregloCampos.add(temporal);
       temporal = new ObjPrepareStatement("NOMUSUARIO", "STRING",usr.getNAMEUSUARIO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_INGRESO", "STRING",usr.getFECHA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ACCION", "STRING","LOGIN");
        arregloCampos.add(temporal);

        return oraDaoFac.queryInsert("LOG_TABLERO", arregloCampos);
    }
   
}