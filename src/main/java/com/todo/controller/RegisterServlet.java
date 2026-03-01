package com.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.dao.UserDAO;
import com.todo.model.User;

/**
 * Servlet implementation class RegisterServlets
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    User user = new User(name, email, password);
	    UserDAO dao = new UserDAO();
	    boolean status = dao.registerUser(user);

	    if (status) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);

	        response.sendRedirect(request.getContextPath() + "/dashboard.jsp");  // go directly

	    } else {
	        response.sendRedirect("register.jsp?error=1");
	    }
	}


}
