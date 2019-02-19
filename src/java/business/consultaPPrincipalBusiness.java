/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import beans.CatalogoBean;
import beans.DescripcionProgBean;
import beans.RegioBean;
import beans.busquedaCCTBean;
import beans.progApoyoBean;
import beans.serviciosLineaBean;
import daos.consultaPPrincipalDAOImpl;
import daos.consultaPPrincipalDao;
import java.util.List;

/**
 *
 * @author pedro
 */
public class consultaPPrincipalBusiness {

    private consultaPPrincipalDao obj;

    public consultaPPrincipalBusiness() throws Exception {
        this.obj = new consultaPPrincipalDAOImpl();
    }

    public List consultaBotones() throws Exception {
        List lista = this.obj.consultaBotones();
        return lista;

    }

    public List ListaServiciosLinea() throws Exception {
        List lista = this.obj.ListaServiciosLinea();
        return lista;

    }
    
     public List ListaMenuSerlinea() throws Exception {
        List lista = this.obj.ListaMenuSerlinea();
        return lista;

    }
     public List ListaMenuSerlineaTodos() throws Exception {
        List lista = this.obj.ListaMenuSerlineaTodos();
        return lista;

    }
     
       public List ListaMenuSerlineaPermanente() throws Exception {
        List lista = this.obj.ListaMenuSerlineaPermanente();
        return lista;

    }
     
         public List ListaSerlineaConsulta(serviciosLineaBean serlinea) throws Exception {
        List lista = this.obj.ListaSerlineaConsulta(serlinea);
        return lista;

    }
           public List ListaMesLinea(serviciosLineaBean serlinea) throws Exception {
        List lista = this.obj.ListaMesLinea(serlinea);
        return lista;

    }
             public List infografiaAvance(serviciosLineaBean serlinea) throws Exception {
        List lista = this.obj.infografiaAvance(serlinea);
        return lista;

    }
               public List infografiaAlcance(serviciosLineaBean serlinea) throws Exception {
        List lista = this.obj.infografiaAlcance(serlinea);
        return lista;

    }
             public List serlineaInfografia(serviciosLineaBean serlinea) throws Exception {
        List lista = this.obj.serlineaInfografia(serlinea);
        return lista;

    }
           
             public List ListaMesDia(serviciosLineaBean serlinea) throws Exception {
        List lista = this.obj.ListaMesDia(serlinea);
        return lista;

    }
     
     
     public List ListaServiciosLineaPorcentaje(String porcentaje) throws Exception {
        List lista = this.obj.ListaServiciosLineaPorcentaje(porcentaje);
        return lista;

    }
    public List mapa(CatalogoBean cat) throws Exception {
        List lista = this.obj.mapa(cat);
        return lista;

    }

    public List mapaMun(CatalogoBean cat) throws Exception {
        List lista = this.obj.mapaMun(cat);
        return lista;

    }

    public List mapaMunTodos(CatalogoBean cat) throws Exception {
        List lista = this.obj.mapaMunTodos(cat);
        return lista;

    }

    public List mapaCatMun(CatalogoBean cat) throws Exception {
        List lista = this.obj.mapaCatMun(cat);
        return lista;

    }

    public List mapaTodos(CatalogoBean cat) throws Exception {
        List lista = this.obj.mapaTodos(cat);
        return lista;

    }

    public List consultageneralcom(CatalogoBean cat) throws Exception {
        List lista = this.obj.consultageneralcom(cat);
        return lista;
    }

    public List busquedaCCT(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.busquedaCCT(buscarCCT);
        return lista;
    }
    
    public List ProgVigentesEECct(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.ProgVigentesEECct(buscarCCT);
        return lista;
    }
     public List ProgTodosEECct(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.ProgTodosEECct(buscarCCT);
        return lista;
    }
     
      public List resultadosPlanea(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.resultadosPlanea(buscarCCT);
        return lista;
    }
     
     
     
     
    public List ProgVigentesMECct(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.ProgVigentesMECct(buscarCCT);
        return lista;
    }
     public List ProgTodosMECct(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.ProgTodosMECct(buscarCCT);
        return lista;
    }
    
    public List ProgVigentesIFCct(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.ProgVigentesIFCct(buscarCCT);
        return lista;
    }
    public List ProgTodosIFCct(busquedaCCTBean buscarCCT) throws Exception {
        List lista = this.obj.ProgTodosIFCct(buscarCCT);
        return lista;
    }
    public List progApoyoMenu(CatalogoBean cat) throws Exception {
        List lista = this.obj.progApoyoMenu(cat);
        return lista;
    }

    public List progApoyoMenuTodos(CatalogoBean cat) throws Exception {
        List lista = this.obj.progApoyoMenuTodos(cat);
        return lista;
    }

    public String ConsultaCiclo(CatalogoBean cat) throws Exception {
        String ciclo = this.obj.ConsultaCiclo(cat);
        return ciclo;
    }

    public List indicadoresProg(CatalogoBean cat) throws Exception {
        List lista = this.obj.indicadoresProg(cat);
        return lista;
    }

    public List indicadoresPrincipal(CatalogoBean cat) throws Exception {
        List lista = this.obj.indicadoresPrincipal(cat);
        return lista;
    }
    
     public List ims(CatalogoBean cat) throws Exception {
        List lista = this.obj.ims(cat);
        return lista;
    }

    public List indicadoresHistoriaProg(CatalogoBean cat) throws Exception {
        List lista = this.obj.indicadoresHistoriaProg(cat);
        return lista;
    }

    public List DescripcionProg(progApoyoBean prog) throws Exception {
        List lista = this.obj.DescripcionProg(prog);
        return lista;
    }

    public List grafNivelProg(progApoyoBean prog) throws Exception {
        List lista = this.obj.grafNivelProg(prog);
        return lista;
    }

    public List grafMunicipioProg(progApoyoBean prog) throws Exception {
        List lista = this.obj.grafMunicipioProg(prog);
        return lista;
    }

    public List grafRegionProg(progApoyoBean prog) throws Exception {
        List lista = this.obj.grafRegionProg(prog);
        return lista;
    }

    public List grafNacionalProg(progApoyoBean prog) throws Exception {
        List lista = this.obj.grafNacionalProg(prog);
        return lista;
    }

    public List descripcionProg(progApoyoBean prog) throws Exception {
        List lista = this.obj.descripcionProg(prog);
        return lista;
    }

    public List progApoyoInicial(CatalogoBean cat) throws Exception {
        List lista = this.obj.progApoyoInicial(cat);
        return lista;
    }

    public List menuRegio(RegioBean regioB) throws Exception {
        List lista = this.obj.menuRegio(regioB);
        return lista;
    }

    public List regioMun(RegioBean regioB) throws Exception {
        List lista = this.obj.regioMun(regioB);
        return lista;
    }

    public List regioGrafMun(RegioBean regioB) throws Exception {
        List lista = this.obj.regioGrafMun(regioB);
        return lista;
    }

    public List regioHistInf(RegioBean regioB) throws Exception {
        List lista = this.obj.regioHistInf(regioB);
        return lista;
    }

    public List regioHistInfCiclo(RegioBean regioB) throws Exception {
        List lista = this.obj.regioHistInfCiclo(regioB);
        return lista;
    }

    public List regioHistEC(RegioBean regioB) throws Exception {
        List lista = this.obj.regioHistEC(regioB);
        return lista;
    }

    public List regioHistECCiclo(RegioBean regioB) throws Exception {
        List lista = this.obj.regioHistECCiclo(regioB);
        return lista;
    }

    public List regioHistEE(RegioBean regioB) throws Exception {
        List lista = this.obj.regioHistEE(regioB);
        return lista;
    }

    public List regioHistEECiclo(RegioBean regioB) throws Exception {
        List lista = this.obj.regioHistEECiclo(regioB);
        return lista;
    }

    public List comunidadNivel(CatalogoBean cat) throws Exception {
        List lista = this.obj.comunidadNivel(cat);
        return lista;
    }

    public List graficaProgNivelEst(CatalogoBean cat) throws Exception {
        List lista = this.obj.graficaProgNivelEst(cat);
        return lista;
    }

    public List graficaProgNivelFed(CatalogoBean cat) throws Exception {
        List lista = this.obj.graficaProgNivelFed(cat);
        return lista;
    }

    public List graficaProgNivelEstTodo(CatalogoBean cat) throws Exception {
        List lista = this.obj.graficaProgNivelEstTodo(cat);
        return lista;
    }

    public List graficaProgNivelFedTodo(CatalogoBean cat) throws Exception {
        List lista = this.obj.graficaProgNivelFedTodo(cat);
        return lista;
    }
}
