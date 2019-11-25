package financiero;

public class CAfiliacion {
	private long lCodigo;
	private long lClientePadre;
	private long lClienteHijo;
	private String sEstado;
	private String sCiudad;
	private String sFecha;
	private String sHora;

	public long getlCodigo() {
		return lCodigo;
	}
	public void setlCodigo(long lCodigo) {
		this.lCodigo = lCodigo;
	}
	public long getlClientePadre() {
		return lClientePadre;
	}
	public void setlClientePadre(long lClientePadre) {
		this.lClientePadre = lClientePadre;
	}
	public long getlClienteHijo() {
		return lClienteHijo;
	}
	public void setlClienteHijo(long lClienteHijo) {
		this.lClienteHijo = lClienteHijo;
	}
	public String getsEstado() {
		return sEstado;
	}
	public void setsEstado(String sEstado) {
		this.sEstado = sEstado;
	}
	public String getsCiudad() {
		return sCiudad;
	}
	public void setsCiudad(String sCiudad) {
		this.sCiudad = sCiudad;
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
