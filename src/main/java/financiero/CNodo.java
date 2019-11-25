package financiero;

public class CNodo {
	private long lCodigo;
	private long lCliente;
	private long lArbol;
	private int iPosicion;
	private String sEstado;
	private int iNivel;
	private String sFecha;
	private String sHora;

	public long getlCodigo() {
		return lCodigo;
	}
	public void setlCodigo(long lCodigo) {
		this.lCodigo = lCodigo;
	}
	public long getlCliente() {
		return lCliente;
	}
	public void setlCliente(long lCliente) {
		this.lCliente = lCliente;
	}
	
	public long getlArbol() {
		return lArbol;
	}
	public void setlArbol(long lArbol) {
		this.lArbol = lArbol;
	}
	public int getiPosicion() {
		return iPosicion;
	}
	public void setiPosicion(int iPosicion) {
		this.iPosicion = iPosicion;
	}
	public String getsEstado() {
		return sEstado;
	}
	public void setsEstado(String sEstado) {
		this.sEstado = sEstado;
	}
	public int getiNivel() {
		return iNivel;
	}
	public void setiNivel(int iNivel) {
		this.iNivel = iNivel;
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
