package stepDefinitions;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConnect;

public class Joins {

	public static void main(String[] args) throws SQLException {

		DBConnect.connectDB();
		ResultSet rs = DBConnect.getDataMoreTables("registrationform", "addformdetails", "firstname", "email",
				"testcase_id", "tid");

		while (rs.next()) {

			String fname = rs.getString("firstname");
			String email = rs.getString("email");
			System.out.println(fname + "-------" + email);

			if (fname.equals("santhoshkumar")) {

				break;
			}

		}

	}

}
