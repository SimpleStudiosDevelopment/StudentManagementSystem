package tk.simplestudios.devel.java.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Logins {
	
	public static String encrypt(String input){
		String salt = "simplestudios";
		return sha1(md5(salt+input));
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
