package com.jspservlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//don't create another new session
		HttpSession session=request.getSession(false);
		System.out.println("UserAdd class called");
		if(session!=null && session.getAttribute("user")!=null) {
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
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			System.out.println("session is working in UserAdd");
		}
	}
	//check the inputs are valid or not
	public Boolean check(boolean done,HttpServletRequest request) {
		System.out.println("check() called");
		//check the id is a number or not
		Pattern pattern = Pattern.compile(".*[^0-9].*");
		
		if(request.getParameter("id") == null) { 
		return false;
		}else if(pattern.matcher(request.getParameter("id")).matches()) {
		return false;	
		}
		else
			return true;	
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		//retrieve user details using request object
		System.out.println("insertUser method in Servlet");
		if(check(true,request)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password");
			String department = request.getParameter("department");
			User newUser = new User(id,username,password,department);
			//insert the retrieve data to database
			userDAO.insertUser(newUser);
			response.sendRedirect(request.getContextPath() +"/users");
		}else
			response.sendRedirect(request.getContextPath() +"/new?");
	}
}
