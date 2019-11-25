package backups;

public class CBackup {
	private int iCodigo;
	private String sDescripcion;
	private int iTipo;
	private String sNombreArchivo;
	private String sRutaArchivo;
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
	public int getiTipo() {
		return iTipo;
	}
	public void setiTipo(int iTipo) {
		this.iTipo = iTipo;
	}
	public String getsNombreArchivo() {
		return sNombreArchivo;
	}
	public void setsNombreArchivo(String sNombreArchivo) {
		this.sNombreArchivo = sNombreArchivo;
	}
	public String getsRutaArchivo() {
		return sRutaArchivo;
	}
	public void setsRutaArchivo(String sRutaArchivo) {
		this.sRutaArchivo = sRutaArchivo;
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
