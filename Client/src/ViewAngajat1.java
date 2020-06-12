
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewAngajat1 extends JFrame {
	
	private static String[] limba = {"Inserare","Selectare","Modificare","Stergere","Tren","Bilet","Alegere operatie","asupra obiectului","ID-ul obiectului","Operatii CRUD"};
	private static String titlu ="Operatii CRUD";
	
	private JLabel alegere = new JLabel("Alegere operatie");
	private JComboBox<String> c1;
	private JLabel asupra = new JLabel("asupra obiectului: ");
	private JComboBox<String> c2;
	private JLabel obiect = new JLabel("ID-ul obiectului");
	private JTextField t = new JTextField("");
	private JButton b1 = new JButton("OK");
	
	public ViewAngajat1() {
		
		titlu = limba[9];
		this.setTitle(titlu);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,100);
		t.setColumns(5);
		JPanel p = new JPanel();
		alegere.setText(limba[6]);
		p.add(alegere);
		String[] criteriu = { limba[0], limba[1], limba[2], limba[3]};
		c1 = new JComboBox<>(criteriu);
		p.add(c1);
		asupra.setText(limba[7]);
		p.add(asupra);
		
		String[] obiecte = { limba[4], limba[5]};
		c2 = new JComboBox<>(obiecte);
		p.add(c2);
		obiect.setText(limba[8]);
		p.add(obiect);
		p.add(t);
		p.add(b1);
		
		this.add(p);
		
	}
	
	public static void setLimba(String[] nouaLimba) {
		
		limba = nouaLimba;
		
	}
	
	public String getTextField() {
		return t.getText();
	}
	
	public String getComboBoxValue()
	{
		return (String) c1.getSelectedItem();
	}
	
	public String getComboBoxValue1()
	{
		return (String) c2.getSelectedItem();
	}
	
	
	
	
	public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
	}

	public String getOptiune1() {
		return limba[0];
	}
	
	public String getOptiune2() {
		return limba[1];
	}
	
	public String getOptiune3() {
		return limba[2];
	}
	
	public String getOptiune4() {
		return limba[3];
	}
	
	public String getObiect1() {
		return limba[4];
		
	}
	
	public String getObiect2() {
		return limba[5];
	}

}
