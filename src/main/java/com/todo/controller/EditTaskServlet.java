package com.todo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.util.DBConnection;

/**
 * Servlet implementation class EditTaskServlet
 */
@WebServlet("/EditTaskServlet")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 int id = Integer.parseInt(request.getParameter("task_id"));

	        try {
	            Connection con = DBConnection.getConnection();
	            
	            PreparedStatement ps = con.prepareStatement(
	                "SELECT * FROM tasks WHERE task_id=?");
	            
	            ps.setInt(1, id);
	            
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                request.setAttribute("task_id", rs.getInt("task_id"));
	                request.setAttribute("title", rs.getString("title"));
	                request.setAttribute("status", rs.getString("status"));
	                request.getRequestDispatcher("editTask.jsp").forward(request, response);
	            }
	        } catch(Exception e){
	            e.printStackTrace();
	        }
	}

}
