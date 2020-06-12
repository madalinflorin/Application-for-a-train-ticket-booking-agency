
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewUpdate1 extends JFrame {
	
	private static String[] limba = {"Nume","Prenume","Nr.tel","E-mail","CNP","ID tren","Pret","Operatii CRUD"};
	private static String titlu = "Operatii CRUD";
	
	
	private JLabel l1 = new JLabel("Nume");
	private JLabel l2 = new JLabel("Prenume");
	private JLabel l3 = new JLabel("Nr.tel");
	private JLabel l4 = new JLabel("E-mail");
	private JLabel l5 = new JLabel("CNP");
	private JLabel l6 = new JLabel("ID tren");
	private JLabel l7 = new JLabel("Pret");
	
	
	private JTextField t1 = new JTextField("");
	private JTextField t2 = new JTextField("");
	private JTextField t3 = new JTextField("");
	private JTextField t4 = new JTextField("");
	private JTextField t5 = new JTextField("");
	private JTextField t6 = new JTextField("");
	private JTextField t7 = new JTextField("");
	private JButton b1 = new JButton("OK");
	
	public ViewUpdate1()
	{
		this.setTitle(titlu);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(250,300);
		t1.setColumns(10);
		t2.setColumns(10);
		t3.setColumns(10);
		t4.setColumns(10);
		t5.setColumns(10);
		t6.setColumns(10);
		t7.setColumns(10);
		this.setLayout(new GridLayout(8,2));
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p21 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p31 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p41 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p51 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p61 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p71 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		l1.setText(limba[0]);
		p1.add(l1);
		p11.add(t1);
		l2.setText(limba[1]);
		p2.add(l2);
		p21.add(t2);
		l3.setText(limba[2]);
		p3.add(l3);
		p31.add(t3);
		l4.setText(limba[3]);
		p4.add(l4);
		p41.add(t4);
		l5.setText(limba[4]);
		p5.add(l5);
		p51.add(t5);
		l6.setText(limba[5]);
		p6.add(l6);
		p61.add(t6);
		l7.setText(limba[6]);
		p7.add(l7);
		p71.add(t7);
		p8.add(b1);
		this.add(p1);
		this.add(p11);
		this.add(p2);
		this.add(p21);
		this.add(p3);
		this.add(p31);
		this.add(p4);
		this.add(p41);
		this.add(p5);
		this.add(p51);
		this.add(p6);
		this.add(p61);
		this.add(p7);
		this.add(p71);
		this.add(p8);
		
		
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
	public String getTextField5() {
		return t6.getText();
	}
	public String getTextField6() {
		return t7.getText();
	}
	
	
public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
	}
    
	
	

}