const mysql = require('mysql');

const connection = mysql.createConnection({
  host: process.env.AZURE_MYSQL_HOST,
  user: process.env.AZURE_MYSQL_USER,
  password: process.env.AZURE_MYSQL_PASSWORD,
  database: process.env.AZURE_MYSQL_DATABASE,
  port: process.env.AZURE_MYSQL_PORT,
  ssl: process.env.AZURE_MYSQL_SSL
});

connection.connect((err) => {
  if (err) {
    console.error('Error connecting to MySQL database: ' + err.stack);
    return;
  }
  console.log('Connected to MySQL database as id ' + connection.threadId);
});

module.exports = connection;
