package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.loginconnection;
import services.loginservice;
@WebServlet("/deletebyemail")
public class delbyemailservlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email =req.getParameter("email");
		loginservice ls=new loginservice(loginconnection.getconnection());
		boolean f=ls.deletebyemail(email);
		if(f)
		{
			resp.sendRedirect("welcome.jsp");
		}
		else {
			resp.sendRedirect("welcome.jsp");
		}
	}

}
