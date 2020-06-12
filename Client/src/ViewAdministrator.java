
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewAdministrator extends JFrame {
	
	private static String[] limba = {"Inserare","Selectare","Modificare","Stergere","Criteriu","Pagina Administrator"};
	private String titlu ="Pagina Administrator";
	private JLabel l1 = new JLabel("Criteriu");
	private JComboBox<String> c1;
	private JButton b1 = new JButton("OK");
	
	public ViewAdministrator()  {
		JPanel p = new JPanel();
		this.setVisible(true);
		titlu = limba[5];
		this.setTitle(titlu);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(200,100);
		l1.setText(limba[4]);
		p.add(l1);
		String[] criteriu = { limba[0], limba[1], limba[2], limba[3]};
		c1 = new JComboBox<String>(criteriu);
		p.add(c1);
		p.add(b1);
		this.add(p);
		
		
	}
	
	public String getCriteriu1() {
		return limba[0];
	}
	
	public String getCriteriu2() {
		return limba[1];
	}
	
	public String getCriteriu3() {
		return limba[2];
	}
	
	public String getCriteriu4() {
		return limba[3];
	}
	
	public static void setLimba(String[] nouaLimba) {
		
		limba = nouaLimba;
		
	}
	
	
	public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
	}
	
	public String getComboBoxValue() {
		return (String) c1.getSelectedItem();
	}

}
