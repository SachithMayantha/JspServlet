package com.jspservlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspservlet.dao.UserDAO;
import com.jspservlet.model.User;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    
    public UserUpdateServlet() {
        this.userDAO = new UserDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session!=null && session.getAttribute("user")!=null) {
			String action = request.getServletPath();
			
			switch (action) {
			case "/update":
			try {
				updateUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			}		
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			System.out.println("session is working in UserUpdate");
		}
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		System.out.println("updateUser() called");
		//retrieve user details using request object
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		String department = request.getParameter("department");
		boolean valid = Boolean.parseBoolean(request.getParameter("valid"));
		
		User user = new User(id, username, password, department,valid);
		userDAO.updateUser(user);
		response.sendRedirect(request.getContextPath()+"/users");
	}

}
