/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import beans.CatalogoBean;
import beans.DescripcionProgBean;
import beans.Navegacion;
import beans.RegioBean;
import beans.busquedaCCTBean;
import beans.comEduBean;
import beans.escuelasDescripcionBean;
import beans.escuelasMunicipioBean;
import beans.escuelasNacionalBean;
import beans.escuelasNivelBean;
import beans.escuelasRegionBean;
import beans.idicadoresProgBean;
import beans.mapaBean;
import beans.moduloBean;
import beans.progApoyoBean;
import beans.progNivelBean;
import beans.serviciosLineaBean;
import beans.usuarioBean;
import business.consultaPPrincipalBusiness;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.text.DecimalFormat;

import org.apache.struts2.interceptor.SessionAware;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author pedro
 */
public class PantallaPrincipal_Action extends ActionSupport implements SessionAware {

    public List<CatalogoBean> ListaBotones = new ArrayList<CatalogoBean>();
    public List<CatalogoBean> ListaComEdu = new ArrayList<CatalogoBean>();
    public List<progNivelBean> ListaProgEst = new ArrayList<progNivelBean>();
    public List<progNivelBean> ListaProgFed = new ArrayList<progNivelBean>();
    public List<progApoyoBean> ListaMenuProg = new ArrayList<progApoyoBean>();

    public List<idicadoresProgBean> ListaIndicadoresProg = new ArrayList<idicadoresProgBean>();
    public List<idicadoresProgBean> ListaHistoricoProg = new ArrayList<idicadoresProgBean>();
    public List<DescripcionProgBean> ListaDescripcionProg = new ArrayList<DescripcionProgBean>();

    public List<escuelasNivelBean> ListaGrafNivelProg = new ArrayList<escuelasNivelBean>();

    public List<escuelasMunicipioBean> ListaGrafMunicipioProg = new ArrayList<escuelasMunicipioBean>();
    public List<escuelasRegionBean> ListaGrafRegionProg = new ArrayList<escuelasRegionBean>();
    public List<escuelasNacionalBean> ListaGrafNacionalProg = new ArrayList<escuelasNacionalBean>();
    public List<escuelasDescripcionBean> ListaDescripcionGrafProg = new ArrayList<escuelasDescripcionBean>();
    public List<mapaBean> ListaMapa = new ArrayList<mapaBean>();

    public List<mapaBean> ListaMapaTodos = new ArrayList<mapaBean>();
    public List<RegioBean> ListaMenuRegio = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioMun = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioGrafNiv = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioInf = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioInfCiclo = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioEC = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioECCiclo = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioEE = new ArrayList<RegioBean>();
    public List<RegioBean> ListaRegioEECiclo = new ArrayList<RegioBean>();
    public List<CatalogoBean> ListaCatMun = new ArrayList<CatalogoBean>();
    public List<CatalogoBean> ListaIndicadoresPrincipal = new ArrayList<CatalogoBean>();
    public List<busquedaCCTBean> ListaBusquedaCCT = new ArrayList<busquedaCCTBean>();
    public List<busquedaCCTBean> ListaProgVigentesEECCT = new ArrayList<busquedaCCTBean>();
    public List<busquedaCCTBean> ListaProgTodosEECCT = new ArrayList<busquedaCCTBean>();

    public List<busquedaCCTBean> ListaProgVigentesMECCT = new ArrayList<busquedaCCTBean>();
    public List<busquedaCCTBean> ListaProgTodosMECCT = new ArrayList<busquedaCCTBean>();

    public List<busquedaCCTBean> ListaProgVigentesIFCCT = new ArrayList<busquedaCCTBean>();

    public List<busquedaCCTBean> ListaResultadosPlanea = new ArrayList<busquedaCCTBean>();
    public List<busquedaCCTBean> ListaProgTodosIFCCT = new ArrayList<busquedaCCTBean>();
    public List<serviciosLineaBean> ListaServiciosLinea = new ArrayList<serviciosLineaBean>();
    public List<serviciosLineaBean> ListaServiciosLineaPorcentaje = new ArrayList<serviciosLineaBean>();

    public List<serviciosLineaBean> ListaMenuSerlinea = new ArrayList<serviciosLineaBean>();

    public List<serviciosLineaBean> ListaMenuSerlineaPermanente = new ArrayList<serviciosLineaBean>();
    public List<serviciosLineaBean> ListaSerlineaConsulta = new ArrayList<serviciosLineaBean>();
    public List<serviciosLineaBean> ListaSerlineaHistDia = new ArrayList<serviciosLineaBean>();
    public List<serviciosLineaBean> ListaSerlineaHistDiaMes = new ArrayList<serviciosLineaBean>();
    public List<serviciosLineaBean> ListaSerlineaInfografia = new ArrayList<serviciosLineaBean>();

    public List<serviciosLineaBean> ListaserlineInfografiaAvance = new ArrayList<serviciosLineaBean>();
    public List<serviciosLineaBean> ListaserlineInfografiaAlcance = new ArrayList<serviciosLineaBean>();
    public List<serviciosLineaBean> Listaims = new ArrayList<serviciosLineaBean>();

    CatalogoBean cat = new CatalogoBean();
    serviciosLineaBean serlinea = new serviciosLineaBean();
    comEduBean comedu = new comEduBean();
    progApoyoBean prog = new progApoyoBean();
    DescripcionProgBean desprg = new DescripcionProgBean();
    RegioBean regioB = new RegioBean();
    busquedaCCTBean busquedaCCT = new busquedaCCTBean();

    private boolean mensajeerror = false;
    private String CICLO = "";

    private boolean tipoProg1 = false;
    private boolean tipoProg2 = false;
    private boolean tipoProg3 = false;
    private boolean banderamenu = false;
    private boolean banderamenumenos = false;
    private boolean nivelimpacto = false;

    private boolean infografia = false;

    private boolean errorFormato = false;
    private boolean errorNoEncontrado = false;

    public List<serviciosLineaBean> getListaims() {
        return Listaims;
    }

    public void setListaims(List<serviciosLineaBean> Listaims) {
        this.Listaims = Listaims;
    }

    public List<busquedaCCTBean> getListaResultadosPlanea() {
        return ListaResultadosPlanea;
    }

    public void setListaResultadosPlanea(List<busquedaCCTBean> ListaResultadosPlanea) {
        this.ListaResultadosPlanea = ListaResultadosPlanea;
    }

    public List<serviciosLineaBean> getListaSerlineaInfografia() {
        return ListaSerlineaInfografia;
    }

    public void setListaSerlineaInfografia(List<serviciosLineaBean> ListaSerlineaInfografia) {
        this.ListaSerlineaInfografia = ListaSerlineaInfografia;
    }

    public List<serviciosLineaBean> getListaserlineInfografiaAvance() {
        return ListaserlineInfografiaAvance;
    }

    public void setListaserlineInfografiaAvance(List<serviciosLineaBean> ListaserlineInfografiaAvance) {
        this.ListaserlineInfografiaAvance = ListaserlineInfografiaAvance;
    }

    public List<serviciosLineaBean> getListaserlineInfografiaAlcance() {
        return ListaserlineInfografiaAlcance;
    }

    public void setListaserlineInfografiaAlcance(List<serviciosLineaBean> ListaserlineInfografiaAlcance) {
        this.ListaserlineInfografiaAlcance = ListaserlineInfografiaAlcance;
    }

    public boolean isNivelimpacto() {
        return nivelimpacto;
    }

    public void setNivelimpacto(boolean nivelimpacto) {
        this.nivelimpacto = nivelimpacto;
    }

    public boolean isInfografia() {
        return infografia;
    }

    public void setInfografia(boolean infografia) {
        this.infografia = infografia;
    }

    public List<serviciosLineaBean> getListaSerlineaHistDiaMes() {
        return ListaSerlineaHistDiaMes;
    }

    public void setListaSerlineaHistDiaMes(List<serviciosLineaBean> ListaSerlineaHistDiaMes) {
        this.ListaSerlineaHistDiaMes = ListaSerlineaHistDiaMes;
    }

    public List<serviciosLineaBean> getListaSerlineaConsulta() {
        return ListaSerlineaConsulta;
    }

    public void setListaSerlineaConsulta(List<serviciosLineaBean> ListaSerlineaConsulta) {
        this.ListaSerlineaConsulta = ListaSerlineaConsulta;
    }

    public List<serviciosLineaBean> getListaSerlineaHistDia() {
        return ListaSerlineaHistDia;
    }

    public void setListaSerlineaHistDia(List<serviciosLineaBean> ListaSerlineaHistDia) {
        this.ListaSerlineaHistDia = ListaSerlineaHistDia;
    }

    public List<serviciosLineaBean> getListaMenuSerlinea() {
        return ListaMenuSerlinea;
    }

    public void setListaMenuSerlinea(List<serviciosLineaBean> ListaMenuSerlinea) {
        this.ListaMenuSerlinea = ListaMenuSerlinea;
    }

    public List<serviciosLineaBean> getListaMenuSerlineaPermanente() {
        return ListaMenuSerlineaPermanente;
    }

    public void setListaMenuSerlineaPermanente(List<serviciosLineaBean> ListaMenuSerlineaPermanente) {
        this.ListaMenuSerlineaPermanente = ListaMenuSerlineaPermanente;
    }

    public boolean isBanderamenumenos() {
        return banderamenumenos;
    }

    public void setBanderamenumenos(boolean banderamenumenos) {
        this.banderamenumenos = banderamenumenos;
    }

    public List<serviciosLineaBean> getListaServiciosLineaPorcentaje() {
        return ListaServiciosLineaPorcentaje;
    }

    public boolean isBanderamenu() {
        return banderamenu;
    }

    public void setBanderamenu(boolean banderamenu) {
        this.banderamenu = banderamenu;
    }

    public void setListaServiciosLineaPorcentaje(List<serviciosLineaBean> ListaServiciosLineaPorcentaje) {
        this.ListaServiciosLineaPorcentaje = ListaServiciosLineaPorcentaje;
    }

    public serviciosLineaBean getSerlinea() {
        return serlinea;
    }

    public void setSerlinea(serviciosLineaBean serlinea) {
        this.serlinea = serlinea;
    }

    public List<serviciosLineaBean> getListaServiciosLinea() {
        return ListaServiciosLinea;
    }

    public void setListaServiciosLinea(List<serviciosLineaBean> ListaServiciosLinea) {
        this.ListaServiciosLinea = ListaServiciosLinea;
    }

    public List<busquedaCCTBean> getListaProgTodosEECCT() {
        return ListaProgTodosEECCT;
    }

    public void setListaProgTodosEECCT(List<busquedaCCTBean> ListaProgTodosEECCT) {
        this.ListaProgTodosEECCT = ListaProgTodosEECCT;
    }

    public List<busquedaCCTBean> getListaProgTodosMECCT() {
        return ListaProgTodosMECCT;
    }

    public void setListaProgTodosMECCT(List<busquedaCCTBean> ListaProgTodosMECCT) {
        this.ListaProgTodosMECCT = ListaProgTodosMECCT;
    }

    public List<busquedaCCTBean> getListaProgTodosIFCCT() {
        return ListaProgTodosIFCCT;
    }

    public void setListaProgTodosIFCCT(List<busquedaCCTBean> ListaProgTodosIFCCT) {
        this.ListaProgTodosIFCCT = ListaProgTodosIFCCT;
    }

    public boolean isErrorNoEncontrado() {
        return errorNoEncontrado;
    }

    public void setErrorNoEncontrado(boolean errorNoEncontrado) {
        this.errorNoEncontrado = errorNoEncontrado;
    }

    public busquedaCCTBean getBusquedaCCT() {
        return busquedaCCT;
    }

    public void setBusquedaCCT(busquedaCCTBean busquedaCCT) {
        this.busquedaCCT = busquedaCCT;
    }

    public boolean isErrorFormato() {
        return errorFormato;
    }

    public void setErrorFormato(boolean errorFormato) {
        this.errorFormato = errorFormato;
    }

    public List<CatalogoBean> getListaIndicadoresPrincipal() {
        return ListaIndicadoresPrincipal;
    }

    public void setListaIndicadoresPrincipal(List<CatalogoBean> ListaIndicadoresPrincipal) {
        this.ListaIndicadoresPrincipal = ListaIndicadoresPrincipal;
    }

    public List<busquedaCCTBean> getListaBusquedaCCT() {
        return ListaBusquedaCCT;
    }

    public void setListaBusquedaCCT(List<busquedaCCTBean> ListaBusquedaCCT) {
        this.ListaBusquedaCCT = ListaBusquedaCCT;
    }

    public List<busquedaCCTBean> getListaProgVigentesEECCT() {
        return ListaProgVigentesEECCT;
    }

    public void setListaProgVigentesEECCT(List<busquedaCCTBean> ListaProgVigentesEECCT) {
        this.ListaProgVigentesEECCT = ListaProgVigentesEECCT;
    }

    public List<busquedaCCTBean> getListaProgVigentesMECCT() {
        return ListaProgVigentesMECCT;
    }

    public void setListaProgVigentesMECCT(List<busquedaCCTBean> ListaProgVigentesMECCT) {
        this.ListaProgVigentesMECCT = ListaProgVigentesMECCT;
    }

    public List<busquedaCCTBean> getListaProgVigentesIFCCT() {
        return ListaProgVigentesIFCCT;
    }

    public void setListaProgVigentesIFCCT(List<busquedaCCTBean> ListaProgVigentesIFCCT) {
        this.ListaProgVigentesIFCCT = ListaProgVigentesIFCCT;
    }

    public List<RegioBean> getListaRegioInfCiclo() {
        return ListaRegioInfCiclo;
    }

    //SET Y SET
    public List<CatalogoBean> getListaCatMun() {
        return ListaCatMun;
    }

    public void setListaCatMun(List<CatalogoBean> ListaCatMun) {
        this.ListaCatMun = ListaCatMun;
    }

    public List<mapaBean> getListaMapaTodos() {
        return ListaMapaTodos;
    }

    public void setListaMapaTodos(List<mapaBean> ListaMapaTodos) {
        this.ListaMapaTodos = ListaMapaTodos;
    }

    public List<RegioBean> getListaRegioECCiclo() {
        return ListaRegioECCiclo;
    }

    public void setListaRegioECCiclo(List<RegioBean> ListaRegioECCiclo) {
        this.ListaRegioECCiclo = ListaRegioECCiclo;
    }

    public List<RegioBean> getListaRegioEECiclo() {
        return ListaRegioEECiclo;
    }

    public void setListaRegioEECiclo(List<RegioBean> ListaRegioEECiclo) {
        this.ListaRegioEECiclo = ListaRegioEECiclo;
    }

    public void setListaRegioInfCiclo(List<RegioBean> ListaRegioInfCiclo) {
        this.ListaRegioInfCiclo = ListaRegioInfCiclo;
    }

    public boolean isTipoProg1() {
        return tipoProg1;
    }

    public void setTipoProg1(boolean tipoProg1) {
        this.tipoProg1 = tipoProg1;
    }

    public boolean isTipoProg2() {
        return tipoProg2;
    }

    public void setTipoProg2(boolean tipoProg2) {
        this.tipoProg2 = tipoProg2;
    }

    public boolean isTipoProg3() {
        return tipoProg3;
    }

    public void setTipoProg3(boolean tipoProg3) {
        this.tipoProg3 = tipoProg3;
    }

    public List<RegioBean> getListaRegioInf() {
        return ListaRegioInf;
    }

    public void setListaRegioInf(List<RegioBean> ListaRegioInf) {
        this.ListaRegioInf = ListaRegioInf;
    }

    public List<RegioBean> getListaRegioEC() {
        return ListaRegioEC;
    }

    public void setListaRegioEC(List<RegioBean> ListaRegioEC) {
        this.ListaRegioEC = ListaRegioEC;
    }

    public List<RegioBean> getListaRegioEE() {
        return ListaRegioEE;
    }

    public void setListaRegioEE(List<RegioBean> ListaRegioEE) {
        this.ListaRegioEE = ListaRegioEE;
    }

    public List<RegioBean> getListaRegioGrafNiv() {
        return ListaRegioGrafNiv;
    }

    public void setListaRegioGrafNiv(List<RegioBean> ListaRegioGrafNiv) {
        this.ListaRegioGrafNiv = ListaRegioGrafNiv;
    }

    public List<RegioBean> getListaRegioMun() {
        return ListaRegioMun;
    }

    public void setListaRegioMun(List<RegioBean> ListaRegioMun) {
        this.ListaRegioMun = ListaRegioMun;
    }

    public List<RegioBean> getListaMenuRegio() {
        return ListaMenuRegio;
    }

    public void setListaMenuRegio(List<RegioBean> ListaMenuRegio) {
        this.ListaMenuRegio = ListaMenuRegio;
    }

    public RegioBean getRegioB() {
        return regioB;
    }

    public void setRegioB(RegioBean regioB) {
        this.regioB = regioB;
    }

    public List<mapaBean> getListaMapa() {
        return ListaMapa;
    }

    public void setListaMapa(List<mapaBean> ListaMapa) {
        this.ListaMapa = ListaMapa;
    }

    public boolean isMensajeerror() {
        return mensajeerror;
    }

    public void setMensajeerror(boolean mensajeerror) {
        this.mensajeerror = mensajeerror;
    }

    public String getCICLO() {
        return CICLO;
    }

    public void setCICLO(String CICLO) {
        this.CICLO = CICLO;
    }

    public List<escuelasDescripcionBean> getListaDescripcionGrafProg() {
        return ListaDescripcionGrafProg;
    }

    public void setListaDescripcionGrafProg(List<escuelasDescripcionBean> ListaDescripcionGrafProg) {
        this.ListaDescripcionGrafProg = ListaDescripcionGrafProg;
    }

    public List<escuelasNacionalBean> getListaGrafNacionalProg() {
        return ListaGrafNacionalProg;
    }

    public void setListaGrafNacionalProg(List<escuelasNacionalBean> ListaGrafNacionalProg) {
        this.ListaGrafNacionalProg = ListaGrafNacionalProg;
    }

    public List<idicadoresProgBean> getListaHistoricoProg() {
        return ListaHistoricoProg;
    }

    public void setListaHistoricoProg(List<idicadoresProgBean> ListaHistoricoProg) {
        this.ListaHistoricoProg = ListaHistoricoProg;
    }

    public List<escuelasRegionBean> getListaGrafRegionProg() {
        return ListaGrafRegionProg;
    }

    public void setListaGrafRegionProg(List<escuelasRegionBean> ListaGrafRegionProg) {
        this.ListaGrafRegionProg = ListaGrafRegionProg;
    }

    public List<escuelasMunicipioBean> getListaGrafMunicipioProg() {
        return ListaGrafMunicipioProg;
    }

    public void setListaGrafMunicipioProg(List<escuelasMunicipioBean> ListaGrafMunicipioProg) {
        this.ListaGrafMunicipioProg = ListaGrafMunicipioProg;
    }

    public List<escuelasNivelBean> getListaGrafNivelProg() {
        return ListaGrafNivelProg;
    }

    public void setListaGrafNivelProg(List<escuelasNivelBean> ListaGrafNivelProg) {
        this.ListaGrafNivelProg = ListaGrafNivelProg;
    }

    public DescripcionProgBean getDesprg() {
        return desprg;
    }

    public void setDesprg(DescripcionProgBean desprg) {
        this.desprg = desprg;
    }

    public List<DescripcionProgBean> getListaDescripcionProg() {
        return ListaDescripcionProg;
    }

    public void setListaDescripcionProg(List<DescripcionProgBean> ListaDescripcionProg) {
        this.ListaDescripcionProg = ListaDescripcionProg;
    }

    public List<idicadoresProgBean> getListaIndicadoresProg() {
        return ListaIndicadoresProg;
    }

    public void setListaIndicadoresProg(List<idicadoresProgBean> ListaIndicadoresProg) {
        this.ListaIndicadoresProg = ListaIndicadoresProg;
    }

    public progApoyoBean getProg() {
        return prog;
    }

    public void setProg(progApoyoBean prog) {
        this.prog = prog;
    }

    public List<progApoyoBean> getListaMenuProg() {
        return ListaMenuProg;
    }

    public void setListaMenuProg(List<progApoyoBean> ListaMenuProg) {
        this.ListaMenuProg = ListaMenuProg;
    }

    public List<CatalogoBean> getListaBotones() {
        return ListaBotones;
    }

    public void setListaBotones(List<CatalogoBean> ListaBotones) {
        this.ListaBotones = ListaBotones;
    }

    public CatalogoBean getCat() {
        return cat;
    }

    public void setCat(CatalogoBean cat) {
        this.cat = cat;
    }

    public List<CatalogoBean> getListaComEdu() {
        return ListaComEdu;
    }

    public void setListaComEdu(List<CatalogoBean> ListaComEdu) {
        this.ListaComEdu = ListaComEdu;
    }

    public comEduBean getComedu() {
        return comedu;
    }

    public void setComedu(comEduBean comedu) {
        this.comedu = comedu;
    }

    public List<progNivelBean> getListaProgEst() {
        return ListaProgEst;
    }

    public void setListaProgEst(List<progNivelBean> ListaProgEst) {
        this.ListaProgEst = ListaProgEst;
    }

    public List<progNivelBean> getListaProgFed() {
        return ListaProgFed;
    }

    public void setListaProgFed(List<progNivelBean> ListaProgFed) {
        this.ListaProgFed = ListaProgFed;
    }

    // xxxxxxxxxxxxxxxxxxxxxSESIONxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    private usuarioBean usuariocons;
    private Map session = ActionContext.getContext().getSession();
    private String nivelUsuario;

    public void setSession(Map session) {
        this.session = session;
    }

    public Map getSession() {
        return session;
    }
    //xxxxxxxxxxxxxxxxxxxxFIN SESIONxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public String botones() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();

            regioB.setAUXTIPOPROG("");

            ListaBotones = con.consultaBotones();

            ListaCatMun = con.mapaCatMun(cat);

            ListaMapa = con.mapaTodos(cat);
            Iterator lb = ListaBotones.iterator();
            CatalogoBean obj;
            while (lb.hasNext()) {
                obj = (CatalogoBean) lb.next();

                cat.setCICLOAUX(obj.getCICLO_ESCOLAR());

                if (obj.getID_OPCION().equals("0")) {
                    cat.setNOMNIVEL(obj.getVALOR());

                }

            }

            ListaComEdu = con.consultageneralcom(cat);

            Iterator lb2 = ListaComEdu.iterator();
            comEduBean obj2;

            while (lb2.hasNext()) {
                obj2 = (comEduBean) lb2.next();

                comedu.setTOTALALUMAT(obj2.getMATRIALU().replace('.', ','));

                comedu.setTOTALDOCENTE(String.valueOf(obj2.getMATRIDOCEN().replace('.', ',')));
                comedu.setTOTALESCU(String.valueOf(obj2.getNOESC().replace('.', ',')));
                comedu.setTOTALESCPUB(String.valueOf(obj2.getESCPUB().replace('.', ',')));
                comedu.setTOTALESCPRIV(String.valueOf(obj2.getESCPRIV().replace('.', ',')));
                comedu.setFUENTE(obj2.getFUENTE());

            }

            cat.setOPCION("0");

            if (cat.getOPCION().equals("0")) {

                cat.setOPCION_NOMBRE("Todos los Niveles");

            }

            if (cat.getOPCION().equals("1")) {

                cat.setOPCION_NOMBRE("Preescolar");

            }

            if (cat.getOPCION().equals("2")) {

                cat.setOPCION_NOMBRE("Primaria");

            }

            if (cat.getOPCION().equals("3")) {

                cat.setOPCION_NOMBRE("Secundaria");

            }

            if (cat.getOPCION().equals("4")) {

                cat.setOPCION_NOMBRE("Media Superior");

            }

            if (cat.getOPCION().equals("5")) {

                cat.setOPCION_NOMBRE("Superior");

            }

            ProgramasNivel();

            //Thread.sleep(2000);
            //  REGIO TOTALES POR REGION  
            regioB.setIDREGION("17");
            ListaRegioMun = con.regioMun(regioB);

            DecimalFormat formateador = new DecimalFormat("###,###.##");

            Iterator mp = ListaRegioMun.iterator();

            RegioBean gm;

            float matricula = 0;
            float docentes = 0;
            float escuelas = 0;
            float totalRegMatricula = 0;
            float totalRegDocentes = 0;
            float totalRegEscuelas = 0;

            while (mp.hasNext()) {
                gm = (RegioBean) mp.next();

                matricula = 0;
                docentes = 0;
                escuelas = 0;

                matricula = Float.parseFloat(gm.getMATRICULA());
                docentes = Float.parseFloat(gm.getNO_DOCENTES());
                escuelas = Float.parseFloat(gm.getNO_ESCUELAS());

                gm.setMATRICULA(String.valueOf(formateador.format(matricula)));
                gm.setNO_DOCENTES(String.valueOf(formateador.format(docentes)));
                gm.setNO_ESCUELAS(String.valueOf(formateador.format(escuelas)));

                totalRegMatricula = totalRegMatricula + matricula;
                totalRegDocentes = totalRegDocentes + docentes;
                totalRegEscuelas = totalRegEscuelas + escuelas;

            }

            regioB.setTOTALREGMATRICULA(String.valueOf(formateador.format(totalRegMatricula)));

            regioB.setTOTALREGDOCENTES(String.valueOf(formateador.format(totalRegDocentes)));

            regioB.setTOTALREGESCUELAS(String.valueOf(formateador.format(totalRegEscuelas)));

            tipoProg1 = true;

            regioB.setCLAVE_MUNICIPIO("106");
            regioB.setIDREGION("17");
            System.out.println("VALOR DE INICIO DE MUNICIPIO" + cat.getCLAVE_MUNICIPIO());

            if (cat.getCLAVE_MUNICIPIO() == null) {

                System.out.println("si entro al if");
                cat.setCLAVE_MUNICIPIO(regioB.getCLAVE_MUNICIPIO());

            }

            ListaRegioGrafNiv = con.regioGrafMun(regioB);

            Iterator rgn = ListaRegioGrafNiv.iterator();

            RegioBean rg;
            float totalrgn = 0;
            int pre = 0;
            int pri = 0;
            int sec = 0;
            int ms = 0;
            int s = 0;
            int otro = 0;

            while (rgn.hasNext()) {
                rg = (RegioBean) rgn.next();

                if (rg.getCVENIV().equals("1")) {
                    pre = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("2")) {
                    pri = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("3")) {
                    sec = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("4")) {
                    ms = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("5")) {
                    s = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("6")) {
                    otro = Integer.parseInt(rg.getTOTALNIV());
                }

            }

            regioB.setPREESCOLAR(String.valueOf(formateador.format(pre)));
            regioB.setPRIMARIA(String.valueOf(formateador.format(pri)));
            regioB.setSECUNDARIA(String.valueOf(formateador.format(sec)));
            regioB.setMEDIA_SUPERIOR(String.valueOf(formateador.format(ms)));
            regioB.setSUPERIOR(String.valueOf(formateador.format(s)));
            regioB.setOTRO(String.valueOf(formateador.format(otro)));
            regioB.setTOTAL_ESCUELAS_NIV(String.valueOf(formateador.format(pre + pri + sec + ms + s + otro)));

            ListaIndicadoresPrincipal = con.indicadoresPrincipal(cat);

            Iterator LIP = ListaIndicadoresPrincipal.iterator();
            CatalogoBean LIPB;

            while (LIP.hasNext()) {
                LIPB = (CatalogoBean) LIP.next();

                if (LIPB.getCVEINDICADOR().equals("ABA")) {

                    cat.setABANDONO(LIPB.getPORCENTAJE());
                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setABANDONO_COLOR("VERDE");

                    } else {
                        cat.setABANDONO_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("ABS")) {

                    cat.setABSORCION(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setABSORCION_COLOR("VERDE");

                    } else {
                        cat.setABSORCION_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("COB")) {

                    cat.setCOBERTURA(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setCOBERTURA_COLOR("VERDE");

                    } else {
                        cat.setCOBERTURA_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("EFI")) {

                    cat.setEFICIENCIAT(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setEFICIENCIAT_COLOR("VERDE");

                    } else {
                        cat.setEFICIENCIAT_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("REP")) {

                    cat.setREPROBACION(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setREPROBACION_COLOR("VERDE");

                    } else {
                        cat.setREPROBACION_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("TNE")) {

                    cat.setTAZA(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setTAZA_COLOR("VERDE");

                    } else {
                        cat.setTAZA_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("BASICAPRINCIPAL")) {

                    cat.setBASICAPRINCIPAL(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setBASICAPRINCIPAL_COLOR("VERDE");

                    } else {
                        cat.setBASICAPRINCIPAL_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("LCPRINCIPAL")) {

                    cat.setLCPRINCIPAL(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setLCPRINCIPAL_COLOR("VERDE");

                    } else {
                        cat.setLCPRINCIPAL_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("BASICAMSUPERIOR")) {

                    cat.setBASICAMSUPERIOR(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setBASICAMSUPERIOR_COLOR("VERDE");

                    } else {
                        cat.setBASICAMSUPERIOR_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("ESCOLARIDADPRICIPAL")) {

                    cat.setESCOLARIDADPRICIPAL(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setESCOLARIDADPRICIPAL_COLOR("VERDE");

                    } else {
                        cat.setESCOLARIDADPRICIPAL_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("BASICASUPERIOR")) {

                    cat.setBASICASUPERIOR(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setBASICASUPERIOR_COLOR("VERDE");

                    } else {
                        cat.setBASICASUPERIOR_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("MATPRINCIPAL")) {

                    cat.setMATPRINCIPAL(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setMATPRINCIPAL_COLOR("VERDE");

                    } else {
                        cat.setMATPRINCIPAL_COLOR("ROJO");
                    }

                }

                if (LIPB.getCVEINDICADOR().equals("ANAPRICIPAL")) {

                    cat.setANAPRICIPAL(LIPB.getPORCENTAJE());

                    if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                        cat.setANAPRICIPAL_COLOR("VERDE");

                    } else {
                        cat.setANAPRICIPAL_COLOR("ROJO");
                    }

                }

            }

            serviciosLinea();

            Listaims = con.ims(cat);

            CatalogoBean IMCCB;

            Iterator LIMS = Listaims.iterator();

            while (LIMS.hasNext()) {
                IMCCB = (CatalogoBean) LIMS.next();

                cat.setTOTAL_ASPIRANTES(String.valueOf(formateador.format(Integer.parseInt(IMCCB.getTOTAL_ASPIRANTES()))));

                cat.setTOTAL_VALIDADOS(String.valueOf(formateador.format(Integer.parseInt(IMCCB.getTOTAL_VALIDADOS()))));

                cat.setTOTAL_NOVALIDADOS(String.valueOf(formateador.format(Integer.parseInt(IMCCB.getTOTAL_NOVALIDADOS()))));

            }

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String comunidadNivel() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            if (cat.getOPCION() == null) {
                botones();

            }

            regioB.setAUXTIPOPROG("");

            if (cat.getOPCION().equals("0")) {
                botones();

                if (cat.getOPCION().equals("0")) {

                    cat.setOPCION_NOMBRE("Todos los Niveles");

                }

                if (cat.getOPCION().equals("1")) {

                    cat.setOPCION_NOMBRE("Preescolar");

                }

                if (cat.getOPCION().equals("2")) {

                    cat.setOPCION_NOMBRE("Primaria");

                }

                if (cat.getOPCION().equals("3")) {

                    cat.setOPCION_NOMBRE("Secundaria");

                }

                if (cat.getOPCION().equals("4")) {

                    cat.setOPCION_NOMBRE("Media Superior");

                }

                if (cat.getOPCION().equals("5")) {

                    cat.setOPCION_NOMBRE("Superior");

                }
                ProgramasNivel();

                consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
                ListaIndicadoresPrincipal = con.indicadoresPrincipal(cat);

                Iterator LIP = ListaIndicadoresPrincipal.iterator();
                CatalogoBean LIPB;

                while (LIP.hasNext()) {
                    LIPB = (CatalogoBean) LIP.next();

                    if (LIPB.getCVEINDICADOR().equals("ABA")) {

                        cat.setABANDONO(LIPB.getPORCENTAJE());
                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setABANDONO_COLOR("VERDE");

                        } else {
                            cat.setABANDONO_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("ABS")) {

                        cat.setABSORCION(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setABSORCION_COLOR("VERDE");

                        } else {
                            cat.setABSORCION_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("COB")) {

                        cat.setCOBERTURA(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setCOBERTURA_COLOR("VERDE");

                        } else {
                            cat.setCOBERTURA_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("EFI")) {

                        cat.setEFICIENCIAT(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setEFICIENCIAT_COLOR("VERDE");

                        } else {
                            cat.setEFICIENCIAT_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("REP")) {

                        cat.setREPROBACION(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setREPROBACION_COLOR("VERDE");

                        } else {
                            cat.setREPROBACION_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("TNE")) {

                        cat.setTAZA(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setTAZA_COLOR("VERDE");

                        } else {
                            cat.setTAZA_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("BASICAPRINCIPAL")) {

                        cat.setBASICAPRINCIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setBASICAPRINCIPAL_COLOR("VERDE");

                        } else {
                            cat.setBASICAPRINCIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("LCPRINCIPAL")) {

                        cat.setLCPRINCIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setLCPRINCIPAL_COLOR("VERDE");

                        } else {
                            cat.setLCPRINCIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("BASICAMSUPERIOR")) {

                        cat.setBASICAMSUPERIOR(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setBASICAMSUPERIOR_COLOR("VERDE");

                        } else {
                            cat.setBASICAMSUPERIOR_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("ESCOLARIDADPRICIPAL")) {

                        cat.setESCOLARIDADPRICIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setESCOLARIDADPRICIPAL_COLOR("VERDE");

                        } else {
                            cat.setESCOLARIDADPRICIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("BASICASUPERIOR")) {

                        cat.setBASICASUPERIOR(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setBASICASUPERIOR_COLOR("VERDE");

                        } else {
                            cat.setBASICASUPERIOR_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("MATPRINCIPAL")) {

                        cat.setMATPRINCIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setMATPRINCIPAL_COLOR("VERDE");

                        } else {
                            cat.setMATPRINCIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("ANAPRICIPAL")) {

                        cat.setANAPRICIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setANAPRICIPAL_COLOR("VERDE");

                        } else {
                            cat.setANAPRICIPAL_COLOR("ROJO");
                        }

                    }
                }

            } else {
                consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();

                Iterator LB = ListaBotones.iterator();
                CatalogoBean obj;

                while (LB.hasNext()) {
                    obj = (CatalogoBean) LB.next();

                    if (cat.getOPCION().equals(obj.getID_OPCION())) {
                        cat.setNOMNIVEL(obj.getVALOR());
                    }

                }

                ListaComEdu = con.comunidadNivel(cat);

                //System.out.println("lista de nivel" + ListaComEdu.size());
                Iterator lb2 = ListaComEdu.iterator();
                comEduBean obj2;
                float totalalu = 0;
                int totaldecen = 0;
                int totalesc = 0;
                int totalescpub = 0;
                int totalpriv = 0;
                String fuente = "";
                DecimalFormat formateador = new DecimalFormat("###,###.##");

                while (lb2.hasNext()) {
                    obj2 = (comEduBean) lb2.next();
                    //System.out.println("entro a la lista");
                    //System.out.println("Matricula alu" + Integer.parseInt(obj2.getMATRIALU()));

                    totalalu = totalalu + Float.parseFloat(obj2.getMATRIALU());
                    totaldecen = totaldecen + Integer.parseInt(obj2.getMATRIDOCEN());
                    totalesc = totalesc + Integer.parseInt(obj2.getNOESC());
                    totalescpub = totalescpub + Integer.parseInt(obj2.getESCPUB());
                    totalpriv = totalpriv + Integer.parseInt(obj2.getESCPRIV());
                    fuente = fuente + "\t" + obj2.getFUENTE();
                    //System.out.println("salio de la lista");
                }

                comedu.setTOTALALUMAT(String.valueOf(formateador.format(totalalu)));
                comedu.setTOTALDOCENTE(String.valueOf(formateador.format(totaldecen)));
                comedu.setTOTALESCU(String.valueOf(formateador.format(totalesc)));
                comedu.setTOTALESCPUB(String.valueOf(formateador.format(totalescpub)));
                comedu.setTOTALESCPRIV(String.valueOf(formateador.format(totalpriv)));
                comedu.setFUENTE(fuente);

                //System.out.println(totalalu);
                //System.out.println(ListaBotones.size());
                //System.out.println(ListaComEdu.size());
                if (cat.getOPCION().equals("0")) {

                    cat.setOPCION_NOMBRE("Todos los Niveles");

                }

                if (cat.getOPCION().equals("1")) {

                    cat.setOPCION_NOMBRE("Preescolar");

                }

                if (cat.getOPCION().equals("2")) {

                    cat.setOPCION_NOMBRE("Primaria");

                }

                if (cat.getOPCION().equals("3")) {

                    cat.setOPCION_NOMBRE("Secundaria");

                }

                if (cat.getOPCION().equals("4")) {

                    cat.setOPCION_NOMBRE("Media Superior");

                }

                if (cat.getOPCION().equals("5")) {

                    cat.setOPCION_NOMBRE("Superior");

                }

                ProgramasNivel();

                Listaims = con.ims(cat);

                CatalogoBean IMCCB;

                Iterator LIMS = Listaims.iterator();

                while (LIMS.hasNext()) {
                    IMCCB = (CatalogoBean) LIMS.next();

                    cat.setTOTAL_ASPIRANTES(String.valueOf(formateador.format(Integer.parseInt(IMCCB.getTOTAL_ASPIRANTES()))));

                    cat.setTOTAL_VALIDADOS(String.valueOf(formateador.format(Integer.parseInt(IMCCB.getTOTAL_VALIDADOS()))));

                    cat.setTOTAL_NOVALIDADOS(String.valueOf(formateador.format(Integer.parseInt(IMCCB.getTOTAL_NOVALIDADOS()))));

                }

                // ListaMapa = con.mapa(cat);
                ListaIndicadoresPrincipal = con.indicadoresPrincipal(cat);

                Iterator LIP = ListaIndicadoresPrincipal.iterator();
                CatalogoBean LIPB;

                while (LIP.hasNext()) {
                    LIPB = (CatalogoBean) LIP.next();

                    if (LIPB.getCVEINDICADOR().equals("ABA")) {

                        cat.setABANDONO(LIPB.getPORCENTAJE());
                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setABANDONO_COLOR("VERDE");

                        } else {
                            cat.setABANDONO_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("ABS")) {

                        cat.setABSORCION(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setABSORCION_COLOR("VERDE");

                        } else {
                            cat.setABSORCION_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("COB")) {

                        cat.setCOBERTURA(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setCOBERTURA_COLOR("VERDE");

                        } else {
                            cat.setCOBERTURA_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("EFI")) {

                        cat.setEFICIENCIAT(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setEFICIENCIAT_COLOR("VERDE");

                        } else {
                            cat.setEFICIENCIAT_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("REP")) {

                        cat.setREPROBACION(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setREPROBACION_COLOR("VERDE");

                        } else {
                            cat.setREPROBACION_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("TNE")) {

                        cat.setTAZA(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setTAZA_COLOR("VERDE");

                        } else {
                            cat.setTAZA_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("BASICAPRINCIPAL")) {

                        cat.setBASICAPRINCIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setBASICAPRINCIPAL_COLOR("VERDE");

                        } else {
                            cat.setBASICAPRINCIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("LCPRINCIPAL")) {

                        cat.setLCPRINCIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setLCPRINCIPAL_COLOR("VERDE");

                        } else {
                            cat.setLCPRINCIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("BASICAMSUPERIOR")) {

                        cat.setBASICAMSUPERIOR(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setBASICAMSUPERIOR_COLOR("VERDE");

                        } else {
                            cat.setBASICAMSUPERIOR_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("ESCOLARIDADPRICIPAL")) {

                        cat.setESCOLARIDADPRICIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setESCOLARIDADPRICIPAL_COLOR("VERDE");

                        } else {
                            cat.setESCOLARIDADPRICIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("BASICASUPERIOR")) {

                        cat.setBASICASUPERIOR(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setBASICASUPERIOR_COLOR("VERDE");

                        } else {
                            cat.setBASICASUPERIOR_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("MATPRINCIPAL")) {

                        cat.setMATPRINCIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setMATPRINCIPAL_COLOR("VERDE");

                        } else {
                            cat.setMATPRINCIPAL_COLOR("ROJO");
                        }

                    }

                    if (LIPB.getCVEINDICADOR().equals("ANAPRICIPAL")) {

                        cat.setANAPRICIPAL(LIPB.getPORCENTAJE());

                        if (Float.parseFloat(LIPB.getDIFERENCIA()) > 0) {

                            cat.setANAPRICIPAL_COLOR("VERDE");

                        } else {
                            cat.setANAPRICIPAL_COLOR("ROJO");
                        }

                    }
                }

            }
            serviciosLinea();
            impactoGet();

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String ProgramasNivel() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            //System.out.println("El VALOR DE OPCION ES " + cat.getOPCION());
            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();

            regioB.setAUXTIPOPROG("");

            //Thread.sleep(2000);
            if (cat.getOPCION().equals("0")) {

                //System.out.println("ENTRO A LA LISTA DE TODOS LOS PROGRAMAS");
                ListaProgEst = con.graficaProgNivelEstTodo(cat);

                Iterator LPE = ListaProgEst.iterator();
                progNivelBean obj;
                String cadena = "";
                while (LPE.hasNext()) {
                    obj = (progNivelBean) LPE.next();

                    cadena = limpiarAcentos(obj.getNOMBRE_PROGRAMA());
                    //System.out.println("cadena recibida: " + cadena);
                    obj.setNOMBRE_PROGRAMA(cadena);

                }

                //System.out.println("action.PantallaPrincipal_Action.ProgramasNivel()" + ListaProgEst.size());
                ListaProgFed = con.graficaProgNivelFedTodo(cat);
                Iterator LPF = ListaProgFed.iterator();
                progNivelBean obj2;
                String acento = "";
                while (LPF.hasNext()) {
                    obj2 = (progNivelBean) LPF.next();

                    acento = limpiarAcentos(obj2.getNOMBRE_PROGRAMA());
                    obj2.setNOMBRE_PROGRAMA(acento);
                    //System.out.println("RESULTADO DE CAMBIO DE ACENTOS: " + acento);

                }
                //            ListaMapa.clear();
                //            ListaMapa = con.mapaTodos(cat);
//                Thread.sleep(2000);

                if (cat.getCLAVE_MUNICIPIO().length() == 0) {
                    System.out.println("Si  entre &&&&&&&&&&");
                    ListaMapa = con.mapaTodos(cat);
                } else {
                    System.out.println("Si  entre al else" + cat.getCLAVE_MUNICIPIO());
                    ListaMapa = con.mapaMunTodos(cat);
                }

            } else {

                ListaProgEst = con.graficaProgNivelEst(cat);

                Iterator LPE = ListaProgEst.iterator();
                progNivelBean obj;
                String cadena = "";
                while (LPE.hasNext()) {
                    obj = (progNivelBean) LPE.next();

                    cadena = limpiarAcentos(obj.getNOMBRE_PROGRAMA());
                    //System.out.println("cadena recibida: " + cadena);
                    obj.setNOMBRE_PROGRAMA(cadena);

                }

                //System.out.println("action.PantallaPrincipal_Action.ProgramasNivel()" + ListaProgEst.size());
                ListaProgFed = con.graficaProgNivelFed(cat);

                Iterator LPF = ListaProgFed.iterator();
                progNivelBean obj2;
                String acento = "";
                while (LPF.hasNext()) {
                    obj2 = (progNivelBean) LPF.next();

                    acento = limpiarAcentos(obj2.getNOMBRE_PROGRAMA());
                    obj2.setNOMBRE_PROGRAMA(acento);
                    //System.out.println("RESULTADO DE CAMBIO DE ACENTOS: " + acento);

                }

                if (cat.getCLAVE_MUNICIPIO().length() == 0) {
                    System.out.println("Si  entre &&&&&&&&&&");
                    ListaMapa = con.mapa(cat);
                } else {
                    System.out.println("Si  entre al else" + cat.getCLAVE_MUNICIPIO());
                    ListaMapa = con.mapaMun(cat);
                }

            }
            serviciosLinea();
            impactoGet();

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String menuProgyApoyo() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            //System.out.println("EL TIPO DE PROGRAMA ES:" + cat.getTIPO_PROGRAMA());
            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            ListaMenuProg = con.progApoyoMenu(cat);

            if (ListaMenuProg.size() < 1) {
                ListaMenuProg = con.progApoyoMenuTodos(cat);
            }

            if (ListaMenuProg.size() > 0) {

                ListaIndicadoresProg = con.indicadoresProg(cat);

                System.out.println("tamaño de lista indicadores" + ListaIndicadoresProg.size());

                for (int i = 0; i < ListaMenuProg.size(); i++) {

                    cat.setID_PROGRAMA(ListaMenuProg.get(i).getID_PROGRAMA());
                    prog.setNOMBRE_PROGRAMA(ListaMenuProg.get(i).getNOMBRE_PROGRAMA());
                    prog.setNOMBRE_PROGRAMA_GRAFICA(limpiarAcentos(ListaMenuProg.get(i).getNOMBRE_PROGRAMA()));

                    break;

                }
                CICLO = con.ConsultaCiclo(cat);
                System.out.println("***********************CICLO ESCOLAR: " + CICLO);
                DecimalFormat formateador = new DecimalFormat("###,###.##");

                float no_alu = 0;
                float no_mun = 0;
                float no_esc = 0;
                float no_inv = 0;

                for (int i = 0; i < ListaIndicadoresProg.size(); i++) {

                    if (cat.getID_PROGRAMA().equals(ListaIndicadoresProg.get(i).getID_PROGRAMA()) && CICLO.equals(ListaIndicadoresProg.get(i).getCICLO_ESCOLAR())) {

                        no_alu = Float.parseFloat(ListaIndicadoresProg.get(i).getNO_ALUMNOS());
                        no_mun = Float.parseFloat(ListaIndicadoresProg.get(i).getNO_MUNIICIPIOS());
                        no_esc = Float.parseFloat(ListaIndicadoresProg.get(i).getNO_ESCUELAS());
                        no_inv = Float.parseFloat(ListaIndicadoresProg.get(i).getINVERSION());

                        prog.setNOTA(ListaIndicadoresProg.get(i).getNOTA());

                        prog.setNO_ALUMNOS(String.valueOf(formateador.format(no_alu)));
                        prog.setMUNICIPIOS(String.valueOf(formateador.format(no_mun)));
                        prog.setNO_ESC_PROG(String.valueOf(formateador.format(no_esc)));
                        prog.setINVERSION(String.valueOf(formateador.format(no_inv)));

                    }

                }

                prog.setID_PROGRAMA(cat.getID_PROGRAMA());
                prog.setCICLO_ESCOLAR(cat.getCICLOAUX());

                ListaDescripcionProg = con.DescripcionProg(prog);

                //System.out.println("si salio de la consulta");
                Iterator datosprog = ListaDescripcionProg.iterator();

                DescripcionProgBean obj;

                while (datosprog.hasNext()) {

                    obj = (DescripcionProgBean) datosprog.next();

                    if (obj.getOBJETIVO().length() > 201) {
                        desprg.setOBJETIVO_CORTO(obj.getOBJETIVO().substring(0, 200));
                    } else {
                        desprg.setOBJETIVO_CORTO(obj.getOBJETIVO());
                    }
                    if (obj.getALCANCE().length() > 51) {
                        desprg.setALCANCE_CORTO(obj.getALCANCE().substring(0, 50));
                    } else {
                        desprg.setALCANCE_CORTO(obj.getALCANCE());
                    }

                    desprg.setOBJETIVO(obj.getOBJETIVO());
                    desprg.setALCANCE(obj.getALCANCE());

                    desprg.setPERIODO(obj.getPERIODO());

                    //System.out.println("si paso");
                    desprg.setMONTO_APOYO(obj.getMONTO_APOYO());
                    desprg.setDESCRIPCION_APOYO(obj.getDESCRIPCION_APOYO());
                    desprg.setNORMATIVIDAD(obj.getNORMATIVIDAD());
                    desprg.setCICLO_ESCOLAR(obj.getCICLO_ESCOLAR());
                    desprg.setLISTA_DOC(obj.getLISTA_DOC());
                    desprg.setINFO_DOC(obj.getINFO_DOC());
                    desprg.setREGLAS_DOC(obj.getREGLAS_DOC());

                }

                ListaGrafNivelProg = con.grafNivelProg(prog);

                ListaGrafMunicipioProg = con.grafMunicipioProg(prog);

                Iterator mp = ListaGrafMunicipioProg.iterator();

                escuelasMunicipioBean gm;

                int cvem = 0;

                while (mp.hasNext()) {
                    gm = (escuelasMunicipioBean) mp.next();
                    ++cvem;
                    gm.setCVEMUNICIPIO(String.valueOf(cvem));

                }

                ListaGrafRegionProg = con.grafRegionProg(prog);

                Iterator lgr = ListaGrafRegionProg.iterator();

                escuelasRegionBean reg;

                while (lgr.hasNext()) {
                    reg = (escuelasRegionBean) lgr.next();
                    reg.setNOMBRE_REGION(limpiarAcentos(reg.getNOMBRE_REGION()));

                }

                ListaHistoricoProg = con.indicadoresHistoriaProg(cat);

                ListaGrafNacionalProg = con.grafNacionalProg(prog);
                Iterator lgn = ListaGrafNacionalProg.iterator();

                escuelasNacionalBean nat;

                while (lgn.hasNext()) {
                    nat = (escuelasNacionalBean) lgn.next();
                    nat.setNOMBRE_ESTADO(limpiarAcentos(nat.getNOMBRE_ESTADO()));

                }

                ListaDescripcionGrafProg = con.descripcionProg(prog);

                Iterator datosDescrip = ListaDescripcionGrafProg.iterator();

                escuelasDescripcionBean obj2;
                while (datosDescrip.hasNext()) {

                    obj2 = (escuelasDescripcionBean) datosDescrip.next();

                    if (obj2.getDESCRIPCION_NIVEL().length() > 65) {
                        desprg.setDESCRIPCION_NIVEL(obj2.getDESCRIPCION_NIVEL().substring(0, 65));
                    } else {
                        desprg.setDESCRIPCION_NIVEL(obj2.getDESCRIPCION_NIVEL());
                    }

                    if (obj2.getDESCRIPCION_HISTORICO().length() > 60) {
                        desprg.setDESCRIPCION_HISTORICO(obj2.getDESCRIPCION_HISTORICO().substring(0, 60));
                    } else {
                        desprg.setDESCRIPCION_HISTORICO(obj2.getDESCRIPCION_HISTORICO());
                    }

                    if (obj2.getDESCRIPCION_MUNICIPIO().length() > 60) {
                        desprg.setDESCRIPCION_MUNICIPIO(obj2.getDESCRIPCION_MUNICIPIO().substring(0, 60));
                    } else {
                        desprg.setDESCRIPCION_MUNICIPIO(obj2.getDESCRIPCION_MUNICIPIO());
                    }

                    if (obj2.getDESCRIPCION_REGION().length() > 65) {
                        desprg.setDESCRIPCION_REGION(obj2.getDESCRIPCION_REGION().substring(0, 65));
                    } else {
                        desprg.setDESCRIPCION_REGION(obj2.getDESCRIPCION_REGION());
                    }

                    if (obj2.getDESCRIPCION_NACIONAL().length() > 120) {
                        desprg.setDESCRIPCION_NACIONAL(obj2.getDESCRIPCION_NACIONAL().substring(0, 120));
                    } else {
                        desprg.setDESCRIPCION_NACIONAL(obj2.getDESCRIPCION_NACIONAL());
                    }

                }

                //System.out.println("corto////////////" + desprg.getOBJETIVO_CORTO());
                //System.out.println("largo???????????" + desprg.getOBJETIVO());
            } else {
                comunidadNivel();
                mensajeerror = true;
                //System.out.println("<script>alert('hola');</script>");
                return "ERROR";

            }

            serviciosLinea();
            impactoGet();

            //ListaMenuProg = con.progApoyoInicial(cat);
        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String menuProgyApoyoSelect() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            //System.out.println("EL TIPO DE PROGRAMA ES:" + cat.getTIPO_PROGRAMA());
            //System.out.println("EL id DE PROGRAMA ES:" + cat.getID_PROGRAMA());
            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            ListaIndicadoresProg = con.indicadoresProg(cat);

            prog.setID_PROGRAMA(cat.getID_PROGRAMA());
            prog.setCICLO_ESCOLAR(cat.getCICLOAUX());

            CICLO = con.ConsultaCiclo(cat);
            //System.out.println("***********************CICLO ESCOLAR SELECT: " + CICLO);

            for (int i = 0; i < ListaMenuProg.size(); i++) {

                if (prog.getID_PROGRAMA().equals(ListaMenuProg.get(i).getID_PROGRAMA())) {
                    //cat.setID_PROGRAMA(ListaMenuProg.get(i).getID_PROGRAMA());
                    prog.setNOMBRE_PROGRAMA(ListaMenuProg.get(i).getNOMBRE_PROGRAMA());
                    prog.setNOMBRE_PROGRAMA_GRAFICA(limpiarAcentos(ListaMenuProg.get(i).getNOMBRE_PROGRAMA()));
                    break;

                }

            }
            DecimalFormat formateador = new DecimalFormat("###,###.##");

            float no_alu = 0;
            float no_mun = 0;
            float no_esc = 0;
            float no_inv = 0;

            for (int i = 0; i < ListaIndicadoresProg.size(); i++) {

                if (prog.getID_PROGRAMA().equals(ListaIndicadoresProg.get(i).getID_PROGRAMA()) && CICLO.equals(ListaIndicadoresProg.get(i).getCICLO_ESCOLAR())) {

                    //System.out.println("si encontre el mismo/////////////////////////");
                    no_alu = Float.parseFloat(ListaIndicadoresProg.get(i).getNO_ALUMNOS());
                    no_mun = Float.parseFloat(ListaIndicadoresProg.get(i).getNO_MUNIICIPIOS());
                    no_esc = Float.parseFloat(ListaIndicadoresProg.get(i).getNO_ESCUELAS());
                    no_inv = Float.parseFloat(ListaIndicadoresProg.get(i).getINVERSION());
                    prog.setNOTA(ListaIndicadoresProg.get(i).getNOTA());

                    prog.setNO_ALUMNOS(String.valueOf(formateador.format(no_alu)));
                    prog.setMUNICIPIOS(String.valueOf(formateador.format(no_mun)));
                    prog.setNO_ESC_PROG(String.valueOf(formateador.format(no_esc)));
                    prog.setINVERSION(String.valueOf(formateador.format(no_inv)));

                    // prog.setNO_ESC_PROG(ListaIndicadoresProg.get(i).getNO_ESCUELAS());
                    // prog.setMUNICIPIOS(ListaIndicadoresProg.get(i).getNO_MUNIICIPIOS());
                    // prog.setINVERSION(ListaIndicadoresProg.get(i).getINVERSION());
                    break;

                }

            }

            ListaDescripcionProg = con.DescripcionProg(prog);

            Iterator datosprog = ListaDescripcionProg.iterator();

            DescripcionProgBean obj;

            while (datosprog.hasNext()) {
                obj = (DescripcionProgBean) datosprog.next();

                if (obj.getOBJETIVO().length() > 201) {
                    desprg.setOBJETIVO_CORTO(obj.getOBJETIVO().substring(0, 200));
                } else {
                    desprg.setOBJETIVO_CORTO(obj.getOBJETIVO());
                }
                if (obj.getALCANCE().length() > 51) {
                    desprg.setALCANCE_CORTO(obj.getALCANCE().substring(0, 50));
                } else {
                    desprg.setALCANCE_CORTO(obj.getALCANCE());
                }

                desprg.setOBJETIVO(obj.getOBJETIVO());
                desprg.setALCANCE(obj.getALCANCE());

                desprg.setPERIODO(obj.getPERIODO());
                desprg.setMONTO_APOYO(obj.getMONTO_APOYO());
                desprg.setDESCRIPCION_APOYO(obj.getDESCRIPCION_APOYO());
                desprg.setNORMATIVIDAD(obj.getNORMATIVIDAD());
                desprg.setCICLO_ESCOLAR(obj.getCICLO_ESCOLAR());
                desprg.setLISTA_DOC(obj.getLISTA_DOC());
                desprg.setINFO_DOC(obj.getINFO_DOC());
                desprg.setREGLAS_DOC(obj.getREGLAS_DOC());

            }

            ListaGrafNivelProg = con.grafNivelProg(prog);

            ListaGrafMunicipioProg = con.grafMunicipioProg(prog);

            Iterator mp = ListaGrafMunicipioProg.iterator();

            escuelasMunicipioBean gm;

            int cvem = 0;

            while (mp.hasNext()) {
                gm = (escuelasMunicipioBean) mp.next();
                ++cvem;
                gm.setCVEMUNICIPIO(String.valueOf(cvem));

            }

            ListaGrafRegionProg = con.grafRegionProg(prog);

            Iterator lgr = ListaGrafRegionProg.iterator();

            escuelasRegionBean reg;

            while (lgr.hasNext()) {
                reg = (escuelasRegionBean) lgr.next();
                reg.setNOMBRE_REGION(limpiarAcentos(reg.getNOMBRE_REGION()));
                System.out.println("a" + reg.getNOMBRE_REGION());
            }

            ListaHistoricoProg = con.indicadoresHistoriaProg(cat);

            ListaGrafNacionalProg = con.grafNacionalProg(prog);

            Iterator lgn = ListaGrafNacionalProg.iterator();

            escuelasNacionalBean nat;

            while (lgn.hasNext()) {
                nat = (escuelasNacionalBean) lgn.next();
                nat.setNOMBRE_ESTADO(limpiarAcentos(nat.getNOMBRE_ESTADO()));
                System.out.println("Nombre Estado++++++++++++++++" + nat.getNOMBRE_ESTADO());
            }

            ListaDescripcionGrafProg = con.descripcionProg(prog);

            if (ListaDescripcionGrafProg.size() > 0) {

                Iterator datosDescrip = ListaDescripcionGrafProg.iterator();

                escuelasDescripcionBean obj2;
                while (datosDescrip.hasNext()) {
                    //System.out.println("si entre al while");
                    obj2 = (escuelasDescripcionBean) datosDescrip.next();

                    if (obj2.getDESCRIPCION_NIVEL().length() > 65) {
                        desprg.setDESCRIPCION_NIVEL(obj2.getDESCRIPCION_NIVEL().substring(0, 65));
                    } else {
                        desprg.setDESCRIPCION_NIVEL(obj2.getDESCRIPCION_NIVEL());
                    }

                    if (obj2.getDESCRIPCION_HISTORICO().length() > 60) {
                        desprg.setDESCRIPCION_HISTORICO(obj2.getDESCRIPCION_HISTORICO().substring(0, 60));
                    } else {
                        desprg.setDESCRIPCION_HISTORICO(obj2.getDESCRIPCION_HISTORICO());
                    }

                    if (obj2.getDESCRIPCION_MUNICIPIO().length() > 60) {
                        desprg.setDESCRIPCION_MUNICIPIO(obj2.getDESCRIPCION_MUNICIPIO().substring(0, 60));
                    } else {
                        desprg.setDESCRIPCION_MUNICIPIO(obj2.getDESCRIPCION_MUNICIPIO());
                    }

                    if (obj2.getDESCRIPCION_REGION().length() > 65) {
                        desprg.setDESCRIPCION_REGION(obj2.getDESCRIPCION_REGION().substring(0, 65));
                    } else {
                        desprg.setDESCRIPCION_REGION(obj2.getDESCRIPCION_REGION());
                    }

                    if (obj2.getDESCRIPCION_NACIONAL().length() > 120) {
                        desprg.setDESCRIPCION_NACIONAL(obj2.getDESCRIPCION_NACIONAL().substring(0, 120));
                    } else {
                        desprg.setDESCRIPCION_NACIONAL(obj2.getDESCRIPCION_NACIONAL());
                    }

                }
            }

            //System.out.println(" si llego aqui");
            //ListaMenuProg = con.progApoyoInicial(cat);
        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public static String limpiarAcentos(String cadena) {

        if (cadena != null) {

            String original = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
            // Cadena de caracteres ASCII que reemplazarán los originales.

            String valor1 = "";
            String valor2 = "";

            for (int o = 0; o < original.length(); o++) {

                valor1 = original.substring(o, o + 1);
                //System.out.println("////////////////////valor1 "+o+" "+valor1);

                for (int i = 0; i < cadena.length(); i++) {

                    valor2 = cadena.substring(i, i + 1);
                    //System.out.println("valor2 "+i+" "+valor2);

                    if (valor1.equals(valor2)) {

                        if (valor2.equals("á")) {
                            cadena = cadena.replace(valor2, "\\u00E1");

                        } else if (valor2.equals("é")) {
                            cadena = cadena.replace(valor2, "\\u00E9");

                        } else if (valor2.equals("í")) {
                            cadena = cadena.replace(valor2, "\\u00ED");

                        } else if (valor2.equals("ó")) {
                            cadena = cadena.replace(valor2, "\\u00F3");

                        } else if (valor2.equals("ú")) {
                            cadena = cadena.replace(valor2, "\\u00FA");

                        } else if (valor2.equals("ñ")) {
                            cadena = cadena.replace(valor2, "\\u00F1");

                        } else if (valor2.equals("Á")) {
                            cadena = cadena.replace(valor2, "\\u00C1");

                        } else if (valor2.equals("É")) {
                            cadena = cadena.replace(valor2, "\\u00C9");

                        } else if (valor2.equals("Í")) {
                            cadena = cadena.replace(valor2, "\\u00CD");

                        } else if (valor2.equals("Ó")) {
                            cadena = cadena.replace(valor2, "\\u00D3");

                        } else if (valor2.equals("Ú")) {
                            cadena = cadena.replace(valor2, "\\u00DA");

                        } else if (valor2.equals("Ñ")) {
                            cadena = cadena.replace(valor2, "\\u00D1");

                        }

                    }

                }
            }

            //System.out.println("cadena" + cadena);
        }
        return cadena;
    }

    public String regio() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();

            ListaMenuRegio = con.menuRegio(regioB);

            regioB.setIDREGION("17");

            regioB.setNOMREGION("XVII Toluca");

            ListaRegioMun = con.regioMun(regioB);

            DecimalFormat formateador = new DecimalFormat("###,###.##");
            String nomregion = "";

            Iterator mp = ListaRegioMun.iterator();

            RegioBean gm;

            float matricula = 0;
            float docentes = 0;
            float escuelas = 0;
            float totalRegMatricula = 0;
            float totalRegDocentes = 0;
            float totalRegEscuelas = 0;

            while (mp.hasNext()) {
                gm = (RegioBean) mp.next();

                matricula = 0;
                docentes = 0;
                escuelas = 0;

                matricula = Float.parseFloat(gm.getMATRICULA());
                docentes = Float.parseFloat(gm.getNO_DOCENTES());
                escuelas = Float.parseFloat(gm.getNO_ESCUELAS());

                gm.setMATRICULA(String.valueOf(formateador.format(matricula)));
                gm.setNO_DOCENTES(String.valueOf(formateador.format(docentes)));
                gm.setNO_ESCUELAS(String.valueOf(formateador.format(escuelas)));

                totalRegMatricula = totalRegMatricula + matricula;
                totalRegDocentes = totalRegDocentes + docentes;
                totalRegEscuelas = totalRegEscuelas + escuelas;

            }
            System.out.println("Region" + nomregion);

            regioB.setTOTALREGMATRICULA(String.valueOf(formateador.format(totalRegMatricula)));

            regioB.setTOTALREGDOCENTES(String.valueOf(formateador.format(totalRegDocentes)));

            regioB.setTOTALREGESCUELAS(String.valueOf(formateador.format(totalRegEscuelas)));

            regioB.setCLAVE_MUNICIPIO(ListaRegioMun.get(0).getCLAVE_MUNICIPIO());
            regioB.setMUNICIPIO(ListaRegioMun.get(0).getMUNICIPIO());

            ListaRegioGrafNiv = con.regioGrafMun(regioB);

            Iterator rgn = ListaRegioGrafNiv.iterator();

            RegioBean rg;
            float totalrgn = 0;

            while (rgn.hasNext()) {
                rg = (RegioBean) rgn.next();

                totalrgn = totalrgn + Float.parseFloat(rg.getTOTALNIV());

                rg.setRECURSOS(String.valueOf(formateador.format(totalrgn)));

            }

            regioB.setNO_ESCUELAS(String.valueOf(formateador.format(totalrgn)));

            regioB.setCICLOAUX(cat.getCICLOAUX());

            ListaRegioInf = con.regioHistInf(regioB);

            ListaRegioInfCiclo = con.regioHistInfCiclo(regioB);

            Iterator infCiclo = ListaRegioInfCiclo.iterator();

            RegioBean infC;

            while (infCiclo.hasNext()) {
                infC = (RegioBean) infCiclo.next();

                if (infC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    infC.setDESCRIPCION_PROGRAMA(infC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    infC.setDESCRIPCION_PROGRAMA(infC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROG("");
            Iterator rinf = ListaRegioInf.iterator();

            RegioBean ri;
            double totalRInf = 0;
            double Recursos = 0;
            while (rinf.hasNext()) {
                ri = (RegioBean) rinf.next();

                totalRInf = totalRInf + Double.parseDouble(ri.getRECURSOS());
                Recursos = Double.parseDouble(ri.getRECURSOS());
                ri.setRECURSOS(String.valueOf(formateador.format(Recursos)));

                System.out.println("el total es total-------" + totalRInf);
                System.out.println("el total es -----------" + Recursos);

            }

            regioB.setTOTALTIPOPROG(String.valueOf(formateador.format(totalRInf)));

            System.out.println("el total es -----------" + regioB.getTOTALTIPOPROG());

            ListaRegioEC = con.regioHistEC(regioB);
            ListaRegioECCiclo = con.regioHistECCiclo(regioB);

            Iterator EcCiclo = ListaRegioECCiclo.iterator();

            RegioBean ECC;

            while (EcCiclo.hasNext()) {
                ECC = (RegioBean) EcCiclo.next();

                if (ECC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    ECC.setDESCRIPCION_PROGRAMA(ECC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    ECC.setDESCRIPCION_PROGRAMA(ECC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROGEC("");

            Iterator rinfec = ListaRegioEC.iterator();

            RegioBean riec;
            double totalRInfec = 0;
            double Recursosec = 0;
            while (rinfec.hasNext()) {
                riec = (RegioBean) rinfec.next();

                Recursosec = 0;
                totalRInfec = totalRInfec + Double.parseDouble(riec.getRECURSOS());
                Recursosec = Double.parseDouble(riec.getRECURSOS());
                riec.setRECURSOS(String.valueOf(formateador.format(Recursosec)));

            }

            regioB.setTOTALTIPOPROGEC(String.valueOf(formateador.format(totalRInfec)));

            ListaRegioEE = con.regioHistEE(regioB);
            ListaRegioEECiclo = con.regioHistEECiclo(regioB);

            Iterator EECiclo = ListaRegioEECiclo.iterator();

            RegioBean EEC;

            while (EECiclo.hasNext()) {
                EEC = (RegioBean) EECiclo.next();

                if (EEC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    EEC.setDESCRIPCION_PROGRAMA(EEC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    EEC.setDESCRIPCION_PROGRAMA(EEC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROGEE("");

            Iterator rinfee = ListaRegioEE.iterator();

            RegioBean riee;
            double totalRInfee = 0;
            double Recursosee = 0;
            while (rinfee.hasNext()) {
                riee = (RegioBean) rinfee.next();

                Recursosee = 0;
                totalRInfee = totalRInfee + Double.parseDouble(riee.getRECURSOS());
                Recursosee = Double.parseDouble(riee.getRECURSOS());
                riee.setRECURSOS(String.valueOf(formateador.format(Recursosee)));

            }

            regioB.setTOTALTIPOPROGEE(String.valueOf(formateador.format(totalRInfee)));

            tipoProg1 = false;
            tipoProg2 = false;
            tipoProg3 = true;

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String regioSelect() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();

            ListaMenuRegio = con.menuRegio(regioB);

            ListaRegioMun = con.regioMun(regioB);

            DecimalFormat formateador = new DecimalFormat("###,###.##");
            String nomregion = "";

            Iterator mp = ListaRegioMun.iterator();

            RegioBean gm;

            float matricula = 0;
            float docentes = 0;
            float escuelas = 0;
            float totalRegMatricula = 0;
            float totalRegDocentes = 0;
            float totalRegEscuelas = 0;

            while (mp.hasNext()) {
                gm = (RegioBean) mp.next();

                matricula = 0;
                docentes = 0;
                escuelas = 0;

                matricula = Float.parseFloat(gm.getMATRICULA());
                docentes = Float.parseFloat(gm.getNO_DOCENTES());
                escuelas = Float.parseFloat(gm.getNO_ESCUELAS());

                gm.setMATRICULA(String.valueOf(formateador.format(matricula)));
                gm.setNO_DOCENTES(String.valueOf(formateador.format(docentes)));
                gm.setNO_ESCUELAS(String.valueOf(formateador.format(escuelas)));

                totalRegMatricula = totalRegMatricula + matricula;
                totalRegDocentes = totalRegDocentes + docentes;
                totalRegEscuelas = totalRegEscuelas + escuelas;

            }
            System.out.println("Region" + nomregion);

            regioB.setTOTALREGMATRICULA(String.valueOf(formateador.format(totalRegMatricula)));

            regioB.setTOTALREGDOCENTES(String.valueOf(formateador.format(totalRegDocentes)));

            regioB.setTOTALREGESCUELAS(String.valueOf(formateador.format(totalRegEscuelas)));

            regioB.setCLAVE_MUNICIPIO(ListaRegioMun.get(0).getCLAVE_MUNICIPIO());
            regioB.setMUNICIPIO(ListaRegioMun.get(0).getMUNICIPIO());

            ListaRegioGrafNiv = con.regioGrafMun(regioB);

            Iterator rgn = ListaRegioGrafNiv.iterator();

            RegioBean rg;
            float totalrgn = 0;

            while (rgn.hasNext()) {
                rg = (RegioBean) rgn.next();

                totalrgn = totalrgn + Float.parseFloat(rg.getTOTALNIV());

                rg.setRECURSOS(String.valueOf(formateador.format(totalrgn)));

            }

            regioB.setNO_ESCUELAS(String.valueOf(formateador.format(totalrgn)));

            ListaRegioInf = con.regioHistInf(regioB);
            ListaRegioInfCiclo = con.regioHistInfCiclo(regioB);

            Iterator infCiclo = ListaRegioInfCiclo.iterator();

            RegioBean infC;

            while (infCiclo.hasNext()) {
                infC = (RegioBean) infCiclo.next();

                if (infC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    infC.setDESCRIPCION_PROGRAMA(infC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    infC.setDESCRIPCION_PROGRAMA(infC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROG("");
            Iterator rinf = ListaRegioInf.iterator();

            RegioBean ri;
            double totalRInf = 0;
            double Recursos = 0;
            while (rinf.hasNext()) {
                ri = (RegioBean) rinf.next();

                totalRInf = totalRInf + Double.parseDouble(ri.getRECURSOS());
                Recursos = Double.parseDouble(ri.getRECURSOS());
                ri.setRECURSOS(String.valueOf(formateador.format(Recursos)));

                System.out.println("el total es total-------" + totalRInf);
                System.out.println("el total es -----------" + Recursos);

            }

            regioB.setTOTALTIPOPROG(String.valueOf(formateador.format(totalRInf)));

            System.out.println("el total es -----------" + regioB.getTOTALTIPOPROG());

            ListaRegioEC = con.regioHistEC(regioB);
            ListaRegioECCiclo = con.regioHistECCiclo(regioB);

            Iterator EcCiclo = ListaRegioECCiclo.iterator();

            RegioBean ECC;

            while (EcCiclo.hasNext()) {
                ECC = (RegioBean) EcCiclo.next();

                if (ECC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    ECC.setDESCRIPCION_PROGRAMA(ECC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    ECC.setDESCRIPCION_PROGRAMA(ECC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROGEC("");

            Iterator rinfec = ListaRegioEC.iterator();

            RegioBean riec;
            double totalRInfec = 0;
            double Recursosec = 0;
            while (rinfec.hasNext()) {
                riec = (RegioBean) rinfec.next();

                Recursosec = 0;
                totalRInfec = totalRInfec + Double.parseDouble(riec.getRECURSOS());
                Recursosec = Double.parseDouble(riec.getRECURSOS());
                riec.setRECURSOS(String.valueOf(formateador.format(Recursosec)));

            }

            regioB.setTOTALTIPOPROGEC(String.valueOf(formateador.format(totalRInfec)));

            ListaRegioEE = con.regioHistEE(regioB);
            ListaRegioEECiclo = con.regioHistEECiclo(regioB);

            Iterator EECiclo = ListaRegioEECiclo.iterator();

            RegioBean EEC;

            while (EECiclo.hasNext()) {
                EEC = (RegioBean) EECiclo.next();

                if (EEC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    EEC.setDESCRIPCION_PROGRAMA(EEC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    EEC.setDESCRIPCION_PROGRAMA(EEC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROGEE("");

            Iterator rinfee = ListaRegioEE.iterator();

            RegioBean riee;
            double totalRInfee = 0;
            double Recursosee = 0;
            while (rinfee.hasNext()) {
                riee = (RegioBean) rinfee.next();

                Recursosee = 0;
                totalRInfee = totalRInfee + Double.parseDouble(riee.getRECURSOS());
                Recursosee = Double.parseDouble(riee.getRECURSOS());
                riee.setRECURSOS(String.valueOf(formateador.format(Recursosee)));

            }

            regioB.setTOTALTIPOPROGEE(String.valueOf(formateador.format(totalRInfee)));

            tipoProg1 = false;
            tipoProg2 = false;
            tipoProg3 = true;

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String municipioSelect() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();

            ListaMenuRegio = con.menuRegio(regioB);

            ListaRegioMun = con.regioMun(regioB);

            DecimalFormat formateador = new DecimalFormat("###,###.##");
            String nomregion = "";

            Iterator mp = ListaRegioMun.iterator();

            RegioBean gm;

            float matricula = 0;
            float docentes = 0;
            float escuelas = 0;
            float totalRegMatricula = 0;
            float totalRegDocentes = 0;
            float totalRegEscuelas = 0;

            while (mp.hasNext()) {
                gm = (RegioBean) mp.next();

                matricula = 0;
                docentes = 0;
                escuelas = 0;

                matricula = Float.parseFloat(gm.getMATRICULA());
                docentes = Float.parseFloat(gm.getNO_DOCENTES());
                escuelas = Float.parseFloat(gm.getNO_ESCUELAS());

                gm.setMATRICULA(String.valueOf(formateador.format(matricula)));
                gm.setNO_DOCENTES(String.valueOf(formateador.format(docentes)));
                gm.setNO_ESCUELAS(String.valueOf(formateador.format(escuelas)));

                totalRegMatricula = totalRegMatricula + matricula;
                totalRegDocentes = totalRegDocentes + docentes;
                totalRegEscuelas = totalRegEscuelas + escuelas;

            }
            System.out.println("Region" + nomregion);

            regioB.setTOTALREGMATRICULA(String.valueOf(formateador.format(totalRegMatricula)));

            regioB.setTOTALREGDOCENTES(String.valueOf(formateador.format(totalRegDocentes)));

            regioB.setTOTALREGESCUELAS(String.valueOf(formateador.format(totalRegEscuelas)));

            System.out.println("EL MUNICIPIO ES " + regioB.getCLAVE_MUNICIPIO());

            System.out.println("el municipio es ++" + regioB.getMUNICIPIO());

            ListaRegioGrafNiv = con.regioGrafMun(regioB);

            Iterator rgn = ListaRegioGrafNiv.iterator();

            RegioBean rg;
            float totalrgn = 0;

            while (rgn.hasNext()) {
                rg = (RegioBean) rgn.next();

                totalrgn = totalrgn + Float.parseFloat(rg.getTOTALNIV());

                rg.setRECURSOS(String.valueOf(formateador.format(totalrgn)));

            }

            regioB.setNO_ESCUELAS(String.valueOf(formateador.format(totalrgn)));

            ListaRegioInf = con.regioHistInf(regioB);
            ListaRegioInfCiclo = con.regioHistInfCiclo(regioB);

            Iterator infCiclo = ListaRegioInfCiclo.iterator();

            RegioBean infC;

            while (infCiclo.hasNext()) {
                infC = (RegioBean) infCiclo.next();

                if (infC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    infC.setDESCRIPCION_PROGRAMA(infC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    infC.setDESCRIPCION_PROGRAMA(infC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROG("");
            Iterator rinf = ListaRegioInf.iterator();

            RegioBean ri;
            double totalRInf = 0;
            double Recursos = 0;
            while (rinf.hasNext()) {
                ri = (RegioBean) rinf.next();

                totalRInf = totalRInf + Double.parseDouble(ri.getRECURSOS());
                Recursos = Double.parseDouble(ri.getRECURSOS());
                ri.setRECURSOS(String.valueOf(formateador.format(Recursos)));

                System.out.println("el total es total-------" + totalRInf);
                System.out.println("el total es -----------" + Recursos);

            }

            regioB.setTOTALTIPOPROG(String.valueOf(formateador.format(totalRInf)));

            System.out.println("el total es -----------" + regioB.getTOTALTIPOPROG());

            ListaRegioEC = con.regioHistEC(regioB);
            ListaRegioECCiclo = con.regioHistECCiclo(regioB);

            Iterator EcCiclo = ListaRegioECCiclo.iterator();

            RegioBean ECC;

            while (EcCiclo.hasNext()) {
                ECC = (RegioBean) EcCiclo.next();

                if (ECC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    ECC.setDESCRIPCION_PROGRAMA(ECC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    ECC.setDESCRIPCION_PROGRAMA(ECC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROGEC("");

            Iterator rinfec = ListaRegioEC.iterator();

            RegioBean riec;
            double totalRInfec = 0;
            double Recursosec = 0;
            while (rinfec.hasNext()) {
                riec = (RegioBean) rinfec.next();

                Recursosec = 0;
                totalRInfec = totalRInfec + Double.parseDouble(riec.getRECURSOS());
                Recursosec = Double.parseDouble(riec.getRECURSOS());
                riec.setRECURSOS(String.valueOf(formateador.format(Recursosec)));

            }

            regioB.setTOTALTIPOPROGEC(String.valueOf(formateador.format(totalRInfec)));

            ListaRegioEE = con.regioHistEE(regioB);
            ListaRegioEECiclo = con.regioHistEECiclo(regioB);

            Iterator EECiclo = ListaRegioEECiclo.iterator();

            RegioBean EEC;

            while (EECiclo.hasNext()) {
                EEC = (RegioBean) EECiclo.next();

                if (EEC.getDESCRIPCION_PROGRAMA().length() > 36) {
                    EEC.setDESCRIPCION_PROGRAMA(EEC.getDESCRIPCION_PROGRAMA().substring(0, 35));
                } else {
                    EEC.setDESCRIPCION_PROGRAMA(EEC.getDESCRIPCION_PROGRAMA());
                }
            }

            regioB.setTOTALTIPOPROGEE("");

            Iterator rinfee = ListaRegioEE.iterator();

            RegioBean riee;
            double totalRInfee = 0;
            double Recursosee = 0;
            while (rinfee.hasNext()) {
                riee = (RegioBean) rinfee.next();

                Recursosee = 0;
                totalRInfee = totalRInfee + Double.parseDouble(riee.getRECURSOS());
                Recursosee = Double.parseDouble(riee.getRECURSOS());
                riee.setRECURSOS(String.valueOf(formateador.format(Recursosee)));

            }

            regioB.setTOTALTIPOPROGEE(String.valueOf(formateador.format(totalRInfee)));

            tipoProg1 = false;
            tipoProg2 = false;
            tipoProg3 = true;

            System.out.println("el municipio es ++" + regioB.getMUNICIPIO());

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String regioTipoProgBan() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();

            ListaMenuRegio = con.menuRegio(regioB);

            ListaRegioMun = con.regioMun(regioB);

            DecimalFormat formateador = new DecimalFormat("###,###.##");
            String nomregion = "";

            Iterator mp = ListaRegioMun.iterator();

            RegioBean gm;

            float matricula = 0;
            float docentes = 0;
            float escuelas = 0;
            float totalRegMatricula = 0;
            float totalRegDocentes = 0;
            float totalRegEscuelas = 0;

            while (mp.hasNext()) {
                gm = (RegioBean) mp.next();

                matricula = 0;
                docentes = 0;
                escuelas = 0;

                matricula = Float.parseFloat(gm.getMATRICULA());
                docentes = Float.parseFloat(gm.getNO_DOCENTES());
                escuelas = Float.parseFloat(gm.getNO_ESCUELAS());

                gm.setMATRICULA(String.valueOf(formateador.format(matricula)));
                gm.setNO_DOCENTES(String.valueOf(formateador.format(docentes)));
                gm.setNO_ESCUELAS(String.valueOf(formateador.format(escuelas)));

                totalRegMatricula = totalRegMatricula + matricula;
                totalRegDocentes = totalRegDocentes + docentes;
                totalRegEscuelas = totalRegEscuelas + escuelas;

            }
            System.out.println("Region" + nomregion);

            regioB.setTOTALREGMATRICULA(String.valueOf(formateador.format(totalRegMatricula)));

            regioB.setTOTALREGDOCENTES(String.valueOf(formateador.format(totalRegDocentes)));

            regioB.setTOTALREGESCUELAS(String.valueOf(formateador.format(totalRegEscuelas)));

            System.out.println("EL MUNICIPIO ES " + regioB.getCLAVE_MUNICIPIO());

            System.out.println("el municipio es ++" + regioB.getMUNICIPIO());

            ListaRegioGrafNiv = con.regioGrafMun(regioB);
            Iterator rgn = ListaRegioGrafNiv.iterator();

            RegioBean rg;
            float totalrgn = 0;

            while (rgn.hasNext()) {
                rg = (RegioBean) rgn.next();

                totalrgn = totalrgn + Float.parseFloat(rg.getTOTALNIV());

                rg.setRECURSOS(String.valueOf(formateador.format(totalrgn)));

            }

            regioB.setNO_ESCUELAS(String.valueOf(formateador.format(totalrgn)));

            if (regioB.getAUXTIPOPROG().equals("1")) {
                tipoProg1 = true;
                tipoProg2 = false;
                tipoProg3 = false;

            }
            if (regioB.getAUXTIPOPROG().equals("2")) {

                tipoProg1 = false;
                tipoProg2 = true;
                tipoProg3 = false;

            }
            if (regioB.getAUXTIPOPROG().equals("3")) {

                tipoProg1 = false;
                tipoProg2 = false;
                tipoProg3 = true;

            }

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String municipioMapa() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat("###,###.##");

            // ListaCatMun=con.mapaCatMun(cat);
            comunidadNivel();

            regioB.setCLAVE_MUNICIPIO(cat.getCLAVE_MUNICIPIO());

            ListaRegioGrafNiv = con.regioGrafMun(regioB);

            Iterator rgn = ListaRegioGrafNiv.iterator();

            RegioBean rg;
            float totalrgn = 0;
            int pre = 0;
            int pri = 0;
            int sec = 0;
            int ms = 0;
            int s = 0;
            int otro = 0;

            while (rgn.hasNext()) {
                rg = (RegioBean) rgn.next();

                if (rg.getCVENIV().equals("1")) {
                    pre = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("2")) {
                    pri = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("3")) {
                    sec = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("4")) {
                    ms = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("5")) {
                    s = Integer.parseInt(rg.getTOTALNIV());
                }
                if (rg.getCVENIV().equals("6")) {
                    otro = Integer.parseInt(rg.getTOTALNIV());
                }

            }

            regioB.setPREESCOLAR(String.valueOf(formateador.format(pre)));
            regioB.setPRIMARIA(String.valueOf(formateador.format(pri)));
            regioB.setSECUNDARIA(String.valueOf(formateador.format(sec)));
            regioB.setMEDIA_SUPERIOR(String.valueOf(formateador.format(ms)));
            regioB.setSUPERIOR(String.valueOf(formateador.format(s)));
            regioB.setOTRO(String.valueOf(formateador.format(otro)));
            regioB.setTOTAL_ESCUELAS_NIV(String.valueOf(formateador.format(pre + pri + sec + ms + s + otro)));

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String busquedaCCT() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat("###,###.##");

            //System.out.println("Buscar la CCT: " + busquedaCCT.getBUSCAR_CCT());
            if (regioB.getAUXTIPOPROG().length() <= 0) {
                tipoProg1 = false;
                tipoProg2 = false;
                tipoProg3 = true;
            }
            if (regioB.getAUXTIPOPROG().equals("3")) {
                tipoProg1 = false;
                tipoProg2 = false;
                tipoProg3 = true;
            }
            if (regioB.getAUXTIPOPROG().equals("2")) {
                tipoProg3 = false;
                tipoProg2 = true;
                tipoProg1 = false;
            }
            if (regioB.getAUXTIPOPROG().equals("1")) {
                tipoProg3 = false;
                tipoProg2 = false;
                tipoProg1 = true;
            }

            if (busquedaCCT.getBUSCAR_CCT().length() == 10) {

                busquedaCCT.setCICLOAUX(cat.getCICLOAUX());

                ListaBusquedaCCT = con.busquedaCCT(busquedaCCT);
                System.out.println("listaBusquedaCCt: " + ListaBusquedaCCT.size());

                ListaProgVigentesEECCT = con.ProgVigentesEECct(busquedaCCT);

                ListaProgTodosEECCT = con.ProgTodosEECct(busquedaCCT);

                Iterator PVEE = ListaProgTodosEECCT.iterator();
                busquedaCCTBean obj1;
                float TotalEE = 0;
                float MontoEE = 0;

                while (PVEE.hasNext()) {
                    obj1 = (busquedaCCTBean) PVEE.next();
                    TotalEE = TotalEE + Float.parseFloat(obj1.getMONTO());
                    MontoEE = Float.parseFloat(obj1.getMONTO());

                    obj1.setMONTO(String.valueOf(formateador.format(MontoEE)));

                }
                regioB.setTOTALTIPOPROGEE(String.valueOf(formateador.format(TotalEE)));

                System.out.println("lista prog vigentes: " + ListaProgVigentesEECCT.size());

                ListaProgVigentesMECCT = con.ProgVigentesMECct(busquedaCCT);
                ListaProgTodosMECCT = con.ProgTodosMECct(busquedaCCT);

                Iterator PVME = ListaProgTodosMECCT.iterator();
                busquedaCCTBean obj2;
                float TotalME = 0;
                float MontoME = 0;

                while (PVME.hasNext()) {
                    obj2 = (busquedaCCTBean) PVME.next();
                    TotalME = TotalME + Float.parseFloat(obj2.getMONTO());
                    MontoME = Float.parseFloat(obj2.getMONTO());

                    obj2.setMONTO(String.valueOf(formateador.format(MontoME)));

                }
                regioB.setTOTALTIPOPROGEC(String.valueOf(formateador.format(TotalME)));

                System.out.println("lista prog vigentes ME: " + ListaProgVigentesMECCT.size());

                ListaProgVigentesIFCCT = con.ProgVigentesIFCct(busquedaCCT);
                ListaProgTodosIFCCT = con.ProgTodosIFCct(busquedaCCT);

                Iterator PVIE = ListaProgTodosIFCCT.iterator();
                busquedaCCTBean obj3;
                float TotalIE = 0;
                float MontoIE = 0;

                while (PVIE.hasNext()) {
                    obj3 = (busquedaCCTBean) PVIE.next();
                    TotalIE = TotalIE + Float.parseFloat(obj3.getMONTO());
                    MontoIE = Float.parseFloat(obj3.getMONTO());

                    obj3.setMONTO(String.valueOf(formateador.format(MontoIE)));

                }
                regioB.setTOTALTIPOPROG(String.valueOf(formateador.format(TotalIE)));

                System.out.println("lista prog vigentes IF: " + ListaProgVigentesIFCCT.size());

                if (ListaBusquedaCCT.size() > 0) {

                    Iterator LBCCT = ListaBusquedaCCT.iterator();
                    busquedaCCTBean obj;

                    while (LBCCT.hasNext()) {
                        obj = (busquedaCCTBean) LBCCT.next();

                        busquedaCCT.setCCT(obj.getCCT());
                        busquedaCCT.setNOMBRE_ESCUELA(obj.getNOMBRE_ESCUELA());
                        busquedaCCT.setVERTIENTE(obj.getVERTIENTE());
                        busquedaCCT.setNIVEL(obj.getNIVEL());
                        busquedaCCT.setMUNICIPIO(obj.getMUNICIPIO());
                        busquedaCCT.setLOCALIDAD(obj.getLOCALIDAD());
                        busquedaCCT.setTURNO(obj.getTURNO());
                        busquedaCCT.setDOMICILIO(obj.getDOMICILIO());
                        busquedaCCT.setLATITUD(obj.getLATITUD());
                        busquedaCCT.setLONGITUD(obj.getLONGITUD());
                        busquedaCCT.setNO_DOCENTES(formateador.format(Integer.parseInt(obj.getNO_DOCENTES())));
                        busquedaCCT.setMATRICULA(formateador.format(Integer.parseInt(obj.getMATRICULA())));

                    }

                    regioB.setAUXTIPOPROG("");

                } else {
                    errorNoEncontrado = true;
                    botones();
                    busquedaCCT.setBUSCAR_CCT("");
                    regioB.setAUXTIPOPROG("");
                    return "ERROR";
                }
            } else {
                errorFormato = true;
                botones();
                busquedaCCT.setBUSCAR_CCT("");
                regioB.setAUXTIPOPROG("");

                return "ERROR";
            }

            ListaResultadosPlanea = con.resultadosPlanea(busquedaCCT);
            int i = 0;

            float lc1 = 0;
            float lc2 = 0;
            float m1 = 0;
            float m2 = 0;

            int mayor = 0;

            if (ListaResultadosPlanea.size() == 2) {

                for (i = 0; i < ListaResultadosPlanea.size(); i++) {

                    if (i == 0) {
                        lc1 = Float.parseFloat(ListaResultadosPlanea.get(i).getLC_IV());
                        m1 = Float.parseFloat(ListaResultadosPlanea.get(i).getM_IV());

                    }

                    if (i == 1) {
                        lc2 = Float.parseFloat(ListaResultadosPlanea.get(i).getLC_IV());
                        m2 = Float.parseFloat(ListaResultadosPlanea.get(i).getM_IV());
                    }

                }

                System.out.println("Valor 1\t" + lc1);
                System.out.println("Valor 2\t" + lc2);
                System.out.println("Valor 1\t" + m1);
                System.out.println("Valor 2\t" + m2);

                if (lc1 > lc2) {

                    ListaResultadosPlanea.get(0).setMAYOR("1");

                }

                if (lc2 > lc1) {

                    ListaResultadosPlanea.get(0).setMAYOR_M("2");

                }

                if (m1 > m2) {

                    ListaResultadosPlanea.get(0).setMAYOR_M("1");

                }

                if (m2 > m1) {

                    ListaResultadosPlanea.get(0).setMAYOR_M("2");

                }

            }

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String monitorIms() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String serviciosLinea() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

            ListaServiciosLinea = con.ListaServiciosLinea();

            Iterator LSL = ListaServiciosLinea.iterator();
            serviciosLineaBean obj;

            while (LSL.hasNext()) {
                obj = (serviciosLineaBean) LSL.next();

                serlinea.setACRONIMO(obj.getACRONIMO());
                //serlinea.setIMPACTO_SOCIEDAD(formateador.format(Integer.parseInt(obj.getIMPACTO_SOCIEDAD())));
                serlinea.setNOMBRE_SISTEMA(obj.getNOMBRE_SISTEMA());
                serlinea.setNOTA(obj.getNOTA());
                serlinea.setIMPACTO_SOCIEDAD(formateador.format(Integer.parseInt(obj.getIMPACTO_SOCIEDAD())));

                serlinea.setVIGENCIA(obj.getVIGENCIA());
                if (obj.getPORCENTAJE_AVANCE() != null) {
                    ListaServiciosLineaPorcentaje = con.ListaServiciosLineaPorcentaje(obj.getPORCENTAJE_AVANCE());

                    Iterator LSLP = ListaServiciosLineaPorcentaje.iterator();

                    serviciosLineaBean obj2;

                    while (LSLP.hasNext()) {
                        obj2 = (serviciosLineaBean) LSLP.next();

                        serlinea.setPORCENTAJE_AVANCE(obj2.getPORCENTAJE_AVANCE());

                    }
                } else {
                    serlinea.setPORCENTAJE_AVANCE("0");
                }
            }

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public void impactoGet() {

        try {

            DecimalFormat formateador = new DecimalFormat();

            URL url = new URL("http://monitoreo.edu-edomex.gob.mx/index.php?date=2018-07-11&expanded=1&filter_limit=100&format=XML&idSite=21&method=Actions.getPageUrls&module=API&period=year&token_auth=8659d47958cf980c51546df31dbcd6be");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String entrada;
            String cadena = "";
            while ((entrada = br.readLine()) != null) {
                cadena = cadena + entrada;
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource archivo = new InputSource();
            archivo.setCharacterStream(new StringReader(cadena));
            Document documento = db.parse(archivo);
            documento.getDocumentElement().normalize();
            NodeList nodeLista = documento.getElementsByTagName("row");

            System.out.println("tamano de lista: " + nodeLista.getLength());
            int totalImpacto = 0;
            Double tiempoRespuesta = 0.0;

            for (int s = 0; s < nodeLista.getLength(); s++) {

                Node primerNodo = nodeLista.item(s);

                //System.out.println("nodetype: " + primerNodo.getNodeType());
                //System.out.println("element: " + Node.ELEMENT_NODE);
                String label = null;
                String nb_visits = null;
                Integer nb_hits = null;
                String sum_time_spent;
                String nb_hits_with_time_generation;
                String min_time_generation;
                String max_time_generation;
                String sum_bandwidth;
                String nb_hits_with_bandwidth;
                String min_bandwidth;
                String max_bandwidth;
                String entry_nb_visits;
                String entry_nb_actions;
                String entry_sum_visit_length;
                String entry_bounce_count;
                String exit_nb_visits;
                String sum_daily_nb_uniq_visitors;
                String sum_daily_entry_nb_uniq_visitors;
                String sum_daily_exit_nb_uniq_visitors;
                String avg_bandwidth;
                String avg_time_on_page;
                String bounce_rate;
                String exit_rate;
                Double avg_time_generation = null;
                String urlm;

                if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element primerElemento = (Element) primerNodo;

                    NodeList primerNombreElementoLista = primerElemento.getElementsByTagName("label");
                    Element primerNombreElemento = (Element) primerNombreElementoLista.item(0);
                    NodeList primerNombre = primerNombreElemento.getChildNodes();
                    label = ((Node) primerNombre.item(0)).getNodeValue().toString();

                    //System.out.println("label : " + label);
                    NodeList segundoNombreElementoLista = primerElemento.getElementsByTagName("avg_time_generation");
                    Element segundoNombreElemento = (Element) segundoNombreElementoLista.item(0);
                    NodeList segundoNombre = segundoNombreElemento.getChildNodes();
                    avg_time_generation = Double.valueOf(((Node) segundoNombre.item(0)).getNodeValue());

                    //System.out.println("avg_time_generation : " + avg_time_generation);
                    NodeList tercerNombreElementoLista = primerElemento.getElementsByTagName("nb_hits");
                    Element tercerNombreElemento = (Element) tercerNombreElementoLista.item(0);
                    NodeList tercerNombre = tercerNombreElemento.getChildNodes();

                    nb_hits = Integer.valueOf(((Node) tercerNombre.item(0)).getNodeValue());

                    //System.out.println("nb_hits : " + nb_hits);
                }

                if (label.equals("/inicio") && nb_hits > 0) {

                    //System.out.println("label : " + label);
                    totalImpacto = totalImpacto + nb_hits;
                    //System.out.println("nb_hits : " + nb_hits);
                    //System.out.println("avg_time_generation maximo : " + avg_time_generation);
                    if (avg_time_generation > tiempoRespuesta) {
                        tiempoRespuesta = avg_time_generation;
                        //System.out.println("max : " + max);
                    }
                }

            }
            System.out.println("totalImpacto : " + totalImpacto);
            System.out.println("tiempo de respuesta maximo : " + tiempoRespuesta);

            serlinea.setIMPACTO_SOCIEDAD(String.valueOf(formateador.format(totalImpacto)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String serlinea() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

            ListaMenuSerlinea = con.ListaMenuSerlinea();

            for (int i = 0; i <= 0; i++) {

                System.out.println("el primer acronimo es;" + ListaMenuSerlinea.get(i).getACRONIMO());

                serlinea.setBUSCAR_ACRONIMO(ListaMenuSerlinea.get(i).getACRONIMO());

            }

            serlineaConsultaValores();

            ListaMenuSerlineaPermanente.clear();

            banderamenu = true;
            banderamenumenos = false;

            infografia = false;
            nivelimpacto = true;

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String serlineaMenuTodos() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

            ListaMenuSerlinea.clear();

            ListaMenuSerlinea = con.ListaMenuSerlinea();

            for (int i = 0; i <= 0; i++) {

                System.out.println("el primer acronimo es;" + ListaMenuSerlinea.get(i).getACRONIMO());

                serlinea.setBUSCAR_ACRONIMO(ListaMenuSerlinea.get(i).getACRONIMO());

            }
            ListaMenuSerlineaPermanente = con.ListaMenuSerlineaPermanente();

            serlineaConsultaValores();

            banderamenu = false;
            banderamenumenos = true;
            infografia = false;
            nivelimpacto = true;

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String serlineaConsulta() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

            serlineaConsultaValores();

            banderamenu = false;
            if (ListaMenuSerlineaPermanente.size() > 0) {
                banderamenumenos = true;
            } else {
                banderamenumenos = false;
                banderamenu = true;
            }

            infografia = false;
            nivelimpacto = true;

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String serlineaConsultaValores() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

            ListaSerlineaConsulta = con.ListaSerlineaConsulta(serlinea);

            String fecha = fecha();
            serlinea.setFECHA_HOY(fecha);

            Iterator LSLC = ListaSerlineaConsulta.iterator();
            serviciosLineaBean obj;

            float totalTipoAcceso = 0;
            float directa = 0;
            float sitios = 0;
            float motores = 0;
            float tel = 0;
            float tableta = 0;
            float pc = 0;
            float otros = 0;
            float totalTipoDispositivo = 0;

            while (LSLC.hasNext()) {
                obj = (serviciosLineaBean) LSLC.next();

                serlinea.setACRONIMO(obj.getACRONIMO());
                serlinea.setNOMBRE_SISTEMA(obj.getNOMBRE_SISTEMA());
                serlinea.setOBJETIVO(obj.getOBJETIVO());
                serlinea.setALCANCE(obj.getALCANCE());
                serlinea.setVER_MAS(obj.getVER_MAS());

                serlinea.setUSUARIOS(obj.getUSUARIOS());
                serlinea.setVIGENCIA(obj.getVIGENCIA());
                serlinea.setID_APLICACION(obj.getID_APLICACION());
                serlinea.setIMPACTO_SOCIEDAD(formateador.format(Integer.parseInt(obj.getIMPACTO_SOCIEDAD())));
                serlinea.setFECHA_INICIO(obj.getFECHA_INICIO());
                serlinea.setFECHA_TERMINO(obj.getFECHA_TERMINO());

                serlinea.setENTRADA_DIRECTA(formateador.format(Integer.parseInt(obj.getENTRADA_DIRECTA())));
                serlinea.setSITIOS_INTERNET(formateador.format(Integer.parseInt(obj.getSITIOS_INTERNET())));
                serlinea.setMOTORES_BUSQUEDA(formateador.format(Integer.parseInt(obj.getMOTORES_BUSQUEDA())));
                serlinea.setTIPO_TEL(formateador.format(Integer.parseInt(obj.getTIPO_TEL())));
                serlinea.setTIPO_TABLETA(formateador.format(Integer.parseInt(obj.getTIPO_TABLETA())));
                serlinea.setTIPO_ESCRITORIO(formateador.format(Integer.parseInt(obj.getTIPO_ESCRITORIO())));
                serlinea.setTIPO_OTROS(formateador.format(Integer.parseInt(obj.getTIPO_OTROS())));

                totalTipoAcceso = Float.parseFloat(obj.getENTRADA_DIRECTA()) + Float.parseFloat(obj.getSITIOS_INTERNET()) + Float.parseFloat(obj.getMOTORES_BUSQUEDA());
                totalTipoDispositivo = Float.parseFloat(obj.getTIPO_TEL()) + Float.parseFloat(obj.getTIPO_TABLETA()) + Float.parseFloat(obj.getTIPO_ESCRITORIO()) + Float.parseFloat(obj.getTIPO_OTROS());

                directa = Float.parseFloat(obj.getENTRADA_DIRECTA());
                sitios = Float.parseFloat(obj.getSITIOS_INTERNET());
                motores = Float.parseFloat(obj.getMOTORES_BUSQUEDA());
                tel = Float.parseFloat(obj.getTIPO_TEL());
                tableta = Float.parseFloat(obj.getTIPO_TABLETA());
                pc = Float.parseFloat(obj.getTIPO_ESCRITORIO());
                otros = Float.parseFloat(obj.getTIPO_OTROS());

                if (obj.getPORCENTAJE_AVANCE() != null) {
                    ListaServiciosLineaPorcentaje = con.ListaServiciosLineaPorcentaje(obj.getPORCENTAJE_AVANCE());

                    if (ListaServiciosLineaPorcentaje.size() > 0) {

                        Iterator LSLP = ListaServiciosLineaPorcentaje.iterator();

                        serviciosLineaBean obj2;

                        while (LSLP.hasNext()) {
                            obj2 = (serviciosLineaBean) LSLP.next();

                            serlinea.setPORCENTAJE_AVANCE(obj2.getPORCENTAJE_AVANCE());

                        }
                    } else {

                        serlinea.setPORCENTAJE_AVANCE("S/D");

                    }

                } else {

                    serlinea.setPORCENTAJE_AVANCE("S/D");
                }

            }

            directa = directa * 100 / totalTipoAcceso;

            sitios = sitios * 100 / totalTipoAcceso;

            motores = motores * 100 / totalTipoAcceso;

            tel = tel * 100 / totalTipoDispositivo;
            tableta = tableta * 100 / totalTipoDispositivo;
            pc = pc * 100 / totalTipoDispositivo;
            otros = otros * 100 / totalTipoDispositivo;

            serlinea.setPORCE_ENTRADA_DIRECTA(String.valueOf(new DecimalFormat("#.##").format(directa)));

            serlinea.setPORCE_SITIOS_INTERNET(String.valueOf(new DecimalFormat("#.##").format(sitios)));

            serlinea.setPORCE_MOTORES_BUSQUEDA(String.valueOf(new DecimalFormat("#.##").format(motores)));

            serlinea.setPORCE_TIPO_TEL(String.valueOf(new DecimalFormat("#.##").format(tel)));
            serlinea.setPORCE_TIPO_TABLETA(String.valueOf(new DecimalFormat("#.##").format(tableta)));
            serlinea.setPORCE_TIPO_ESCRITORIO(String.valueOf(new DecimalFormat("#.##").format(pc)));
            serlinea.setPORCE_TIPO_OTROS(String.valueOf(new DecimalFormat("#.##").format(otros)));

            String ano;
            String mes;
            ano = fecha();
            mes = fecha();
            ano = ano.substring(2, 4);
            mes = mes.substring(5, 7);
            serlinea.setANO(ano);

            if (serlinea.getMES_CONSULTA() == null) {
                serlinea.setMES_CONSULTA(mes);
            }

            System.out.println("AÑOOOOOOOOOOOOOO:" + ano);

            ListaSerlineaHistDiaMes = con.ListaMesDia(serlinea);

            System.out.println("AÑOOOOOOOOOOOOOO:" + ano);

            ListaSerlineaHistDia = con.ListaMesLinea(serlinea);

            ListaSerlineaInfografia = con.serlineaInfografia(serlinea);

            Iterator LSLI = ListaSerlineaInfografia.iterator();
            serviciosLineaBean obj2;

            while (LSLI.hasNext()) {
                obj2 = (serviciosLineaBean) LSLI.next();

                serlinea.setDESCRIPCION(obj2.getDESCRIPCION());
                serlinea.setNOTA_AVANCE(obj2.getNOTA_AVANCE());
                serlinea.setNOTA_ALCANCE(obj2.getNOTA_ALCANCE());
                serlinea.setTITULO_SEC3(obj2.getTITULO_SEC3());
                serlinea.setNOTA_SEC3(obj2.getNOTA_SEC3());
                serlinea.setCONSULTA_AVANCE(obj2.getCONSULTA_AVANCE());
                serlinea.setCONSULTA_ALCANCE(obj2.getCONSULTA_ALCANCE());

            }

            if (serlinea.getDESCRIPCION() == null) {
                serlinea.setDESCRIPCION("!No hay información para mostrar!");
            }

            if (serlinea.getCONSULTA_ALCANCE().length() > 0) {

                ListaserlineInfografiaAvance = con.infografiaAvance(serlinea);

                Iterator LLIAC = ListaserlineInfografiaAvance.iterator();

                serviciosLineaBean obj4;

                while (LLIAC.hasNext()) {
                    obj4 = (serviciosLineaBean) LLIAC.next();

                    //ALUMNOS
                    if (obj4.getALUMNOS().equals("0")) {

                        obj4.setALUMNOS("N/A");

                    } else {
                        obj4.setALUMNOS(String.valueOf(formateador.format(Integer.parseInt(obj4.getALUMNOS()))));
                    }

                    if (obj4.getPORCE_ALUMNOS().equals("0")) {

                        obj4.setPORCE_ALUMNOS("N/A");

                    } else {
                        obj4.setPORCE_ALUMNOS(obj4.getPORCE_ALUMNOS() + "%");
                    }

                    // DOCENTES
                    if (obj4.getDOCENTES().equals("0")) {

                        obj4.setDOCENTES("N/A");

                    } else {
                        obj4.setDOCENTES(String.valueOf(formateador.format(Integer.parseInt(obj4.getDOCENTES()))));
                    }

                    if (obj4.getPORCE_DOCENTES().equals("0")) {

                        obj4.setPORCE_DOCENTES("N/A");

                    } else {
                        obj4.setPORCE_DOCENTES(obj4.getPORCE_DOCENTES() + "%");
                    }

                    //ESCUELAS
                    if (obj4.getESCUELAS().equals("0")) {

                        obj4.setESCUELAS("N/A");

                    } else {
                        obj4.setESCUELAS(String.valueOf(formateador.format(Integer.parseInt(obj4.getESCUELAS()))));
                    }

                    if (obj4.getPORCE_ESCUELAS().equals("0")) {

                        obj4.setPORCE_ESCUELAS("N/A");

                    } else {
                        obj4.setPORCE_ESCUELAS(obj4.getPORCE_ESCUELAS() + "%");
                    }

                    //MUNICIPIOS
                    if (obj4.getMUNICIPIOS().equals("0")) {

                        obj4.setMUNICIPIOS("N/A");

                    } else {
                        obj4.setMUNICIPIOS(String.valueOf(formateador.format(Integer.parseInt(obj4.getMUNICIPIOS()))));
                    }

                    if (obj4.getPORCE_MUNICIPIOS().equals("0")) {

                        obj4.setPORCE_MUNICIPIOS("N/A");

                    } else {
                        obj4.setPORCE_MUNICIPIOS(obj4.getPORCE_MUNICIPIOS() + "%");
                    }

                }

            }

            if (serlinea.getCONSULTA_AVANCE().length() > 0) {

                ListaserlineInfografiaAlcance = con.infografiaAlcance(serlinea);

                Iterator LLIA = ListaserlineInfografiaAlcance.iterator();
                serviciosLineaBean obj3;

                while (LLIA.hasNext()) {
                    obj3 = (serviciosLineaBean) LLIA.next();

                    if (obj3.getUNIVERSO().equals("0")) {

                        obj3.setUNIVERSO("N/A");

                    } else {
                        obj3.setUNIVERSO(String.valueOf(formateador.format(Integer.parseInt(obj3.getUNIVERSO()))));
                    }

                    if (obj3.getBENEFICIARIOS().equals("0")) {

                        obj3.setBENEFICIARIOS("N/A");

                    } else {
                        obj3.setBENEFICIARIOS(String.valueOf(formateador.format(Integer.parseInt(obj3.getBENEFICIARIOS()))));
                    }

                    if (obj3.getPORCE_BENEFICIARIO().equals("0")) {

                        obj3.setPORCE_BENEFICIARIO("N/A");

                    } else {
                        obj3.setPORCE_BENEFICIARIO(String.valueOf(formateador.format(Integer.parseInt(obj3.getPORCE_BENEFICIARIO()))) + "%");
                    }

                }

            }

            if (ListaMenuSerlineaPermanente.size() > 0) {
                banderamenumenos = true;

            } else {
                banderamenumenos = false;
                banderamenu = true;
                ListaMenuSerlineaPermanente.clear();
            }

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String serlineaMesConsulta() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

            String ano;
            String mes;
            ano = fecha();
            mes = fecha();
            ano = ano.substring(2, 4);
            mes = mes.substring(5, 7);
            serlinea.setANO(ano);

            if (serlinea.getMES_CONSULTA() == null) {
                serlinea.setMES_CONSULTA(mes);
            }

            System.out.println("AÑOOOOOOOOOOOOOO:" + ano);

            ListaSerlineaHistDiaMes = con.ListaMesDia(serlinea);

            serlineaConsultaValores();

            banderamenu = false;
            banderamenumenos = true;

            infografia = false;
            nivelimpacto = true;

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    public String infografia() {

        try {

            //validando session***********************************************************************
            if (session.get("cveUsuario") != null) {
                String sUsu = (String) session.get("cveUsuario");
            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }
            if (session.containsKey("usuario")) {
                usuariocons = (usuarioBean) session.get("usuario");
                nivelUsuario = usuariocons.getPUESTO();

            } else {
                addActionError("**** La sesión ha expirado *** favor de iniciar una nueva sesion *** ");
                return "SESION";
            }

            consultaPPrincipalBusiness con = new consultaPPrincipalBusiness();
            DecimalFormat formateador = new DecimalFormat();

            infografia = true;
            nivelimpacto = false;

            if (ListaMenuSerlineaPermanente.size() > 0) {
                banderamenumenos = true;

            } else {
                banderamenumenos = false;
                banderamenu = true;
                ListaMenuSerlineaPermanente.clear();
            }

            serlineaConsultaValores();

        } catch (Exception e) {

            return "ERROR";
        }

        return "SUCCESS";
    }

    private String fecha() {

        String fecha_formato = "2";

        java.util.Date fecha = new Date();

        System.out.println("fecha" + fecha);

        SimpleDateFormat dt1 = new SimpleDateFormat("YYYY-MM-dd");

        fecha_formato = dt1.format(fecha);
        System.out.println("fecha" + fecha_formato);

        return fecha_formato;

    }

}
