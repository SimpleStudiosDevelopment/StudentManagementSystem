package tk.simplestudios.devel.java.sms;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	Connection conn;
	PreparedStatement query = null;
	
	ArrayList<String> users;
	
	public Database(){
		String url = "jdbc:mysql://db4free.net:3306/";
		String dbName = "stumansysdata";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "simplestudios"; 
		String password = "SimplyComplex1!2";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
		} catch (Exception e){
			e.printStackTrace();
		}
		printUsers();
	}
	public static void main(String[] args){
		new Database();
	}
	
	public void printUsers() {
		try {
			query = conn.prepareStatement("SELECT * FROM `Logins`");
			ResultSet logins = query.executeQuery();
			while(logins.next()){
				String user = logins.getString("Username");
				int id = logins.getInt("ID");
				String email = logins.getString("Email");
				boolean teacher = logins.getBoolean("Teacher");
				
				System.out.print("* User: " + user);
				String p = teacher ? ", Teacher" : "";
				System.out.println(p);
				System.out.println("  ID: " + id);
				System.out.println("  Email: " + email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = null;
	}
}
