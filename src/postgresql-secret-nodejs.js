const { Client } = require('pg');

const client = new Client({
  user: process.env.AZURE_POSTGRESQL_USERNAME,
  host: process.env.AZURE_POSTGRESQL_HOST,
  database: process.env.AZURE_POSTGRESQL_DATABASE,
  password: process.env.AZURE_POSTGRESQL_PASSWORD,
  port: process.env.AZURE_POSTGRESQL_PORT,
  ssl: process.env.AZURE_POSTGRESQL_SSL
});

client.connect();

console.log('Connected successfully.');
