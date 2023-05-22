<?php
$dbconn = pg_connect(getenv('AZURE_POSTGRESQL_CONNECTIONSTRING'))
    or die('Could not connect: ' . pg_last_error());

$query = 'SELECT * FROM your_table';
$result = pg_query($query) or die('Query failed: ' . pg_last_error());

while ($line = pg_fetch_array($result, null, PGSQL_ASSOC)) {
    echo $line['column1'] . "\t" . $line['column2'] . "\n";
}

pg_free_result($result);
pg_close($dbconn);

echo 'Connected successfully.';
?>
