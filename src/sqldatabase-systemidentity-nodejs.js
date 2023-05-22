const sql = require('mssql');

async function main() {
    const host = process.env.AZURE_SQL_SERVER;
    const database = process.env.AZURE_SQL_DATABASE;
    const username = process.env.AZURE_SQL_USERNAME;
    const password = process.env.AZURE_SQL_PASSWORD;
    const port = process.env.AZURE_SQL_PORT;
    const authType = process.env.AZURE_SQL_AUTHENTICATIONTYPE;

    const pool = await sql.connect({
        server: host,
        database: database,
        user: username,
        password: password,
        port: port,
        authentication: {
            type: authType
        }
    });

    console.log('Connected successfully.');
}

main().catch(err => console.error(err));
