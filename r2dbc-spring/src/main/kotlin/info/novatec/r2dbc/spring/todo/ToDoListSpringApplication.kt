package info.novatec.r2dbc.spring.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoListSpringApplication

fun main(args: Array<String>) {
    runApplication<ToDoListSpringApplication>(*args)
}
