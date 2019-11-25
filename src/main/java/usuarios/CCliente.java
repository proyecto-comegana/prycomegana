package usuarios;

public class CCliente {
	private long lCedula;
	private long lNumArbol;
	private long lNivel;
	private long lPredecesor;
	private long lPersona;
	private long lSaldo;
	private long lBonos;
	private int iPremio;
	private String sFecha;
	private String sHora;

	public long getlCedula() {
		return lCedula;
	}
	public void setlCedula(long lCedula) {
		this.lCedula = lCedula;
	}
	public long getlNumArbol() {
		return lNumArbol;
	}
	public void setlNumArbol(long lNumArbol) {
		this.lNumArbol = lNumArbol;
	}
	public long getlNivel() {
		return lNivel;
	}
	public void setlNivel(long lNivel) {
		this.lNivel = lNivel;
	}
	public long getlPredecesor() {
		return lPredecesor;
	}
	public void setlPredecesor(long lPredecesor) {
		this.lPredecesor = lPredecesor;
	}
	public long getlPersona() {
		return lPersona;
	}
	public void setlPersona(long lPersona) {
		this.lPersona = lPersona;
	}
	public long getlSaldo() {
		return lSaldo;
	}
	public void setlSaldo(long lSaldo) {
		this.lSaldo = lSaldo;
	}
	public long getlBonos() {
		return lBonos;
	}
	public void setlBonos(long lBonos) {
		this.lBonos = lBonos;
	}
	public int getiPremio() {
		return iPremio;
	}
	public void setiPremio(int iPremio) {
		this.iPremio = iPremio;
	}
	public String getsFecha() {
		return sFecha;
	}
	public void setsFecha(String sFecha) {
		this.sFecha = sFecha;
	}
	public String getsHora() {
		return sHora;
	}
	public void setsHora(String sHora) {
		this.sHora = sHora;
	}
}
