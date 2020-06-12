

public class Bilet {

	private int idBilet;
	private Calator c;
	private Tren t;
	private float pret;
	
	public Bilet()
	{
		
	}
	
	public Bilet(int a,Calator c, Tren t) {
		this.setIdBilet(a);
		this.c =c;
		this.t=t;
		this.pret=t.getPret();
	}

	

	public float getPret() {
		return pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}

	public Calator getC() {
		return c;
	}

	public void setC(Calator c) {
		this.c = c;
	}

	public Tren getT() {
		return t;
	}

	public void setT(Tren t) {
		this.t = t;
	}
	
	public String toString() {
		return this.idBilet+" "+this.c.getNume()+" "+this.c.getPrenume()+" "+this.c.getNrTel()+" "+this.c.getEmail()+" "+this.c.getCNP()+" "+this.t.getIdTren()+" "+this.getPret()+"\n";
	}

	public int getIdBilet() {
		return idBilet;
	}

	public void setIdBilet(int idBilet) {
		this.idBilet = idBilet;
	}
	
	
}
