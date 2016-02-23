package frassl;

import java.sql.SQLException;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * class that connects to a database with cli input and executes different
 * prepared Statements(CRUD) on the database
 * 
 * @author Gabriel
 * 
 */
public class PrepStatementsMain {

	/**
	 * Main method that manages the sequence of events. Determines way of receiving connection data, establishes the connection and calls launch method
	 * 
	 * @param args cli arguments
	 * @throws ParseException
	 * @throws SQLException
	 */
	public static void main(String[] args) {
		try{
			MyProperties props = new MyProperties();
			if (props.hasValidFile()) { // if a file was found
				Connect conn = new Connect(props.getSname(), props.getUname(),
						props.getPassword(), props.getDbname());// trying to connect

				if(conn.refused = false){ //if connection is not refused -> launch 
				launch(conn);}
				else{ //if connection is refused error and cli arguments
					System.out.println("data from file incorrect - insert CLI args");
				 // wenn kein File gefunden werden kann werden CLI eingaben gefordert 
				CLI cli = new CLI();
				cli.getConnArgs(args);
				conn = new Connect(cli.getServername(), cli.getUser(), //trying to connect with cli args
						cli.getPassword(), cli.getDbname());
				if(conn.refused = false){ //if connection works -> launch
				launch(conn);
				}else{ // if neither file or cli works -> error message
					System.out.println("Try again");
				}
				}
			}
		}catch(ParseException e){
			System.out.println("error");
		}

	}
	
	/**
	 * determines further actions after the connection has been established
	 * @param conn JDBC connection
	 * @throws SQLException
	 */
	public static void launch(Connect conn) {
		PreparedStatemens myPrepStats;
		try {
			myPrepStats = new PreparedStatemens(conn.getConn());
			myPrepStats.insert(); // adds Data into Person
			myPrepStats.update(); // updates a column
			myPrepStats.delete(); // deletes the Data that has been added in Person
			conn.dropConnection(); // drops connection to database
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		

	}
}
