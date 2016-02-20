package frassl;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * class that connects to a database with cli input and executes different prepared Statements(CRUD) on the database
 * @author Gabriel
 *
 */
public class PrepStatements {
	
/**
 * Main method that manages the sequence of events
 * @param args cli arguments
 * @throws ParseException
 */
	public static void main(String[] args) throws ParseException{
		CLI cli = new CLI();
		cli.getConnArgs(args);
		Connect conn = new Connect(cli.getServername(),cli.getUser(),cli.getPassword(),cli.getDbname());
		
		
	}
}
