
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewAngajat extends JFrame{
	
	private static String[] limba = {"Vizualizare lista trenuri","Cautare tren","Operatii CRUD","Vanzare bilet","Vizualizare statistici","Salvare rapoarte","Trenul:","Introdu id","Pagina angajat"};
	private static String titlu = "Pagina angajat";
	private JButton b1 = new JButton("Vizualizare lista trenuri");
	private JButton b2 = new JButton("Cautare tren");
	private JButton b3 = new JButton("Operatii CRUD");
	private JButton b4 = new JButton("Vanzare bilet");
	private JButton b5 = new JButton("Vizualizare statistici");
	private JButton b6 = new JButton("Salvare rapoarte");
	private JLabel l1 = new JLabel("Trenul:");
	private JTextField t1 = new JTextField("Introdu id");
	
	public ViewAngajat()  {
		JPanel p = new JPanel();
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("./train.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		this.setVisible(true);
		titlu = limba[8];
		this.setTitle(titlu);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1080,720);
		b1.setText(limba[0]);
		p.add(b1);
		b2.setText(limba[1]);
		p.add(b2);
		l1.setText(limba[6]);
		p.add(l1);
		t1.setText(limba[7]);
		p.add(t1);
		b3.setText(limba[2]);
		p.add(b3);
		b4.setText(limba[3]);
		p.add(b4);
		b5.setText(limba[4]);
		p.add(b5);
		b6.setText(limba[5]);
		p.add(b6);
		p.add(picLabel);
		this.add(p);
		
		
	}
	
	public static void setLimba(String[] nouaLimba) {
		
		limba = nouaLimba;
		
	}
	
	public String getIdTren()
	{
		return t1.getText();
	}
	
	public void addButtonListener(ActionListener listenForButton) {
		
		b1.addActionListener(listenForButton);
		
	}
	
    public void addButtonListener1(ActionListener listenForButton1) {
		
		b2.addActionListener(listenForButton1);
		
	}
    
    public void addButtonListener2(ActionListener listenForButton1) {
		
  		b3.addActionListener(listenForButton1);
  		
  	}
    
 public void addButtonListener3(ActionListener listenForButton1) {
		
  		b4.addActionListener(listenForButton1);
  		
  	}
 
 
public void addButtonListener4(ActionListener listenForButton1) {
		
		b5.addActionListener(listenForButton1);
		
	}
 
 public void addButtonListener5(ActionListener listenForButton1) {
		
		b6.addActionListener(listenForButton1);
		
	}

}
