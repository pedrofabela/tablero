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

/**
 *
 * @author pedro
 */
public interface consultaPPrincipalDao {

    public List consultaBotones() throws Exception;
    
    public List ListaServiciosLinea() throws Exception;
    
     public List ListaMenuSerlinea() throws Exception;
      
     public List ListaMenuSerlineaTodos() throws Exception;
     
       public List ListaMenuSerlineaPermanente() throws Exception;
       
       
       public List ListaSerlineaConsulta(serviciosLineaBean serlinea) throws Exception;
        public List ListaMesLinea(serviciosLineaBean serlinea) throws Exception;
         public List infografiaAvance(serviciosLineaBean serlinea) throws Exception;
         public List infografiaAlcance(serviciosLineaBean serlinea) throws Exception;
        public List serlineaInfografia(serviciosLineaBean serlinea) throws Exception;
          public List ListaMesDia(serviciosLineaBean serlinea) throws Exception;
   
    public List ListaServiciosLineaPorcentaje(String porcentaje) throws Exception;

    public List mapa(CatalogoBean cat) throws Exception;

    public List mapaMun(CatalogoBean cat) throws Exception;

    public List mapaMunTodos(CatalogoBean cat) throws Exception;

    public List mapaCatMun(CatalogoBean cat) throws Exception;

    public List mapaTodos(CatalogoBean cat) throws Exception;

    public List consultageneralcom(CatalogoBean cat) throws Exception;

    public List busquedaCCT(busquedaCCTBean buscarCCT) throws Exception;
    
    public List ProgVigentesEECct(busquedaCCTBean buscarCCT) throws Exception;
    
    public List ProgTodosEECct(busquedaCCTBean buscarCCT) throws Exception;
     public List resultadosPlanea(busquedaCCTBean buscarCCT) throws Exception;
    
    public List ProgVigentesMECct(busquedaCCTBean buscarCCT) throws Exception;
     public List ProgTodosMECct(busquedaCCTBean buscarCCT) throws Exception;
    
    public List ProgVigentesIFCct(busquedaCCTBean buscarCCT) throws Exception;
     public List ProgTodosIFCct(busquedaCCTBean buscarCCT) throws Exception;

    public List progApoyoMenu(CatalogoBean cat) throws Exception;

    public List progApoyoMenuTodos(CatalogoBean cat) throws Exception;

    public String ConsultaCiclo(CatalogoBean cat) throws Exception;

    public List indicadoresProg(CatalogoBean cat) throws Exception;

    public List indicadoresPrincipal(CatalogoBean cat) throws Exception;
     public List ims(CatalogoBean cat) throws Exception;

    public List indicadoresHistoriaProg(CatalogoBean cat) throws Exception;

    public List DescripcionProg(progApoyoBean prog) throws Exception;

    public List grafNivelProg(progApoyoBean prog) throws Exception;

    public List grafMunicipioProg(progApoyoBean prog) throws Exception;

    public List grafRegionProg(progApoyoBean prog) throws Exception;

    public List grafNacionalProg(progApoyoBean prog) throws Exception;

    public List descripcionProg(progApoyoBean prog) throws Exception;

    public List progApoyoInicial(CatalogoBean cat) throws Exception;

    public List menuRegio(RegioBean regioB) throws Exception;

    public List regioMun(RegioBean regioB) throws Exception;

    public List regioGrafMun(RegioBean regioB) throws Exception;

    public List regioHistInf(RegioBean regioB) throws Exception;

    public List regioHistInfCiclo(RegioBean regioB) throws Exception;

    public List regioHistEC(RegioBean regioB) throws Exception;

    public List regioHistECCiclo(RegioBean regioB) throws Exception;

    public List regioHistEE(RegioBean regioB) throws Exception;

    public List regioHistEECiclo(RegioBean regioB) throws Exception;

    public List comunidadNivel(CatalogoBean cat) throws Exception;

    public List graficaProgNivelEst(CatalogoBean cat) throws Exception;

    public List graficaProgNivelFed(CatalogoBean cat) throws Exception;

    public List graficaProgNivelEstTodo(CatalogoBean cat) throws Exception;

    public List graficaProgNivelFedTodo(CatalogoBean cat) throws Exception;

}
