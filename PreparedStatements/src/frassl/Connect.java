package frassl;
import java.sql.Connection;
import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;


/**
 * class that establishes and manages the connection to the database
 * @author Gabriel
 *
 */
public class Connect {
	private String servername;
	private String user;
	private String password;
	private String dbname;
	private Connection conn;
	boolean refused = false;

	/**
	 * Constructor that establishes a connection
	 * @param Sname serveraddress
	 * @param Uname username
	 * @param pw password
	 * @param dbn database name
	 */
	public Connect(String Sname, String Uname, String pw, String dbn){
		this.servername = Sname;
		this.user = Uname;
		this.password = pw;
		this.dbname = dbn;
		
		PGSimpleDataSource ds = new PGSimpleDataSource();
		ds.setServerName(servername);// Ip der DB
		ds.setUser(user);//User im DBMS
		ds.setPassword(password);//pw der Users
		ds.setDatabaseName(dbname);//name der datenbank die zu erreichen ist
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			refused = true;
		}
		
	
		
	}
	
	/**
	 * Method to drop the connection
	 * @throws SQLException
	 */
	public void dropConnection() throws SQLException{
		conn.close();
		
	}
	
	public Connection getConn(){
		return this.conn;
	}

	public boolean refused(){ 
		return refused;
	}
	
	

}
