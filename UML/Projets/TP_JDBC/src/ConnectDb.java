import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class ConnectDb {
    public static void main(String[] arg) {
        String JdbcURL = "jdbc:mysql://localhost/sports?useSSL=false";
        String Username = "root";
        String password = "";
        Connection con = null;

        try {
            System.out.println("Connection à la BD ......" + JdbcURL);
            con = DriverManager.getConnection(JdbcURL, Username, password);
            System.out.println("Connection réussie !!!!");

            Statement st = con.createStatement();

            /*String insertSport1 = "INSERT INTO sport (code_sport, intitule) VALUES (1, 'Football')";
            String insertSport2 = "INSERT INTO sport (code_sport, intitule) VALUES (2, 'Basketball')";
            st.executeUpdate(insertSport1);
            st.executeUpdate(insertSport2);
            System.out.println("Enregistrements insérés avec succès !");*/

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le code du sport : ");
            int codeSport = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Entrez l'intitulé du sport : ");
            String intituleSport = scanner.nextLine();

            String insertUserSport = "INSERT INTO sport (code_sport, intitule) VALUES (" + codeSport + ", '" + intituleSport + "')";
            st.executeUpdate(insertUserSport);
            System.out.println("Enregistrement inséré avec succès par l'utilisateur !");

            String query = "SELECT * FROM sport";
            System.out.println("Query : " + query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int code_sport = rs.getInt("code_sport");
                String intitule = rs.getString("intitule");
                System.out.println("Le code sport : " + code_sport + " | " + "L'intitulé Sport: " + intitule);
            }

            rs.close();
            scanner.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}