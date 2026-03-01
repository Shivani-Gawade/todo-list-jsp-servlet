package com.todo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.model.User;
import com.todo.util.DBConnection;

/**
 * Servlet implementation class AddTaskServlet
 */
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 HttpSession session = request.getSession(false);
	        User user = (User) session.getAttribute("user");

	        if (user == null) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        int userId = user.getId();
	        String title = request.getParameter("title");
	        String status = request.getParameter("status");

	        try {
	            Connection con = DBConnection.getConnection();

	            String sql = "INSERT INTO tasks (user_id, title, description, due_date, status) VALUES (?, ?, NULL, NULL, ?)";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, userId);
	            ps.setString(2, title);
	            ps.setString(3, status);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                response.sendRedirect("dashboard.jsp");
	            } else {
	                response.sendRedirect("addTask.jsp?error=1");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("addTask.jsp?error=2");
	        }
		
	}

}
