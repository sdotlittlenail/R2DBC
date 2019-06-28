package info.novatec.r2dbc.spring.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/todos")
class ToDoListController(@Autowired private val repository: ToDoRepository) {

    @GetMapping
    fun getTodoList() = ResponseEntity.ok().body(repository.findAll())

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId: String) = ResponseEntity.ok(repository.findById(todoId))

    @PostMapping
    fun addTodo(@RequestBody toDo: ToDoEntity) = repository.save(toDo)

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable("todoId") todoId: String): ResponseEntity<Unit> {
        repository.deleteById(todoId)
        return ResponseEntity.noContent().build()
    }
}