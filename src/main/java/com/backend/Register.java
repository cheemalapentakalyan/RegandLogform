package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@WebServlet("/regForm")
public class Register extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/Html");
		 PrintWriter out = resp.getWriter();

		String myname =req.getParameter("name1");
		String myemail =req.getParameter("email1");
		String mypassword =req.getParameter("pass1");
		String mygender =req.getParameter("gender1");
		String mycity =req.getParameter("city1");
		
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Kalyan@1234");
		
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
		
		ps.setString(1, myname);             
		ps.setString(2, myemail);
		ps.setString(3, mypassword);
		ps.setString(4, mygender);
		ps.setString(5, mycity);
		int count = ps.executeUpdate();
		if(count >0) {
			
			resp.setContentType("text/html");
			out.print("<h3 style=color:green>user registerd successfully</h3>");
		
			RequestDispatcher rd= req.getRequestDispatcher("/Register.jsp");
			rd.include(req, resp);
		}
		else {   
			resp.setContentType("text/html");
			out.print("<h3 style=color:red>not registered successfully</h3>");
			RequestDispatcher rd= req.getRequestDispatcher("/Register.jsp");
			rd.include(req, resp);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		resp.setContentType("text/html");
		out.print("<h3 style=color:green>Exception ocurred:"+e.getMessage()+"</h3>");
	
		RequestDispatcher rd= req.getRequestDispatcher("/Register.jsp");
		rd.include(req, resp);
		
		
	}
	}

}





