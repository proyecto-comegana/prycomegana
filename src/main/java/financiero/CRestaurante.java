package financiero;

public class CRestaurante {
	private long lCodigo;
	private String sNombre;
	private String sDescripcion;
	private String sTelefono;
	private long lPropietario;
	private int iConvenio;
	private int iTipo;
	private String sFecha;
	private String sHora;
	public long getlCodigo() {
		return lCodigo;
	}
	public void setlCodigo(long lCodigo) {
		this.lCodigo = lCodigo;
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
	public String getsTelefono() {
		return sTelefono;
	}
	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}
	public long getlPropietario() {
		return lPropietario;
	}
	public void setlPropietario(long lPropietario) {
		this.lPropietario = lPropietario;
	}
	public int getiConvenio() {
		return iConvenio;
	}
	public void setiConvenio(int iConvenio) {
		this.iConvenio = iConvenio;
	}
	public int getiTipo() {
		return iTipo;
	}
	public void setiTipo(int iTipo) {
		this.iTipo = iTipo;
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
