# settings.py
import os

DATABASES = {
    "default": {
        "ENGINE": "mssql",
        "NAME": os.environ['AZURE_SQL_NAME'],
        "USER": os.environ['AZURE_SQL_USER'],
        "PASSWORD": os.environ['AZURE_SQL_PASSWORD'],
        "HOST": os.environ['AZURE_SQL_HOST'],
        "PORT": os.environ['AZURE_SQL_PORT'],
        "OPTIONS": {"driver": "ODBC Driver 17 for SQL Server", 
        },
    },
}