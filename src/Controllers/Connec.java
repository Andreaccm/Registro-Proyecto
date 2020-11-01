package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connec {
	private static String url = "jdbc:postgresql://localhost:5433/web";
	private static String user = "postgres";
	private static String pwd = "250797Ac*";
	private static String driver = "org.postgresql.Driver";
	Connection con;
	
	String sql,email1,pwd1;
	PreparedStatement pst;
	PreparedStatement pst1;
	Statement st;
	
	public void starConnec() throws SQLException {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void closeConnec() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertConnec(String email,String usuario,String pwd) {
		sql = "INSERT INTO registation VALUES (?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, usuario);
			pst.setString(3, pwd);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteConnec(String email) {
		
	}
	
	public void upDateConnec(String email) {
		
	}
	
	public void  readConnec(String email, String pwd, String _email, String _pwd) {
		Connec cone = new Connec();
		
		Statement st;
		ResultSet result;
		
		sql = "select *from registation where email = '"+email+"' and password_pwd = '"+pwd+"'";
		try {
			cone.starConnec();
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setString(1, email);
			stt.setString(3, pwd);
			
			result = stt.executeQuery();
			
		
			
		
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
		cone.closeConnec();
	}



}

