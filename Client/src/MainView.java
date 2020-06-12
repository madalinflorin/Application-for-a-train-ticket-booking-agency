import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainView extends JFrame {
	
	private static String[] limba = {"Vizualizare lista trenuri","Cautare tren","Conectare","Trenul:","Introdu id","Alegere limba:","Pagina principala"};
	private static String titlu = "Pagina principala";
	private String[] limbi = {"Romana","English","Français"};
	private JButton b1 = new JButton("Vizualizare lista trenuri");
	private JButton b2 = new JButton("Cautare tren");
	private JButton b3 = new JButton("Conectare");
	private JLabel l1 = new JLabel("Trenul:");
	private JTextField t1 = new JTextField("Introdu id");
	private JLabel l2 = new JLabel("Alegere limba:");
	private JComboBox<String> c1 = new JComboBox<>(limbi);
	
	public MainView()  {
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
		titlu = limba[6];
		this.setTitle(titlu);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1080,720);
		b1.setText(limba[0]);
		p.add(b1);
		b2.setText(limba[1]);
		p.add(b2);
		l1.setText(limba[3]);
		p.add(l1);
		t1.setText(limba[4]);
		p.add(t1);
		b3.setText(limba[2]);
		p.add(b3);
		l2.setText(limba[5]);
		p.add(l2);
		p.add(c1);
		initializeListener();
		p.add(picLabel);
		this.add(p);
		
		
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
    
    private void initializeListener() {

    	c1.addActionListener (new ActionListener () {
    	public void actionPerformed(ActionEvent e) {
    		
    		if(((String)c1.getSelectedItem()).equals("Français")) {
                String csvFile = "franceza.csv";
            	BufferedReader br = null;
    			try {
    				br = new BufferedReader(new FileReader(csvFile));
    			} catch (FileNotFoundException e2) {
    				// TODO Auto-generated catch block
    				e2.printStackTrace();
    			}
            	String line;
    			try {
    				    // use comma as separator
    					line = br.readLine();
    				    String[] mainView = line.split(",");
    				    limba = mainView;
    				    
    				    line = br.readLine();
    				    String[] view1 = line.split(",");
    				    View1.setLimba(view1);
    				    
    				    line = br.readLine();
    				    String[] view2 = line.split(",");
    				    View2.setTitlu(view2[0]);
    				    
    				    line = br.readLine();
    				    String[] view3 = line.split(",");
    				    View3.setLimba(view3);
    				    
    				    line = br.readLine();
    				    String[] viewAdministrator = line.split(",");
    				    ViewAdministrator.setLimba(viewAdministrator);
    				    
    				    line = br.readLine();
    				    String[] viewAngajat = line.split(",");
    				    ViewAngajat.setLimba(viewAngajat);
    				    
    				    line = br.readLine();
    				    String[] viewAngajat1 = line.split(",");
    				    ViewAngajat1.setLimba(viewAngajat1);
    				    
    				    line = br.readLine();
    				    String[] viewInsert = line.split(",");
    				    ViewInsert.setLimba(viewInsert);
    				    
    				    line = br.readLine();
    				    String[] viewInsert1 = line.split(",");
    				    ViewInsert1.setLimba(viewInsert1);
    				    
    				    line = br.readLine();
    				    String[] viewInsertA = line.split(",");
    				    ViewInsertA.setLimba(viewInsertA);
    				    
    				    line = br.readLine();
    				    String[] viewSelectA = line.split(",");
    				    ViewSelectA.setLimba(viewSelectA);
    				    
    				    line = br.readLine();
    				    String[] viewUpdate = line.split(",");
    				    ViewUpdate.setLimba(viewUpdate);
    				    
    				    line = br.readLine();
    				    String[] viewUpdate1 = line.split(",");
    				    ViewUpdate1.setLimba(viewUpdate1);
    				    
    				    line = br.readLine();
    				    String[] viewUpdataA = line.split(",");
    				    ViewUpdateA.setLimba(viewUpdataA);
    				    
    				    line = br.readLine();
    				    String[] updateBar = line.split(",");
    				    BarChartSample.updateLimba(updateBar);
    				    
    				    line = br.readLine();
    				    String[] informatii = line.split(",");
    				    ControlerOperatiiCalator.updateInformatii(informatii);
    				    
    				
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			
    			
            }
    		
    		if(((String)c1.getSelectedItem()).equals("Romana")) {
                String csvFile = "romana.csv";
            	BufferedReader br = null;
    			try {
    				br = new BufferedReader(new FileReader(csvFile));
    			} catch (FileNotFoundException e2) {
    				// TODO Auto-generated catch block
    				e2.printStackTrace();
    			}
            	String line;
    			try {
    				    // use comma as separator
    					line = br.readLine();
    				    String[] mainView = line.split(",");
    				    limba = mainView;
    				    
    				    line = br.readLine();
    				    String[] view1 = line.split(",");
    				    View1.setLimba(view1);
    				    
    				    line = br.readLine();
    				    String[] view2 = line.split(",");
    				    View2.setTitlu(view2[0]);
    				    
    				    line = br.readLine();
    				    String[] view3 = line.split(",");
    				    View3.setLimba(view3);
    				    
    				    line = br.readLine();
    				    String[] viewAdministrator = line.split(",");
    				    ViewAdministrator.setLimba(viewAdministrator);
    				    
    				    line = br.readLine();
    				    String[] viewAngajat = line.split(",");
    				    ViewAngajat.setLimba(viewAngajat);
    				    
    				    line = br.readLine();
    				    String[] viewAngajat1 = line.split(",");
    				    ViewAngajat1.setLimba(viewAngajat1);
    				    
    				    line = br.readLine();
    				    String[] viewInsert = line.split(",");
    				    ViewInsert.setLimba(viewInsert);
    				    
    				    line = br.readLine();
    				    String[] viewInsert1 = line.split(",");
    				    ViewInsert1.setLimba(viewInsert1);
    				    
    				    line = br.readLine();
    				    String[] viewInsertA = line.split(",");
    				    ViewInsertA.setLimba(viewInsertA);
    				    
    				    line = br.readLine();
    				    String[] viewSelectA = line.split(",");
    				    ViewSelectA.setLimba(viewSelectA);
    				    
    				    line = br.readLine();
    				    String[] viewUpdate = line.split(",");
    				    ViewUpdate.setLimba(viewUpdate);
    				    
    				    line = br.readLine();
    				    String[] viewUpdate1 = line.split(",");
    				    ViewUpdate1.setLimba(viewUpdate1);
    				    
    				    line = br.readLine();
    				    String[] viewUpdataA = line.split(",");
    				    ViewUpdateA.setLimba(viewUpdataA);
    				    
    				    line = br.readLine();
    				    String[] updateBar = line.split(",");
    				    BarChartSample.updateLimba(updateBar);
    				    
    				    line = br.readLine();
    				    String[] informatii = line.split(",");
    				    ControlerOperatiiCalator.updateInformatii(informatii);
    				
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			
    			
            }
    		
        if(((String)c1.getSelectedItem()).equals("English")) {
            String csvFile = "engleza.csv";
        	BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(csvFile));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
        	String line;
			try {
				    // use comma as separator
					line = br.readLine();
				    String[] mainView = line.split(",");
				    limba = mainView;
				    
				    line = br.readLine();
				    String[] view1 = line.split(",");
				    View1.setLimba(view1);
				    
				    line = br.readLine();
				    String[] view2 = line.split(",");
				    View2.setTitlu(view2[0]);
				    
				    line = br.readLine();
				    String[] view3 = line.split(",");
				    View3.setLimba(view3);
				    
				    line = br.readLine();
				    String[] viewAdministrator = line.split(",");
				    ViewAdministrator.setLimba(viewAdministrator);
				    
				    line = br.readLine();
				    String[] viewAngajat = line.split(",");
				    ViewAngajat.setLimba(viewAngajat);
				    
				    line = br.readLine();
				    String[] viewAngajat1 = line.split(",");
				    ViewAngajat1.setLimba(viewAngajat1);
				    
				    line = br.readLine();
				    String[] viewInsert = line.split(",");
				    ViewInsert.setLimba(viewInsert);
				    
				    line = br.readLine();
				    String[] viewInsert1 = line.split(",");
				    ViewInsert1.setLimba(viewInsert1);
				    
				    line = br.readLine();
				    String[] viewInsertA = line.split(",");
				    ViewInsertA.setLimba(viewInsertA);
				    
				    line = br.readLine();
				    String[] viewSelectA = line.split(",");
				    ViewSelectA.setLimba(viewSelectA);
				    
				    line = br.readLine();
				    String[] viewUpdate = line.split(",");
				    ViewUpdate.setLimba(viewUpdate);
				    
				    line = br.readLine();
				    String[] viewUpdate1 = line.split(",");
				    ViewUpdate1.setLimba(viewUpdate1);
				    
				    line = br.readLine();
				    String[] viewUpdataA = line.split(",");
				    ViewUpdateA.setLimba(viewUpdataA);
				    
				    line = br.readLine();
				    String[] updateBar = line.split(",");
				    BarChartSample.updateLimba(updateBar);
				    
				    line = br.readLine();
				    String[] informatii = line.split(",");
				    ControlerOperatiiCalator.updateInformatii(informatii);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
        }
        
        titlu = limba[6];
		b1.setText(limba[0]);
		b2.setText(limba[1]);
		l1.setText(limba[3]);
		t1.setText(limba[4]);
		b3.setText(limba[2]);
		l2.setText(limba[5]);
		
    	}
    	});
    }
    

}
