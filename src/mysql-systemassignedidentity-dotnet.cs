using System;
using System.Data;
using MySqlConnector;
using Azure.Identity;
using Azure.Core;

namespace MysqlConnectionExample  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {
            // For a complete managed identity sample, please refer to <place holder to Xiaofan's passwordless tutorial>  

            // system assigned identity
            var credential = new DefaultAzureCredential(); 
            // user assigned identity
            // var credential = new DefaultAzureCredential(new DefaultAzureCredentialOptions { ManagedIdentityClientId = userAssignedClientId });
            // service principal 
            // var credential = new ClientSecretCredential(tenantId, clientId, clientSecret);
            TokenRequestContext tokenRequestContext = new TokenRequestContext(new[] { "https://ossrdbms-aad.database.windows.net/.default" });  
            AccessToken accessToken = await credential.GetTokenAsync(tokenRequestContext);  
            
            // Open a connection to the MySQL server using the access token.
            
            // How to get environment variable names after creating connection via Service Connector?
            // Option 1: Azure CLI command: az webapp/containerapp/springapp connection list-configuration. 
            // eg: https://learn.microsoft.com/en-us/cli/azure/containerapp/connection?view=azure-cli-latest#az-containerapp-connection-list-configuration.
            // Option 2: Get from Rest API https://github.com/Azure/azure-rest-api-specs/blob/main/specification/servicelinker/resource-manager/Microsoft.ServiceLinker/preview/2022-11-01-preview/servicelinker.json#L945-L983
            // Option 3: Get from doc https://learn.microsoft.com/en-us/azure/service-connector/how-to-integrate-mysql#default-environment-variable-names-or-application-properties.
            // Option 4: Check source compute's configurations for newly added configurations, such as WebApp's appSettings.
            var connectionString = System.getenv("AZURE_MYSQL_CONNECTIONSTRING") + $";Password={accessToken.Token}";        
            using (var conn = new MySqlConnection(connectionString))
            {
                Console.Out.WriteLine("Opening connection using access token...");
                await conn.OpenAsync();
            
                // do something
            }
        }
    }
}