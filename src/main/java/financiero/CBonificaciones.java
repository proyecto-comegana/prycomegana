package financiero;

public class CBonificaciones {
	private long lCodigo;
	private long lCliente;
	private long lValor;
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
	public long getlValor() {
		return lValor;
	}
	public void setlValor(long lValor) {
		this.lValor = lValor;
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
