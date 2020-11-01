package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.Connec;

@WebServlet("/Registation")
public class Registation extends HttpServlet {
	Connec con = new Connec();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			con.starConnec();
			
			String email = request.getParameter("email");
			String usuario = request.getParameter("usuario");
			String pwd = request.getParameter("pwd");
			
			if(email != null)
			con.insertConnec(email,usuario,pwd);
			else 
				out.println("Error");
		
		} catch (SQLException e) {
							
			e.printStackTrace();
		}	
		
	}

}
