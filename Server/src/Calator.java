import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Calator {

	private String nume;
	private String prenume;
	private String nrTel;
	private String email;
	private long CNP;
	
	public Calator() {}
	
	public Calator(String a, String b, String c, String d, long e) {
		this.nume=a;
		this.prenume=b;
		this.nrTel=c;
		this.email=d;
		this.CNP=e;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getNrTel() {
		return nrTel;
	}
	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCNP() {
		return CNP;
	}
	public void setCNP(long cNP) {
		CNP = cNP;
	}
	
	public String toString() {
		return this.nume+" "+this.prenume+" "+this.nrTel+" "+this.email+" "+this.CNP+"\n";
	}
	
	public void update(Tren t) {
		try {
			String titlu = "Notificare privind aparitia unui nou tren.";
			String Mesaj = "Salut " + this.getPrenume()+",\n"+
			"Te anuntam ca incepand de astazi, va circula un nou tren pe ruta " + t.getStatiePlecare()+"-"+t.getStatieDestinatie()+
			", pretul biletului fiind de doar "+t.getPret()+" lei.\n Ce mai astepti?";

			SendEmail.Send("brz1998","javaeviatamea",this.email,"",titlu,Mesaj);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
