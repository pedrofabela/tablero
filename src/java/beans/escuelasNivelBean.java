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
public class escuelasNivelBean {
    
    
   private String ID_PROGRAMA;
        private String    CVENIVEL;
          private String  NOMBRE_NIVEL;
          private String  SUBNIVEL, DATO_ESTATAL;
           private String DATO_FEDERALIZADO;
           private String TOTAL_NIVEL;
           private String CICLO_ESCOLAR;
           private String COLOR;

    public String getID_PROGRAMA() {
        return ID_PROGRAMA;
    }

    public void setID_PROGRAMA(String ID_PROGRAMA) {
        this.ID_PROGRAMA = ID_PROGRAMA;
    }

    public String getCVENIVEL() {
        return CVENIVEL;
    }

    public void setCVENIVEL(String CVENIVEL) {
        this.CVENIVEL = CVENIVEL;
    }

    public String getNOMBRE_NIVEL() {
        return NOMBRE_NIVEL;
    }

    public void setNOMBRE_NIVEL(String NOMBRE_NIVEL) {
        this.NOMBRE_NIVEL = NOMBRE_NIVEL;
    }

    public String getSUBNIVEL() {
        return SUBNIVEL;
    }

    public void setSUBNIVEL(String SUBNIVEL) {
        this.SUBNIVEL = SUBNIVEL;
    }

    public String getDATO_ESTATAL() {
        return DATO_ESTATAL;
    }

    public void setDATO_ESTATAL(String DATO_ESTATAL) {
        this.DATO_ESTATAL = DATO_ESTATAL;
    }

    public String getDATO_FEDERALIZADO() {
        return DATO_FEDERALIZADO;
    }

    public void setDATO_FEDERALIZADO(String DATO_FEDERALIZADO) {
        this.DATO_FEDERALIZADO = DATO_FEDERALIZADO;
    }

    public String getTOTAL_NIVEL() {
        return TOTAL_NIVEL;
    }

    public void setTOTAL_NIVEL(String TOTAL_NIVEL) {
        this.TOTAL_NIVEL = TOTAL_NIVEL;
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
