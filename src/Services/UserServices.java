/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import IServices.IUserServices;
import Services.connectionManger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed osama
 */
public class UserServices implements IUserServices {

    private Connection c;

    public UserServices() {
        c = connectionManger.getInc().getConnection();
    }

    public void signUp(User user) {

        String sql = "insert into user (id,username,password,icon)"
                + "values (?,?,?,?)";

        try {
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, UUID.randomUUID().toString());
            st.setString(2, user.username);
            st.setString(3, user.password);
            st.setInt(4, user.icon);
            int affected = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User signIn(String username, String password) {
        String sql = "select * from user where username= ? and password = ?";

        try {
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.id=UUID.fromString(rs.getString("id"));
                user.username = rs.getString("username");
                user.global_score = rs.getInt("global_score");
                user.icon = rs.getInt("icon");
                return user;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }
    }
    
    public User getById(UUID id) {
        String sql = "select * from user where id=?";

        try {
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1,id.toString());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.id=UUID.fromString(rs.getString("id"));
                user.username = rs.getString("username");
                user.global_score = rs.getInt("global_score");
                user.icon = rs.getInt("icon");
                return user;
            } else {
                return null;
            } 

        } catch (SQLException ex) {
            return null;
        }
    }
    
    public User getByUsername(String username) {
        String sql = "select * from user where username=?";

        try {
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1,username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.id=UUID.fromString(rs.getString("id"));
                user.username = rs.getString("username");
                user.global_score = rs.getInt("global_score");
                user.icon = rs.getInt("icon");
                return user;
            } else {
                return null;
            } 

        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean addScore(int score, UUID id)
    {
        try {
            User us=getById(id);
            String sql="update user set global_score = ? where id=? ";
            int newScore=us.global_score+score;
            PreparedStatement st =c.prepareStatement(sql);
            st.setInt(1,newScore);
            st.setString(2,us.id.toString());
            int affected=st.executeUpdate();
            return affected==1;
        } catch (SQLException ex) {
            return false;
        }
        
    }

}
