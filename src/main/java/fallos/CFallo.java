package fallos;

public class CFallo {
	private int iCodigo;
	private String sDescripcion;
	private String sRuta;
	private String sArchivo;
	private int iLinea;
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
	public String getsRuta() {
		return sRuta;
	}
	public void setsRuta(String sRuta) {
		this.sRuta = sRuta;
	}
	public String getsArchivo() {
		return sArchivo;
	}
	public void setsArchivo(String sArchivo) {
		this.sArchivo = sArchivo;
	}
	public int getiLinea() {
		return iLinea;
	}
	public void setiLinea(int iLinea) {
		this.iLinea = iLinea;
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
