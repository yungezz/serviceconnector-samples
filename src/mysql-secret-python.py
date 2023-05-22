import os
import mysql.connector

host = os.getenv('AZURE_MYSQL_HOST')
user = os.getenv('AZURE_MYSQL_USER')
password = os.getenv('AZURE_MYSQL_PASSWORD')
database = os.getenv('AZURE_MYSQL_DATABASE')
port = os.getenv('AZURE_MYSQL_PORT')

cnx = mysql.connector.connect(user=user, password=password,
                              host=host,
                              database=database,
                              port=port)

cnx.close()
