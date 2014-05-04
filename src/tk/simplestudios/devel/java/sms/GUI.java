package tk.simplestudios.devel.java.sms;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	JPanel content;
	
	JPanel loginScreen;
	
	public GUI(){
		this.setVisible(true);
		components();
	}
	
	public void components(){
		content = new JPanel();
		setContentPane(content);
		
		
	}
	
	public static void main(String[] args){
		new GUI();
	}
}
