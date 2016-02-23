package frassl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Sets up Create,Read,Update,Delete Prepared Statements and creates Test Methods
 * @author Gabriel
 *
 */
public class PreparedStatemens {
	PreparedStatement insertIntoPerson;
	PreparedStatement updatePerson;
	PreparedStatement deletePerson;
	PreparedStatement ReadFromPerson;

/**
 * Creates the Statements
 * @param conn Connection to database
 * @throws SQLException
 */
	public PreparedStatemens(Connection conn) throws SQLException {
		insertIntoPerson = conn
				.prepareStatement("INSERT Into person Values (?,?,?)");
		ReadFromPerson = conn
				.prepareStatement("Select count(*) From Person WHERE vorname LIKE (?)");
		updatePerson = conn
				.prepareStatement("UPDATE person SET nachname = ? WHERE nummer = ?");
		deletePerson = conn
				.prepareStatement("DELETE FROM person WHERE nummer = ?");
	}

	/**
	 * Inserts Data into Person and also uses the READ Statements
	 * @throws SQLException
	 */
	public void insert() throws SQLException {

		for (int i = 100; i < 10100; i++) {// inserts 10000 times
			String vname = "max" + i;
			String nname = "mustermann" + i;
			insertIntoPerson.setInt(1, i);
			insertIntoPerson.setString(2, vname);
			insertIntoPerson.setString(3, nname);
			insertIntoPerson.executeUpdate();
			
			
		}
		ReadFromPerson.setString(1, "max%");//Readstatement
		ResultSet result = ReadFromPerson.executeQuery();
		result.next();
		String s = result.getString(1); //first column has index 1 (?)
		System.out.println("Read: Nach dem inserts exestieren " + s + " Personen deren Vorname mit Max anfängt");
	}

	/**
	 * Deletes Data from Person and also uses the READ Statement
	 * @throws SQLException
	 */
	public void delete() throws SQLException {
		for (int i = 100; i < 10100; i++) {
			deletePerson.setInt(1, i);
			deletePerson.execute();

		}
		ReadFromPerson.setString(1, "max%");
		ResultSet result = ReadFromPerson.executeQuery();
		result.next();
		String s = result.getString(1); //first column has index 1 (?)
		System.out.println("Read: Nach dem delete exestieren " + s + " Personen deren Vorname mit Max anfängt");
	}
	/**
	 * Updates a Row in Person
	 * @throws SQLException
	 */
	public void update() throws SQLException {
		updatePerson.setString(1, "updatedValue");
		updatePerson.setInt(2, 5);

		updatePerson.executeUpdate();
	}

}
