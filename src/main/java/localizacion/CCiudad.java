package localizacion;

public class CCiudad {
	private int iCodigo;
	private String sNombre;
	private String sDepartamento;
	private String sFecha;
	private String sHora;
	public CCiudad() {
		
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
	public String getsDepartamento() {
		return sDepartamento;
	}
	public void setsDepartamento(String sDepartamento) {
		this.sDepartamento = sDepartamento;
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
