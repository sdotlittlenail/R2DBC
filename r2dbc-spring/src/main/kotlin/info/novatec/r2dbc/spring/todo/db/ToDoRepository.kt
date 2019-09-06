package info.novatec.r2dbc.spring.todo.db

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ToDoRepository : ReactiveCrudRepository<ToDoEntity, String>