package localizacion;

public class CDepartamento {
	private int iCodigo;
	private String sNombre;
	private String sPais;
	private String sFecha;
	private String sHora;

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
	public String getsPais() {
		return sPais;
	}
	public void setsPais(String sPais) {
		this.sPais = sPais;
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