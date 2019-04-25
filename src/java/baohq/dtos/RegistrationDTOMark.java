/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dtos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class RegistrationDTOMark implements Serializable{
    private String markID;

    public RegistrationDTOMark(String markID) {
        this.markID = markID;
    }

    public String getMarkID() {
        return markID;
    }

    public void setMarkID(String markID) {
        this.markID = markID;
    }
    
    
}
