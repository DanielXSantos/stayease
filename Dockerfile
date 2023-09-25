# Use uma imagem base oficial do PostgreSQL
FROM postgres:latest

# Defina as variáveis de ambiente para o PostgreSQL
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB stayeasy

# Expõe a porta padrão do PostgreSQL (5432)
EXPOSE 5432
