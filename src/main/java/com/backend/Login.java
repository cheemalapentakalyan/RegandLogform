package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;


@WebServlet("/LogForm")
public class Login extends HttpServlet {
	
   
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		 String email=request.getParameter("email1");
		 String password=request.getParameter("password1");
		
		
		
	try {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Kalyan@1234");
	
	PreparedStatement ps = con.prepareStatement("select * from student where email=? and password=?");
	ps.setString(1, email);
	ps.setString(2, password);
	     ResultSet rs =ps.executeQuery();
	     if(rs.next()) {
	    	 
	    	 response.setContentType("text/html");
	    	 HttpSession session =request.getSession();
	         session.setAttribute("session_name",rs.getString("Name"));
	    	 
	    	 
	    	 
	    	 RequestDispatcher rd= request.getRequestDispatcher("/profile.jsp");
	    	 rd.include(request, response);
	    	 
	     }else {
	    	 response.setContentType("text/html");
	    	 out.print("<h3 style=color:red>email nd password didnt match</h3>");
	    	 
	    	 RequestDispatcher rd= request.getRequestDispatcher("/Login.jsp");
	    	 rd.include(request, response);
	    	 
	     }
	  
	    
	
	}
	catch(Exception e) {
		
		
		e.printStackTrace();
		response.setContentType("text/html");
		out.print("<h3 style=color:green>Exception ocurred:"+e.getMessage()+"</h3>");
	
		RequestDispatcher rd= request.getRequestDispatcher("/Register.jsp");
		rd.include(request, response);
	}
	}

}
