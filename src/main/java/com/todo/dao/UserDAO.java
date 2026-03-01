package com.todo.dao;
import java.sql.*;
import com.todo.model.User;
import com.todo.util.DBConnection;

public class UserDAO {

    public boolean registerUser(User user) {
        boolean status = false;
        
        try{
        	Connection con = DBConnection.getConnection();
        	
            String sql = "INSERT INTO users(id,name,email,password) VALUES(users_seq.NEXTVAL,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rows = ps.executeUpdate();
            status = rows > 0;
            
        } catch (Exception e){
        	e.printStackTrace(); 
        	
        }
        return status;
    }
    
    

    public User login(String email, String password) {
    	
        User user = null;
        
        try{
        	
        	Connection con = DBConnection.getConnection();
        	
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
            }
            
        } catch (Exception e) {
        	e.printStackTrace(); 
        	
        }
        return user;
    }
}
