require 'mysql2'
require 'dotenv/load'

client = Mysql2::Client.new(
  host: ENV['AZURE_MYSQL_HOST'],
  username: ENV['AZURE_MYSQL_USER'],
  password: ENV['AZURE_MYSQL_PASSWORD'],
  database: ENV['AZURE_MYSQL_DATABASE'],
  sslca: ENV['AZURE_MYSQL_SSLMODE']
)

client.close
