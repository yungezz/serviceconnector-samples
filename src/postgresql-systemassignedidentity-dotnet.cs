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
            // system assigned identity
            var credential = new DefaultAzureCredential(); 
            // user assigned identity
            // var credential = new DefaultAzureCredential(new DefaultAzureCredentialOptions { ManagedIdentityClientId = userAssignedClientId });
            // service principal 
            // var credential = new ClientSecretCredential(tenantId, clientId, clientSecret);
            TokenRequestContext tokenRequestContext = new TokenRequestContext(new[] { "https://ossrdbms-aad.database.windows.net/.default" });  
            AccessToken accessToken = await credential.GetTokenAsync(tokenRequestContext);  
            // Open a connection to the MySQL server using the access token.
            var connectionString = System.getenv("AZURE_POSTGRESQL_CONNECTIONSTRING") + $";Password={accessToken.Token}";    
            using (var conn = new MySqlConnection(connectionString))
            {
                Console.Out.WriteLine("Opening connection using access token...");
                await conn.OpenAsync();

                // do something
            }
        }
    }
}