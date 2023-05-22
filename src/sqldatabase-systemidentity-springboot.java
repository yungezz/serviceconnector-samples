import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        String connString = System.getenv("AZURE_SQL_CONNECTIONSTRING");

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setURL(connString);

        return ds;
    }
}
