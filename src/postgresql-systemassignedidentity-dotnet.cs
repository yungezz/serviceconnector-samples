using System;
using System.Threading.Tasks;
using Azure.Identity;
using Npgsql;

namespace ConsoleApp1
{
    class Program
    {
        static async Task Main(string[] args)
        {
            var connectionString = Environment.GetEnvironmentVariable("AZURE_POSTGRESQL_CONNECTIONSTRING");
            var tokenCredential = new DefaultAzureCredential();
            var accessToken = await tokenCredential.GetTokenAsync(new Azure.Core.TokenRequestContext(new[] { "https://ossrdbms-aad.database.windows.net/.default" }));
            var builder = new NpgsqlConnectionStringBuilder(connectionString)
            {
                SslMode = SslMode.Require,
                TrustServerCertificate = true,
                IntegratedSecurity = true,
                Username = new NpgsqlConnectionStringBuilder($"user=<{accessToken.Token}>").Username,
                Password = new NpgsqlConnectionStringBuilder($"password=<{accessToken.Token}>").Password
            };
            using var conn = new NpgsqlConnection(builder.ConnectionString);
            await conn.OpenAsync();
            Console.WriteLine("Successfully connected!");
        }
    }
}
