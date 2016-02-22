package frassl;

import java.sql.SQLException;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * class that connects to a database with cli input and executes different prepared Statements(CRUD) on the database
 * @author Gabriel
 *
 */
public class PrepStatementsMain {
	
/**
 * Main method that manages the sequence of events
 * @param args cli arguments
 * @throws ParseException
 * @throws SQLException 
 */
	public static void main(String[] args) throws ParseException, SQLException{
		CLI cli = new CLI();
		cli.getConnArgs(args);
		Connect conn = new Connect(cli.getServername(),cli.getUser(),cli.getPassword(),cli.getDbname());
		PreparedStatemens myPrepStats = new PreparedStatemens(conn.getConn());
		myPrepStats.insert();	//adds Data into Person
		myPrepStats.update();	//updates a column
		myPrepStats.delete();	//deletes the Data that has been added in Person
		
		
		
		
	}
}
