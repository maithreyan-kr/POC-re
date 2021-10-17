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

public class iplRead {
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
		FileInputStream f = new FileInputStream("C:\\Users\\m.ramalingam\\Desktop\\project\\POC\\ipl.txt");
		DataInputStream in = new DataInputStream(f);

		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String strLine;
		ArrayList list = new ArrayList();
		while ((strLine = br.readLine()) != null) {
		list.add(strLine);
		}
		Iterator itr;
		for (itr = list.iterator(); itr.hasNext(); ) {
		String str = itr.next().toString();
		String[] spliting = str.split("\t");
		String s_no = "", team_id = "", team_name = "", player_name = "";
		
		for (int i = 0; i < 11; i++) {
		s_no = spliting[0];
		team_id = spliting[1];
		team_name = spliting[2];
		player_name = spliting[3];
		
		
		
		}
		
		


		myRs = Stmnt1.executeQuery("select * from ipl");
		while(myRs.next()){
			
		
		}
		int i = Stmnt1.executeUpdate("insert into ipl(s_no, team_id, team_name, player_name) values('" + s_no + "','" + team_id + "','" + team_name + "','" + player_name + "')");
		
		System.out.println(player_name +" inserted into db");
		
		
		

		}
		}
		catch (Exception e) {
		System.out.println(e);
		}



		}
		
}


