package info.novatec.r2dbc.spring.todo

import org.springframework.data.repository.CrudRepository

interface ToDoRepository : CrudRepository<ToDoEntity, String>