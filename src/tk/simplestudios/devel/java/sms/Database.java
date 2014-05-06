package tk.simplestudios.devel.java.sms;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	static Connection conn;
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
	}
	public static void main(String[] args){
		new Database();
		System.out.println(getRowCount());
	}
	
	public String[][] getUserList(){
		String[][] list = null;
		try {
			ResultSet users = runQuery("SELECT * FROM 'Logins'");
			int size = query.getUpdateCount();
			list = new String[size][4];
			for (int i = 0; i < size; i++){
				users.next();
				//0: user
				//1: email
				//2: password
				//3: id
				list[i][0] = users.getString("Username");
				list[i][1] = users.getString("Email");
				list[i][2] = users.getString("Password");
				list[i][3] = Integer.toString(users.getInt("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int getRowCount(){
		PreparedStatement ps;
		int size = 0;
		try {
			ps = conn.prepareStatement("SELECT * FROM 'Logins'");
			size = ps.getUpdateCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
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
	public ResultSet runQuery(String statement){
		ResultSet rs = null;
		try {
			query = conn.prepareStatement(statement);
			rs = query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = null;
		return rs;
		
	}
}
