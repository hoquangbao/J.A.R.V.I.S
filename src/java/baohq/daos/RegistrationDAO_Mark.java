/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.daos;

import baohq.connection.MyConnection;
import baohq.dtos.RegistrationDTOMark;
import java.io.Serializable;
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
public class RegistrationDAO_Mark implements Serializable {

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

    public List<RegistrationDTOMark> findLikeByMarkName(String search) throws SQLException {
        List<RegistrationDTOMark> result = null;
        String markID = null;
        RegistrationDTOMark dtoMark = null;
        try {
            String sql = "select MarkID from Marks where MarkID LIKE ? and Active = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setBoolean(2, true);
            rs = preStm.executeQuery();
            result = new ArrayList();
            while (rs.next()) {
                markID = rs.getString("MarkID");
                dtoMark = new RegistrationDTOMark(markID);
                result.add(dtoMark);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insertMark(RegistrationDTOMark dtoMark) throws SQLException {
        boolean check = false;
        try {
            String sql = "insert into Marks(MarkID, Active) values(?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dtoMark.getMarkID());
            preStm.setBoolean(2, true);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteMark(String markID) throws SQLException {
        boolean check = false;
        try {
            String sql = "update Marks set Active=? where MarkID=?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, false);
            preStm.setString(2, markID);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }


}
