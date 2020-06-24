package com.jspservlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspservlet.dao.UserDAO;
import com.jspservlet.model.User;


@WebServlet("/edit")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	 public UserEditServlet() {
	        this.userDAO = new UserDAO();
	    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit doGet() called");
		
		//don't create another new session
		HttpSession session=request.getSession(false);
		
		if(session!=null && session.getAttribute("user")!=null) {
			
			System.out.println("session exists");
			String action = request.getServletPath();
			
			switch (action) {
			case "/edit":
				try {
					showEditForm(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}else {
			System.out.println("session not exists");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			System.out.println("session is working in UserEdit");
		}
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		//get the id using request object
		int id = Integer.parseInt(request.getParameter("id"));
		//get user object using selectUser method
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp"); 
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

}
