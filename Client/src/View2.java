
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View2 extends JFrame{
	
	private static String titlu = "Lista trenuri"; 
	
	public View2(JTable table) {
		
		JPanel p = new JPanel();
		this.setVisible(true);
		this.setTitle(titlu);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,200);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		p.add(scrollPane);
		this.add(p);
	}
	
	public static void setTitlu(String titluNou) {
		titlu=titluNou;
	}

}
