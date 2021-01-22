package info.novatec.r2dbc.spring.todo.db

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ToDoRepository : ReactiveCrudRepository<ToDoEntity, String> {

    @Query("SELECT id, name, category, complete FROM todo t WHERE t.complete = :complete")
    fun findByComplete(complete: Boolean): Flux<ToDoEntity>
}