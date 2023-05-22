require 'tiny_tds'

client = TinyTds::Client.new(
  username: ENV['AZURE_SQL_USERNAME'],
  password: ENV['AZURE_SQL_PASSWORD'],
  host: ENV['AZURE_SQL_HOST'],
  port: ENV['AZURE_SQL_PORT'],
  database: ENV['AZURE_SQL_DATABASE']
)

if client.active?
  puts "Connected successfully."
else
  puts "Error connecting to SQL Server."
end
