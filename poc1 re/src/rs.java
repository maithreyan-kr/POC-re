import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class rs {
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/poc";
		String user = "student";
		String pass = "Maith15@10";

		Connection myConn = null;


		Connection conn = DriverManager.getConnection(dbUrl, user, pass);
		ResultSet myRs = null;
		Statement Stmnt1 = conn.createStatement();
		
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i<10; i++) {
			
		System.out.println("enter player name :");
		String player_name = scan.nextLine();
		System.out.println("Enter player score :");
		String player_score = scan.nextLine();
		myRs = Stmnt1.executeQuery("select * from ipl");
		while (myRs.next()) {
			
			
			if (player_name.equals(myRs.getString("player_name"))) {
			 PreparedStatement ps = conn.prepareStatement("update ipl set player_score = ? where player_name = ? ");
			 ps.setString(1, player_score);
			 ps.setString(2, player_name);
			 ps.executeUpdate();
			
			}
		}
		
		}
		
		}catch (Exception e) {
		System.out.println(e);
		}



		}
		
	}

