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
public class RegistrationDTO_Mission {
    private String missionID, missionDescription, missionStatus;
    private String username;

    public RegistrationDTO_Mission() {
    }

    public RegistrationDTO_Mission(String missionID, String missionDescription, String missionStatus) {
        this.missionID = missionID;
        this.missionDescription = missionDescription;
        this.missionStatus = missionStatus;
    }

    public RegistrationDTO_Mission(String missionID, String username) {
        this.missionID = missionID;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMissionID() {
        return missionID;
    }

    public void setMissionID(String missionID) {
        this.missionID = missionID;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }
    
    
}
