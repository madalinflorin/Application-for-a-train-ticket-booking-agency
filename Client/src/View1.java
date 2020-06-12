
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View1 extends JFrame {

	private static String[] limba = {"Statie plecare", "Statie sosire" , "Durata","Statie plecare - Statie destinatie", "Alegere criteriu", "Statie plecare","Statie sosire","Durata","Alege","Vizualizare trenuri"};
	private static String titlu = "Vizualizare trenuri";
	private String[] statii = { "Bucuresti", "Pitesti", "Aiud","Arad","Baia mare","Suceava","Iasi","Vaslui","Craiova","Cluj-Napoca","Targu-Jiu","Mangalia","Bistrita-Nasaud"};
	private String[] intervale = {"< 1h","< 2h","< 4h","< 8h","< 12h"};
	
	private JButton b1 = new JButton("Alege");
	
	private JLabel l1 = new JLabel("Alegere criteriu");
	private JLabel l2 = new JLabel("Statie plecare");
	private JLabel l3 = new JLabel("Statie sosire");
	private JLabel l4 = new JLabel("Durata");
	
	private JComboBox<String> c1 ;
	private JComboBox<String> c2 = new JComboBox<>(statii);
	private JComboBox<String> c3 = new JComboBox<>(statii);
	private JComboBox<String> c4 = new JComboBox<>(intervale);
	
	
	public View1() {
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		titlu = limba[9];
		this.setTitle(titlu);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,280);
		this.setLayout(new GridLayout(4,1));
		String[] criterii = {limba[0],limba[1],limba[2],limba[3]};
		c1 = new JComboBox<>(criterii);
		l1.setText(limba[4]);
		p.add(l1);
		p.add(c1);
		b1.setText(limba[8]);
		p.add(b1);
		l2.setText(limba[5]);
		p1.add(l2);
		p1.add(c2);
		l3.setText(limba[6]);
		p2.add(l3);
		p2.add(c3);
		l4.setText(limba[7]);
		p3.add(l4);
		p3.add(c4);

		
		this.add(p);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		
	}
	
	public static void setLimba(String[] nouaLimba) {
		
		limba = nouaLimba;
		
	}
	
	public String getComboBoxValue() {
		
		return (String) c1.getSelectedItem();
	}
	
	public String getComboBoxValue1() {
		return (String) c2.getSelectedItem();
	}
	
	
	public String getComboBoxValue2() {
		return (String) c3.getSelectedItem();
	}
	
	public String getComboBoxValue3() {
		return (String) c4.getSelectedItem();
	}
	
	public String statieDePlecare() {
		return limba[0];
	}
	
	public String statieDeSosire() {
		return limba[1];
	}
	
	public String durata() {
		return limba[2];
	}
	
	public String statiePlecareSosire() {
		return limba[3];
	}
	
	
    public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
    }
    
}
