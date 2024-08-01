package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.loginconnection;
import model.login;
import services.loginservice;
@WebServlet("/register")
public class loginservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
//	Long phonenumber=Long.parseLong()
	login lo=new login(0, name,email,password);
	loginservice ls=new loginservice(loginconnection.getconnection());
	boolean f=ls.addingstudent(lo);
	if (f) {
		resp.sendRedirect("welcome.jsp");
		
	} else {
		resp.sendRedirect("login.jsp");
		
	}
	
	}

}
