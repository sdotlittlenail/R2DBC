package info.novatec.r2dbc.spring.todo.rest

import info.novatec.r2dbc.spring.todo.db.ToDoEntity
import info.novatec.r2dbc.spring.todo.service.ToDoService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/todos")
class ToDoListController(private val service: ToDoService) {

    @GetMapping
    @ResponseStatus(OK)
    fun getTodoList(@RequestParam(required = false) complete: Boolean?) =
            complete?.let(service::getAllByComplete) ?: service.getAll()

    @GetMapping("/{todoId}")
    @ResponseStatus(OK)
    fun getTodo(@PathVariable("todoId") todoId: String) = service.getEntry(todoId)

    @PostMapping
    @ResponseStatus(CREATED)
    fun addTodo(@RequestBody toDo: ToDoEntity) = service.update(toDo)

    @DeleteMapping("/{todoId}")
    @ResponseStatus(NO_CONTENT)
    fun deleteTodo(@PathVariable("todoId") todoId: String) = service.delete(todoId)
}