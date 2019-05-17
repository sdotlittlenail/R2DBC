#!/bin/bash
docker run -d \
-p 2012:3306 \
--name r2dbc_spring_todo_container \
-e MYSQL_ROOT_PASSWORD=root123 \
-e MYSQL_DATABASE=r2dbc_spring_todo_db \
-e MYSQL_USER=app_user \
-e MYSQL_PASSWORD=r2dbc_spring_todo_pw  \
mysql:latest
