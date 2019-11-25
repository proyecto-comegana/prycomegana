package financiero;

public class CTipoRestaurante {
	private int iCodigo;
	private String sNombre;
	private String sDescripcion;
	private String sFecha;
	private String sHora;
	public CTipoRestaurante() {
		
	}
	public int getiCodigo() {
		return iCodigo;
	}
	public void setiCodigo(int iCodigo) {
		this.iCodigo = iCodigo;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsDescripcion() {
		return sDescripcion;
	}
	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
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
