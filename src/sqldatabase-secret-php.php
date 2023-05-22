<?php

$connectionString = sprintf("sqlsrv:server = tcp:%s.database.windows.net,1433; Database = %s", 
    getenv("AZURE_SQL_SERVERNAME"), 
    getenv("AZURE_SQL_DATABASE"));

$connectionOptions = array(
    "Uid" => getenv("AZURE_SQL_UID"), 
    "PWD" => getenv("AZURE_SQL_PASSWORD"), 
    "Encrypt" => 1,
    "TrustServerCertificate" => 0
);

try {
    $conn = new PDO($connectionString, $connectionOptions);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    echo "Connected successfully.";
} catch (PDOException $e) {
    print("Error connecting to SQL Server.");
    die(print_r($e));
}
