import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connString = System.getenv("AZURE_SQL_CONNECTIONSTRING");

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setURL(connString);

        try (Connection con = ds.getConnection()) {
            System.out.println("Connected successfully.");
        }
    }
}
