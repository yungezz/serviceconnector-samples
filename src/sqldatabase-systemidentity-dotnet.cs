using System;
using System.Data;
using Azure.Identity;
using Azure.Core;

namespace Sample  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            // The connection string should have been set to environment variables by Service Connector
                // sample connection string looks like @"Server=demo.database.windows.net; Authentication=Active Directory Managed Identity; Encrypt=True; Database=testdb";
            string connectionString = Environment.GetEnvironmentVariable("AZURE_SQL_CONNECTIONSTRING");  
            using (SqlConnection conn = new SqlConnection(connectionString)) {
                conn.Open();            
            }
        }
    }
}