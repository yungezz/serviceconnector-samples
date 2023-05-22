import com.azure.identity.DefaultAzureCredential;
import org.postgresql.ssl.NonValidatingFactory;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Connection getConnection(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String username) throws SQLException {
        DefaultAzureCredential tokenCredential = new DefaultAzureCredential();
        String accessToken = tokenCredential.getToken("https://ossrdbms-aad.database.windows.net/.default").getToken();
        url = String.format("%s?&authenticationPluginClassName=com.azure.identity.extensions.jdbc.postgresql.AzurePostgresqlAuthenticationPlugin&sslfactory=org.postgresql.ssl.NonValidatingFactory", url);
        Connection conn = DriverManager.getConnection(url, String.format("user=%s", username), String.format("password=%s", accessToken));
        return conn;
    }
}
