package com.aniket;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname,pass,email;
    public Signup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("signup.html");
        view.forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.uname = request.getParameter("username");
		this.pass = request.getParameter("password");
		this.email = request.getParameter("email");
		Cookie cred = new Cookie("cred", this.uname+":"+this.pass);
		Cookie email_c = new Cookie("email", this.email);
		response.addCookie(cred);
		response.addCookie(email_c);
		System.out.println(this.email);
		System.out.println(this.uname);
		System.out.println(this.pass);
		response.sendRedirect("/Java_Servlet_Assignment/login");
	}

}
