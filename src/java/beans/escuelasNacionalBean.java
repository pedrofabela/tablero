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
public class escuelasNacionalBean {
    private String ID_PROGRAMA;
    private String NOMBRE_ESTADO;
   private String NO_ESCUELAS;
   private String COLOR;
   private String CVEESTADO;

    public String getCVEESTADO() {
        return CVEESTADO;
    }

    public void setCVEESTADO(String CVEESTADO) {
        this.CVEESTADO = CVEESTADO;
    }
   
   
    public String getID_PROGRAMA() {
        return ID_PROGRAMA;
    }

    public void setID_PROGRAMA(String ID_PROGRAMA) {
        this.ID_PROGRAMA = ID_PROGRAMA;
    }

    public String getNOMBRE_ESTADO() {
        return NOMBRE_ESTADO;
    }

    public void setNOMBRE_ESTADO(String NOMBRE_ESTADO) {
        this.NOMBRE_ESTADO = NOMBRE_ESTADO;
    }

    public String getNO_ESCUELAS() {
        return NO_ESCUELAS;
    }

    public void setNO_ESCUELAS(String NO_ESCUELAS) {
        this.NO_ESCUELAS = NO_ESCUELAS;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }
   
   
}
