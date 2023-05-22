using System.Data.SqlClient;
using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            string connString = Environment.GetEnvironmentVariable("AZURE_SQL_CONNECTIONSTRING");

            using (SqlConnection connection = new SqlConnection(connString))
            {
                connection.Open();
                Console.WriteLine("Connected successfully.");
            }
        }
    }
}
