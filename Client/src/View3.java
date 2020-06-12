
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View3 extends JFrame {
	
	private static String[] limba = {"Nume","Parola", "Autentificare","Autentificare"};
	private static String titlu = "Autentificare";
	
	private JLabel username=new JLabel("Username");
	private JLabel password=new JLabel("Password");
	private JTextField nume=new JTextField("");
	private JTextField parola=new JTextField("");
	private JButton b1 = new JButton("Login");
	
	public View3() {
		titlu = limba[3];
		this.setTitle(titlu);
		this.setVisible(true);
		this.setSize(400,225);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(2,1));
		nume.setColumns(27);
		parola.setColumns(27);
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		username.setText(limba[0]);
		p.add(username);
		p.add(nume);
		password.setText(limba[1]);
		p.add(password);
		p.add(parola);
		b1.setText(limba[2]);
		p1.add(b1);
		this.add(p);
		this.add(p1);
	}
	
	public static void setLimba(String[] nouaLimba) {
		
		limba = nouaLimba;
		
	}
	
	public String getTextField1() {
		return nume.getText();
	}
	
	public String getTextField2() {
		return parola.getText();
	}
	
	  public void addButtonListener(ActionListener listenForButton) {
			
			b1.addActionListener(listenForButton);
			
		}

}
