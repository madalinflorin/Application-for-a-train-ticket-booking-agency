
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewUpdate extends JFrame {
	
	
	private static String[] limba = {"Statie plecare","Statie sosire","Durata","Locuri","Pret","Operatii CRUD"};
	private static String titlu = "Operatii CRUD";
	
	private JLabel l1 = new JLabel("Statie plecare");
	private JLabel l2 = new JLabel("Statie sosire");
	private JLabel l3 = new JLabel("Durata");
	private JLabel l4 = new JLabel("Locuri");
	private JLabel l5 = new JLabel("Pret");
	private JTextField t1 = new JTextField("");
	private JTextField t2 = new JTextField("");
	private JTextField t3 = new JTextField("");
	private JTextField t4 = new JTextField("");
	private JTextField t5 = new JTextField("");
	private JButton b1 = new JButton("OK");
	
	public ViewUpdate()
	{
		titlu = limba[5];
		this.setTitle(titlu);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(250,300);
		t1.setColumns(10);
		t2.setColumns(10);
		t3.setColumns(10);
		t4.setColumns(10);
		t5.setColumns(10);
		this.setLayout(new GridLayout(6,2));
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l1.setText(limba[0]);
		p.add(l1);
		p5.add(t1);
		l2.setText(limba[1]);
		p1.add(l2);
		p6.add(t2);
		l3.setText(limba[2]);
		p2.add(l3);
		p7.add(t3);
		l4.setText(limba[3]);
		p3.add(l4);
		p8.add(t4);
		l5.setText(limba[4]);
		p4.add(l5);
		p9.add(t5);
		p10.add(b1);
		this.add(p);
		this.add(p5);
		this.add(p1);
		this.add(p6);
		this.add(p2);
		this.add(p7);
		this.add(p3);
		this.add(p8);
		this.add(p4);
		this.add(p9);
		this.add(p10);
		
	}
	
	public static void setLimba(String[] nouaLimba) {
		
		limba = nouaLimba;
		
	}
	
	public String getTextField() {
		return t1.getText();
	}
	
	public String getTextField1() {
		return t2.getText();
	}
	
	public String getTextField2() {
		return t3.getText();
	}
	
	public String getTextField3() {
		return t4.getText();
	}
	
	public String getTextField4() {
		return t5.getText();
	}
	
	
public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
	}
    
	
	

}
