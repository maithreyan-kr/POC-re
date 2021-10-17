import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ipldata {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/poc";
			String user = "student";
			String pass = "Maith15@10";

			Connection con = null;


			Connection conn = DriverManager.getConnection(dbUrl, user, pass);
			Statement st = conn.createStatement();
			
			
			for (int i = 1501; i<1504; i++) {
			String q = "select * from ipl where team_id = '" + i + "' order by player_score ASC";
			
			ResultSet rs = st.executeQuery(q);
			
			while (rs.next()) {
				String player_name = rs.getString("player_name");
				String team_id = rs.getString("team_id");
				String team_name = rs.getString("team_name");
				String player_score = rs.getString("player_score");
				
				System.out.println(team_id + "," + team_name + "," +  player_name + "," + player_score);
			}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
	