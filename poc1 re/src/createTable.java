import java.sql.*;
public class createTable {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/poc";
			String username="student";
			String password="Maith15@10";
			
			Connection c = DriverManager.getConnection(url, username, password);
			
			String q = "create table ipl(s_no varchar(3) , team_id varchar(5) not null , team_name varchar(10) not null, player_name varchar(20) not null , player_score varchar(4))";
			
			Statement s = c.createStatement();
			
			s.executeUpdate(q);
			
			System.out.println("table created in Db....");
			
			c.close(); 
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
