using System;
using Npgsql;

class Program
{
    static void Main(string[] args)
    {
        string connString = Environment.GetEnvironmentVariable("AZURE_POSTGRESQL_CONNECTIONSTRING");

        using (var conn = new NpgsqlConnection(connString))
        {
            conn.Open();
            using (var cmd = new NpgsqlCommand("SELECT * FROM your_table", conn))
            {
                using (var reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Console.WriteLine(reader.GetString(0));
                    }
                }
            }
        }

        Console.WriteLine("Connected successfully.");
    }
}
