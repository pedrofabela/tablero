package utilidades;

import java.io.Serializable;

public class Constantes implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;
	
     //GENERALES
	 public static final String tablaDual="dual";
	 public static final String nombreSistema = "SEGESCN";
	 public static String usuarioseg= "SEGESCN";
	 public static final String modulo0 = "0";
	 public static final String moduloSegEsc = "segesc";

	 
	 //JOVENES CON VALOR
     //TABLAS
	 public static final String TablaUsuarios="TBL_USUARIOS";
	 public static final String TablaModulosPerfiles="TBL_MODULOSPERFILES";
	 public static final String TablaModulos="TBL_MODULOS";
	 public static final String catJoven= "CATALOGOSERVICIO";
	 
		/*//**************DESARROLLO**********************************************************
	
		public static final boolean esDesarrollo = true;
		public static final String rutaProyectos = "";	
		public static final String rutareportesjasper = "C:/Soft Stif/JASPERS/tablero/";		                                                  
		public static final String rutaArch = "C:/archivosB/";  //cambiar cuando els ervidor este activo
		public static final String rutaEstilos = "http://aplicaciones.edugem.gob.mx/estilosUDAI/";	
		public static final String rutaManuales = "";
		public static final String rutaImages ="C:/Users/Giovani/Desktop/imagenes Tablero/";		
		//*/
		
	 
		//******************* PRODUCCION*******************************************************
      
		public static final boolean esDesarrollo = false;		
		public static final String rutaProyectos =   "http://aplicaciones.edugem.gob.mx/";
		public static final String rutareportesjasper = "/apachetomcat/reportes/Tablero/";		                                                  
		public static final String rutaArch = "/apachetomcat/webapps/documentos/Tablero/";  				
		public static final String rutaEstilos = "http://aplicaciones.edugem.gob.mx/estilosUDAI/";		                                        
		public static final String rutaImages = "/apachetomcat/reportes/imagenes/Tablero/";
		public static final String rutaManuales = "http://aplicaciones.edugem.gob.mx/manuales/ManualUsuario3P.pdf";		
		//*/
	  
	  

	  public static void enviaMensajeConsola(String cadena){
			if(Constantes.esDesarrollo){
				System.out.println("MENSAJE_DESARROLLO: "+cadena);
			}
		}
} 

