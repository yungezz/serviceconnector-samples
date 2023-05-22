import psycopg2
import os

conn = psycopg2.connect(os.environ['AZURE_POSTGRESQL_CONNECTIONSTRING'])

cur = conn.cursor()
cur.execute('SELECT * FROM your_table')

rows = cur.fetchall()

for row in rows:
    print(row)

cur.close()
conn.close()

print('Connected successfully.')
