import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AngajatPersistent {
	
	private static final String bazaDate = "jdbc:mysql://localhost:3306/sneakers?autoReconnect=true&useSSL=false";
	private static final String queryAngajat = "select * from angajati where email="+"(?)"+" and pass="+"(?);";
	private static final String queryUsername = "select * from angajati where email="+"(?);";
	private static final String deleteUser = "DELETE FROM angajati \r\n" + "WHERE\r\n" + "email = ?;";
	private static final String queryAngajati = "select * from angajati";
	private static final String insertAngajat = "INSERT INTO angajati (nume,prenume,phone,email,cnp,pass,salariu,program,adminn)\r\n" + "VALUES\r\n" + "(?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String editAngajat = "UPDATE angajati \r\n" + "SET \r\n" + "nume = ?,\r\n" + "prenume=?,\r\n"
			+ "phone=?,\r\n" + "cnp=?,\r\n" + "pass=?,\r\n"+ "salariu=?,\r\n"+ "program=?,\r\n"+ "adminn=?\r\n" + "WHERE\r\n" + "    email = ?;";
	
	
	public AngajatPersistent() {
		
	}


	public Boolean cautareAngajat(String mail, String password)  {
		
		

	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  
	        	bazaDate,"root","madalin");
	        	ResultSet rs = null; 
	        	
	        	PreparedStatement fd = null;
	    		try {
	    			fd = con.prepareStatement(queryAngajat);
	    			fd.setString(1, mail);
	    			fd.setString(2,password);
	    			rs = fd.executeQuery();
	    			
	    			
	    			if(!rs.next()) return false;
	    			
	    		
	    			
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
	        	    
		
		return true;
	}
	
	public Boolean cautareGrad(String mail,String password) {
		
			 try{  
		        	Class.forName("com.mysql.jdbc.Driver");  
		        	Connection con=DriverManager.getConnection(  
		        	bazaDate,"root","madalin");
		        	ResultSet rs = null; 
		        	
		        	PreparedStatement fd = null;
		    		try {
		    			fd = con.prepareStatement(queryAngajat);
		    			fd.setString(1, mail);
		    			fd.setString(2,password);
		    			rs = fd.executeQuery();
		    			rs.next();
		    			if(Integer.parseInt(rs.getString("adminn"))==1) return true;
		    			
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
	
	public JTable cautareUsername(String username)  {
		 
		 DefaultTableModel model = new DefaultTableModel(); 
		 JTable table = new JTable(model); 
		 
		    model.addColumn("Nume");
	        model.addColumn("Prenume");
	        model.addColumn("Nr.tel");
	        model.addColumn("E-mail");
	        model.addColumn("CNP");
	        model.addColumn("Parola");
	        model.addColumn("Salariu");
	        model.addColumn("Program");
	        model.addColumn("Administrator");
	      

		        try{  
		        	Class.forName("com.mysql.jdbc.Driver");  
		        	Connection con=DriverManager.getConnection(  
		        	bazaDate,"root","madalin");
		        	ResultSet rs = null; 
		        	
		        	PreparedStatement fd = null;
		    		try {
		    			fd = con.prepareStatement(queryUsername);
		    			fd.setString(1, username);
		    			rs = fd.executeQuery();
		    			while(rs.next())  
			        		model.addRow(new Object[]{rs.getString("nume"),rs.getString("prenume"),rs.getString("phone"),rs.getString("email"),rs.getString("cnp"),rs.getString("pass"),rs.getString("salariu"),rs.getString("program"),rs.getString("adminn")});
		    			
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
	
	
	public void deleteUser(String username)  {

	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  
	        	bazaDate,"root","madalin");
	        	 
	        	
	        	PreparedStatement fd = null;
	    		try {
	    			fd = con.prepareStatement(deleteUser);
	    			fd.setString(1, username);
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
	
	public JTable listaAngajati()  {
		 DefaultTableModel model = new DefaultTableModel(); 
		 JTable table = new JTable(model); 

		    model.addColumn("Nume");
	        model.addColumn("Prenume");
	        model.addColumn("Nr.tel");
	        model.addColumn("E-mail");
	        model.addColumn("CNP");
	        model.addColumn("Parola");
	        model.addColumn("Salariu");
	        model.addColumn("Program");
	        model.addColumn("Administrator");
	      

		        try{  
		        	Class.forName("com.mysql.jdbc.Driver");  
		        	Connection con=DriverManager.getConnection(  
		        	bazaDate,"root","madalin");
		        	ResultSet rs = null; 
		        	
		        	PreparedStatement fd = null;
		    		try {
		    			fd = con.prepareStatement(queryAngajati);
		    			rs = fd.executeQuery();
		    			while(rs.next())  
			        		model.addRow(new Object[]{rs.getString("nume"),rs.getString("prenume"),rs.getString("phone"),rs.getString("email"),rs.getString("cnp"),rs.getString("pass"),rs.getString("salariu"),rs.getString("program"),rs.getString("adminn")});
		    			
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
	
	public void insertAngajat(Angajat a) {

		try{  
        	Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	bazaDate,"root","madalin");
        	System.out.println(2);
        	PreparedStatement fd = null;
    		try {
    			fd = con.prepareStatement(insertAngajat);
    			fd.setString(1, a.getNume());
    			fd.setString(2, a.getPrenume());
    			fd.setString(3, a.getNrTel());
    			fd.setString(4, a.getEmail());
    			fd.setLong(5, a.getCNP());
    			fd.setString(6, a.getParola());
    			fd.setFloat(7, a.getSalariu());
    			fd.setString(8, a.getProgramDeLucru());
    			fd.setBoolean(9, a.getOk());
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
	
	public void updateUser(String username,String a,String b, String c, long d, String e, float f, String g, Boolean h)  {
		try{  
        	Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	bazaDate,"root","madalin");
        	System.out.println(2);
        	PreparedStatement fd = null;
    		try {
    			fd = con.prepareStatement(editAngajat);
    			fd.setString(1, a);
    			fd.setString(2, b);
    			fd.setString(3, c);
    			fd.setLong(4, d);
    			fd.setString(5, e);
    			fd.setFloat(6, f);
    			fd.setString(7, g);
    			fd.setBoolean(8, h);
    			fd.setString(9, username);
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
