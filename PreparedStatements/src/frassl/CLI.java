package frassl;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


/**
 * Class that manages the arguments input from the cli using the apache commons cli library 
 * @author Gabriel
 *
 */
public class CLI {

private String servername;
private String user;
private String password;
private String dbname;


/**
 * establishes options for the arguments filters the input of the user 
 * @param arguments the StringArray with the userArguments
 * @throws ParseException
 */
@SuppressWarnings({ "static-access", "deprecation" })
public  void  getConnArgs(String[] arguments) throws ParseException{
	
	//Options are made 
	Options options = new Options();
	
	options.addOption(Option.builder("sn")
		     .required(true)
		     .longOpt("serverName")
		     .desc("adress of the database server")
		     .build()); 
	
	options.addOption(Option.builder("u")
		     .required(true)
		     .longOpt("userName")
		     .desc("username for the database connection")
		     .build()); 
	
	options.addOption(Option.builder("p")
		     .required(true)
		     .longOpt("password")
		     .desc("password for the database connection")
		     .build()); 
	
	options.addOption(Option.builder("db")
		     .required(true)
		     .longOpt("databaseName")
		     .desc("name of the Database")
		     .build()); 
	
	//options and arguments are parsed
	CommandLineParser parser = new DefaultParser();
	CommandLine line = parser.parse(options, arguments);

	//arguments are saved into classvariables
	this.servername = line.getOptionValue("sn");
	this.user = line.getOptionValue("u");
	this.password = line.getOptionValue("p");
	this.dbname = line.getOptionValue("db");
	
	
	//Test-Debugging
	System.out.print(arguments[1]);
	System.out.print(servername +""+ user +""+ password +""+ dbname+line.hasOption("u"));
	
	
}


/**
 * Returns Serveraddress
 * @return the serveraddress
 */
public String getServername() {
	return servername;
}


/**
 * return Username
 * @return the username
 */
public String getUser() {
	return user;
}


/**
 * returns Password
 * @return the password
 */
public String getPassword() {
	return password;
}


/**
 * returns the Name of the Database
 * @return database name
 */
public String getDbname() {
	return dbname;
}




}
