using System;
using System.Data.SqlClient;
using System.Diagnostics;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            string connectionString = Environment.GetEnvironmentVariable("AZURE_SQL_CONNECTIONSTRING");

            SqlConnectionStringBuilder builder = new SqlConnectionStringBuilder(connectionString);

            using (SqlConnection connection = new SqlConnection(builder.ConnectionString))
            {
                connection.Open();
                Console.WriteLine("Connected successfully.");
                connection.Close();
            }
        }
    }
}
