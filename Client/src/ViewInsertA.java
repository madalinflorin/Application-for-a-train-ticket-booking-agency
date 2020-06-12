
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewInsertA extends JFrame {
	
	private static String[] limba = {"Nume","Prenume","Nr.tel","E-mail","CNP","Parola","Salariu","Program de lucru","Administrator","Operatii CRUD"};
	private static String titlu = "Operatii crud";
	
	private JLabel l1 = new JLabel("Nume");
	private JLabel l2 = new JLabel("Prenume");
	private JLabel l3 = new JLabel("Nr.tel");
	private JLabel l4 = new JLabel("E-mail");
	private JLabel l5 = new JLabel("CNP");
	private JLabel l6 = new JLabel("Parola");
	private JLabel l7 = new JLabel("Salariu");
	private JLabel l8 = new JLabel("Program de lucru");
	private JLabel l9 = new JLabel("Administrator");
	private JTextField t1 = new JTextField("");
	private JTextField t2 = new JTextField("");
	private JTextField t3 = new JTextField("");
	private JTextField t4 = new JTextField("");
	private JTextField t5 = new JTextField("");
	private JTextField t6 = new JTextField("");
	private JTextField t7 = new JTextField("");
	private JTextField t8 = new JTextField("");
	private JTextField t9 = new JTextField("");
	private JButton b1 = new JButton("OK");
	
	public ViewInsertA() {
		
		titlu = limba[9];
		this.setTitle(titlu);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(280,325);
		t1.setColumns(10);
		t2.setColumns(10);
		t3.setColumns(10);
		t4.setColumns(10);
		t5.setColumns(10);
		t6.setColumns(10);
		t7.setColumns(10);
		t8.setColumns(10);
		t9.setColumns(10);
		
		this.setLayout(new GridLayout(10,2));
		
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
		JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p16 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p18 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p19 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		l1.setText(limba[0]);
		p1.add(l1);
		p10.add(t1);
		l2.setText(limba[1]);
		p2.add(l2);
		p11.add(t2);
		l3.setText(limba[2]);
		p3.add(l3);
		p12.add(t3);
		l4.setText(limba[3]);
		p4.add(l4);
		p13.add(t4);
		l5.setText(limba[4]);
		p5.add(l5);
		p14.add(t5);
		l6.setText(limba[5]);
		p6.add(l6);
		p15.add(t6);
		l7.setText(limba[6]);
		p7.add(l7);
		p16.add(t7);
		l8.setText(limba[7]);
		p8.add(l8);
		p17.add(t8);
		l9.setText(limba[8]);
		p9.add(l9);
		p18.add(t9);
		p19.add(b1);
		this.add(p1);
		this.add(p10);
		this.add(p2);
		this.add(p11);
		this.add(p3);
		this.add(p12);
		this.add(p4);
		this.add(p13);
		this.add(p5);
		this.add(p14);
		this.add(p6);
		this.add(p15);
		this.add(p7);
		this.add(p16);
		this.add(p8);
		this.add(p17);
		this.add(p9);
		this.add(p18);
		this.add(p19);
		
	}
	
	public static String[] returnareLimba() {
		return limba;
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
	
	public String getTextField7() {
		return t8.getText();
	}
	
	public String getTextField8() {
		return t9.getText();
	}
	
	
public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
	}

}
