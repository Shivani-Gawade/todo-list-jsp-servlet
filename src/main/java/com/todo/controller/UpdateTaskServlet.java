package com.todo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.util.DBConnection;

/**
 * Servlet implementation class UpdateTaskServlet
 */
@WebServlet("/UpdateTaskServlet")
public class UpdateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int id = Integer.parseInt(request.getParameter("task_id"));
        String title = request.getParameter("title");
        String status = request.getParameter("status");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE tasks SET title=?, status=? WHERE task_id=?");
            ps.setString(1, title);
            ps.setString(2, status);
            ps.setInt(3, id);
            ps.executeUpdate();
            
        } catch(Exception e){
        	e.printStackTrace();
        }

        response.sendRedirect("dashboard.jsp");
    }

	

}
