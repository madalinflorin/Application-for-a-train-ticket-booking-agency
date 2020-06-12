
public class Angajat extends Calator {
	
	private String parola;
	private float salariu;
	private String programDeLucru;
	private Boolean ok;
	
	public Angajat() {
	
	}
	
	public Angajat(String a,String b,String c,String d,long e,String p, float f, String g,Boolean bb) {
		super(a,b,c,d,e);
		this.parola=p;
		this.salariu=f;
		this.programDeLucru=g;
		this.setOk(bb);
	}

	public float getSalariu() {
		return salariu;
	}

	public void setSalariu(float salariu) {
		this.salariu = salariu;
	}

	public String getProgramDeLucru() {
		return programDeLucru;
	}

	public void setProgramDeLucru(String programDeLucru) {
		this.programDeLucru = programDeLucru;
	}
	
	
	
	public String toString() {
		return super.getNume()+" "+super.getPrenume()+" "+super.getNrTel()+" "+super.getEmail()+" "+super.getCNP()+" "+this.parola+" "+this.salariu+" "+this.programDeLucru+" "+this.ok+"\n";
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	
}