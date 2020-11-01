package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.Connec;

@WebServlet("/LoginS")
public class LoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email, _email;
	private String pwd, _pwd;
	
   
    public LoginS() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/htmal");
		Connec con = new Connec();
		
		try(PrintWriter out = response.getWriter()){
			email = request.getParameter("email");
			pwd = request.getParameter("password");
			
			out.print(email);
			//con.readConnec(email, pwd, _email,  _pwd);
			System.out.println(email);
			
			out.print(_email);
			out.print(_pwd);

			
			if(email != null && pwd != null) {
				if(email.equals(_email) && pwd.equals(_pwd)) {
					response.sendRedirect("Profile.jsp");
				}else {
					out.println("Invalid user or password");
				}
			}else {
				out.println("Empty Username or password");
			}
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
