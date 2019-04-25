/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.daos;

import baohq.connection.MyConnection;
import baohq.dtos.RegistrationDTO_Mission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class RegistrationDAO_Mission {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public List<RegistrationDTO_Mission> findLikeByMissionID(String search) throws SQLException{
        List<RegistrationDTO_Mission> result = null;
        String missionID = null;
        String username = null;
        RegistrationDTO_Mission dtoMission = null;
        try {
            String sql = "select MissionID, Username from AvengerMission where MissionID LIKE ? and Active=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setBoolean(2, true);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                missionID = rs.getString("MissionID");
                username = rs.getString("Username");
                dtoMission = new RegistrationDTO_Mission(missionID, username);
                result.add(dtoMission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public boolean deleteMission(String missionID) throws Exception{
        boolean check = false;
        try {
            String sql="update AvengerMission set Active=? where MissionID=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, false);
            preStm.setString(2, missionID);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean updateMission(String missionID, String username, String newUsername) throws SQLException, Exception{
        boolean check;
        try {
            String sql = "update AvengerMission set Username=? where MissionID=? and Username=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, newUsername);
            preStm.setString(2, missionID);
            preStm.setString(3, username);
            check = preStm.executeUpdate() >= 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    
    public RegistrationDTO_Mission findLikeByPrimaryKey(String missionID) throws SQLException{
        RegistrationDTO_Mission dtoMission = null;
        String username = null;
        try {
            String sql = "select MissionID, Username from AvengerMission where missionID LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, missionID);
            rs = preStm.executeQuery();
            while(rs.next()){
                missionID = rs.getString("MissionID");
                username = rs.getString("Username");
                dtoMission = new RegistrationDTO_Mission(missionID, username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return dtoMission;
    }
    
    public boolean setMission(RegistrationDTO_Mission dtoMission) throws SQLException, Exception{
        boolean check;
        try {
            String sql = "insert into AvengerMission(MissionID, Username, Active) values(?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dtoMission.getMissionID());
            preStm.setString(2, dtoMission.getUsername());
            preStm.setBoolean(3, true);
            check = preStm.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insertMission(RegistrationDTO_Mission dtoMission) throws SQLException, Exception{
        boolean check;
        try {
            String sql = "insert into Mission(MissionID, MissionDescription, MissionStatus) values(?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dtoMission.getMissionID());
            preStm.setString(2, dtoMission.getMissionDescription());
            preStm.setString(3, dtoMission.getMissionStatus());
            check = preStm.executeUpdate() > 0;
        }finally {
            closeConnection();
        }
        return check;
    }
    
    public List<RegistrationDTO_Mission> allListMission() throws SQLException, Exception{
        List<RegistrationDTO_Mission> result = null;
        try {
            String sql = "select MissionID, MissionDescription, MissionStatus from Mission";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {                
                String missionID = rs.getString("MissionID");
                String missionDescription = rs.getString("MissionDescription");
                String missionStatus = rs.getString("MissionStatus");
                result.add(new RegistrationDTO_Mission(missionID, missionDescription, missionStatus));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
