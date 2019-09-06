#!/bin/bash

# Fallback script to initialize data
# SQL scripts in resources are not yet working on service start

# create table
docker cp src/main/resources/schema-postgresql.sql r2dbc_spring_todo_container:/schema-postgresql.sql
docker exec -it r2dbc_spring_todo_container psql -h localhost -p 5432 -U app_user -d r2dbc_spring_todo_db -f schema-postgresql.sql

# insert data
docker cp src/main/resources/data-postgresql.sql r2dbc_spring_todo_container:/data-postgresql.sql
docker exec -it r2dbc_spring_todo_container psql -h localhost -p 5432 -U app_user -d r2dbc_spring_todo_db -f data-postgresql.sql

docker exec -it r2dbc_spring_todo_container /bin/bash

psql -h localhost -p 5432 -U app_user -d r2dbc_spring_todo_db