import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // ServiceConnector set spring.data.url, spring.data.username, spring.data.password already
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void run(String... args) throws Exception {
        jdbcTemplate.query("SELECT * FROM your_table", rs -> {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        });

        System.out.println("Connected successfully.");
    }
}
