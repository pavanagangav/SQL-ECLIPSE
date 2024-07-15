package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.studentdb;
import model.student;
import services.studentservice;

@WebServlet("/register")

public class studentservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Rollnumber = req.getParameter("rollnumber");
		String Name = req.getParameter("name");
		String Branch = req.getParameter("branch");
		String Email = req.getParameter("email");
		String Section = req.getParameter("section");

		student std = new student(Rollnumber, Name, Email, Branch, Section);
		studentservice services = new studentservice(studentdb.getconn());
		boolean f = services.addstudent(std);
		if (f) {
			resp.sendRedirect("welcome.jsp");
		} else {
			resp.sendRedirect("register.jsp");
		}

	}

}
