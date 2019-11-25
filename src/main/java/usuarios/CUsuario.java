package usuarios;

public class CUsuario {
	private long lCodigo;
	private String sNombreUsuario;
	private String sContrasena;
	private String sTipo;
	private long lPersona;
	private String sFecha;
	private String sHora;
	
	public long getlCodigo() {
		return lCodigo;
	}
	public void setlCodigo(long lCodigo) {
		this.lCodigo = lCodigo;
	}
	public String getsNombreUsuario() {
		return sNombreUsuario;
	}
	public void setsNombreUsuario(String sNombreUsuario) {
		this.sNombreUsuario = sNombreUsuario;
	}
	public String getsContrasena() {
		return sContrasena;
	}
	public void setsContrasena(String sContrasena) {
		this.sContrasena = sContrasena;
	}
	public String getsTipo() {
		return sTipo;
	}
	public void setsTipo(String sTipo) {
		this.sTipo = sTipo;
	}
	public long getlPersona() {
		return lPersona;
	}
	public void setlPersona(long lPersona) {
		this.lPersona = lPersona;
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
