import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        /* ServiceConnector set below properties: spring.datasource.url, spring.datasource.username, spring.datasource.password */
        SpringApplication.run(Main.class, args);
    }
}
