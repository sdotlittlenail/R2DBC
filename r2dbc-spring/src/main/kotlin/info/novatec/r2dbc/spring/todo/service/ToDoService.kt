package info.novatec.r2dbc.spring.todo.service

import info.novatec.r2dbc.spring.todo.db.ToDoRepository
import info.novatec.r2dbc.spring.todo.db.ToDoEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ToDoService(private val repository: ToDoRepository) {

    fun getAll(): Flux<ToDoEntity> = repository.findAll()

    fun getEntry(id: String): Mono<ToDoEntity> = repository.findById(id)

    fun getAllByComplete(complete: Boolean) = repository.findByComplete(complete)

    fun update(toDo: ToDoEntity): Mono<ToDoEntity> = repository.save(toDo)

    fun delete(id: String): Mono<Void> = repository.deleteById(id)
}