import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ControlerOperatiiCalator {
	
	private MainView acasa;
	private View1 vizualizare;
	private View2 vizualizare2;
	private View3 vizualizare3;
	private ViewAngajat vizualizare4;
	private ViewAngajat1 vizualizare5;
	private ViewInsert vizualizare6;
	private ViewUpdate vizualizare7;
	private ViewInsert1 vizualizare8;
	private ViewUpdate1 vizualizare9;
	private ViewAdministrator vizualizare10;
	private ViewSelectA vizualizare11;
	private ViewInsertA vizualizare12;
	private ViewUpdateA vizualizare13;
	private AngajatPersistent angajat = null;
	private BiletPersistent b = null;
	private TrenPersistent t = null;
	
	private static String[] limba = {
			"Nu a fost gasit niciun rezultat", //0
			"Nici un rezultat cu acest ID",    //1
			"Introdu un numar intreg",         //2
			"Nume sau parola gresita",         //3
			"Nici un rezultat", 				//4
			"Poate exista un singur tren cu acest id",		//5
			"ID-ul sau numarul de locuri sau durata cursei sau pretul au valori invalide", //6
			"ID-ul sau durata sau nr.locuri sau pret au valori invalide",	//7
			"Nu pot exista 2 bilete cu acelas ID",		//8
			"ID tren incorect",							//9
			"ID bilet sau CNP sau ID tren incorect",	//10
			"ID bilet sau CNP sau ID tren sau pret invalid",	//11
			"Salvarea a avut loc cu succes",  //12
			"Diagrama generata cu succes",    //13
			"Nu a fost gasit niciun angajat cu user-ul acesta", //14
			"Tabelul este gol",									//15
			"User-ul pe care vrei sa il stergi nu exista",		//16
			"Acest user exista deja",							//17
			"CNP sau salariu au valoarea gresita"};				//18
	
	
	public ControlerOperatiiCalator(MainView acasa)
	{
		this.acasa=acasa;
		this.acasa.addButtonListener(new ButtonListener());
		this.acasa.addButtonListener1(new ButtonListener2());
		this.acasa.addButtonListener2(new ButtonListener3());
		angajat = new AngajatPersistent();
		t = new TrenPersistent();
		b = new BiletPersistent();
	    
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isNumeric1(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        float d = Float.parseFloat(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static void updateInformatii(String[] inf) {
		limba=inf;
	}
	

	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			vizualizare=new View1();
			vizualizare.addButtonListener(new ButtonListener1());
			
		}
	}
	
	class ButtonListener1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String criteriu = vizualizare.getComboBoxValue();
			JTable table = null ;
			String statie1 = vizualizare.statieDePlecare();
			String statie2 = vizualizare.statieDeSosire();
			String durataCursa = vizualizare.durata();
			String statiePlecareSosire = vizualizare.statiePlecareSosire();
			
			if(criteriu.equals(statie1)) {
				String statiePlecare=vizualizare.getComboBoxValue1();
			    table=t.cautareTrenDupaStatiaDePlecare(statiePlecare);
			}
			else if(criteriu.equals(statie2)) {
			    String statieSosire=vizualizare.getComboBoxValue2();
				  table=t.cautareTrenDupaStatiaDeSosire(statieSosire);
			    
			}
			else if(criteriu.equals(durataCursa)) {
				String durataMinute=vizualizare.getComboBoxValue3().substring(2);
				durataMinute=durataMinute.substring(0,durataMinute.length()-1);
				int durata = Integer.parseInt(durataMinute);
				table=t.cautareTrenDupaDurata(durata);
			}
			else if(criteriu.equals(statiePlecareSosire)) {
				  String statiePlecare=vizualizare.getComboBoxValue1();
				  String statieSosire=vizualizare.getComboBoxValue2();
				  table=t.intreStatii(statiePlecare,statieSosire);
			}
			
		    if(table.getRowCount()==0) {JFrame frame = null;
		    JOptionPane.showMessageDialog(frame,
		    	    limba[0],
		    	    "Warning",
		    	    JOptionPane.WARNING_MESSAGE);
		    }
		    else
		    	
			vizualizare2= new View2(table);
			
		}
		
	}
	
	class ButtonListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String criteriu = acasa.getIdTren();
			JTable table = null ;
			if(isNumeric(criteriu)) {
			table = t.cautareTren(Integer.parseInt(criteriu));
			if(table.getRowCount()>0)
			vizualizare2= new View2(table);
			else {
				
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[1],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
				
			}
			
			}
			else {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[2],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
	
		
	}
	
	
	class ButtonListener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			vizualizare3 = new View3();
			
			vizualizare3.addButtonListener(new ButtonListener4());
			
		}
	}
	
	class ButtonListener4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			
			String mail=vizualizare3.getTextField1();
			String pass=vizualizare3.getTextField2();
			
			if(angajat.cautareAngajat(mail,pass)) {
				
				if(angajat.cautareGrad(mail, pass)==false) {
				
			vizualizare4 = new ViewAngajat();
			vizualizare4.addButtonListener(new ButtonListener());
			vizualizare4.addButtonListener1(new ButtonListener5());
			vizualizare4.addButtonListener2(new ButtonListener6());
			vizualizare4.addButtonListener3(new ButtonListener12());
			vizualizare4.addButtonListener4(new ButtonListener14());
			vizualizare4.addButtonListener5(new ButtonListener13());
				}
				else {
					vizualizare10 = new ViewAdministrator();
					vizualizare10.addButtonListener(new ButtonListener15());
				}
			
			}
			
			else {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[3],
			    	    "Warning",
			    	    JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	
	class ButtonListener5 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String criteriu = vizualizare4.getIdTren();
			JTable table = null ;
			if(isNumeric(criteriu)) {
			table = t.cautareTren(Integer.parseInt(criteriu));
			if(table.getRowCount()>0)
			vizualizare2= new View2(table);
			else {
				
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[1],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
				
			}
			
			}
			else {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[2],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
	}
	
	class ButtonListener6 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			vizualizare5 = new ViewAngajat1();
			vizualizare5.addButtonListener(new ButtonListener7());
		
		}
}
	
	class ButtonListener7 implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String operatie = vizualizare5.getComboBoxValue();
			String obiect = vizualizare5.getComboBoxValue1();
			JTable table = null;
			
			String optiune1 = vizualizare5.getOptiune1();
			String optiune2 = vizualizare5.getOptiune2();
			String optiune3 = vizualizare5.getOptiune3();
			String optiune4 = vizualizare5.getOptiune4();
			
			String obiect1 = vizualizare5.getObiect1();
			
			if(operatie.equals(optiune1)) {
				  if(obiect.equals(obiect1)) {
				  vizualizare6=new ViewInsert();
				  vizualizare6.addButtonListener(new ButtonListener8());}
				  else {
					  vizualizare8=new ViewInsert1();
					  vizualizare8.addButtonListener(new ButtonListener10());
					  
				  }
			}
			
			else if(operatie.equals(optiune2)) {
				
				  int idd = Integer.parseInt(vizualizare5.getTextField());
				  if(obiect.equals(obiect1)) {
				  table=t.cautareTren(idd);	
				  if(table.getRowCount()>0)
						vizualizare2= new View2(table);
						else {
							
							JFrame frame = null;
						    JOptionPane.showMessageDialog(frame,
						    	    limba[1],
						    	    "Warning",
						    	    JOptionPane.WARNING_MESSAGE);
							
						}}
				  else {
					  
					  table=b.cautareBilet(idd);
					  if(table.getRowCount()>0)
							vizualizare2= new View2(table);
							else {
								
								JFrame frame = null;
							    JOptionPane.showMessageDialog(frame,
							    	    limba[1],
							    	    "Warning",
							    	    JOptionPane.WARNING_MESSAGE);
								
							}
					  
				  }
				  
			}
			else if(operatie.equals(optiune3)) {
				
				  if(obiect.equals(obiect1)) {
					  
				  vizualizare7 = new ViewUpdate();
				  vizualizare7.addButtonListener(new ButtonListener9());}
				  
				  else {
					  
					  vizualizare9 = new ViewUpdate1();
					  vizualizare9.addButtonListener(new ButtonListener11());
					  
				  }
			} 
			else if(operatie.equals(optiune4)) {
				
					if(obiect.equals(obiect)) {
					int idd = Integer.parseInt(vizualizare5.getTextField());
					 t.deleteTren(idd);
					 table=t.listaTrenuri();
					 
					  if(table.getRowCount()>0)
							vizualizare2= new View2(table);
							else {
								
								JFrame frame = null;
							    JOptionPane.showMessageDialog(frame,
							    	    "Nici un rezultat",
							    	    "Warning",
							    	    JOptionPane.WARNING_MESSAGE);
								
							}}
					else {
						int idd = Integer.parseInt(vizualizare5.getTextField());
						 Calator c = b.cautareCalator(idd);
						 t.removeObserver(c);
						 b.deleteBilet(idd);
						 table=b.listaBilete();
						  if(table.getRowCount()>0)
								vizualizare2= new View2(table);
								else {
									
									JFrame frame = null;
								    JOptionPane.showMessageDialog(frame,
								    	    limba[4],
								    	    "Warning",
								    	    JOptionPane.WARNING_MESSAGE);
					}}
			}
			
		}
	}
	
	
	class ButtonListener8 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTable table = null;
			if(isNumeric(vizualizare6.getTextField())&&isNumeric(vizualizare6.getTextField4())&&isNumeric(vizualizare6.getTextField3())&&isNumeric1(vizualizare6.getTextField5()))
			{
				int id = Integer.parseInt(vizualizare6.getTextField());
			 if(t.gasitTren(id)) {JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[5],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);}
			 else {
			  String statiePlecare = vizualizare6.getTextField1();
			  String statieSosire = vizualizare6.getTextField2();
			  int durataMinute = Integer.parseInt(vizualizare6.getTextField3());
			  int locuri = Integer.parseInt(vizualizare6.getTextField4());
			  float pret= Float.parseFloat(vizualizare6.getTextField5());
			  Tren tp = FabricaTren.obtineTren(id,statiePlecare,statieSosire,durataMinute,locuri,pret);
			  t.salvareTren(tp);
			  table=t.listaTrenuri();

			  if(table.getRowCount()==0) {JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[6],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
			    }
			    else
			    	
				vizualizare2= new View2(table);
				
			}
		}
			else {
				JFrame frame = null;
				JOptionPane.showMessageDialog(frame,
			    	    limba[7],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
			}
		}
		}
	
	class ButtonListener9 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			
			  JTable table = null;
			  if(isNumeric(vizualizare5.getTextField())&&isNumeric(vizualizare7.getTextField2())&&isNumeric(vizualizare7.getTextField3())&&isNumeric1(vizualizare7.getTextField4())){
			  int id = Integer.parseInt(vizualizare5.getTextField());
			  String statiePlecare = vizualizare7.getTextField();
			  String statieSosire = vizualizare7.getTextField1();
			  int durataMinute = Integer.parseInt(vizualizare7.getTextField2());
			  int locuri = Integer.parseInt(vizualizare7.getTextField3());
			  float pret= Float.parseFloat(vizualizare7.getTextField4());
			  
			  t.modificareTren(id,statiePlecare,statieSosire,durataMinute,locuri,pret);
			  
			  table=t.listaTrenuri();
			  
			  if(table.getRowCount()==0) {JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[0],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
			    }
			    else
			    	
				vizualizare2= new View2(table);
				
			
			  }
			  else {
				  JFrame frame = null;
				  JOptionPane.showMessageDialog(frame,
						  limba[6],
				    	    "Warning",
				    	    JOptionPane.WARNING_MESSAGE);
			  }
		}
}
	
	
	class ButtonListener10 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTable table = null;
			if(isNumeric(vizualizare8.getTextField())&&isNumeric(vizualizare8.getTextField5())&&isNumeric(vizualizare8.getTextField6())&&t.gasitTren(Integer.parseInt(vizualizare8.getTextField6()))) {
			  int idBilet = Integer.parseInt(vizualizare8.getTextField());
			  String nume = vizualizare8.getTextField1();
			  String prenume = vizualizare8.getTextField2();
			  String tel = vizualizare8.getTextField3();
			  String mail = vizualizare8.getTextField4();
			  long cnp = Long.parseLong(vizualizare8.getTextField5());
			  System.out.println(cnp);
			  int idTren = Integer.parseInt(vizualizare8.getTextField6());
			  if(b.gasitBilet(idBilet)) {JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[8],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);}
			  else {
			  if(t.gasitTren(idTren)) {
			  
			  float pret= t.pretTren(idTren);
			  t.updateLocuri(idTren);
			  Bilet bil= FabricaBilet.obtineBilet(idBilet, new Calator(nume,prenume,tel,mail,cnp), new Tren.Builder().id(idTren).pret(pret).build());
			  t.addObserver(new Calator(nume,prenume,tel,mail,cnp));
			  b.salvare(bil);
			  table = b.listaBilete();

			  if(table.getRowCount()==0) {JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[0],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
			    }
			    else
			    	
				vizualizare2= new View2(table);}
			  else {
				  JFrame frame = null;
				JOptionPane.showMessageDialog(frame,
				    	    limba[9],
				    	    "Warning",
				    	    JOptionPane.WARNING_MESSAGE);
			  }
			  }
			
		}
			else {
				JFrame frame = null;
				JOptionPane.showMessageDialog(frame,
				    	    limba[10],
				    	    "Warning",
				    	    JOptionPane.WARNING_MESSAGE);
			}
		}
		}
	
	class ButtonListener11 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTable table = null;
			if(isNumeric(vizualizare5.getTextField())&&isNumeric(vizualizare9.getTextField4())&&isNumeric(vizualizare9.getTextField5())&&isNumeric1(vizualizare9.getTextField6())) {
			int id = Integer.parseInt(vizualizare5.getTextField());
			String nume = vizualizare9.getTextField();
			String prenume = vizualizare9.getTextField1();
			String tel = vizualizare9.getTextField2();
			String mail = vizualizare9.getTextField3();
			long cnp = Long.parseLong(vizualizare9.getTextField4());
			int idTren = Integer.parseInt(vizualizare9.getTextField5());
			float pret = Float.parseFloat(vizualizare9.getTextField6());
			
			 b.modificareBilet(id,nume,prenume,tel,mail,cnp,idTren,pret);
			 
			 table= b.listaBilete();
			 
			  if(table.getRowCount()==0) {JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[0],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
			    }
			    else
			    	
				vizualizare2= new View2(table);
		}
		else {
			JFrame frame = null;
			JOptionPane.showMessageDialog(frame,
			    	    limba[11],
			    	    "Warning",
			    	    JOptionPane.WARNING_MESSAGE);
		}
	}
	}
	
	
	class ButtonListener12 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		 vizualizare8=new ViewInsert1();
		 vizualizare8.addButtonListener(new ButtonListener10());
		}

}
	
	class ButtonListener13 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			t.conversieFormate();
			JFrame frame = null;
		    JOptionPane.showMessageDialog(frame,
		    	    limba[12],
		    	    "INFO",
		    	    JOptionPane.INFORMATION_MESSAGE);
		}
	}

	
	class ButtonListener14 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			JFrame frame = null;
		    JOptionPane.showMessageDialog(frame,
		    	    limba[13],
		    	    "INFO",
		    	    JOptionPane.INFORMATION_MESSAGE);
		   String[] a = null;
		   BarChartSample.main(a);
		}
	}
	
	
	class ButtonListener15 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String criteriu=vizualizare10.getComboBoxValue();
			
			String optiune1 = vizualizare10.getCriteriu1();
			String optiune2 = vizualizare10.getCriteriu2();
			String optiune3 = vizualizare10.getCriteriu3();
			String optiune4 = vizualizare10.getCriteriu4();
			
			if(criteriu.equals(optiune1)) {
				vizualizare12 = new ViewInsertA();
				vizualizare12.addButtonListener(new ButtonListener18());
			}
			else if(criteriu.equals(optiune2)) {
				vizualizare11 = new ViewSelectA();
				vizualizare11.addButtonListener(new ButtonListener16());
			}
			else if(criteriu.equals(optiune3)) {
				vizualizare11 = new ViewSelectA();
				vizualizare11.addButtonListener(new ButtonListener19());
			}
			else if(criteriu.equals(optiune4)){ 
				vizualizare11 = new ViewSelectA();
				vizualizare11.addButtonListener(new ButtonListener17());
			}
			
		}
	}
	
	class ButtonListener16 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTable table=null;
			String username= vizualizare11.getTextField();
			
			table=angajat.cautareUsername(username);
			
			if(table.getRowCount()>0)
			
			vizualizare2= new View2(table);
			
			else {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[14],
			    	    "WARNING",
			    	    JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
		
	}
	
	
	class ButtonListener17 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTable table=null;
			String username= vizualizare11.getTextField();
			table=angajat.cautareUsername(username);
			if(table.getRowCount()>0) {
			angajat.deleteUser(username);
			table=angajat.listaAngajati();
			vizualizare2= new View2(table);
			
			if(table.getRowCount()>0)
			
			vizualizare2= new View2(table);
			
			else {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[15],
			    	    "WARNING",
			    	    JOptionPane.WARNING_MESSAGE);
			}
			
			}
			
			else {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[16],
			    	    "WARNING",
			    	    JOptionPane.WARNING_MESSAGE);
		}
		
	}
	}
	
	class ButtonListener18 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			JTable table = null;
			
			String nume = vizualizare12.getTextField();
			String prenume = vizualizare12.getTextField1();
			String nrTel = vizualizare12.getTextField2();
			String mail = vizualizare12.getTextField3();
			if(isNumeric(vizualizare12.getTextField4())&&isNumeric(vizualizare12.getTextField6())) {
			long CNP = Long.parseLong(vizualizare12.getTextField4());
			String parola = vizualizare12.getTextField5();
			float salariu = Float.parseFloat(vizualizare12.getTextField6());
			String program = vizualizare12.getTextField7();
			Boolean ok = Boolean.parseBoolean(vizualizare12.getTextField8());
			table=angajat.cautareUsername(mail);
			if(table.getRowCount()>0) {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    		limba[17],
			    	    "WARNING",
			    	    JOptionPane.WARNING_MESSAGE);
			}
			
			else {
			Angajat a = FabricaAngajat.obtineAngajat(nume, prenume, nrTel, mail, CNP, parola, salariu, program, ok);
			
			angajat.insertAngajat(a);		
			table=angajat.listaAngajati();
			
			if(table.getRowCount()>0)
				
				vizualizare2= new View2(table);
				
				else {
					JFrame frame = null;
				    JOptionPane.showMessageDialog(frame,
				    	    limba[15],
				    	    "WARNING",
				    	    JOptionPane.WARNING_MESSAGE);
				}
			}
			
			
			
			
		}
			else {
			JFrame frame = null;
		    JOptionPane.showMessageDialog(frame,
		    	    limba[18],
		    	    "WARNING",
		    	    JOptionPane.WARNING_MESSAGE);
		}
		
	}
	}
	
	class ButtonListener19 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTable table = null;
			table = angajat.cautareUsername(vizualizare11.getTextField());
			if(table.getRowCount()>0)
			{
			vizualizare13 = new ViewUpdateA();
			vizualizare13.addButtonListener(new ButtonListener20());
			}
			
			else {
				JFrame frame = null;
			    JOptionPane.showMessageDialog(frame,
			    	    limba[14],
			    	    "WARNING",
			    	    JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	
	class ButtonListener20 implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JTable table = null;
			String username = vizualizare11.getTextField();
			String nume = vizualizare13.getTextField();
			String prenume = vizualizare13.getTextField1();
			String nrTel = vizualizare13.getTextField2();
			if(isNumeric(vizualizare13.getTextField4())&&isNumeric1(vizualizare13.getTextField6())){
			long CNP = Long.parseLong(vizualizare13.getTextField4());
			String parola = vizualizare13.getTextField5();
			float salariu = Float.parseFloat(vizualizare13.getTextField6());
			String program = vizualizare13.getTextField7();
			Boolean ok = Boolean.parseBoolean(vizualizare13.getTextField8());

				angajat.updateUser(username,nume,prenume,nrTel,CNP,parola,salariu,program,ok);
				table=angajat.listaAngajati();
				vizualizare2= new View2(table);
		}
			    else  {
					JFrame frame = null;
				    JOptionPane.showMessageDialog(frame,
				    	    limba[18],
				    	    "WARNING",
				    	    JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
		
}

	
