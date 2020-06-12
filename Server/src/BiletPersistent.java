import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BiletPersistent {
	
	private static final String bazaDate = "jdbc:mysql://localhost:3306/sneakers?autoReconnect=true&useSSL=false";
	private static final String queryBilet = "select * from bilete where id = "+"(?);";
	private static final String insertBilet = "INSERT INTO bilete (id,nume,prenume,nrTel,mail,cnp,idTren,pret)\r\n" + 
			"VALUES\r\n" + "(?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String lista = "select * from bilete;";
	
	private static final String editBilet = "UPDATE bilete \r\n" + "SET \r\n" + "nume = ?,\r\n" + "prenume=?,\r\n"
			+ "nrTel=?,\r\n" +  "mail=?,\r\n" + "cnp=?,\r\n" + "idTren=?,\r\n" + "pret=?\r\n" + "WHERE\r\n" + "    id = ?;";
	
	private static final String deleteBilet = "DELETE FROM bilete \r\n" + "WHERE\r\n" + "id = ?;";
	
	public BiletPersistent()
	{
		
	}
	
	
	public Boolean gasitBilet(int id)  {
		try{  
        	Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	bazaDate,"root","madalin");
        	ResultSet rs = null; 
        	
        	PreparedStatement fd = null;
    		try {
    			fd = con.prepareStatement(queryBilet);
    			fd.setInt(1, id);
    			rs = fd.executeQuery();
    			if(rs.next()) return true;
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				fd.close();
    				con.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    		}
        	
        	}
        
            catch(Exception e)
        	{ System.out.println(e);}  
        	    
	return false;
	}
	
	
	public boolean salvare(Bilet c) {
		try{  
        	Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	bazaDate,"root","madalin");
        	PreparedStatement fd = null;
    		try {
    			fd = con.prepareStatement(insertBilet);
    			fd.setInt(1,c.getIdBilet());
    			fd.setString(2, c.getC().getNume());
    			fd.setString(3, c.getC().getPrenume());
    			fd.setString(4, c.getC().getNrTel());
    			fd.setString(5, c.getC().getEmail());
    			fd.setLong(6, c.getC().getCNP());
    			fd.setInt(7,c.getT().getIdTren());
    			fd.setFloat(8, c.getT().getPret());
    			fd.executeUpdate();
    			return true;
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				fd.close();
    				con.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    		}
        	
        	}
        
            catch(Exception e)
        	{ System.out.println(e);} 
		return false;
		 		
	}
	
	public JTable cautareBilet(int id)  {
		
		DefaultTableModel model = new DefaultTableModel(); 
		 JTable table = new JTable(model); 
		 
		 model.addColumn("Id-ul biletul");
	        model.addColumn("Nume calator");
	        model.addColumn("Prenume calator");
	        model.addColumn("Nr. telefon");
	        model.addColumn("E-mail");
	        model.addColumn("CNP");
	        model.addColumn("Id-ul trenului");
	        model.addColumn("Pretul biletului");
		
		 try{  
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  
	        	bazaDate,"root","madalin");
	        	ResultSet rs = null; 
	        	
	        	PreparedStatement fd = null;
	    		try {
	    			fd = con.prepareStatement(queryBilet);
	    			fd.setInt(1, id);
	    			rs = fd.executeQuery();
	    			while(rs.next())  
	    				model.addRow(new Object[]{rs.getString("id"),rs.getString("nume"),rs.getString("prenume"),rs.getString("nrTel"),rs.getString("mail"),rs.getString("cnp"),rs.getString("idTren"),rs.getString("pret")});
	    			
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		} finally {
	    			try {
	    				fd.close();
	    				con.close();
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	    		}
	        	
	        	}
	        
	            catch(Exception e)
	        	{ System.out.println(e);}  
		 
		 return table;
	}
	
public Calator cautareCalator(int id)  {
	
		 try{  
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  
	        	bazaDate,"root","madalin");
	        	ResultSet rs = null; 
	        	
	        	PreparedStatement fd = null;
	    		try {
	    			fd = con.prepareStatement(queryBilet);
	    			fd.setInt(1, id);
	    			rs = fd.executeQuery();
	    			while(rs.next())  {
	    				Calator c = new Calator(rs.getString("nume"),rs.getString("prenume"),rs.getString("nrTel"),rs.getString("mail"),Long.parseLong(rs.getString("cnp")));
	    				return c;
	    			}
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		} finally {
	    			try {
	    				fd.close();
	    				con.close();
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	    		}
	        	
	        	}
	        
	            catch(Exception e)
	        	{ System.out.println(e);}  
		 
		 return null;
	}
	
	public ArrayList<Integer> idTrenuri()  {
		 
		 ArrayList<Integer> arr = new ArrayList<Integer>();

		 try{  
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  
	        	bazaDate,"root","madalin");  
	        	ResultSet rs = null; 
	        	
	        	PreparedStatement fd = null;
	    		try {
	    			fd = con.prepareStatement(lista);
	    			rs = fd.executeQuery();
	    			while(rs.next())  
		        		arr.add(rs.getInt("idTren"));
	    			
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		} finally {
	    			try {
	    				fd.close();
	    				con.close();
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	    		}
	        	
	        	}
	        
	            catch(Exception e)
	        	{ System.out.println(e);}  
		 
		
		return arr;
	}
	
	
	public JTable listaBilete()  {
		 DefaultTableModel model = new DefaultTableModel(); 
		 JTable table = new JTable(model); 

		    model.addColumn("Id-ul biletul");
	        model.addColumn("Nume calator");
	        model.addColumn("Prenume calator");
	        model.addColumn("Nr. telefon");
	        model.addColumn("E-mail");
	        model.addColumn("CNP");
	        model.addColumn("Id-ul trenului");
	        model.addColumn("Pretul biletului");

	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  
	        	bazaDate,"root","madalin");  
	        	ResultSet rs = null; 
	        	
	        	PreparedStatement fd = null;
	    		try {
	    			fd = con.prepareStatement(lista);
	    			rs = fd.executeQuery();
	    			while(rs.next())  
		        		model.addRow(new Object[]{rs.getString("id"),rs.getString("nume"),rs.getString("prenume"),rs.getString("nrTel"),rs.getString("mail"),rs.getString("cnp"),rs.getString("idTren"),rs.getString("pret")});
	    			
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		} finally {
	    			try {
	    				fd.close();
	    				con.close();
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	    		}
	        	
	        	}
	        
	            catch(Exception e)
	        	{ System.out.println(e);}  
	        
	        
		return table;
	}
	
	
	public void initializareObserveri()  {
		TrenPersistent tren = new TrenPersistent();
	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  
	        	bazaDate,"root","madalin");  
	        	ResultSet rs = null; 
	        	
	        	PreparedStatement fd = null;
	    		try {
	    			fd = con.prepareStatement(lista);
	    			rs = fd.executeQuery();
	    			while(rs.next())  {
	    				Calator c = new Calator(rs.getString("nume"),rs.getString("prenume"),rs.getString("nrTel"),rs.getString("mail"),Long.parseLong(rs.getString("cnp")));
	    				
		        		tren.addObserver(c);
	    			}
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		} finally {
	    			try {
	    				fd.close();
	    				con.close();
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	    		}
	        	
	        	}
	        
	            catch(Exception e)
	        	{ System.out.println(e);}  
	        
	}
	
	
	public void deleteBilet(int id)  {
		try{  
        	Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	bazaDate,"root","madalin");
        	
        	PreparedStatement fd = null;
    		try {
    			fd = con.prepareStatement(deleteBilet);
    			fd.setInt(1, id);
    			fd.executeUpdate();
    			
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				fd.close();
    				con.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    		}
        	
        	}
        
            catch(Exception e)
        	{ System.out.println(e);} 
	}
	
	
	public void modificareBilet(int id,String a, String b, String c, String d, long e,int f,float g)  {
		try{  
        	Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	bazaDate,"root","madalin");
        	
        	PreparedStatement fd = null;
    		try {
    			fd = con.prepareStatement(editBilet);
    			fd.setString(1, a);
    			fd.setString(2, b);
    			fd.setString(3, c);
    			fd.setString(4, d);
    			fd.setDouble(5, e);
    			fd.setInt(6, f);
    			fd.setFloat(7, g);
    			fd.setInt(8, id);
    			fd.executeUpdate();
    			
    		} catch (SQLException ee) {
    			ee.printStackTrace();
    		} finally {
    			try {
    				fd.close();
    				con.close();
    			} catch (SQLException ee) {
    				// TODO Auto-generated catch block
    				ee.printStackTrace();
    			}

    		}
        	
        	}
        
            catch(Exception ee)
        	{ System.out.println(ee);} 
	}
}
