package com.todo.dao;
import java.sql.*;
import java.util.*;
import com.todo.model.Task;
import com.todo.util.DBConnection;

public class TaskDAO {

	public List<Task> getTasks(int userId) throws Exception {
	    List<Task> list = new ArrayList<>();
	    Connection con = DBConnection.getConnection();
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM tasks WHERE user_id=?");
	    ps.setInt(1, userId);
	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	        Task t = new Task();
	        t.setTaskId(rs.getInt("task_id"));   
	        t.setTitle(rs.getString("title"));
	        t.setStatus(rs.getString("status"));
	        list.add(t);
	    }
	    return list;
	}
}
