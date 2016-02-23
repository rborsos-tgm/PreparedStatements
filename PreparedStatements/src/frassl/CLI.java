package frassl;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Class that manages the arguments input from the cli using the apache commons
 * cli library
 * 
 * @author Gabriel
 * 
 */
public class CLI {

	private String servername;
	private String user;
	private String password;
	private String dbname;
	private boolean valid = true;

	/**
	 * establishes options for the arguments filters the input of the user
	 * 
	 * @param arguments
	 *            the StringArray with the userArguments
	 * @throws ParseException
	 */
	@SuppressWarnings({ "static-access" })
	public void getConnArgs(String[] arguments) throws ParseException {

		// Options are made
		Options options = new Options();

		options.addOption("s", "serveraddress", true, "serveraddress");
		options.addOption("u", "user name", true, "username");
		options.addOption("p", "password", true, "password");
		options.addOption("d", "database name", true, "database name");

		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("ant", options);
		
		
		CommandLineParser parser = new DefaultParser();
		CommandLine line;
		line = parser.parse(options, arguments);
		
		
		// arguments are saved into classvariables
		this.servername = line.getOptionValue("s");
		this.user = line.getOptionValue("u");
		this.password = line.getOptionValue("p");
		this.dbname = line.getOptionValue("d");
		
		
		
		

	}

	/**
	 * Returns Serveraddress
	 * 
	 * @return the serveraddress
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * return Username
	 * 
	 * @return the username
	 */
	public String getUser() {
		return user;
	}

	/**
	 * returns Password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * returns the Name of the Database
	 * 
	 * @return database name
	 */
	public String getDbname() {
		return dbname;
	}

	public boolean isValid() {
		return valid;
	}

}
