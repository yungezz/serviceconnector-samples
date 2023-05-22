
const { Connection } = require('tedious');

const config = {
  authentication: {
    options: {
      userName: process.env.AZURE_SQL_USERNAME,
      password: process.env.AZURE_SQL_PASSWORD,
    },
    type: 'default',
  },
  server: process.env.AZURE_SQL_SERVER,
  options: {
    database: process.env.AZURE_SQL_DATABASE,
    port: process.env.AZURE_SQL_PORT,
    encrypt: true,
  },
};

const connection = new Connection(config);

connection.on('connect', (err) => {
  if (err) {
    console.error(err.message);
  } else {
    console.log('Connected successfully.');
  }
});
