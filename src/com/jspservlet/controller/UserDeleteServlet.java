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

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    
    public UserDeleteServlet() {
        this.userDAO = new UserDAO();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//don't create another new session
		HttpSession session=request.getSession(false);
		
		if(session!=null && session.getAttribute("user")!=null) {
			String action = request.getServletPath();
			
			switch(action) {
			case "/delete":
				try {
					deleteUser(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
	
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			System.out.println("session is working in UserDelete");
		}
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		//get the user id using request object
		int id = Integer.parseInt(request.getParameter("id"));
		//delete the relative user from the database
		userDAO.deleteUser(id);
		response.sendRedirect(request.getContextPath()+"/users");
	}

}
