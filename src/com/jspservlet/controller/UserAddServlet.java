package com.jspservlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspservlet.dao.UserDAO;
import com.jspservlet.model.User;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/insert")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    
    public UserAddServlet() {
        this.userDAO = new UserDAO();
    }
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/insert":
		try {
			insertUser(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;	
		}
		
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		//retrieve user details using request object
		System.out.println("insertUser method in Servlet");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String department = request.getParameter("department");
		User newUser = new User(id,username,password,department);
		//insert the retrieve data to database
		userDAO.insertUser(newUser);
		response.sendRedirect(request.getContextPath() +"/users");
	}
}
