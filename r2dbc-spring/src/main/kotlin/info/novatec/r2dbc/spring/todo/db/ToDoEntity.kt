package info.novatec.r2dbc.spring.todo.db

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("todo")
data class ToDoEntity(
        @Id val id: Int?,
        val name: String,
        val category: String,
        val complete: Boolean)