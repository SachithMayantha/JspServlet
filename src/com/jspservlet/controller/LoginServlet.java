package com.jspservlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspservlet.dao.UserDAO;
import com.jspservlet.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
	
	try
	{	  
	     User user = new User();
	     user.setUsername(request.getParameter("un"));
	     user.setPassword(request.getParameter("pw"));
	
	     user = UserDAO.login(user);
		   		    
	     if (user.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",user);
	          response.sendRedirect(request.getContextPath()+"/users"); //logged-in page      		
	     }
		        
	     else 
	          response.sendRedirect("loginError.jsp"); //error page 
		} 
			
			
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}
}