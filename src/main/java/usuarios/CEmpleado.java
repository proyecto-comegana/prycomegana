package usuarios;

public class CEmpleado {
	private long lEmpleado;
	private int iCargo;
	private int iArea;
	private long lPersona;
	private String sFecha;
	private String sHora;
	
	public long getlEmpleado() {
		return lEmpleado;
	}
	public void setlEmpleado(long lEmpleado) {
		this.lEmpleado = lEmpleado;
	}
	public int getiCargo() {
		return iCargo;
	}
	public void setiCargo(int iCargo) {
		this.iCargo = iCargo;
	}
	public int getiArea() {
		return iArea;
	}
	public void setiArea(int iArea) {
		this.iArea = iArea;
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
