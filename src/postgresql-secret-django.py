import os
import dj_database_url

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.postgresql',
        'HOST': os.environ['AZURE_POSTGRESQL_HOST'],
        'NAME': os.environ['AZURE_POSTGRESQL_NAME'],
        'USER': os.environ['AZURE_POSTGRESQL_USER'],
        'PASSWORD': os.environ['AZURE_POSTGRESQL_PASSWORD'],
        'PORT': os.environ.get('AZURE_POSTGRESQL_PORT', 5432),
    }
}
