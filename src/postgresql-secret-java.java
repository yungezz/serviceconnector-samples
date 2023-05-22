import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String connString = System.getenv("AZURE_POSTGRESQL_CONNECTIONSTRING");

        try {
            Connection conn = DriverManager.getConnection(connString);
            System.out.println("Connected successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
