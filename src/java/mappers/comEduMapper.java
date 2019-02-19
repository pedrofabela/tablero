/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.comEduBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class comEduMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        comEduBean mod = new comEduBean();
        

        
        
        
        
        

        if (rs.getString("ID") != null) {
            mod.setID(rs.getString("ID").trim());

        } else {
            mod.setID(rs.getString("ID"));
        }
        
        
        

        if (rs.getString("CVENIV") != null) {
            mod.setCVENIV(rs.getString("CVENIV").trim());

        } else {
            mod.setCVENIV(rs.getString("CVENIV"));
        }
        
        
        

        if (rs.getString("NOMNIV") != null) {
            mod.setNOMNIV(rs.getString("NOMNIV").trim());

        } else {
            mod.setNOMNIV(rs.getString("NOMNIV"));
        }
        
        
        

        if (rs.getString("MATRIALU") != null) {
            mod.setMATRIALU(rs.getString("MATRIALU").trim());

        } else {
            mod.setMATRIALU(rs.getString("MATRIALU"));
        }

        if (rs.getString("MATRIDOCEN") != null) {
            mod.setMATRIDOCEN(rs.getString("MATRIDOCEN").trim());

        } else {
            mod.setMATRIDOCEN(rs.getString("MATRIDOCEN"));
        }
        
        

        if (rs.getString("NOESC") != null) {
            mod.setNOESC(rs.getString("NOESC").trim());

        } else {
            mod.setNOESC(rs.getString("NOESC"));
        }
        
        
        

        if (rs.getString("TIPOMTRIC") != null) {
            mod.setTIPOMTRIC(rs.getString("TIPOMTRIC").trim());

        } else {
            mod.setTIPOMTRIC(rs.getString("TIPOMTRIC"));
        }
        

        if (rs.getString("FUENTE") != null) {
            mod.setFUENTE(rs.getString("FUENTE").trim());

        } else {
            mod.setFUENTE(rs.getString("FUENTE"));
        }
        
        
        if (rs.getString("ESCPUB") != null) {
            mod.setESCPUB(rs.getString("ESCPUB").trim());

        } else {
            mod.setESCPUB(rs.getString("ESCPUB"));
        }

        if (rs.getString("ESCPRIV") != null) {
            mod.setESCPRIV(rs.getString("ESCPRIV").trim());

        } else {
            mod.setESCPRIV(rs.getString("ESCPRIV"));
        }
        if (rs.getString("CICLO_ESCOLAR") != null) {
            mod.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR").trim());

        } else {
            mod.setCICLO_ESCOLAR(rs.getString("CICLO_ESCOLAR"));
        }

        return mod;
    }

}
