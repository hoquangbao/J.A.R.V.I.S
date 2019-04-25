/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class RegistrationDTO implements Serializable{
    private String username, password, avengerName, fullname, role;
    private Date dateOfBirth;
    
    public RegistrationDTO(String username, String avengerName, String fullname, String role, Date dateOfBirth) {
        this.username = username;
        this.avengerName = avengerName;
        this.fullname = fullname;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
    }

    public RegistrationDTO(String username, String password, String avengerName, String fullname, String role, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.avengerName = avengerName;
        this.fullname = fullname;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
    }
    
    public RegistrationDTO() {
    }
       
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAvengerName() {
        return avengerName;
    }

    public void setAvengerName(String avengerName) {
        this.avengerName = avengerName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
}
