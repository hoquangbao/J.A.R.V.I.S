/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.dtos;

/**
 *
 * @author PC
 */
public class RegistrationErrorObject {
    private String usernameError, passwordError, fullnameError, avengerNameError, roleError;
    
    private String markIDError;

    private String missionIDError, missionStatusError;
    
    public RegistrationErrorObject() {
    }

    public String getMissionStatusError() {
        return missionStatusError;
    }

    public void setMissionStatusError(String missionStatusError) {
        this.missionStatusError = missionStatusError;
    }

    public String getMissionIDError() {
        return missionIDError;
    }

    public void setMissionIDError(String missionIDError) {
        this.missionIDError = missionIDError;
    }

    public String getMarkIDError() {
        return markIDError;
    }

    public void setMarkIDError(String markIDError) {
        this.markIDError = markIDError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public String getAvengerNameError() {
        return avengerNameError;
    }

    public void setAvengerNameError(String avengerNameError) {
        this.avengerNameError = avengerNameError;
    }

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
    
}
