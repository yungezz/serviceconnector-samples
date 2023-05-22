import com.azure.identity.DefaultAzureCredential;
import org.postgresql.ssl.NonValidatingFactory;
import org.postgresql.util.PSQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String connectionString = System.getenv("AZURE_POSTGRESQL_CONNECTIONSTRING");
        
        try {
            DefaultAzureCredential tokenCredential = new DefaultAzureCredential();
            String accessToken = tokenCredential.getToken("https://ossrdbms-aad.database.windows.net/.default").getToken();
            String url = String.format("%s?sslfactory=org.postgresql.ssl.NonValidatingFactory&authenticationPluginClassName=com.azure.identity.extensions.jdbc.postgresql.AzurePostgresqlAuthenticationPlugin", connectionString);
            Connection conn = DriverManager.getConnection(url, String.format("password=%s", accessToken));
            System.out.println("Successfully connected!");
            conn.close();
        } catch (SQLException | PSQLException e) {
            e.printStackTrace();
        }
    }
}
