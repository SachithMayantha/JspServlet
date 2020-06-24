package com.jspservlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/new")
public class UserNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//don't create another new session
				HttpSession session=request.getSession(false);
				
				if(session!=null && session.getAttribute("user")!=null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("insert.jsp");
					dispatcher.forward(request, response);
				}else {
					response.sendRedirect(request.getContextPath()+"/login.jsp");
					System.out.println("session is working in UserEdit");
				}
		}

}
