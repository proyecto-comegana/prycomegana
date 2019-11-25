package parametros;

public class CParametro {
	private int iCodigo;
	private String sNombre;
	private String sDescripcion;
	private long lValor;
	private int iTipo;
	private int iModulo;
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
	public String getsDescripcion() {
		return sDescripcion;
	}
	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}
	public long getlValor() {
		return lValor;
	}
	public void setlValor(long lValor) {
		this.lValor = lValor;
	}
	public int getiTipo() {
		return iTipo;
	}
	public void setiTipo(int iTipo) {
		this.iTipo = iTipo;
	}
	public int getiModulo() {
		return iModulo;
	}
	public void setiModulo(int iModulo) {
		this.iModulo = iModulo;
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
