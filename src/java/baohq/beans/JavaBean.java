/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.beans;

import baohq.daos.RegistrationDAO;
import baohq.daos.RegistrationDAO_Mark;
import baohq.daos.RegistrationDAO_Mission;
import baohq.dtos.RegistrationDTO;
import baohq.dtos.RegistrationDTOMark;
import baohq.dtos.RegistrationDTO_Mission;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PC
 */
public class JavaBean implements Serializable {

    private String username, password, avengerName;
    
    private String markID;
    
    private String missionID, oldUsername, missionDescription, missionStatus;

    private RegistrationDTO dto;
    private RegistrationDTOMark dTOMark;
    private RegistrationDTO_Mission dTO_Mission;

    public JavaBean() {
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

    
    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    
    public void setdTO_Mission(RegistrationDTO_Mission dTO_Mission) {
        this.dTO_Mission = dTO_Mission;
    }

    public String getMissionID() {
        return missionID;
    }

    public void setMissionID(String missionID) {
        this.missionID = missionID;
    }

    public void setdTOMark(RegistrationDTOMark dTOMark) {
        this.dTOMark = dTOMark;
    }

    public String getMarkID() {
        return markID;
    }

    public void setMarkID(String markID) {
        this.markID = markID;
    }

    public String getAvengerName() {
        return avengerName;
    }

    public void setAvengerName(String avengerName) {
        this.avengerName = avengerName;
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

    public void setDto(RegistrationDTO dto) {
        this.dto = dto;
    }

    public String checkLogin() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.checkLogin(username, password);
    }
    
    public List<RegistrationDTO_Mission> allListMission() throws Exception{
        RegistrationDAO_Mission dao = new RegistrationDAO_Mission();
        return dao.allListMission();
    }
    
    public List<RegistrationDTO> allListAvenger() throws Exception{
        RegistrationDAO dao = new RegistrationDAO();
        return dao.allListAvenger();
    }

    public List<RegistrationDTO> findLikeByAvengerName() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.findLikeByAvengerName(avengerName);
    }

    public List<RegistrationDTOMark> findLikeByMarkID() throws Exception {
        RegistrationDAO_Mark daoMark = new RegistrationDAO_Mark();
        return daoMark.findLikeByMarkName(markID);
    }
    
    public List<RegistrationDTO_Mission> findLikeByMissionID() throws Exception{
        RegistrationDAO_Mission daoMission = new RegistrationDAO_Mission();
        return daoMission.findLikeByMissionID(missionID);
    }
    
    public RegistrationDTO_Mission findLikeByPrimaryKey() throws Exception{
        RegistrationDAO_Mission daoMission = new RegistrationDAO_Mission();
        return daoMission.findLikeByPrimaryKey(missionID);
    }

    public boolean insert() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.insert(dto);
    }

    public boolean insertMark() throws Exception {
        RegistrationDAO_Mark daoMark = new RegistrationDAO_Mark();
        return daoMark.insertMark(dTOMark);
    }
    
    public boolean insertMission() throws Exception{
        RegistrationDAO_Mission daoMission = new RegistrationDAO_Mission();
        return daoMission.insertMission(dTO_Mission);
    }
    
    public boolean setMission()throws Exception{
        RegistrationDAO_Mission daoMission = new RegistrationDAO_Mission();
        return daoMission.setMission(dTO_Mission);
    }

    public boolean delete() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.delete(username);
    }

    public boolean deleteMark() throws Exception {
        RegistrationDAO_Mark daoMark = new RegistrationDAO_Mark();
        return daoMark.deleteMark(markID);
    }
    
    public boolean deleteMission() throws Exception{
        RegistrationDAO_Mission daoMark = new RegistrationDAO_Mission();
        return daoMark.deleteMission(missionID);
    }

    public boolean update() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.update(dto);
    }
    
    public boolean updateMission() throws Exception{
        RegistrationDAO_Mission daoMission = new RegistrationDAO_Mission();
        return daoMission.updateMission(missionID, oldUsername, username);
    }

    public RegistrationDTO findLikeByPrimarykey() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.findLikeByPrimaryKey(username);
    }
}
