package usuarios;

public class CPropietario {
	private long lCedula;
	private long lRestaurante;
	private String sEstado;
	private long lPersona;
	private String sFecha;
	private String sHora;
	public long getlCedula() {
		return lCedula;
	}
	public void setlCedula(long lCedula) {
		this.lCedula = lCedula;
	}
	public long getlRestaurante() {
		return lRestaurante;
	}
	public void setlRestaurante(long lRestaurante) {
		this.lRestaurante = lRestaurante;
	}
	public String getsEstado() {
		return sEstado;
	}
	public void setsEstado(String sEstado) {
		this.sEstado = sEstado;
	}
	public long getlPersona() {
		return lPersona;
	}
	public void setlPersona(long lIdPersona) {
		this.lPersona = lIdPersona;
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
