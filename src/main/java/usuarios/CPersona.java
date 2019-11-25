package usuarios;

public class CPersona {
	private long lPersona;
	private String sNombres;
	private String sApellidos;
	private String sDireccion;
	private String sTelefono;
	private String sCorreo;
	private String sFecha_Nac;
	private String sSexo;
	private String sCiudad;
	private String sFecha;
	private String sHora;
	
	public CPersona(long lPersona, String sNombres, String sApellidos, String sDireccion, String sTelefono,
			String sCorreo, String sFecha_Nac, String sSexo, String sCiudad, String sFecha, String sHora) {
		super();
		this.lPersona = lPersona;
		this.sNombres = sNombres;
		this.sApellidos = sApellidos;
		this.sDireccion = sDireccion;
		this.sTelefono = sTelefono;
		this.sCorreo = sCorreo;
		this.sFecha_Nac = sFecha_Nac;
		this.sSexo = sSexo;
		this.sCiudad = sCiudad;
		this.sFecha = sFecha;
		this.sHora = sHora;
	}

	public CPersona() {
		super();
	}

	public long getlPersona() {
		return lPersona;
	}
	public void setlPersona(long lPersona) {
		this.lPersona = lPersona;
	}
	public String getsNombres() {
		return sNombres;
	}
	public void setsNombres(String sNombres) {
		this.sNombres = sNombres;
	}
	public String getsApellidos() {
		return sApellidos;
	}
	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}
	
	public String getsDireccion() {
		return sDireccion;
	}
	public void setsDireccion(String sDireccion) {
		this.sDireccion = sDireccion;
	}
	public String getsTelefono() {
		return sTelefono;
	}
	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}
	public String getsCorreo() {
		return sCorreo;
	}
	public void setsCorreo(String sCorreo) {
		this.sCorreo = sCorreo;
	}
	public String getsFecha_Nac() {
		return sFecha_Nac;
	}
	public void setsFecha_Nac(String sFecha_Nac) {
		this.sFecha_Nac = sFecha_Nac;
	}
	public String getsSexo() {
		return sSexo;
	}
	public void setsSexo(String sSexo) {
		this.sSexo = sSexo;
	}
	public String getsCiudad() {
		return sCiudad;
	}
	public void setiCiudad(String sCiudad) {
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
