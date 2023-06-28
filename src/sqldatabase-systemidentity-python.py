import pyodbc
import os

host = os.environ['AZURE_SQL_HOST']
database = os.environ['AZURE_SQL_DATABASE']
username = os.environ['AZURE_SQL_USERNAME']
authtype = os.environ['AZURE_SQL_AUTHENTICATION']

conn = pyodbc.connect(
    'DRIVER={ODBC Driver 17 for SQL Server};'
    f'SERVER={host};'
    f'DATABASE={database};'
    f'UID={username};'
    'Authentication={authtype};'
)

print('Connected successfully.')
