package com.aniket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Dashboard() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Cookie cookies[]=request.getCookies();
		if(cookies!=null) {
		  out.println("<h1>WELCOME TO YOUR PROFILE</h1>");
		
			  for (Cookie cookie : cookies) {
				 cookie.setMaxAge(0);
					response.addCookie(cookie);
				  }
		}else {
			out.println("Please login to view this page");
			response.sendRedirect("/Java_Servlet_Assignment/");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
