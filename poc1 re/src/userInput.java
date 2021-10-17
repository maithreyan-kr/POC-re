import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;



import java.sql.*;



public class userInput {
static final String DB_URL = "jdbc:mysql://localhost:3306/poc";
static final String USER = "student";
static final String PASS = "Maith15@10";



public static void main(String[] args) {



try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
Statement st = con.createStatement();



) {






Statement stm = con.createStatement();
FileInputStream fs = new FileInputStream("C:\\\\Users\\\\m.ramalingam\\\\Desktop\\\\project\\\\POC\\\\ipl.txt");
DataInputStream ds = new DataInputStream(fs);
BufferedReader br = new BufferedReader(new InputStreamReader(ds));
String s;
ArrayList list = new ArrayList();
while ((s = br.readLine()) != null) {
list.add(s);
}
Iterator itr;
for (itr = list.iterator(); itr.hasNext();) {
String st1 = itr.next().toString();
String[] spliting = st1.split("\t");
String s_no = "", team_id = "", team_name ="", player_name="", player_score="";
for (int i = 0; i < 11; i++) {
s_no = spliting[0];
team_id = spliting[1];
team_name = spliting[2];
player_name = spliting[3];
}
Scanner Input = new Scanner(System.in);
System.out.println("Enter the score of "+ player_name);
player_score = Input.nextLine();

ResultSet r = null;
Statement stmt1 = con.createStatement();
stmt1.executeUpdate("insert into ipl(s_no, team_id, team_name, player_name, player_score) values('"+s_no+"','"+team_id+"','"+team_name+"','"+ player_name +"', '"+ player_score +"')");



}
}

catch (SQLException throwables) {
throwables.printStackTrace();
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
}
}
}
