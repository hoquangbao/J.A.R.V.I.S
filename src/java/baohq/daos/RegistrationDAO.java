/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.daos;

import baohq.connection.MyConnection;
import baohq.dtos.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class RegistrationDAO implements Serializable {

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
    
    public String checkLogin(String username, String password) throws Exception{
        String role = "failed";
        try {
            String sql ="select Role from Avengers where Username=? and Password=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()){
                role = rs.getString("Role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return role;
    }
    
    public List<RegistrationDTO> findLikeByAvengerName(String search) throws SQLException{
        List<RegistrationDTO> result = null;
        String username = null;
        String avengerName = null;
        String fullname = null;
        String role = null;
        Date dateOfBirth = null;
        RegistrationDTO dto = null;
        try {
            String sql = "select Username, AvengerName, Fullname, DateOfBirth, Role from Avengers where AvengerName LIKE ? and Active=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setBoolean(2, true);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                username = rs.getString("Username");
                avengerName = rs.getString("AvengerName");
                fullname = rs.getString("Fullname");
                dateOfBirth = rs.getDate("DateOfBirth");
                role = rs.getString("Role");
                dto = new RegistrationDTO(username, avengerName, fullname, role, dateOfBirth);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return result;
    }

    
    public boolean insert(RegistrationDTO dto) throws SQLException{
        boolean check = false;
        try {
            String sql = "insert into Avengers(Username, Password, AvengerName, Fullname, DateOfBirth, Role, Active)"
                    + " values(?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getAvengerName());
            preStm.setString(4, dto.getFullname());
            preStm.setDate(5, dto.getDateOfBirth());
            preStm.setString(6, dto.getRole());
            preStm.setBoolean(7, true);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
    

    
    public boolean delete(String username) throws SQLException{
        boolean check = false;
        try {
            String sql = "update Avengers set Active=? where Username=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, false);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
    
    
    public boolean update(RegistrationDTO dto) throws SQLException{
        boolean check = false;
        try {
            String sql = "update Avengers set Password=?, AvengerName=?, Fullname=?, DateOfBirth=?, Role=? "
                    + "where Username=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getAvengerName());
            preStm.setString(3, dto.getFullname());
            preStm.setDate(4, dto.getDateOfBirth());
            preStm.setString(5, dto.getRole());
            preStm.setString(6, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
    
    
    public RegistrationDTO findLikeByPrimaryKey(String username) throws SQLException{
        RegistrationDTO dto = null;
        String password = null;
        String avengerName = null;
        String fullname = null;
        String role = null;
        Date dateOfBirth = null;
        try {
            String sql = "select Username, Password, AvengerName, Fullname, DateOfBirth, Role from Avengers where Username LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while(rs.next()){
                username = rs.getString("Username");
                password = rs.getString("Password");
                avengerName = rs.getString("AvengerName");
                fullname = rs.getString("Fullname");
                dateOfBirth = rs.getDate("DateOfBirth");
                role = rs.getString("Role");
                dto = new RegistrationDTO(username, password, avengerName, fullname, role, dateOfBirth);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    public List<RegistrationDTO> allListAvenger() throws Exception, SQLException{
        List<RegistrationDTO> result = null;
        try {
            String sql = "select Username, AvengerName, Fullname, DateOfBirth, Role from Avengers where Active=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, true);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                String username = rs.getString("Username");
                String avengerName = rs.getString("AvengerName");
                String fullname = rs.getString("Fullname");
                Date dateOfBirth = rs.getDate("DateOfBirth");
                String role = rs.getString("Role");
                result.add(new RegistrationDTO(username, avengerName, fullname, role, dateOfBirth));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
