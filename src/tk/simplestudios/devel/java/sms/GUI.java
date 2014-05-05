package tk.simplestudios.devel.java.sms;

import java.awt.Font;

import javax.swing.*;

public class GUI extends JFrame{
	JPanel content;
	JPanel loginScreen;
	
	JLabel login_title;
	JTextField login_username;
	
	User currUser = null;
	
	public GUI(){
		this.setVisible(true);
		components();
		initLogins();
		login();
	}
	
	public void components(){
		content = new JPanel();
	}
	
	public void initLogins(){
		loginScreen = new JPanel();
		
		login_title = new JLabel("Login");
		Font login_title_f = new Font("LoginTitle", Font.BOLD, 16);
		login_title.setFont(login_title_f);
		loginScreen.add(login_title);
		
		login_username = new JTextField();
		
		
		
	}
	
	public void login(){
		setContentPane(loginScreen);
	}
	
	public static void main(String[] args){
		new GUI();
	}
}
