require 'pg'
require 'uri'

uri = URI.parse(ENV['AZURE_POSTGRESQL_CONNECTIONSTRING'])

conn = PG.connect(
  host: uri.host,
  port: uri.port,
  dbname: uri.path[1..-1],
  user: uri.user,
  password: uri.password
)

puts "Successfully connected!"

conn.close
