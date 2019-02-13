/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author pedro
 */
public class mapaBean {

    private String CLAVE;
    private String NOMBRE;
    private String LATITUD;
    private String LONGITUD;
    private String CVE_NIVEDU;
    private String DOMICILIO;
    private String FILTRO_PARA_TABLERO;
    private String MATRICULA;
    private String LOCALIDAD;

    
    
    public String getDOMICILIO() {
        return DOMICILIO;
    }

    public void setDOMICILIO(String DOMICILIO) {
        this.DOMICILIO = DOMICILIO;
    }

    public String getFILTRO_PARA_TABLERO() {
        return FILTRO_PARA_TABLERO;
    }

    public void setFILTRO_PARA_TABLERO(String FILTRO_PARA_TABLERO) {
        this.FILTRO_PARA_TABLERO = FILTRO_PARA_TABLERO;
    }

    public String getMATRICULA() {
        return MATRICULA;
    }

    public void setMATRICULA(String MATRICULA) {
        this.MATRICULA = MATRICULA;
    }

    public String getLOCALIDAD() {
        return LOCALIDAD;
    }

    public void setLOCALIDAD(String LOCALIDAD) {
        this.LOCALIDAD = LOCALIDAD;
    }
    
    
    
    

    public String getCVE_NIVEDU() {
        return CVE_NIVEDU;
    }

    public void setCVE_NIVEDU(String CVE_NIVEDU) {
        this.CVE_NIVEDU = CVE_NIVEDU;
    }
     
     

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getLATITUD() {
        return LATITUD;
    }

    public void setLATITUD(String LATITUD) {
        this.LATITUD = LATITUD;
    }

    public String getLONGITUD() {
        return LONGITUD;
    }

    public void setLONGITUD(String LONGITUD) {
        this.LONGITUD = LONGITUD;
    }

    
    
    
}
