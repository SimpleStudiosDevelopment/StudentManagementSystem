package tk.simplestudios.devel.java.sms;

import java.sql.*;

public class Database {
	Connection conn;
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
		 
	}
}
