package com.aniket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname,pass;
   
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookies[]=request.getCookies();
		if(cookies!=null) {
			RequestDispatcher view = request.getRequestDispatcher("index.html");
	        view.forward(request, response);   
		}else {
			response.sendRedirect("/Java_Servlet_Assignment/signup");
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		Cookie cookies[]=request.getCookies();
		PrintWriter out = response.getWriter();
		this.uname = request.getParameter("username");
		this.pass = request.getParameter("password");
		System.out.println(this.uname);
		System.out.println(this.pass);
		if (cookies != null) {
			 for (Cookie cookie : cookies) {
			   if (cookie.getValue().equals(this.uname+":"+this.pass)) {
				   response.sendRedirect("/Java_Servlet_Assignment/Dashboard");
			    }else {
			    	flag = true;
			    }
			  }
			}
		if (flag) {
			out.println("Invalid username/password.....");
		} 
	}

}
