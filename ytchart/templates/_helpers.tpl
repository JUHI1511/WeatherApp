{{/* Define a helper to generate the full PostgreSQL connection URL */}}
{{- define "my-weather-app.fullPostgreSQLConnectionURL" -}}
jdbc:postgresql://{{ .Release.Name }}-postgres-service:5432/{{ .Values.postgres.databaseName }}?createDatabaseIfNotExist=true&characterEncoding=UTF-8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true
{{- end -}}
