package frassl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatemens {
	PreparedStatement insertIntoPerson;
	PreparedStatement updatePerson;
	PreparedStatement deletePerson;


	public PreparedStatemens(Connection conn) throws SQLException {
		insertIntoPerson = conn
				.prepareStatement("INSERT Into person Values (?,?,?)");
		updatePerson = conn
				.prepareStatement("UPDATE person SET nachname = ? WHERE nummer = ?");
		deletePerson = conn
				.prepareStatement("DELETE FROM person WHERE nummer = ?");
	}

	public void insert() throws SQLException {

		for (int i = 100; i < 10100; i++) {
			String vname = "max" + i;
			String nname = "mustermann" + i;
			insertIntoPerson.setInt(1, i);
			insertIntoPerson.setString(2, vname);
			insertIntoPerson.setString(3, nname);
			insertIntoPerson.executeUpdate();

			/*
			 * deletePerson.setInt(1, i); deletePerson.execute();
			 */
		}
	}

	public void delete() throws SQLException {
		for (int i = 100; i < 10100; i++) {
			deletePerson.setInt(1, i);
			deletePerson.execute();

		}
	}

	public void update() throws SQLException {
		updatePerson.setString(1, "updatedValue");
		updatePerson.setInt(2, 5);

		updatePerson.executeUpdate();
	}

}
