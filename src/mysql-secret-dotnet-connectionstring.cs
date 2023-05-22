using System;
using System.Data;
using MySql.Data.MySqlClient;

class Program
{
    static void Main(string[] args)
    {
        string connectionString = Environment.GetEnvironmentVariable("AZURE_MYSQL_CONNECTIONSTRING");
        using (MySqlConnection connection = new MySqlConnection(connectionString))
        {
            connection.Open();
            Console.WriteLine("Connection successful!");
        }
    }
}
