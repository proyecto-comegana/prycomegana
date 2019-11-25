package usuarios;

public class CTipoUsuario {
	private int iCodigo;
	private String sDescripcion;
	private String sFecha;
	private String sHora;
	public int getiCodigo() {
		return iCodigo;
	}
	public void setiCodigo(int iCodigo) {
		this.iCodigo = iCodigo;
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
