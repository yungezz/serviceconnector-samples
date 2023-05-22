import pyodbc
import os

connection_string = 'Driver={ODBC Driver 17 for SQL Server};Server=tcp:' \
    + os.environ['AZURE_SQL_SERVERNAME'] + '.database.windows.net,1433;Database=' \
    + os.environ['AZURE_SQL_DATABASE'] + ';Uid=' + os.environ['AZURE_SQL_UID'] \
    + ';Pwd=' + os.environ['AZURE_SQL_PASSWORD'] + ';Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;'

try:
    with pyodbc.connect(connection_string) as connection:
        print("Connected successfully.")
except pyodbc.Error as e:
    print("Error connecting to SQL Server.")
    print(e)
