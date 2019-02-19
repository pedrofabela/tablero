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
public class escuelasRegionBean {
    
 private String   ID_PROGRAMA;
 private String  CVEREGION;
 private String  NOMBRE_REGION;
 private String  TOTAL_REGION;
 private String  CICLO_ESCOLAR;
 private String  COLOR;
  private String  NOMBRE_PROGRAMA;

    public String getNOMBRE_PROGRAMA() {
        return NOMBRE_PROGRAMA;
    }

    public void setNOMBRE_PROGRAMA(String NOMBRE_PROGRAMA) {
        this.NOMBRE_PROGRAMA = NOMBRE_PROGRAMA;
    }
  
  
  
  

    public String getID_PROGRAMA() {
        return ID_PROGRAMA;
    }

    public void setID_PROGRAMA(String ID_PROGRAMA) {
        this.ID_PROGRAMA = ID_PROGRAMA;
    }

    public String getCVEREGION() {
        return CVEREGION;
    }

    public void setCVEREGION(String CVEREGION) {
        this.CVEREGION = CVEREGION;
    }

    public String getNOMBRE_REGION() {
        return NOMBRE_REGION;
    }

    public void setNOMBRE_REGION(String NOMBRE_REGION) {
        this.NOMBRE_REGION = NOMBRE_REGION;
    }

    public String getTOTAL_REGION() {
        return TOTAL_REGION;
    }

    public void setTOTAL_REGION(String TOTAL_REGION) {
        this.TOTAL_REGION = TOTAL_REGION;
    }

    public String getCICLO_ESCOLAR() {
        return CICLO_ESCOLAR;
    }

    public void setCICLO_ESCOLAR(String CICLO_ESCOLAR) {
        this.CICLO_ESCOLAR = CICLO_ESCOLAR;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }
 
 
    
}
