package frassl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * Class that searches for a propertiefile and reads connection information
 * @author Gabriel
 */
public class MyProperties {
	private String Sname;
	private String Uname;
	private String password;
	private String Dbname;

	private boolean FileIsValid = true;
	
	/**
	 * Reads from the file and gives out error if file is not valid
	 */
	public MyProperties(){
		try {
			FileInputStream in = new FileInputStream(
					"src/ressources/properties.properties");
			Properties connProps = new Properties();
			connProps.load(in);
			Sname = (String) connProps.get("server");
			Dbname = (String) connProps.get("database");
			Uname = (String) connProps.get("user");
			password = (String) connProps.get("password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			FileIsValid = false;
			System.out.println("No valid properties file found in src/ressources - Insert CLI Args");
		} catch (IOException e) {
			FileIsValid = false;
			System.out.println("No valid properties file found in src/ressources - Insert CLI Args");
		}

	}
	
/**
 * returns if file is valid
 * @return boolean if file is valid
 */
	public boolean hasValidFile() {
		return FileIsValid;
	}
/**
 * returns servername
 * @return serveraddress
 */
	public String getSname() {
		return Sname;
	}


	public String getUname() {
		return Uname;
	}


	public String getPassword() {
		return password;
	}


	public String getDbname() {
		return Dbname;
	}
	
	
	
}
