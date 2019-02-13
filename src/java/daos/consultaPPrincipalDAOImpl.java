/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.CatalogoBean;
import beans.DescripcionProgBean;
import beans.RegioBean;
import beans.busquedaCCTBean;
import beans.progApoyoBean;
import beans.serviciosLineaBean;
import java.util.List;
import mappers.DescripcionProgMapper;
import mappers.ProgTodosCCTMapper;
import mappers.ProgVigentesCCTMapper;
import mappers.busquedaCCTMapper;
import mappers.catMunMapper;
import mappers.catalogoMapper;
import mappers.comEduMapper;
import mappers.escuelasDescripcionMapper;
import mappers.escuelasMunicipioMapper;
import mappers.escuelasNacionalMapper;
import mappers.escuelasNivelMapper;
import mappers.escuelasRegionMapper;
import mappers.imsValidadosMapper;
import mappers.indicadoresHistoriaProgMapper;
import mappers.indicadoresPrincipalMapper;
import mappers.indicadoresProgMapper;
import mappers.mapaMapper;
import mappers.menuRegioMapper;
import mappers.menuSerlineaMapper;
import mappers.mesDiaMapper;
import mappers.mesLineaMapper;
import mappers.moduloMapper;
import mappers.porcentajeAvanceMapper;
import mappers.progApoyoMapper;
import mappers.progNivelMapper;
import mappers.regioGrafNivMapper;
import mappers.regioHistMapper;
import mappers.regioMunMapper;
import mappers.resultadosPlaneaMapper;
import mappers.serlineaAlcanceMapper;
import mappers.serlineaConsultaMapper;
import mappers.serlineaInfografiaAvanceMapper;
import mappers.serlineaInfografiaMapper;
import mappers.serviciosLineaMapper;
import utilidades.Constantes;

/**
 *
 * @author pedro
 */
public class consultaPPrincipalDAOImpl extends OracleDAOFactory implements consultaPPrincipalDao {

    OracleDAOFactory oraDaoFac = new OracleDAOFactory();

    public List consultaBotones() throws Exception {

        String query = "select * from(SELECT ID_OPCION, VALOR FROM Cat Where TIPO<>1 AND Id_Catalogo=100 and ID_OPCION<=5), (Select valor as CICLO_ESCOLAR From Cat WHERE TIPO<>1 AND Id_Catalogo=200) ORDER BY ID_OPCION";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new catalogoMapper());
        return list;

    }
    
     public List ListaServiciosLinea() throws Exception {

        String query = "SELECT CAT.ACRONIMO, CAT.NOMBRE_SISTEMA, CAT.NOTA, TBL.IMPACTO_SOCIEDAD, TBL.PORCENTAJE_AVANCE , CAT.VIGENCIA FROM (SELECT * FROM CAT_SISTEMAS_LINEA)CAT JOIN (SELECT * FROM TBL_INDICADORES_LINEA)TBL ON CAT.ACRONIMO=TBL.ACRONIMO WHERE STATUS='ACTIVO'";
        System.out.println("servicios en linea ---> " + query);
        List list = null;
        list = queryForList(query, new serviciosLineaMapper());
        return list;

    }
      public List ListaMenuSerlinea() throws Exception {

        String query = "SELECT ACRONIMO, NOMBRE_SISTEMA,ID_APLICACION, PRIORIDAD FROM  CAT_SISTEMAS_LINEA WHERE PRIORIDAD=1 ORDER BY NOMBRE_SISTEMA";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new menuSerlineaMapper());
        return list;

    }
      public List ListaMenuSerlineaTodos() throws Exception {

        String query = "SELECT ACRONIMO, NOMBRE_SISTEMA,ID_APLICACION, PRIORIDAD FROM  CAT_SISTEMAS_LINEA WHERE PRIORIDAD<>3 ORDER BY NOMBRE_SISTEMA";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new menuSerlineaMapper());
        return list;

    }
       public List ListaMenuSerlineaPermanente() throws Exception {

        String query = "SELECT ACRONIMO, NOMBRE_SISTEMA,ID_APLICACION, PRIORIDAD FROM  CAT_SISTEMAS_LINEA WHERE PRIORIDAD>1 ORDER BY NOMBRE_SISTEMA";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new menuSerlineaMapper());
        return list;

    }
       
        public List ListaSerlineaConsulta(serviciosLineaBean serlinea) throws Exception {

        String query = "SELECT ACRONIMO, NOMBRE_SISTEMA, VIGENCIA, STATUS, NOTA, OBJETIVO, VER_MAS, ALCANCE, USUARIOS, URL_SISTEMA, ID_APLICACION, FECHA_INICIO,  FECHA_TERMINO,  PAG_INICIO,  PRIORIDAD, IMPACTO_SOCIEDAD, PORCENTAJE_AVANCE, ENTRADA_DIRECTA, SITIOS_INTERNET, MOTORES_BUSQUEDA, TIPO_TEL, TIPO_TABLETA, TIPO_ESCRITORIO, TIPO_OTROS FROM SERLINEA_CONSULTA WHERE ACRONIMO='"+serlinea.getBUSCAR_ACRONIMO()+"'";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new serlineaConsultaMapper());
        return list;

    }
        
         public List ListaMesLinea(serviciosLineaBean serlinea) throws Exception {

        String query = "SELECT DATOS.MES, ME.MES AS MES_LETRA FROM(  SELECT MES FROM (select DISTINCT(SUBSTR(FECHA_ANTERIOR,4,2) ) AS MES from (select DISTINCT(FECHA_ANTERIOR) as FECHA_ANTERIOR from TBL_INDICADORES_LINEA_X_DIA WHERE ACRONIMO='"+serlinea.getBUSCAR_ACRONIMO()+"' AND SUBSTR(FECHA_ANTERIOR,7,2)='"+serlinea.getANO()+"' )  ORDER BY  TO_NUMBER(MES) DESC)  WHERE ROWNUM<=3)DATOS INNER JOIN (SELECT * FROM CAT_MESES)ME ON DATOS.MES=ME.ID_MES";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new mesLineaMapper());
        return list;

    }
           public List infografiaAvance(serviciosLineaBean serlinea) throws Exception {

        String query = ""+serlinea.getCONSULTA_AVANCE()+"";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new serlineaInfografiaAvanceMapper());
        return list;

    }
            public List infografiaAlcance(serviciosLineaBean serlinea) throws Exception {

        String query = ""+serlinea.getCONSULTA_ALCANCE()+"";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new serlineaAlcanceMapper());
        return list;

    }
          public List serlineaInfografia(serviciosLineaBean serlinea) throws Exception {

        String query = "SELECT ACRONIMO, DESCRIPCION, CONSULTA_AVANCE, NOTA_AVANCE, CONSULTA_ALCANCE, NOTA_ALCANCE, TITULO_SEC3, CONSULTA_SEC3MENU, CONSULTA_SEC3GRAF, NOTA_SEC3  FROM TBL_SERLINEA_INFOGRAFIA WHERE ACRONIMO='"+serlinea.getBUSCAR_ACRONIMO()+"'";
        System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List list = null;
        list = queryForList(query, new serlineaInfografiaMapper());
        return list;

    }
          public List ListaMesDia(serviciosLineaBean serlinea) throws Exception {

        String query = "SELECT DATOS.ACRONIMO, DATOS.IMPACTO_DIA, DATOS.FECHA_ANTERIOR, DATOS.MES, ME.MES AS MES_LETRA FROM (SELECT ACRONIMO, (IMPACTO_ACTUAL-IMPACTO_ANTERIOR) AS IMPACTO_DIA , FECHA_ANTERIOR, SUBSTR(FECHA_ANTERIOR,4,2) AS MES FROM TBL_INDICADORES_LINEA_X_DIA WHERE ACRONIMO='"+serlinea.getBUSCAR_ACRONIMO()+"'AND SUBSTR(FECHA_ANTERIOR,4,2)='"+serlinea.getMES_CONSULTA()+"' AND SUBSTR(FECHA_ANTERIOR,7,2)='"+serlinea.getANO()+"')DATOS INNER JOIN (SELECT * FROM CAT_MESES)ME ON DATOS.MES=ME.ID_MES ORDER BY TO_DATE(FECHA_ANTERIOR) ASC";
        System.out.println("QueryConsulta historico por dia---> " + query);
        List list = null;
        list = queryForList(query, new mesDiaMapper());
        return list;

    }
      public List ListaServiciosLineaPorcentaje(String porcentaje) throws Exception {

        String query = ""+porcentaje+"";
        //System.out.println("QueryConsultaSubModulosPerfil ---> " + query);
        List    list = null;
        list = queryForList(query, new porcentajeAvanceMapper());
        return list;

    }

    public List mapa(CatalogoBean cat) throws Exception {

        String query = "SELECT CLAVE, TRANSLATE(NOMBRE,   'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS NOMBRE, LATITUD, LONGITUD, CVE_NIVEDU, TRANSLATE(DOMICILIO, 'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS DOMICILIO, TRANSLATE(LOCALIDAD,   'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ',   'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS LOCALIDAD, FILTRO_PARA_TABLERO, MATRICULA  FROM CAT_CCTS WHERE TO_CHAR(CVE_NIVEDU)='" + cat.getOPCION() + "' AND LATITUD IS NOT NULL AND LONGITUD IS NOT NULL AND LENGTH(LONGITUD)<=11 AND LENGTH(LATITUD)<=11 AND IDREGION=17";
        System.out.println("Query DE MAPA ---> " + query);
        List list = null;
        list = queryForList(query, new mapaMapper());
        return list;

    }

    public List mapaMun(CatalogoBean cat) throws Exception {

        String query = "SELECT CLAVE, TRANSLATE(NOMBRE,   'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS NOMBRE, LATITUD, LONGITUD, CVE_NIVEDU, TRANSLATE(DOMICILIO, 'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS DOMICILIO, TRANSLATE(LOCALIDAD,   'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ',   'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS LOCALIDAD, FILTRO_PARA_TABLERO, MATRICULA  FROM CAT_CCTS WHERE TO_CHAR(CVE_NIVEDU)='" + cat.getOPCION() + "' AND LATITUD IS NOT NULL AND LONGITUD IS NOT NULL AND LENGTH(LONGITUD)<=11 AND LENGTH(LATITUD)<=11 AND CLAVE_MUNICIPIO='" + cat.getCLAVE_MUNICIPIO() + "'";
        System.out.println("Query DE MAPA ---> " + query);
        List list = null;
        list = queryForList(query, new mapaMapper());
        return list;

    }

    public List mapaMunTodos(CatalogoBean cat) throws Exception {

        String query = "SELECT CLAVE, TRANSLATE(NOMBRE,   'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS NOMBRE, LATITUD, LONGITUD, CVE_NIVEDU, TRANSLATE(DOMICILIO, 'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS DOMICILIO, TRANSLATE(LOCALIDAD,   'áéíóúàèìòùãõâêîôôäëïöüçñÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ',   'aeiouaeiouaoaeiooaeioucnNAEIOUAEIOUAOAEIOOAEIOUC') AS LOCALIDAD, FILTRO_PARA_TABLERO, MATRICULA FROM CAT_CCTS WHERE TO_CHAR(CVE_NIVEDU)<=5 AND TO_CHAR(CVE_NIVEDU)>=1  AND LATITUD IS NOT NULL AND LONGITUD IS NOT NULL AND LENGTH(LONGITUD)<=11 AND LENGTH(LATITUD)<=11 AND CLAVE_MUNICIPIO='" + cat.getCLAVE_MUNICIPIO() + "'";
        System.out.println("Query DE MAPA ---> " + query);
        List list = null;
        list = queryForList(query, new mapaMapper());
        return list;

    }

    public List mapaCatMun(CatalogoBean cat) throws Exception {

        String query = "SELECT CLAVE AS CLAVE_MUNICIPIO, MUNICIPIO FROM CAT_REGION_MUN ORDER BY MUNICIPIO  ";
        System.out.println("Query MUNICIPIOS DE MAPA ---> " + query);
        List list = null;
        list = queryForList(query, new catMunMapper());
        return list;

    }

    public List mapaTodos(CatalogoBean cat) throws Exception {

        String query = "SELECT CLAVE, NOMBRE, LATITUD, LONGITUD, CVE_NIVEDU, DOMICILIO, LOCALIDAD, FILTRO_PARA_TABLERO, MATRICULA  FROM CAT_CCTS WHERE  LATITUD IS NOT NULL AND LONGITUD IS NOT NULL AND LENGTH(LONGITUD)<=11 AND LENGTH(LATITUD)<=11 AND CLAVE_MUNICIPIO=106  ";
        System.out.println("Query DE MAPA ---> " + query);
        List list = null;
        list = queryForList(query, new mapaMapper());
        return list;

    }

    public List consultageneralcom(CatalogoBean cat) throws Exception {

        String query = "SELECT ID,    CVENIV, NOMNIV, TO_CHAR(MATRIALU, '99G999G999') AS MATRIALU, TO_CHAR(MATRIDOCEN, '99G999G999') AS MATRIDOCEN, TO_CHAR(NOESC, '99G999G999') AS NOESC, TIPOMTRIC, FUENTE2 as FUENTE, TO_CHAR(ESCPUB, '99G999G999') AS ESCPUB, TO_CHAR(ESCPRIV, '99G999G999') AS ESCPRIV, CICLO_ESCOLAR   FROM (SELECT  SUM(Matrialu) AS MATRIALU, SUM(MATRIDOCEN) AS MATRIDOCEN, SUM(NOESC) AS NOESC , SUM(ESCPUB) AS ESCPUB , SUM(ESCPRIV) AS ESCPRIV FROM Comunidad_Educativa WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "'),(Select ID, CVENIV, NOMNIV, TIPOMTRIC, FUENTE, CICLO_ESCOLAR, FUENTE2 From Datos_Generales WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "')";
        //System.out.println("QueryConsultaGeneral ---> " + query);
        List list = null;
        list = queryForList(query, new comEduMapper());
        return list;

    }

    public List busquedaCCT(busquedaCCTBean buscarCCT) throws Exception {

        String query = " SELECT CLAVE AS CCT, NOMBRE AS NOMBRE_ESCUELA, DOMICILIO, MUNICIPIO, CLAVE_MUNICIPIO, NIVEL, VERTIENTE, MATRICULA,REGIÓN AS REGION , LATITUD, LONGITUD, NO_DOCENTES, IDREGION, LOCALIDAD, TURNO_1 AS TURNO  FROM CAT_CCTS WHERE CLAVE='" + buscarCCT.getBUSCAR_CCT() + "' AND Rownum <=1";
        //System.out.println("QueryConsultaGeneral ---> " + query);
        List list = null;
        list = queryForList(query, new busquedaCCTMapper());
        return list;

    }

    public List ProgVigentesEECct(busquedaCCTBean buscarCCT) throws Exception {

        String query = "SELECT DISTINCT IDPROGRAMA,CP.DESCRIPCION_PROGRAMA FROM PROGRAMASB.TBL_ESCUELAS_PROGRAMAS_BASICA PB INNER JOIN CAT_PROGRAMAS CP ON CP.ACRONIMO=PB.IDPROGRAMA "
                + "WHERE PB.CLACET='"+buscarCCT.getBUSCAR_CCT()+"' AND PB.CICLO_ESCOLAR='"+buscarCCT.getCICLOAUX()+"' AND CP.ID_CLASEPROG='3'";
        System.out.println("VigentesEECct ---> " + query);
        List list = null;
        list = queryForList(query, new ProgVigentesCCTMapper());
        return list;

    }
    public List ProgTodosEECct(busquedaCCTBean buscarCCT) throws Exception {

        String query = "SELECT ESC.CLACET AS CCT, ESC.IDPROGRAMA, UPPER(ESC.CONCEPTO) AS CONCEPTO, UPPER(CAT.DESCRIPCION_PROGRAMA) AS DESC_PROG,  ESC.CICLO_ESCOLAR AS CICLOESCOLAR,  ESC.MONTO FROM (SELECT CLACET, IDPROGRAMA, CICLO_ESCOLAR, CONCEPTO, MONTO FROM  PROGRAMASB.TBL_ESCUELAS_PROGRAMAS_BASICA WHERE CLACET='"+buscarCCT.getBUSCAR_CCT()+"' )ESC INNER JOIN (SELECT ACRONIMO, ID_CLASEPROG, DESCRIPCION_PROGRAMA, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS WHERE ID_CLASEPROG='3')CAT ON  ESC.IDPROGRAMA=CAT.ACRONIMO   ORDER BY CICLO_ESCOLAR DESC ";
        System.out.println("VigentesEECct ---> " + query);
        List list = null;
        list = queryForList(query, new ProgTodosCCTMapper());
        return list;

    }
    
     public List resultadosPlanea(busquedaCCTBean buscarCCT) throws Exception {

        String query = "SELECT CICLO_ESCOLAR, LC_I, LC_II, LC_III, LC_IV, M_I, M_II, M_III, M_IV , '' AS MAYOR,'' AS MAYOR_M FROM TBL_PLANEA_GENERAL WHERE CCT='"+buscarCCT.getBUSCAR_CCT()+"'  AND  ROWNUM<=2 ORDER BY CICLO_ESCOLAR DESC";
        System.out.println("VigentesEECct ---> " + query);
        List list = null;
        list = queryForList(query, new resultadosPlaneaMapper());
        return list;

    }
    
    public List ProgVigentesMECct(busquedaCCTBean buscarCCT) throws Exception {

        String query = "SELECT DISTINCT IDPROGRAMA,CP.DESCRIPCION_PROGRAMA  FROM PROGRAMASB.TBL_ESCUELAS_PROGRAMAS_BASICA PB INNER JOIN CAT_PROGRAMAS CP ON CP.ACRONIMO=PB.IDPROGRAMA "
                + "WHERE PB.CLACET='"+buscarCCT.getBUSCAR_CCT()+"' AND PB.CICLO_ESCOLAR='"+buscarCCT.getCICLOAUX()+"' AND CP.ID_CLASEPROG='2'";
        System.out.println("VigentesMECct ---> " + query);
        List list = null;
        list = queryForList(query, new ProgVigentesCCTMapper());
        return list;

    }
     public List ProgTodosMECct(busquedaCCTBean buscarCCT) throws Exception {

        String query = "SELECT ESC.CLACET AS CCT, ESC.IDPROGRAMA, UPPER(ESC.CONCEPTO) AS CONCEPTO, UPPER(CAT.DESCRIPCION_PROGRAMA) AS DESC_PROG,  ESC.CICLO_ESCOLAR AS CICLOESCOLAR,  ESC.MONTO FROM (SELECT CLACET, IDPROGRAMA, CICLO_ESCOLAR, CONCEPTO, MONTO FROM  PROGRAMASB.TBL_ESCUELAS_PROGRAMAS_BASICA WHERE CLACET='"+buscarCCT.getBUSCAR_CCT()+"' )ESC INNER JOIN (SELECT ACRONIMO, ID_CLASEPROG, DESCRIPCION_PROGRAMA, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS WHERE ID_CLASEPROG='2')CAT ON  ESC.IDPROGRAMA=CAT.ACRONIMO   ORDER BY CICLO_ESCOLAR DESC ";
        System.out.println("VigentesMECct ---> " + query);
        List list = null;
        list = queryForList(query, new ProgTodosCCTMapper());
        return list;

    }
    
    public List ProgVigentesIFCct(busquedaCCTBean buscarCCT) throws Exception {

        String query = "SELECT DISTINCT IDPROGRAMA,CP.DESCRIPCION_PROGRAMA  FROM PROGRAMASB.TBL_ESCUELAS_PROGRAMAS_BASICA PB INNER JOIN CAT_PROGRAMAS CP ON CP.ACRONIMO=PB.IDPROGRAMA "
                + "WHERE PB.CLACET='"+buscarCCT.getBUSCAR_CCT()+"' AND PB.CICLO_ESCOLAR='"+buscarCCT.getCICLOAUX()+"' AND CP.ID_CLASEPROG='1'";
        System.out.println("VigentesIFCct ---> " + query);
        List list = null;
        list = queryForList(query, new ProgVigentesCCTMapper());
        return list;

    }

    public List ProgTodosIFCct(busquedaCCTBean buscarCCT) throws Exception {

        String query = "SELECT ESC.CLACET AS CCT, ESC.IDPROGRAMA, UPPER(ESC.CONCEPTO) AS CONCEPTO, CAT.DESCRIPCION_PROGRAMA AS DESC_PROG,  ESC.CICLO_ESCOLAR AS CICLOESCOLAR, ESC.MONTO FROM (SELECT CLACET, IDPROGRAMA, CICLO_ESCOLAR, CONCEPTO, MONTO FROM  PROGRAMASB.TBL_ESCUELAS_PROGRAMAS_BASICA WHERE CLACET='"+buscarCCT.getBUSCAR_CCT()+"' )ESC INNER JOIN (SELECT ACRONIMO, ID_CLASEPROG, DESCRIPCION_PROGRAMA, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS WHERE ID_CLASEPROG='1')CAT ON  ESC.IDPROGRAMA=CAT.ACRONIMO   ORDER BY CICLO_ESCOLAR DESC ";
        System.out.println("VigentesIFCct ---> " + query);
        List list = null;
        list = queryForList(query, new ProgTodosCCTMapper());
        return list;

    }
    
    public List progApoyoMenu(CatalogoBean cat) throws Exception {

        String query = "SELECT  PROGVIGENTE.ACRONIMO AS ID_PROGRAMA, PROGVIGENTE.DESCRIPCION_PROGRAMA AS NOMBRE_PROGRAMA, PROGVIGENTE.TIPOPROGRAMA AS TIPO_PROGRAMA FROM ( SELECT CAT.ACRONIMO, CAT.CVENIVEL, PROG.DESCRIPCION_PROGRAMA, PROG.TIPOPROGRAMA FROM ( SELECT ACRONIMO, NIVEL, CVENIVEL FROM TBL_NIVELES_PARA_PROG WHERE CVENIVEL='" + cat.getOPCION() + "') CAT JOIN (SELECT ACRONIMO, DESCRIPCION_PROGRAMA, TIPOPROGRAMA FROM CAT_PROGRAMAS) PROG ON  CAT.ACRONIMO=PROG.ACRONIMO WHERE PROG.TIPOPROGRAMA='" + cat.getTIPO_PROGRAMA() + "')PROGVIGENTE LEFT OUTER JOIN (SELECT ID, CVENIV, ID_PROGRAMA, NOMBRE_PROGRAMA, TIPO_PROGRAMA, NO_ESC_PROG, CICLO_ESCOLAR  FROM  PROGYAPOYO WHERE CVENIV='" + cat.getOPCION() + "' AND TIPO_PROGRAMA='" + cat.getTIPO_PROGRAMA() + "' AND CICLO_ESCOLAR='" + cat.getCICLOAUX() + "' ORDER BY NOMBRE_PROGRAMA ASC)PROGNIVEL ON  PROGVIGENTE.ACRONIMO=PROGNIVEL.ID_PROGRAMA ORDER BY NOMBRE_PROGRAMA ASC";
        System.out.println("QueryConsultaApoyoMenu ---> " + query);
        List list = null;
        list = queryForList(query, new progApoyoMapper());
        return list;

    }

    public List progApoyoMenuTodos(CatalogoBean cat) throws Exception {

        String query = "SELECT ACRONIMO AS ID_PROGRAMA, DESCRIPCION_PROGRAMA AS NOMBRE_PROGRAMA, TIPOPROGRAMA AS TIPO_PROGRAMA FROM CAT_PROGRAMAS WHERE TIPOPROGRAMA='" + cat.getTIPO_PROGRAMA() + "' ORDER BY DESCRIPCION_PROGRAMA ASC ";
        System.out.println("QueryConsultaApoyoMenu ---> " + query);
        List list = null;
        list = queryForList(query, new progApoyoMapper());
        return list;

    }

    public String ConsultaCiclo(CatalogoBean cat) throws Exception {

        String query = "SELECT CICLO_ESCOLAR FROM (SELECT * FROM Tbl_Indicadores_Programas WHERE ID_PROGRAMA='" + cat.getID_PROGRAMA() + "' ORDER BY CICLO_ESCOLAR DESC) WHERE ROWNUM=1";
        //System.out.println("QueryConsultaCiclo ---> " + query);
        String ciclo = null;
        ciclo = queryStringUnCampo(query);
        return ciclo;

    }

    public List indicadoresProg(CatalogoBean cat) throws Exception {

        String query = "SELECT * FROM TBL_INDICADORES_PROGRAMAS";
       System.out.println("QueryConsulta indicadores programa---> " + query);
        List list = null;
        list = queryForList(query, new indicadoresProgMapper());
        return list;

    }

    public List indicadoresPrincipal(CatalogoBean cat) throws Exception {

        String query = "SELECT CAT.CVEINDICADOR, NVL(NIV.PORCENTAJE,'N/A') AS PORCENTAJE, NVL( NIV.DIFERENCIA,'0') AS DIFERENCIA FROM (SELECT DISTINCT(CVEINDICADOR) FROM TBL_INDICADORES_GENERALES WHERE ESTATUS=1)CAT LEFT OUTER JOIN (SELECT CVEINDICADOR,  PORCENTAJE,  TO_NUMBER(PORCENTAJE)-TO_NUMBER(MEDIA_NACIONAL) AS DIFERENCIA FROM TBL_INDICADORES_GENERALES WHERE CVENIVEL='" + cat.getOPCION() + "' AND ESTATUS='1')NIV ON CAT.CVEINDICADOR=NIV.CVEINDICADOR";
        System.out.println("QueryConsulta INDICADORES PRINCIPAL DE INDICADORES()()()()()()()()    > " + query);
        List list = null;
        list = queryForList(query, new indicadoresPrincipalMapper());
        return list;

    }
    public List ims(CatalogoBean cat) throws Exception {

        String query = "SELECT TOTAL.TOTAL_ASPIRANTES, VALIDADOS.TOTAL_VALIDADOS, TO_NUMBER(TOTAL.TOTAL_ASPIRANTES)-TO_NUMBER(VALIDADOS.TOTAL_VALIDADOS) AS TOTAL_NOVALIDADOS FROM (SELECT COUNT(*) AS TOTAL_ASPIRANTES FROM PREREGISTRO@ingresoms)TOTAL,(SELECT COUNT(*) AS TOTAL_VALIDADOS FROM PREREGISTRO@ingresoms WHERE INSCRITO=1 OR CERTIFICADO=1)VALIDADOS";
        System.out.println("QueryConsulta INDICADORES IMS??????????????????    > " + query);
        List list = null;
        list = queryForList(query, new imsValidadosMapper());
        return list;

    }

    public List indicadoresHistoriaProg(CatalogoBean cat) throws Exception {

        String query = "SELECT ID_PROGRAMA, NO_ALUMNOS, NO_ESCUELAS, INVERSION, CICLO_ESCOLAR, COLOR AS ID_COLOR, NO_MUNIICIPIOS FROM (SELECT * FROM TBL_INDICADORES_PROGRAMAS WHERE ID_PROGRAMA='" + cat.getID_PROGRAMA() + "' ORDER BY CICLO_ESCOLAR) DATOS,( SELECT ID_COD_COLOR, COLOR FROM TBL_COLORES) COLORES WHERE DATOS.ID_COLOR=COLORES.ID_COD_COLOR ";
        //System.out.println("QueryConsulta indicadores HISTORIAL programa---> " + query);
        List list = null;
        list = queryForList(query, new indicadoresHistoriaProgMapper());
        return list;

    }

    public List DescripcionProg(progApoyoBean prog) throws Exception {

        String query = "SELECT * FROM TBL_DESCRIPCION_PROGRAMAS WHERE ID_PROGRAMA='" + prog.getID_PROGRAMA() + "' AND CICLO_ESCOLAR='" + prog.getCICLO_ESCOLAR() + "'";
        //System.out.println("QueryConsulta descripcion programa---> " + query);
        List list = null;
        list = queryForList(query, new DescripcionProgMapper());
        return list;
    }

    public List grafNivelProg(progApoyoBean prog) throws Exception {

        String query = "SELECT ID_PROGRAMA, CVENIVEL, NOMBRE_NIVEL, SUBNIVEL, DATO_ESTATAL, DATO_FEDERALIZADO, DATO_ESTATAL+DATO_FEDERALIZADO AS TOTAL_NIVEL, CICLO_ESCOLAR, COLOR FROM (SELECT * FROM Tbl_Graf_Prog_Nivel WHERE CICLO_ESCOLAR='" + prog.getCICLO_ESCOLAR() + "' AND ID_PROGRAMA='" + prog.getID_PROGRAMA() + "' ORDER BY CVENIVEL) DATOS, (Select * From Tbl_Colores) COLORES WHERE DATOS.ID_COLOR=COLORES.ID_COD_COLOR ";
        System.out.println("QueryConsulta GRAF NIVEL programa---> " + query);
        List list = null;
        list = queryForList(query, new escuelasNivelMapper());
        return list;
    }

    public List grafMunicipioProg(progApoyoBean prog) throws Exception {

        String query = "SELECT ID_PROGRAMA, CVEMUNICIPIO, NOMBRE_MUNICIPIO, TOTAL_MUNICIPIO, CICLO_ESCOLAR FROM TBL_PROG_MUN WHERE CICLO_ESCOLAR='" + prog.getCICLO_ESCOLAR() + "' AND ID_PROGRAMA='" + prog.getID_PROGRAMA() + "' ORDER BY  NOMBRE_MUNICIPIO ASC";
        //System.out.println("QueryConsulta Graf Mun programa---> " + query);
        List list = null;
        list = queryForList(query, new escuelasMunicipioMapper());
        return list;
    }

    public List grafRegionProg(progApoyoBean prog) throws Exception {

        String query = "SELECT ID_PROGRAMA, CVEREGION, NOMBRE_REGION, TOTAL_REGION, CICLO_ESCOLAR, COLOR, NOMBRE_PROGRAMA FROM (SELECT ID_PROGRAMA, CVEREGION, NOMBRE_REGION, TOTAL_REGION, CICLO_ESCOLAR, ID_COLOR, NOMBRE_PROGRAMA FROM  TBL_PROG_REGION WHERE ID_PROGRAMA='" + prog.getID_PROGRAMA() + "' AND CICLO_ESCOLAR='" + prog.getCICLO_ESCOLAR() + "' ORDER BY TO_NUMBER(CVEREGION)) DATOS,(SELECT ID_COD_COLOR, COLOR FROM TBL_COLORES) COLORES WHERE DATOS.ID_COLOR=COLORES.ID_COD_COLOR";
        //System.out.println("QueryConsulta Region programa---> " + query);
        List list = null;
        list = queryForList(query, new escuelasRegionMapper());
        return list;
    }

    public List grafNacionalProg(progApoyoBean prog) throws Exception {

        String query = "SELECT ID_PROGRAMA, NOMBRE_ESTADO, NO_ESCUELAS, COLOR, CVEESTADO FROM (SELECT * FROM TBL_GRAF_NACIONAL WHERE  ID_PROGRAMA='" + prog.getID_PROGRAMA() + "' AND CICLO_ESCOLAR='" + prog.getCICLO_ESCOLAR() + "' ORDER BY TO_NUMBER(NO_ESCUELAS) DESC ) DATOS,(SELECT ID_COD_COLOR, COLOR FROM TBL_COLORES ) COLORES WHERE DATOS.ID_COLOR=COLORES.ID_COD_COLOR";
        //System.out.println("QueryConsulta Nacional programa---> " + query);
        List list = null;
        list = queryForList(query, new escuelasNacionalMapper());
        return list;
    }

    public List descripcionProg(progApoyoBean prog) throws Exception {

        String query = "SELECT Id_Programa, Descripcion_Nivel, Descripcion_Historico, Descripcion_Municipio, Descripcion_Region, Descripcion_Nacional FROM Tbl_Descripcion_Graficas WHERE CICLO_ESCOLAR ='" + prog.getCICLO_ESCOLAR() + "' AND ID_PROGRAMA='" + prog.getID_PROGRAMA() + "'";
        //System.out.println("QueryConsulta descripcionGraficas programa---> " + query);
        List list = null;
        list = queryForList(query, new escuelasDescripcionMapper());
        return list;
    }

    public List progApoyoInicial(CatalogoBean cat) throws Exception {

        String query = "SELECT ID, CVENIV, ID_PROGRAMA, NOMBRE_PROGRAMA, TIPO_PROGRAMA, NO_ESC_PROG, CICLO_ESCOLAR, NVL(NO_ALUMNOS,'0') AS NO_ALUMNOS, NVL(MUNICIPIOS,'0') AS MUNICIPIOS, NVL(INVERSION,'0') AS INVERSION, NVL(NO_ESC_BASICA, '0') AS NO_ESC_BASICA, NVL(NO_ESC_SEIEM,'0') AS NO_ESC_SEIEM  FROM  PROGYAPOYO WHERE CVENIV='" + cat.getOPCION() + "' AND TIPO_PROGRAMA='" + cat.getTIPO_PROGRAMA() + "' AND CICLO_ESCOLAR='" + cat.getCICLOAUX() + "'";
        //System.out.println("QueryConsultaProgApoyoInicial ---> " + query);
        List list = null;
        list = queryForList(query, new progApoyoMapper());
        return list;

    }

    public List menuRegio(RegioBean regioB) throws Exception {

        String query = "SELECT IDREGION, NOMREGION FROM CAT_REGIONES ORDER BY TO_NUMBER(IDREGION) ASC";
        //System.out.println("QueryConsultaProgApoyoInicial ---> " + query);
        List list = null;
        list = queryForList(query, new menuRegioMapper());
        return list;

    }

    public List regioMun(RegioBean regioB) throws Exception {

        String query = "SELECT CLAVE_MUNICIPIO, MUNICIPIO, COUNT(CLAVE)AS NO_ESCUELAS, SUM(NVL(MATRICULA,'0')) AS  MATRICULA, SUM(NVL(NO_DOCENTES,'0')) AS  NO_DOCENTES FROM CAT_CCTS WHERE IDREGION='" + regioB.getIDREGION()+ "' GROUP BY CLAVE_MUNICIPIO,MUNICIPIO ORDER BY MUNICIPIO ";
        //System.out.println("QueryConsultaProgApoyoInicial ---> " + query);
        List list = null;
        list = queryForList(query, new regioMunMapper());
        return list;

    }

    public List regioGrafMun(RegioBean regioB) throws Exception {

        String query = "SELECT CAT.ID_OPCION AS CVENIV, CAT.VALOR AS NOMNIV, TOT.TOTAL_NIV_MUN AS TOTALNIV FROM (SELECT ID_OPCION, VALOR FROM CAT WHERE ID_CATALOGO='100'AND TIPO=2 AND ID_OPCION>0 ORDER BY ID_OPCION)CAT JOIN  (SELECT TOTAL_NIV_MUN, CVE_NIVEDU FROM(SELECT Clave_Municipio,COUNT(CLAVE) AS TOTAL_NIV_MUN, Cve_Nivedu FROM CAT_CCTS GROUP BY CLAVE_MUNICIPIO, Cve_Nivedu) WHERE CLAVE_MUNICIPIO='" + regioB.getCLAVE_MUNICIPIO() + "')TOT ON CAT.ID_OPCION=TOT.CVE_NIVEDU ";
        System.out.println("QueryConsultaProgApoyoInicial ---> " + query);
        List list = null;
        list = queryForList(query, new regioGrafNivMapper());
        return list;

    }

    public List regioHistInf(RegioBean regioB) throws Exception {

        String query = "SELECT * FROM (SELECT B1.IDPROGRAMA, B1.DESCRIPCION_PROGRAMA, B1.ID_CLASEPROG, B1.CLASIFICACION_PROGRAMA, B1.CICLO_ESCOLAR AS CICLO_PROGRAMA, B2.NO_REGIÓN AS IDREGION, B1.CLAMUN AS CLAVE_MUNICIPIO, B1.ESCUELAS AS NO_ESCUELAS, B1.AREA_EJECUTORA, B1.MONTO_TOTAL AS RECURSOS  FROM (SELECT * FROM (SELECT T1.CLAMUN, T1.CICLO_ESCOLAR, T1.IDPROGRAMA, T1.ESCUELAS,  T1.AREA_EJECUTORA, T1.MONTO_TOTAL, T2.DESCRIPCION_PROGRAMA, T2.ID_CLASEPROG, T2.CLASIFICACION_PROGRAMA FROM (SELECT  CLAMUN, CICLO_ESCOLAR, IDPROGRAMA, ESCUELAS, NVL(AREA_EJECUTORA,'Sin Información') AS AREA_EJECUTORA, REPLACE( REPLACE (TO_CHAR(TRIM(REPLACE (MONTO_TOTAL,',',''))),'$','' ), ' ','' ) AS MONTO_TOTAL FROM TBL_PROG_MUNICIPIOS)T1 JOIN (SELECT ACRONIMO, DESCRIPCION_PROGRAMA, ID_CLASEPROG, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS) T2 ON  T1.IDPROGRAMA=T2.ACRONIMO))B1 JOIN (SELECT CLAVE, NO_REGIÓN FROM CAT_REGION_MUN) B2  ON  B1.CLAMUN=B2.CLAVE) WHERE CLAVE_MUNICIPIO='" + regioB.getCLAVE_MUNICIPIO() + "' AND TO_CHAR(ID_CLASEPROG)='1' ORDER BY CICLO_PROGRAMA DESC";
        System.out.println("QueryConsultaregioHistInf ---> " + query);
        List list = null;
        list = queryForList(query, new regioHistMapper());
        return list;

    }

    public List regioHistInfCiclo(RegioBean regioB) throws Exception {

        String query = "SELECT * FROM (SELECT B1.IDPROGRAMA, B1.DESCRIPCION_PROGRAMA, B1.ID_CLASEPROG, B1.CLASIFICACION_PROGRAMA, B1.CICLO_ESCOLAR AS CICLO_PROGRAMA, B2.NO_REGIÓN AS IDREGION, B1.CLAMUN AS CLAVE_MUNICIPIO, B1.ESCUELAS AS NO_ESCUELAS, B1.AREA_EJECUTORA, B1.MONTO_TOTAL AS RECURSOS  FROM (SELECT * FROM (SELECT T1.CLAMUN, T1.CICLO_ESCOLAR, T1.IDPROGRAMA, T1.ESCUELAS,  T1.AREA_EJECUTORA, T1.MONTO_TOTAL, T2.DESCRIPCION_PROGRAMA, T2.ID_CLASEPROG, T2.CLASIFICACION_PROGRAMA FROM (SELECT  CLAMUN, CICLO_ESCOLAR, IDPROGRAMA, ESCUELAS, NVL(AREA_EJECUTORA,'Sin Información') AS AREA_EJECUTORA, REPLACE( REPLACE (TO_CHAR(TRIM(REPLACE (MONTO_TOTAL,',',''))),'$','' ), ' ','' ) AS MONTO_TOTAL FROM TBL_PROG_MUNICIPIOS)T1 JOIN (SELECT ACRONIMO, DESCRIPCION_PROGRAMA, ID_CLASEPROG, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS) T2 ON  T1.IDPROGRAMA=T2.ACRONIMO))B1 JOIN (SELECT CLAVE, NO_REGIÓN FROM CAT_REGION_MUN) B2  ON  B1.CLAMUN=B2.CLAVE) WHERE CLAVE_MUNICIPIO='" + regioB.getCLAVE_MUNICIPIO() + "' AND TO_CHAR(ID_CLASEPROG)='1' AND CICLO_PROGRAMA='" + regioB.getCICLOAUX() + "' ORDER BY CICLO_PROGRAMA DESC";
        System.out.println("QueryConsultaregioHistInfCiclo ---> " + query);
        List list = null;
        list = queryForList(query, new regioHistMapper());
        return list;

    }

    public List regioHistEC(RegioBean regioB) throws Exception {
        String query = "SELECT * FROM (SELECT B1.IDPROGRAMA, B1.DESCRIPCION_PROGRAMA, B1.ID_CLASEPROG, B1.CLASIFICACION_PROGRAMA, B1.CICLO_ESCOLAR AS CICLO_PROGRAMA, B2.NO_REGIÓN AS IDREGION, B1.CLAMUN AS CLAVE_MUNICIPIO, B1.ESCUELAS AS NO_ESCUELAS, B1.AREA_EJECUTORA, B1.MONTO_TOTAL AS RECURSOS  FROM (SELECT * FROM (SELECT T1.CLAMUN, T1.CICLO_ESCOLAR, T1.IDPROGRAMA, T1.ESCUELAS,  T1.AREA_EJECUTORA, T1.MONTO_TOTAL, T2.DESCRIPCION_PROGRAMA, T2.ID_CLASEPROG, T2.CLASIFICACION_PROGRAMA FROM (SELECT  CLAMUN, CICLO_ESCOLAR, IDPROGRAMA, ESCUELAS, NVL(AREA_EJECUTORA,'Sin Información') AS AREA_EJECUTORA, REPLACE( REPLACE (TO_CHAR(TRIM(REPLACE (MONTO_TOTAL,',',''))),'$','' ), ' ','' ) AS MONTO_TOTAL FROM TBL_PROG_MUNICIPIOS)T1 JOIN (SELECT ACRONIMO, DESCRIPCION_PROGRAMA, ID_CLASEPROG, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS) T2 ON  T1.IDPROGRAMA=T2.ACRONIMO))B1 JOIN (SELECT CLAVE, NO_REGIÓN FROM CAT_REGION_MUN) B2  ON  B1.CLAMUN=B2.CLAVE) WHERE CLAVE_MUNICIPIO='" + regioB.getCLAVE_MUNICIPIO() + "' AND TO_CHAR(ID_CLASEPROG)='2' ORDER BY CICLO_PROGRAMA DESC";

        System.out.println("QueryConsultaregioHistEC ---> " + query);
        List list = null;
        list = queryForList(query, new regioHistMapper());
        return list;

    }

    public List regioHistECCiclo(RegioBean regioB) throws Exception {
        String query = "SELECT * FROM (SELECT B1.IDPROGRAMA, B1.DESCRIPCION_PROGRAMA, B1.ID_CLASEPROG, B1.CLASIFICACION_PROGRAMA, B1.CICLO_ESCOLAR AS CICLO_PROGRAMA, B2.NO_REGIÓN AS IDREGION, B1.CLAMUN AS CLAVE_MUNICIPIO, B1.ESCUELAS AS NO_ESCUELAS, B1.AREA_EJECUTORA, B1.MONTO_TOTAL AS RECURSOS  FROM (SELECT * FROM (SELECT T1.CLAMUN, T1.CICLO_ESCOLAR, T1.IDPROGRAMA, T1.ESCUELAS,  T1.AREA_EJECUTORA, T1.MONTO_TOTAL, T2.DESCRIPCION_PROGRAMA, T2.ID_CLASEPROG, T2.CLASIFICACION_PROGRAMA FROM (SELECT  CLAMUN, CICLO_ESCOLAR, IDPROGRAMA, ESCUELAS, NVL(AREA_EJECUTORA,'Sin Información') AS AREA_EJECUTORA, REPLACE( REPLACE (TO_CHAR(TRIM(REPLACE (MONTO_TOTAL,',',''))),'$','' ), ' ','' ) AS MONTO_TOTAL FROM TBL_PROG_MUNICIPIOS)T1 JOIN (SELECT ACRONIMO, DESCRIPCION_PROGRAMA, ID_CLASEPROG, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS) T2 ON  T1.IDPROGRAMA=T2.ACRONIMO))B1 JOIN (SELECT CLAVE, NO_REGIÓN FROM CAT_REGION_MUN) B2  ON  B1.CLAMUN=B2.CLAVE) WHERE CLAVE_MUNICIPIO='" + regioB.getCLAVE_MUNICIPIO() + "' AND TO_CHAR(ID_CLASEPROG)='2' AND CICLO_PROGRAMA='" + regioB.getCICLOAUX() + "' ORDER BY CICLO_PROGRAMA DESC";

        System.out.println("QueryConsultaregioHistECCiclo ---> " + query);
        List list = null;
        list = queryForList(query, new regioHistMapper());
        return list;

    }

    public List regioHistEE(RegioBean regioB) throws Exception {

        String query = "SELECT * FROM (SELECT B1.IDPROGRAMA, B1.DESCRIPCION_PROGRAMA, B1.ID_CLASEPROG, B1.CLASIFICACION_PROGRAMA, B1.CICLO_ESCOLAR AS CICLO_PROGRAMA, B2.NO_REGIÓN AS IDREGION, B1.CLAMUN AS CLAVE_MUNICIPIO, B1.ESCUELAS AS NO_ESCUELAS, B1.AREA_EJECUTORA, B1.MONTO_TOTAL AS RECURSOS  FROM (SELECT * FROM (SELECT T1.CLAMUN, T1.CICLO_ESCOLAR, T1.IDPROGRAMA, T1.ESCUELAS,  T1.AREA_EJECUTORA, T1.MONTO_TOTAL, T2.DESCRIPCION_PROGRAMA, T2.ID_CLASEPROG, T2.CLASIFICACION_PROGRAMA FROM (SELECT  CLAMUN, CICLO_ESCOLAR, IDPROGRAMA, ESCUELAS, NVL(AREA_EJECUTORA,'Sin Información') AS AREA_EJECUTORA, REPLACE( REPLACE (TO_CHAR(TRIM(REPLACE (MONTO_TOTAL,',',''))),'$','' ), ' ','' ) AS MONTO_TOTAL FROM TBL_PROG_MUNICIPIOS)T1 JOIN (SELECT ACRONIMO, DESCRIPCION_PROGRAMA, ID_CLASEPROG, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS) T2 ON  T1.IDPROGRAMA=T2.ACRONIMO))B1 JOIN (SELECT CLAVE, NO_REGIÓN FROM CAT_REGION_MUN) B2  ON  B1.CLAMUN=B2.CLAVE) WHERE CLAVE_MUNICIPIO='" + regioB.getCLAVE_MUNICIPIO() + "' AND TO_CHAR(ID_CLASEPROG)='3' ORDER BY CICLO_PROGRAMA DESC";

        System.out.println("QueryConsultaregioHistEE ---> " + query);
        List list = null;
        list = queryForList(query, new regioHistMapper());
        return list;

    }

    public List regioHistEECiclo(RegioBean regioB) throws Exception {

        String query = "SELECT * FROM (SELECT B1.IDPROGRAMA, B1.DESCRIPCION_PROGRAMA, B1.ID_CLASEPROG, B1.CLASIFICACION_PROGRAMA, B1.CICLO_ESCOLAR AS CICLO_PROGRAMA, B2.NO_REGIÓN AS IDREGION, B1.CLAMUN AS CLAVE_MUNICIPIO, B1.ESCUELAS AS NO_ESCUELAS, B1.AREA_EJECUTORA, B1.MONTO_TOTAL AS RECURSOS  FROM (SELECT * FROM (SELECT T1.CLAMUN, T1.CICLO_ESCOLAR, T1.IDPROGRAMA, T1.ESCUELAS,  T1.AREA_EJECUTORA, T1.MONTO_TOTAL, T2.DESCRIPCION_PROGRAMA, T2.ID_CLASEPROG, T2.CLASIFICACION_PROGRAMA FROM (SELECT  CLAMUN, CICLO_ESCOLAR, IDPROGRAMA, ESCUELAS, NVL(AREA_EJECUTORA,'Sin Información') AS AREA_EJECUTORA, REPLACE( REPLACE (TO_CHAR(TRIM(REPLACE (MONTO_TOTAL,',',''))),'$','' ), ' ','' ) AS MONTO_TOTAL FROM TBL_PROG_MUNICIPIOS)T1 JOIN (SELECT ACRONIMO, DESCRIPCION_PROGRAMA, ID_CLASEPROG, CLASIFICACION_PROGRAMA FROM CAT_PROGRAMAS) T2 ON  T1.IDPROGRAMA=T2.ACRONIMO))B1 JOIN (SELECT CLAVE, NO_REGIÓN FROM CAT_REGION_MUN) B2  ON  B1.CLAMUN=B2.CLAVE) WHERE CLAVE_MUNICIPIO='" + regioB.getCLAVE_MUNICIPIO() + "' AND TO_CHAR(ID_CLASEPROG)='3' AND CICLO_PROGRAMA='" + regioB.getCICLOAUX() + "' ORDER BY CICLO_PROGRAMA DESC";

        System.out.println("QueryConsultaregioHistEECiclo ---> " + query);
        List list = null;
        list = queryForList(query, new regioHistMapper());
        return list;

    }

    public List comunidadNivel(CatalogoBean cat) throws Exception {

        String query = "SELECT ID, CVENIV, NOMNIV, MATRIALU, MATRIDOCEN, NOESC, TIPOMTRIC, FUENTE, ESCPUB, ESCPRIV, CICLO_ESCOLAR  FROM Comunidad_Educativa where Ciclo_Escolar='" + cat.getCICLOAUX() + "' and Cveniv=" + cat.getOPCION() + "";
        //System.out.println("QueryConsultaCominidadEductiva ---> " + query);
        List list = null;
        list = queryForList(query, new comEduMapper());
        return list;

    }

    public List graficaProgNivelEst(CatalogoBean cat) throws Exception {

        String query = "SELECT CATFINPROG.DESCRIPCION_PROGRAMA AS NOMBRE_PROGRAMA, NVL(TABVALORES.NO_ESC_PROG,'0') AS NO_ESC_PROG, NVL(TABVALORES.PORCENTAJE_AVANCE,'0') AS PORCENTAJE_AVANCE  FROM (SELECT PROG.ACRONIMO, PROG.NIVEL, PROG.CVENIVEL, CATPROG.DESCRIPCION_PROGRAMA FROM (SELECT * FROM TBL_NIVELES_PARA_PROG)PROG JOIN (SELECT * FROM Cat_Programas)CATPROG ON PROG.ACRONIMO=CATPROG.ACRONIMO WHERE CATPROG.TIPOPROGRAMA='E' AND PROG.CVENIVEL='" + cat.getOPCION() + "') CATFINPROG Left OUTER JOIN (SELECT NOMBRE_PROGRAMA, NO_ESC_PROG,TRUNC( (NO_ESC_PROG*100)/NOES,2) AS PORCENTAJE_AVANCE, ID_PROGRAMA  FROM (SELECT   SUM(NOESC) AS NOES FROM Comunidad_Educativa WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "' AND CVENIV='" + cat.getOPCION() + "') PROGRAMAS,(SELECT * FROM Progyapoyo WHERE TIPO_PROGRAMA='E' AND CVENIV='" + cat.getOPCION() + "' AND CICLO_ESCOLAR='" + cat.getCICLOAUX() + "') TOTALNIV  ORDER BY NOMBRE_PROGRAMA ASC)TABVALORES ON CATFINPROG.ACRONIMO=TABVALORES.ID_PROGRAMA ORDER BY CATFINPROG.DESCRIPCION_PROGRAMA ASC";
        System.out.println("QueryConsultaGRAFProgNivelEst///////////////////////+++++++++++++++++++++ ---> " + query);
        List list = null;
        list = queryForList(query, new progNivelMapper());
        return list;

    }

    public List graficaProgNivelFed(CatalogoBean cat) throws Exception {

        String query = "SELECT CATFINPROG.DESCRIPCION_PROGRAMA AS NOMBRE_PROGRAMA, NVL(TABVALORES.NO_ESC_PROG,'0') AS NO_ESC_PROG, NVL(TABVALORES.PORCENTAJE_AVANCE,'0') AS PORCENTAJE_AVANCE  FROM (SELECT PROG.ACRONIMO, PROG.NIVEL, PROG.CVENIVEL, CATPROG.DESCRIPCION_PROGRAMA FROM (SELECT * FROM TBL_NIVELES_PARA_PROG)PROG JOIN (SELECT * FROM Cat_Programas)CATPROG ON PROG.ACRONIMO=CATPROG.ACRONIMO WHERE CATPROG.TIPOPROGRAMA='F' AND PROG.CVENIVEL='" + cat.getOPCION() + "') CATFINPROG Left OUTER JOIN (SELECT NOMBRE_PROGRAMA, NO_ESC_PROG,TRUNC( (NO_ESC_PROG*100)/NOES,2) AS PORCENTAJE_AVANCE, ID_PROGRAMA  FROM (SELECT   SUM(NOESC) AS NOES FROM Comunidad_Educativa WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "' AND CVENIV='" + cat.getOPCION() + "') PROGRAMAS,(SELECT * FROM Progyapoyo WHERE TIPO_PROGRAMA='F' AND CVENIV='" + cat.getOPCION() + "' AND CICLO_ESCOLAR='" + cat.getCICLOAUX() + "') TOTALNIV  ORDER BY NOMBRE_PROGRAMA ASC)TABVALORES ON CATFINPROG.ACRONIMO=TABVALORES.ID_PROGRAMA ORDER BY CATFINPROG.DESCRIPCION_PROGRAMA ASC";
        System.out.println("QueryConsultaGrafProgFed ---> " + query);
        List list = null;
        list = queryForList(query, new progNivelMapper());
        return list;

    }

    public List graficaProgNivelEstTodo(CatalogoBean cat) throws Exception {

        String query = "SELECT NOMBRE_PROGRAMA, NO_ESC_PROG,TRUNC( (NO_ESC_PROG*100)/NOES,2) AS PORCENTAJE_AVANCE FROM (SELECT Distinct(Id_PROGRAMA), Nombre_Programa, SUM(NO_ESC_PROG) AS NO_ESC_PROG  FROM Progyapoyo WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "' and Progyapoyo.Tipo_Programa='E' Group BY ID_PROGRAMA, Nombre_Programa),(SELECT   SUM(NOESC) AS NOES FROM Comunidad_Educativa WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "') ORDER BY NOMBRE_PROGRAMA ASC ";
        //System.out.println("QueryConsultaProgNivelEstTodo ---> " + query);
        List list = null;
        list = queryForList(query, new progNivelMapper());
        return list;

    }

    public List graficaProgNivelFedTodo(CatalogoBean cat) throws Exception {

        String query = "SELECT NOMBRE_PROGRAMA, NO_ESC_PROG,TRUNC( (NO_ESC_PROG*100)/NOES,2) AS PORCENTAJE_AVANCE FROM (SELECT Distinct(Id_PROGRAMA), Nombre_Programa, SUM(NO_ESC_PROG) AS NO_ESC_PROG  FROM Progyapoyo WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "' and Progyapoyo.Tipo_Programa='F' Group BY ID_PROGRAMA, Nombre_Programa),(SELECT   SUM(NOESC) AS NOES FROM Comunidad_Educativa WHERE Ciclo_Escolar='" + cat.getCICLOAUX() + "') ORDER BY NOMBRE_PROGRAMA ASC";
        System.out.println("QueryConsultaProgNivelFedTodo ---> " + query);
        List list = null;
        list = queryForList(query, new progNivelMapper());
        return list;

    }

}
