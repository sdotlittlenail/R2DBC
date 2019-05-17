package info.novatec.r2dbc.spring.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/v1/todos")
class ToDoListController @Autowired constructor(private val repository: ToDoRepository) {

    @GetMapping
    fun getTodoList() = ResponseEntity.ok().body(repository.findAll())

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId: Long) = ResponseEntity.ok(repository.findById(todoId))

    @PostMapping
    fun addToDoEntry(@RequestBody toDo: ToDoEntity): ResponseEntity.BodyBuilder {
        val addedToDo = repository.save(toDo)
        val location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/todos/{todoId}")
                .buildAndExpand(addedToDo.id)
                .toUri()

        return ResponseEntity.created(location)
    }

    @DeleteMapping("/{todoId}")
    fun deleteEntry(@PathVariable("todoId") todoId: Long): ResponseEntity<Unit> {
        repository.deleteById(todoId)
        return ResponseEntity.noContent().build()
    }
}