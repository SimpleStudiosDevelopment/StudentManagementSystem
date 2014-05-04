package tk.simplestudios.devel.java.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Logins {
	ArrayList<String> users;
	ArrayList<String> hashes;
	
	public String md5(String input) {
		String output = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.digest(input.getBytes());
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
	
	public void loadData(){
		
	}
	
}
