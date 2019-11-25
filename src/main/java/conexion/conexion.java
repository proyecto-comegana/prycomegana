package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	static final String URL = "jdbc:postgresql://localhost:5432/comegana";
	static final String USER = "postgres";
	static final String PASS = "123";
	
	public static Connection crearConexion() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection conex = DriverManager.getConnection(URL, USER, PASS);
		if (conex != null) {
			System.out.println("Conexion establecida...");
			return conex;
		}
		return null;
	}
}
