
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewSelectA extends JFrame {
	
	private static String[] limba= {"Introdu adresa de e-mail","Operatii CRUD"};
	private static String titlu = "Operatii CRUD";
	
	private JLabel l1 = new JLabel("Introdu adresa de e-mail");
	private JTextField t1 = new JTextField("");
	private JButton b1 = new JButton("OK");
	
	public ViewSelectA() {
		titlu = limba[1];
		this.setTitle(titlu);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(250,100);
		t1.setColumns(10);
		this.setLayout(new GridLayout(1,3));
		JPanel p = new JPanel();
		l1.setText(limba[0]);
		p.add(l1);
		p.add(t1);
		p.add(b1);
		this.add(p);
		
	}
	
	public static void setLimba(String[] nouaLimba) {
		
		limba = nouaLimba;
		
	}
	
	
	public String getTextField() {
		return t1.getText();
	}
	
	public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
	}

}
