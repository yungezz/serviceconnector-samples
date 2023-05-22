import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String connectionString = System.getenv("AZURE_SQL_CONNECTIONSTRING");

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            System.out.println("Connected successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}