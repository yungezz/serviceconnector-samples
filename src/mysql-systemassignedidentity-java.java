
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlSample {
    public static void main(String[] args) {
        // For a complete managed identity sample, please refer to <place holder to Xiaofan's passwordless tutorial>  

        /* How to get environment variable names after creating connection via Service Connector?
           Option 1: Azure CLI command: az webapp/containerapp/springapp connection list-configuration. 
             eg: https://learn.microsoft.com/en-us/cli/azure/containerapp/connection?view=azure-cli-latest#az-containerapp-connection-list-configuration.
           Option 2: Get from Rest API https://github.com/Azure/azure-rest-api-specs/blob/main/specification/servicelinker/resource-manager/Microsoft.ServiceLinker/preview/2022-11-01-preview/servicelinker.json#L945-L983
           Option 3: Get from doc https://learn.microsoft.com/en-us/azure/service-connector/how-to-integrate-mysql#default-environment-variable-names-or-application-properties.
           Option 4: Check source compute's configurations for newly added configurations, such as WebApp's appSettings.        
        */
        String url = System.getenv("AZURE_MYSQL_CONNECTIONSTRING");  
        try {
            Connection connection = DriverManager.getConnection(url + "&defaultAuthenticationPlugin=com.azure.identity.extensions.jdbc.mysql.AzureMysqlAuthenticationPlugin" +
            "&authenticationPlugins=com.azure.identity.extensions.jdbc.mysql.AzureMysqlAuthenticationPlugin");

            // do something
        } catch (SQLException e) {
            System.err.println("Cannot connect to MySQL database: " + e.getMessage());
        }
    }
}

