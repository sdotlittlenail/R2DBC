package info.novatec.r2dbc.spring.todo.service

import info.novatec.r2dbc.spring.todo.db.ToDoRepository
import info.novatec.r2dbc.spring.todo.db.ToDoEntity
import org.springframework.stereotype.Service

@Service
class ToDoService(private val repository: ToDoRepository) {

    fun getAll() = repository.findAll()

    fun getEntry(id: String) = repository.findById(id)

    fun getAllByComplete(complete: Boolean) = repository.findByComplete(complete)

    fun update(toDo: ToDoEntity) = repository.save(toDo)

    fun delete(id: String) = repository.deleteById(id)
}