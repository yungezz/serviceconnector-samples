import os
import mysql.connector

host = os.getenv('AZURE_MYSQL_HOST')
user = os.getenv('AZURE_MYSQL_USER')
password = os.getenv('AZURE_MYSQL_PASSWORD')
database = os.getenv('AZURE_MYSQL_DATABASE')
port = os.getenv('AZURE_MYSQL_PORT')

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': database,
        'USER': user,
        'PASSWORD': password,
        'HOST': host,
        'PORT': port
    }
}
