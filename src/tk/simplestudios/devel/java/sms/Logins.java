package tk.simplestudios.devel.java.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Logins {
	Database db = new Database();
	
	public boolean isLoginValid(String user, String pass_hash){
		String[][] users = db.getUserList();
		for (int i = 0; i < users.length; i++){
			if (users[i][0].equals(user) && users[i][2].equals(pass_hash)) return true;
		}
		return false;
	}
	
	public static String encrypt(String input){
		String salt = "simplestudios";
		String md5 = md5(input+salt);
		String sha1 = sha1(salt+input);
		return sha1(md5+sha1);
	}
	
	public static String md5(String input) {
		String output = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			output = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			System.out.println("Algorithm error.");
		}
		return output;
	}
	
	public static String sha1(String input){
		String output = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(input.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			output = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Algorithm error.");
		}
		
		return output;
	}

	
}
