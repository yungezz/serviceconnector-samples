require 'mysql2'
require 'dotenv/load'

=begin
 How to get environment variable names after creating connection via Service Connector?
 Option 1: Azure CLI command: az webapp/containerapp/springapp connection list-configuration. 
   eg: https://learn.microsoft.com/en-us/cli/azure/containerapp/connection?view=azure-cli-latest#az-containerapp-connection-list-configuration.
 Option 2: Get from Rest API https://github.com/Azure/azure-rest-api-specs/blob/main/specification/servicelinker/resource-manager/Microsoft.ServiceLinker/preview/2022-11-01-preview/servicelinker.json#L945-L983
 Option 3: Get from doc https://learn.microsoft.com/en-us/azure/service-connector/how-to-integrate-mysql#default-environment-variable-names-or-application-properties.
 Option 4: Check source compute's configurations for newly added configurations, such as WebApp's appSettings.
=end
client = Mysql2::Client.new(
  host: ENV['AZURE_MYSQL_HOST'],
  username: ENV['AZURE_MYSQL_USER'],
  password: ENV['AZURE_MYSQL_PASSWORD'],
  database: ENV['AZURE_MYSQL_DATABASE'],
  sslca: ENV['AZURE_MYSQL_SSLMODE']
)

client.close
